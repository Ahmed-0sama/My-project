package com.example.finalprojectfx;

import java.sql.*;
import java.util.ArrayList;

public class DBMethods {
    public static Statement getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/gamesInCart.db");
        return connection.createStatement();
    }
    public static void addUser(Users users) throws SQLException, ClassNotFoundException {
        getConnection().execute("INSERT into UserInfo values ('"+users.getUsername() +"','"+users.getPassword()+"')");
    }

    public static void changePass(String username,String newPass) throws ClassNotFoundException, SQLException {
        getConnection().execute("UPDATE UserInfo set password = "+newPass+" where username = '"+username+"' ");
    }

    public static void removeAccount(String username) throws ClassNotFoundException, SQLException {
        getConnection().execute("Delete from UserInfo where username = '"+username+"' ");
    }

    public static ArrayList<Users> getAllUsers() throws ClassNotFoundException, SQLException {
        Statement statement = getConnection();
        statement.execute("SELECT * from UserInfo");
        ResultSet resultSet = statement.getResultSet();

        ArrayList<Users> usersArrayList = new ArrayList<>();

        while (resultSet.next()){
            String password = resultSet.getString("password");
            String name = resultSet.getString("username");
            usersArrayList.add(new Users(name,password));
        }
        return usersArrayList;
    }


}
