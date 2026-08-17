package model;

public abstract class Transaction {

    protected int id;
    protected int userId;
    protected double amount;
    protected String category;
    protected String date;
    protected String description;

    // Constructor
    public Transaction(int id, int userId, double amount,
                       String category, String date, String description) {

        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    // Abstract method
    public abstract String getType();

    // Getters
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    // toString method
    public String toString() {
        return id + " | " + getType() + " | " + amount
                + " | " + category + " | " + date
                + " | " + description;
    }
}