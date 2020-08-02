package Services;


public interface userService {

  int register(User user);

  User validateUser(Login login);
}
