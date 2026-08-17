import model.User;
import model.Income;
import model.Expense;
import model.Transaction;

public class Main {

    public static void main(String[] args) {

        User user = new User(
            1,
            "Avi",
            "avi123",
            "1234"
        );

        Income income = new Income(
            1,
            user.getId(),
            30000,
            "Salary",
            "2026-08-17",
            "August salary"
        );

        Expense expense = new Expense(
            2,
            user.getId(),
            500,
            "Food",
            "2026-08-17",
            "Lunch"
        );

        System.out.println("===== USER =====");
        System.out.println("Name: " + user.getName());

        System.out.println("\n===== INCOME =====");
        System.out.println(income);

        System.out.println("\n===== EXPENSE =====");
        System.out.println(expense);
    }
}