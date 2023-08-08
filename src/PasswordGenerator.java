import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialCharacters = scanner.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeLowercase, includeUppercase, includeNumbers, includeSpecialCharacters);
        System.out.println("Generated password: " + password);
    }

    private static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                           boolean includeNumbers, boolean includeSpecialCharacters) {
        StringBuilder characters = new StringBuilder();
        if (includeLowercase) {
            characters.append(LOWERCASE_LETTERS);
        }
        if (includeUppercase) {
            characters.append(UPPERCASE_LETTERS);
        }
        if (includeNumbers) {
            characters.append(NUMBERS);
        }
        if (includeSpecialCharacters) {
            characters.append(SPECIAL_CHARACTERS);
        }

        SecureRandom random = new SecureRandom();
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password[i] = characters.charAt(randomIndex);
        }
        return new String(password);
    }
}

