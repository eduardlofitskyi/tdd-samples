package userservice;

/**
 * Created by eduard on 1/6/16.
 */
public class UserServiceImpl {

    private UserDAO userDAO;
    private SecurityService securityService;

    public UserServiceImpl(UserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }

    public void assignPassword(User user) throws Exception{
        String pass = user.getPassword();
        String passwordMd5 = securityService.md5(pass);
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }
}
