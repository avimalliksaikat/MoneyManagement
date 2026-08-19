package model;

public class Expense {

    private String username;
    private double amount;
    private String category;
    private String date;

    
    public Expense(String username, double amount,
                   String category, String date) {

        this.username = username;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String getUsername() {
        return username;
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
}
