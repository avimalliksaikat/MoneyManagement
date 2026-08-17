package model;

public class Expense extends Transaction {

    public Expense(int id, int userId, double amount,
                   String category, String date, String description) {

        super(id, userId, amount, category, date, description);
    }

    @Override
    public String getType() {
        return "EXPENSE";
    }
}