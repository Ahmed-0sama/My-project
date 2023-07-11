package com.example.finalprojectfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException, ClassNotFoundException {

        //Stores all users in database in this ArrayList
        ArrayList<Users> users = DBMethods.getAllUsers();
        //Stores games that users adds in cart
        ArrayList<Games> gamesInCart = new ArrayList<>();
        //Used in modifyUser to know which user signed in and modify his info
        int[] signedInUser = new int[1];
        //Css File path
        String cssFile = new File("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\projectCss.css").toURI().toString();

        //Prints available users
        for (Users user : users) {
            System.out.println(user);
        }
        Label username = new Label("Username");
        Label password = new Label("Password");
        Label signUpUsername = new Label("Username ");
        Label signUpPassword = new Label("Password ");
        Label confirmPass = new Label("Confirm Password");
        Label signUpMessage = new Label("Don't have an account ? ");
        Label signInMessage = new Label("Already have an account ? ");
        Label signUpError = new Label("");
        Label signInError = new Label("");
        Label signInWelcomeMsg = new Label("");
        signInWelcomeMsg.setStyle("-fx-text-fill: green");
        signInWelcomeMsg.getStyleClass().add("gameName");
        signUpError.setStyle("-fx-text-fill: red");
        signInError.setStyle("-fx-text-fill: red");

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField signUpUsernameField = new TextField();
        PasswordField signUpPassField = new PasswordField();
        PasswordField confirmPassField = new PasswordField();
        usernameField.setPrefWidth(250);
        signUpUsernameField.setPrefWidth(250);

        usernameField.setPromptText("Enter your Username");
        passwordField.setPromptText("Enter your Password");
        signUpUsernameField.setPromptText("Enter Username");
        signUpPassField.setPromptText("Enter Password");
        confirmPassField.setPromptText("Confirm Password");

        Button signInPage1 = new Button("Sign In");
        Button signInButtonInPage2 = new Button("Sign In");
        Button signUpButtonInPage1 = new Button("Sign Up");
        Button signUpPage2 = new Button("Sign Up");

        signUpButtonInPage1.getStyleClass().add("signUp");
        signInButtonInPage2.getStyleClass().add("signUp");

        signInPage1.setPrefWidth(320);
        signInPage1.setPrefHeight(35);
        signUpPage2.setPrefWidth(320);
        signUpPage2.setPrefHeight(35);

        Image gameOverImage = new Image(new FileInputStream("G:\\Projects\\GameOverStore.jpg"));
        ImageView image = new ImageView(gameOverImage);
        image.setFitHeight(600);
        image.setFitWidth(360);

        ImageView image2 = new ImageView(gameOverImage);
        image2.setFitHeight(600);
        image2.setFitWidth(360);

        GridPane grid = new GridPane();
        grid.add(username, 1, 6);
        grid.add(password, 1, 7);
        grid.add(usernameField, 2, 6);
        grid.add(passwordField, 2, 7);
        grid.add(signInError, 2, 10);
        grid.add(signInPage1, 1, 8, 2, 8);
        grid.add(signUpMessage, 1, 9, 2, 9);
        grid.add(signUpButtonInPage1, 1, 10, 2, 10);
        grid.setHgap(30);
        grid.setVgap(30);

        HBox hBox = new HBox(image, grid);

        Scene scene = new Scene(hBox, 750, 600);
        scene.getStylesheets().add(cssFile);
        stage.setTitle("Game Over Store | Download Your Favorite Games");

        GridPane signUpGrid = new GridPane();
        signUpGrid.add(signUpUsername, 1, 6);
        signUpGrid.add(signUpPassword, 1, 7);
        signUpGrid.add(confirmPass, 1, 8);
        signUpGrid.add(signUpError, 2, 9);
        signUpGrid.add(signUpUsernameField, 2, 6);
        signUpGrid.add(signUpPassField, 2, 7);
        signUpGrid.add(confirmPassField, 2, 8);
        signUpGrid.add(signUpPage2, 1, 8, 2, 8);
        signUpGrid.add(signInMessage, 1, 9, 2, 9);
        signUpGrid.add(signInButtonInPage2, 1, 10, 2, 10);
        signUpGrid.setHgap(30);
        signUpGrid.setVgap(30);

        HBox signUpHBox = new HBox(image2, signUpGrid);
        Scene signUpScene = new Scene(signUpHBox, 800, 600);
        signUpScene.getStylesheets().add(cssFile);

//Third scene code////////////////////////////////////////////////////////////////////
        Image sekiroImg = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\sekiro.jpg"));
        Image img = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\warzone.jpg"));
        Image img1 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\r6s.jpg"));
        Image img2 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\fifa.jpg"));
        Image img3 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\apex.jpg"));
        Image img4 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\pubg.jpg"));
        Image img5 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\hff.jpg"));
        Image img6 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\destiny.jpg"));
        Image img7 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\amongus.jpg"));
        Image img8 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\stickFight.jpg"));
        Image img9 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\uno.jpg"));
        Image img10 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\wwe.jpg"));
        Image img11 = new Image(new FileInputStream("C:\\Users\\Zeux\\IdeaProjects\\FinalProjectFX\\src\\main\\java\\com\\example\\finalprojectfx\\pummelParty.jpg"));

        Label gameName = new Label("");
        Label gamePrice = new Label("");
        gameName.getStyleClass().add("gameName");
        gamePrice.getStyleClass().add("gameName");

        ImageView gameImage = new ImageView();

        Button nextGame = new Button("Next Game");
        Button addToCart = new Button("Add To Cart");
        Button viewCart = new Button("View Cart");
        Button modifyUser = new Button("Change Password");
        modifyUser.setPrefHeight(40);
        modifyUser.setPrefWidth(160);
        modifyUser.getStyleClass().add("modifyButton");

        addToCart.setPrefWidth(120);
        addToCart.setPrefHeight(30);
        nextGame.getStyleClass().add("signUp");
        viewCart.setStyle("-fx-font-weight: bold");

        GridPane thirdGrid = new GridPane();

        ArrayList<Image> images = new ArrayList<>();
        ArrayList<String> gameNames = new ArrayList<>();
        ArrayList<Double> gamePrices = new ArrayList<>();
        //Adding the name of each game to an ArrayList of Strings corresponding to the image of the game in the images ArrayList
        gameNames.add("Sekitroll - Shadows Die Alot\t\t\t");
        gameNames.add("Call Of Duty Black Ops 3\t\t\t\t");
        gameNames.add("Rainbow Six Siege\t\t\t\t\t\t");
        gameNames.add("Fifa 22\t\t\t\t\t\t\t\t\t");
        gameNames.add("Apex Legends\t\t\t\t\t\t\t");
        gameNames.add("PUBG\t\t\t\t\t\t\t\t\t");
        gameNames.add("Human Fall Flat\t\t\t\t\t\t");
        gameNames.add("Destiny 2\t\t\t\t\t\t\t\t");
        gameNames.add("Among Us\t\t\t\t\t\t\t\t");
        gameNames.add("Stick Fight\t\t\t\t\t\t\t\t");
        gameNames.add("UNO\t\t\t\t\t\t\t\t\t");
        gameNames.add("WWE 2K22\t\t\t\t\t\t\t\t");
        gameNames.add("Pummel Party\t\t\t\t\t\t\t");
        //Adding the price of each game to an ArrayList of Strings corresponding to the image of the game in the images ArrayList
        gamePrices.add(59.99);
        gamePrices.add(14.99);
        gamePrices.add(19.99);
        gamePrices.add(39.99);
        gamePrices.add(0.0);
        gamePrices.add(0.0);
        gamePrices.add(5.99);
        gamePrices.add(0.0);
        gamePrices.add(3.49);
        gamePrices.add(1.49);
        gamePrices.add(3.99);
        gamePrices.add(19.79);
        gamePrices.add(8.99);
        //Adding images to the ArrayList
        images.add(sekiroImg);
        images.add(img);
        images.add(img1);
        images.add(img2);
        images.add(img3);
        images.add(img4);
        images.add(img5);
        images.add(img6);
        images.add(img7);
        images.add(img8);
        images.add(img9);
        images.add(img10);
        images.add(img11);
        //This will be the index of the current image , gameName, gamePrice ,appearing on screen
        int[] indexOfCurrentGame = new int[1];
        //Setting the first game that will appear on screen
        gameImage.setImage(images.get(0));
        gameName.setText(gameNames.get(0));
        gamePrice.setText(gamePrices.get(0) + "$");

        nextGame.setOnAction((ActionEvent event) -> {
            gameName.setText("");
            gamePrice.setText("");
            indexOfCurrentGame[0]++;
            //if index of current game equals array size reset it to 0
            //to avoid IndexOutOfBounds exception
            if (indexOfCurrentGame[0] == images.size()) {
                indexOfCurrentGame[0] = 0;
            }
            int i = indexOfCurrentGame[0];

            //Change current image to the next image in the array
            gameImage.setImage(images.get(i));
            gameName.setText(gameNames.get(i));
            if (gamePrices.get(i) == 0) //if price equals zero set the text to Free
                gamePrice.setText("Free");
            else {
                gamePrice.setText(gamePrices.get(i) + "$");
            }
        });

        thirdGrid.add(signInWelcomeMsg, 0, 0);
        thirdGrid.add(gameImage, 0, 1, 4, 1);
        thirdGrid.add(gameName, 0, 2);
        thirdGrid.add(nextGame, 2, 0);
        thirdGrid.add(gamePrice, 2, 2);
        thirdGrid.add(addToCart, 0, 4);
        thirdGrid.add(viewCart, 2, 4);
        thirdGrid.add(modifyUser, 0, 7);

        thirdGrid.setVgap(10);
        thirdGrid.setHgap(30);
        thirdGrid.setPadding(new Insets(30));
        thirdGrid.setAlignment(Pos.CENTER);

        Scene thirdScene = new Scene(thirdGrid, 570, 600);
        thirdScene.getStylesheets().add(cssFile);
//End of third scene code/////////////////////////////////////////////////////////////
////Start of fourth scene code///////////////////////////////////////////////////////////
        Label newPassword = new Label("New Password");
        Label confirmNewPass = new Label("Confirm New Password");
        Label newPassError = new Label("");

        newPassword.getStyleClass().add("newPass");
        confirmNewPass.getStyleClass().add("newPass");
        newPassError.setStyle("-fx-text-fill: red");

        PasswordField newPasswordField = new PasswordField();
        PasswordField confirmNewPasswordField = new PasswordField();

        newPasswordField.setPromptText("Enter new Password");
        confirmNewPasswordField.setPromptText("Confirm new Password");

        Button changePassConfirm = new Button("Change Password");
        Button removeAccount = new Button("Delete account");
        Button returnToScene1 = new Button("Return to login page");

        changePassConfirm.getStyleClass().add("signUp");
        returnToScene1.getStyleClass().add("signUp");

        GridPane fourthGrid = new GridPane();

        fourthGrid.add(returnToScene1, 0, 0);
        fourthGrid.add(removeAccount, 2, 0);
        fourthGrid.add(newPassword, 0, 1);
        fourthGrid.add(confirmNewPass, 0, 2);
        fourthGrid.add(newPasswordField, 1, 1);
        fourthGrid.add(confirmNewPasswordField, 1, 2);
        fourthGrid.add(newPassError, 1, 3);
        fourthGrid.add(changePassConfirm, 0, 3);


        fourthGrid.setVgap(20);
        fourthGrid.setHgap(20);
        fourthGrid.setAlignment(Pos.CENTER);

        returnToScene1.setOnAction((ActionEvent event) -> {
            stage.setScene(scene);
            newPasswordField.clear();
            confirmNewPasswordField.clear();
            newPassError.setText("");
        });
        removeAccount.setOnAction((ActionEvent event) -> {
            //Gets the index of the user signed in (Check signInPage1 button method)
            int i = signedInUser[0];
            try {
                DBMethods.removeAccount(users.get(i).getUsername());
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
            users.remove(i);
            stage.setScene(scene);
            newPasswordField.clear();
            confirmNewPasswordField.clear();
            newPassError.setText("");
        });

        changePassConfirm.setOnAction((ActionEvent event) -> {
            String passText = newPasswordField.getText(), confirmText = confirmNewPasswordField.getText();
            int i = signedInUser[0];
            //Checking if any field is empty
            if (passText.isEmpty() || confirmText.isEmpty()) {
                newPassError.setText("Empty Field, please enter and confirm new password");
            }//checking if the 2 fields are equal ,then updating user info
            else if (passText.equals(confirmText)) {
                users.get(i).setPassword(newPasswordField.getText());
                try {
                    DBMethods.changePass(users.get(i).getUsername(), passText);
                    stage.setScene(scene);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }//If the field are not empty and not equal print an error message
            } else {
                newPassError.setText("Password Doesn't Match");
            }
            newPasswordField.clear();
            confirmNewPasswordField.clear();
            newPassError.setText("");
        });

        Scene fourthScene = new Scene(fourthGrid, 500, 300);
        fourthScene.getStylesheets().add(cssFile);
//End of fourth scene////////////////////////////////////////////////////////////////
//Start of fifth scene///////////////////////////////////////////////////////////////

        Label payment = new Label("Payment");
        payment.setStyle("-fx-font: normal bold 30px 'serif'");

        Button payBtn = new Button("Pay");
        Button returnToSignInPage = new Button("Return to Sign in");
        payBtn.getStyleClass().add("payBtn");

        returnToSignInPage.getStylesheets().add(cssFile);
        payBtn.getStylesheets().add(cssFile);

        GridPane root = new GridPane();
        root.add(payment,0,0,2,1);
//        root.add(payBtn,4,9);

        root.setVgap(20);
        root.setHgap(20);
        root.setPadding(new Insets(20));


        TableView table = new TableView();
        table.getStyleClass().add("cartTable");

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No Games In Cart"));

        TableColumn<Games,String> firstColumn = new TableColumn<>("Game Name");
        firstColumn.setCellValueFactory(new PropertyValueFactory<>("gameName"));

        TableColumn<Games,Double> secondColumn = new TableColumn<>("Price");
        secondColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        table.getColumns().addAll(firstColumn,secondColumn);
        table.setPrefWidth(400);

        VBox vBox = new VBox(table);
        vBox.setPadding(new Insets(20));

        payBtn.setOnAction((ActionEvent event) -> {
            //deletes items in table
            for (Games games : gamesInCart){
                table.getItems().remove(games);
            }
            gamesInCart.clear();
        });

        returnToSignInPage.setOnAction((ActionEvent event) -> {
            stage.setScene(scene);
            for (Games games : gamesInCart){
                table.getItems().remove(games);
            }
            gamesInCart.clear();
        });

        GridPane fifthGrid = new GridPane();
        fifthGrid.add(payment, 2, 0);
        fifthGrid.add(returnToSignInPage,5,6);
        fifthGrid.add(vBox, 0, 1,6,3);
        fifthGrid.add(payBtn,2,6);

        fifthGrid.setAlignment(Pos.CENTER);
        fifthGrid.setHgap(10);
        fifthGrid.setPadding(new Insets(30));
        fifthGrid.setStyle("-fx-background-color: rgb(18,18,18)");


        Scene fifthScene = new Scene(fifthGrid, 600, 500);

//End of fifth scene////////////////////////////////////////////////////////////////

        addToCart.setOnAction((ActionEvent event) -> {
            //First we need to set up this button to add things to cart (ArrayList<Games>)
            //and actually there is no need to add game in cart to a DB,
            // so we will do all the operations on the UserInfo table in DB
            int i = indexOfCurrentGame[0];
            Games game = new Games(gameNames.get(i),gamePrices.get(i));
            gamesInCart.add(game);
            table.getItems().add(game);
        });

        modifyUser.setOnAction((ActionEvent event) -> {
            //This is the button that will set the scene to the
            //fourth scene which will have the remaining methods (Update,Remove)
            stage.setScene(fourthScene);
        });

        viewCart.setOnAction((ActionEvent event) -> {
            //This button will set the stage to the fifth scene ,
            //where there will be a table with the items in cart
            stage.setScene(fifthScene);
            indexOfCurrentGame[0] = 0;
        });

        signInPage1.setOnAction((ActionEvent event) -> {
            for (Users user : users) {
                if (usernameField.getText().equals(user.getUsername()) && passwordField.getText().equals(user.getPassword())) {
                    stage.setScene(thirdScene);
                    signInWelcomeMsg.setText("Welcome " + user.getUsername());
                    signedInUser[0] = users.indexOf(user);
                    signInError.setText("");
                    usernameField.setText("");
                    passwordField.setText("");
                    break;
                } else {
                    signInError.setText("Invalid Username or Password");

                }
            }
        });

        signInButtonInPage2.setOnAction((ActionEvent event) -> {
            signUpUsernameField.clear();
            signUpPassField.clear();
            confirmPassField.clear();
            signUpError.setText("");
            stage.setScene(scene);
        });

        signUpButtonInPage1.setOnAction((ActionEvent event) -> {
            usernameField.clear();
            passwordField.clear();
            signInError.setText("");
            stage.setScene(signUpScene);

        });

        signUpPage2.setOnAction((ActionEvent event) -> {
            Users newUser = new Users(signUpUsernameField.getText(), signUpPassField.getText());
            boolean usernameAvailable = true;
            for (Users user : users) {
                if (user.getUsername().equals(newUser.getUsername())) {
                    usernameAvailable = false;
                    break;
                }
            }
            try {
                if (newUser.getUsername().equals("") || newUser.getPassword().equals("")) {
                    signUpError.setText("Empty username or password field");
                } else if (!usernameAvailable) {
                    signUpError.setText("Username taken, please try a different username");
                } else if (newUser.getPassword().length() < 8) {
                    signUpError.setText("Password must be at least 8 characters");
                } else if (!signUpPassField.getText().equals(confirmPassField.getText())) {
                    signUpError.setText("Password Doesn't Match");
                } else {
                    DBMethods.addUser(newUser);
                    users.add(newUser);
                    stage.setScene(scene);
                    signUpUsernameField.clear();
                    signUpPassField.clear();
                    confirmPassField.clear();
                    signUpError.setText("");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}