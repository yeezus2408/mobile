public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final String DIGIT_REGEX = ".*\\d.*";

    // Статический метод для проверки пароля
    public static boolean validate(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_LENGTH) {
            System.out.println("Пароль должен содержать не менее " + MIN_LENGTH + " символов.");
            return false;
        }

        if (!password.matches(DIGIT_REGEX)) {
            System.out.println("Пароль должен содержать хотя бы одну цифру.");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Пароль 'Password123': " + PasswordValidator.validate("Password123"));
        System.out.println("Пароль 'Passwrd': " + PasswordValidator.validate("Passwrd"));
        System.out.println("Пароль 'Password': " + PasswordValidator.validate("Password"));
        System.out.println("Пароль '12345678': " + PasswordValidator.validate("12345678"));
        System.out.println("Пароль 'Short1': " + PasswordValidator.validate("Short1"));
        System.out.println("Пароль null: " + PasswordValidator.validate(null));
    }
}
