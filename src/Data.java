import java.lang.reflect.Array;
import java.util.Arrays;

public class Data {
    String login;
    String password;
    String confirmPassword;

    public  Data(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (checkLogin(login) == true) {
            this.login = login;
        }
        if (checkPassword(password) == true) {
            this.password = password;
        }
        if (checkPassword(confirmPassword) == true && confirmPassword.equals(password)) {
            this.confirmPassword = confirmPassword;
        } else {
            throw new WrongPasswordException("Пароли не соответсвуют");
        }
    }

    public boolean checkLogin(String e) throws WrongLoginException {
        String[] s1 = new String[20];
        if (e.matches("^[a-zA-Z0-9_]+$") && e.length() <= s1.length && !e.isEmpty()) {
            return true;
        } else {
            throw new WrongLoginException("Неправильный логин");
        }
    }
    public boolean checkPassword(String e) throws WrongLoginException, WrongPasswordException {
        String[] s1 = new String[20];
        if (e.matches("^[a-zA-Z0-9_]+$") && e.length() <= s1.length && !e.isEmpty()) {
            return true;
        } else {
            throw new WrongPasswordException("Неправильный пароль");
        }
    }

    public  void printInfo() {
        System.out.println(login + " " + password +  " " +  confirmPassword);
    }
}
