package com.example.finalprojectfx;

public class Games {
    private  String gameName;
    private double price;
    public Games(String gameName, double price) {
        this.gameName = gameName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Games{" +
                "gameName='" + gameName + '\'' +
                ", price=" + price +
                '}';
    }
}

