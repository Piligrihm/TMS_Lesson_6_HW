import com.tms.exception.WrongLoginException;
import com.tms.exception.WrongPasswordException;

public class Task_01 {
    public static void main(String[] args) {

        String login = "Alex";
        String password = "мзмриомз1";
        String confirmPassword = "мзмриомз1";

        try {
            if (confirmation(login, password, confirmPassword)) {
                System.out.println("Вход успешно выполнен");
            } else {
                System.out.println("В доступе отказано");
            }
        } catch (WrongPasswordException | WrongLoginException e) {
            e.printStackTrace();
        }
    }

    public static boolean confirmation(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        //логин без пробелов и не больше 20 символов
        if (login.length() > 20 || login.contains(" ")) {
            throw new WrongLoginException("Введен недопустимый логин");
        } else if (password.length() > 20 || password.contains(" ") || password.matches("[\\p{L}| ]+")) {
            throw new WrongPasswordException("Введен недопустимый пароль");
        } else if (!password.equals(confirmPassword)) {
            System.out.println("Пароли не совпадают");
            return false;
        }
        return true;
    }
}
