
import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter a password: ");
            String password = scanner.nextLine();

            String strength = checkPasswordStrength(password);

            if (strength.equals("weak")) {
                System.out.println("Weak password. Please try again.");
            } else if (strength.equals("medium")) {
                System.out.print("Medium password. Press 'enter' to keep this password, or type 'Reenter' to try again: ");
                String input = scanner.nextLine();
                if (input.equals("reenter")) {
                    continue;
                } else {
                    System.out.println("Password accepted.");
                    break;
                }
            } else if (strength.equals("strong")) {
                System.out.println("Strong password. Password accepted.");
                break;
            }
        }
    }

    private static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "weak";
        } else if (password.length() >= 8 && password.matches(".*[a-zA-Z]+.*") && password.matches(".*[0-9]+.*")) {
            return "medium";
        } else if (password.length() >= 12 && password.matches(".*[a-zA-Z]+.*") && password.matches(".*[0-9]+.*") && password.matches(".*[A-Z]+.*") && password.matches(".*[a-z]+.*")) {
            return "strong";
        } else {
            return "weak";
        }
    }
}