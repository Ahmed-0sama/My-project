/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec6_db;

import java.awt.Button;
import java.awt.Insets;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author NorhanNasr
 */
public class Sec6_db extends Application {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet res = null;
}
    @Override
    public void start(Stage primaryStage) {

        Button btn1 = new Button();
        btn1.setText("insert");
        
        Button btn2 = new Button();
        btn2.setText("print");
 

        Text txt1 = new Text("Add New Student");

        Label l1 = new Label("ID");
        Label l2 = new Label("Name");
        Label l3 = new Label("CGPA");
        Label l4 = new Label("Major");

        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();

        GridPane root = new GridPane();
        root.add(txt1, 0, 0, 2, 1);
        root.add(l1, 0, 1);
        root.add(t1, 1, 1);
        root.add(l2, 0, 2);
        root.add(t2, 1, 2);
        root.add(l3, 0, 3);
        root.add(t3, 1, 3);
        root.add(l4, 0, 4);
        root.add(t4, 1, 4);

        root.add(btn1, 0, 6);
        root.add(btn2, 1, 6);

        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));

       btn1.setOnAction((ActionEvent event) -> {

            conn = dbConn.DBConnection();
            String sql = "Insert into students (id, name, cgpa, major) Values(?,?,?,?)";

            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, t1.getText());
                pst.setString(2, t2.getText());
                pst.setString(3, t3.getText());
                pst.setString(4, t4.getText());
           

                int i = pst.executeUpdate();
                if (i == 1) {
                    System.out.println("Data is inserted");
                }
                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        });

        
        btn2.setOnAction((ActionEvent event) -> {

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement("select * from students");
                res = pst.executeQuery();
                while (res.next()) {
                    System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getDouble(3) + " " + res.getString(4));
                }

                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        });

        
        Scene scene = new Scene(root, 500, 500);

        primaryStage.setTitle("DB Connection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
