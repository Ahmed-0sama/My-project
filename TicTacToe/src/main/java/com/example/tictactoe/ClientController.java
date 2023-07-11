package com.example.tictactoe;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private Text mainText;
    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;

    private ArrayList<Button> buttons;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private boolean isServer = false;
    private boolean isMyTurn;
    private final char mySymbol = 'O';
    private final char opponentSymbol = 'X';
    private Socket socket;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8,
                button9));

        for (Button button : buttons) {
            setupButton(button);
            button.setFocusTraversable(false);
        }
        startAsClient();
    }



    @FXML
    void handleExitButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void restartGame(ActionEvent event) {
        resetGame();
        sendResetCommand();
    }

    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }

    private void setupButton(Button button) {
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                if (isMyTurn) {
                    int buttonIndex = buttons.indexOf(button);
                    makeMove(buttonIndex);
                }
            }
        });
    }

    public void startAsClient() {
        try {
            socket = new Socket("localhost", 12345);
            initializeGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeGame() {
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            isMyTurn = isServer;
            Platform.runLater(() -> {
                mainText.setText(isMyTurn ? "Your turn (" + mySymbol + ")" : "Opponent's turn (" + opponentSymbol + ")");
                resetGame();
            });
            Thread messageHandlerThread = new Thread(new MessageHandler());
            messageHandlerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateGameState(int buttonIndex, char symbol) {
        Button button = buttons.get(buttonIndex);
        button.setText(String.valueOf(symbol));
        button.setDisable(true);
    }

    public void checkGameResult() {
        Platform.runLater(() -> {
            if (checkWinCondition(mySymbol)) {
                handleWin();
            } else if (checkWinCondition(opponentSymbol)) {
                handleLoss();
            } else if (isBoardFull()) {
                handleDraw();
            }
        });
    }

    public boolean checkWinCondition(char symbol) {
        String line = "";
        // Check rows
        for (int i = 0; i < 3; i++) {
            line = "";
            for (int j = 0; j < 3; j++) {
                line += buttons.get(i * 3 + j).getText();
            }
            if (line.equals(String.valueOf(symbol).repeat(3))) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            line = "";
            for (int j = 0; j < 3; j++) {
                line += buttons.get(j * 3 + i).getText();
            }
            if (line.equals(String.valueOf(symbol).repeat(3))) {
                return true;
            }
        }

        // Check diagonals
        line = "";
        for (int i = 0; i < 3; i++) {
            line += buttons.get(i * 3 + i).getText();
        }
        if (line.equals(String.valueOf(symbol).repeat(3))) {
            return true;
        }

        line = "";
        for (int i = 0; i < 3; i++) {
            line += buttons.get(i * 3 + (2 - i)).getText();
        }
        if (line.equals(String.valueOf(symbol).repeat(3))) {
            return true;
        }

        return false;
    }

    public boolean isBoardFull() {
        for (Button button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void handleWin() {
        Platform.runLater(() -> {
            mainText.setText("You won!");
            disableButtons();
        });
    }

    public void handleLoss() {
        Platform.runLater(() -> {
            mainText.setText("You lost!");
            disableButtons();
        });
    }


    public void handleDraw() {
        Platform.runLater(() -> {
            mainText.setText("Draw!");
            disableButtons();
        });
    }

    public void disableButtons() {
        Platform.runLater(() -> {
        for (Button button : buttons) {
            button.setDisable(true);
        }
        });
    }

    public void resetGame() {
        Platform.runLater(() -> {
            for (Button button : buttons) {
                resetButton(button);
            }
            mainText.setText(isMyTurn ? "Your turn (" + mySymbol + ")" : "Opponent's turn (" + opponentSymbol + ")");
        });
    }

    public void sendResetCommand() {
        try {
            outputStream.writeInt(-1);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTurnMessage() {
        String turnMessage = isMyTurn ? "Your turn (" + mySymbol + ")" : "Opponent's turn (" + opponentSymbol + ")";
        mainText.setText(turnMessage);
    }

    public void makeMove(int buttonIndex) {
        try {
            outputStream.writeInt(buttonIndex);
            outputStream.flush();
            Platform.runLater(() -> {
                updateGameState(buttonIndex, mySymbol);
                checkGameResult();
                isMyTurn = false;
                updateTurnMessage();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class MessageHandler implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    int buttonIndex = inputStream.readInt();
                    Platform.runLater(() -> {
                    if (buttonIndex == -1) {
                        resetGame();
                    } else {
                        updateGameState(buttonIndex, opponentSymbol);
                        checkGameResult();
                        isMyTurn = true;
                        Platform.runLater(() -> mainText.setText("Your turn (" + mySymbol + ")"));
                    }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
