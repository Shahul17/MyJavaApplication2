package Services;


public interface UserDao {

  int register(User user);

  User validateUser(Login login);
}
