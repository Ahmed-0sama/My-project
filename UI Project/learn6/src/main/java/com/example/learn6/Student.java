package com.example.learn6;

public class Student {
    private int id;
    private String name;
    private double cgpa;
    private String major;

    public Student(int id, String name, double cgpa, String major) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
