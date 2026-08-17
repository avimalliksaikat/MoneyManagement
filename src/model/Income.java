package model;

public class Income extends Transaction {

    public Income(int id, int userId, double amount,
                  String category, String date, String description) {

        super(id, userId, amount, category, date, description);
    }

    @Override
    public String getType() {
        return "INCOME";
    }
}