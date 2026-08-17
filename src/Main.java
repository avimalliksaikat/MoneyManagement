import model.User;

public class Main {

    public static void main(String[] args) {

        User user = new User(
            1,
            "Avi",
            "avi123",
            "1234"
        );

        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
    }
}