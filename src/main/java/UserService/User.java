package UserService;

/**
 * Created by eduard on 1/4/16.
 */
public interface User {
    void setPassword(String passwordMd5);

    String getPassword();
}
