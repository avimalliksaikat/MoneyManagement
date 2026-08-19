package model;

public class Transaction {

    private String username;
    private String type;
    private double amount;
    private String description;
    private String date;

    
    public Transaction(String username,
                       String type,
                       double amount,
                       String description,
                       String date) {

        this.username = username;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }
}
