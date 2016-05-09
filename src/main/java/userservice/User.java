package userservice;

/**
 * Created by eduard on 1/6/16.
 */
public interface User {
    String getPassword();

    void setPassword(String passwordMd5);
}
