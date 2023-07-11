package com.example.tictactoe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        startGameAsServer(primaryStage);
        startGameAsClient(primaryStage);
    }

    private void startGameAsServer(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("server.fxml"));
            Stage serverStage = new Stage();
            serverStage.setTitle("Server");
            serverStage.setScene(new Scene(loader.load(),795,700));
            serverStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGameAsClient(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("client.fxml"));
            Stage clientStage = new Stage();
            clientStage.setTitle("Client");
            clientStage.setScene(new Scene(loader.load(),795,700));
            clientStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
}
