package model;

public class Income {

    private int id;
    private String username;
    private double amount;
    private String source;
    private String date;

    // Constructor
    public Income(String username, double amount, String source, String date) {

        this.username = username;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    // Get username
    public String getUsername() {
        return username;
    }

    // Get amount
    public double getAmount() {
        return amount;
    }

    // Get source
    public String getSource() {
        return source;
    }

    // Get date
    public String getDate() {
        return date;
    }
}