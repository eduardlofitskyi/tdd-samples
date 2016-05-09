/**
 * Created by eduard on 1/3/16.
 */
public class PasswordValidator {

    public static boolean checkLength(String password) {
        if (password==null){
            return false;
        }
        return password.length()>=6;
    }

    public static boolean checkDigit(String password) {
        if (password==null){
            return false;
        }
        char[] arr = password.toCharArray();
        for (char anArr : arr) {
            if (Character.isDigit(anArr)) {
                return true;
            }
        }
        return false;
    }
}
