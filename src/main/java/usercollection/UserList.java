package usercollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduard on 1/7/16.
 */
public class UserList {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
