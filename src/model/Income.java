package model;

public class Income {

    private int id;
    private String username;
    private double amount;
    private String source;
    private String date;

    
    public Income(String username, double amount, String source, String date) {

        this.username = username;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    
    public String getUsername() {
        return username;
    }

    
    public double getAmount() {
        return amount;
    }

    
    public String getSource() {
        return source;
    }

    // Get date
    public String getDate() {
        return date;
    }
}
