package com.example.learn6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.*;

import java.io.IOException;

public class HelloApplication extends Application {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet res = null;
    ObservableList<Student> data;
    TableView<Student> table;

    @Override
    public void start(Stage stage) throws IOException {
        Button btn1 = new Button();
        btn1.setText("Add");

        Button btn2 = new Button();
        btn2.setText("Clear");

        Text txt1 = new Text("Add New Student");

        Label l1 = new Label("ID");
        Label l2 = new Label("Name");
        Label l3 = new Label("CGPA");
        Label l4 = new Label("Major");

        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();

        GridPane g1 = new GridPane();
        g1.add(txt1, 0, 0, 2, 1);
        g1.add(l1, 0, 1);
        g1.add(t1, 1, 1);
        g1.add(l2, 0, 2);
        g1.add(t2, 1, 2);
        g1.add(l3, 0, 3);
        g1.add(t3, 1, 3);
        g1.add(l4, 0, 4);
        g1.add(t4, 1, 4);

        g1.add(btn1, 0, 6);
        g1.add(btn2, 1, 6);

        g1.setVgap(10);
        g1.setHgap(10);
        g1.setAlignment(Pos.CENTER);
        g1.setPadding(new Insets(20));

        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No rows to display"));

        TableColumn c1 = new TableColumn("ID");
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn c2 = new TableColumn("Name");
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn c3 = new TableColumn("CGPA");
        c3.setCellValueFactory(new PropertyValueFactory<>("cgpa"));

        TableColumn c4 = new TableColumn("Major");
        c4.setCellValueFactory(new PropertyValueFactory<>("major"));

        table.getColumns().addAll(c1, c2, c3, c4);
        VBox v = new VBox(table);
        v.setPadding(new Insets(20));

        try {
            show();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        Label l5 = new Label("Update Student's Major by ID: ");
        Label l6 = new Label("ID");
        TextField t5 = new TextField();
        Label l7 = new Label("Major");
        TextField t6 = new TextField();
        Button btn3 = new Button("Update");

        GridPane g2 = new GridPane();

        g2.add(l5, 0, 0, 2, 1);
        g2.add(l6, 0, 1);
        g2.add(t5, 1, 1);
        g2.add(l7, 0, 2);
        g2.add(t6, 1, 2);
        g2.add(btn3, 0, 3, 2, 1);

        g2.setVgap(10);
        g2.setHgap(10);
        g2.setPadding(new Insets(20));

        Label l8 = new Label("Delete Student by ID: ");
        Label l9 = new Label("ID");
        TextField t7 = new TextField();
        Button btn4 = new Button("Delete");

        GridPane g3 = new GridPane();

        g3.add(l8, 0, 0, 2, 1);
        g3.add(l9, 0, 1);
        g3.add(t7, 1, 1);
        g3.add(btn4, 0, 2, 2, 1);

        g3.setVgap(10);
        g3.setHgap(10);
        g3.setPadding(new Insets(20));

        Label l10 = new Label("Average CGPA:  ");
        Button btn5 = new Button("Avg");
        Label l11 = new Label();

        GridPane g4 = new GridPane();

        g4.add(l10, 0, 0, 2, 1);
        g4.add(btn5, 0, 1);
        g4.add(l11, 0, 2);

        g4.setVgap(10);
        g4.setHgap(10);
        g4.setPadding(new Insets(20));

        VBox vbox = new VBox(g2, g3, g4);

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
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        });

        btn2.setOnAction((ActionEvent event) -> {

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        });

        btn3.setOnAction((ActionEvent event) -> {

            String id = t5.getText();
            String m = t6.getText();

            String sql = "Update students set major = ? where id = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, m);
                pst.setString(2, id);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });

        btn4.setOnAction(e -> {
            String id = t7.getText();
            String sql = "Delete from students where id = ?";

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });
        btn5.setOnAction(e -> {
            String sql = "select avg (cgpa) from students"; // avg, sum, count, min, max

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                res = pst.executeQuery();
                if (res.next()) {
                    l11.setText(Double.toString(res.getDouble(1)));
                }
                pst.close();
                conn.close();

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });

        FlowPane root = new FlowPane(g1, v, vbox);
        Scene scene = new Scene(root, 1000, 500);

        stage.setTitle("DB Connection");
        stage.setScene(scene);
        stage.show();
    }
    public void show() throws SQLException {

        data = FXCollections.observableArrayList();
        conn = dbConn.DBConnection();

        pst = conn.prepareStatement("select * from students");
        res = pst.executeQuery();

        while (res.next()) {
            data.add(new Student(res.getInt(1), res.getString(2), res.getDouble(3), res.getString(4)));

        }
        pst.close();
        conn.close();
        table.setItems(data);
    }



    public static void main(String[] args) {
        launch();
    }
}