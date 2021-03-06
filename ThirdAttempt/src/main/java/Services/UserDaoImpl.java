package Services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int register(User user) {
    String sql = "insert into users values(?,?,?,?)";

    return jdbcTemplate.update(sql, new Object[] { user.getEmail(), user.getUserName(), user.getPassword(),
        user.ConfirmPassword });
  }

  public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getEmail() + "' and password='" + login.getPassword()
        + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }

}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setEmail(rs.getString("Email"));
    user.setUserName(rs.getString("UserName"));
    user.setPassword(rs.getString("Password"));
    user.setConfirmPassword(rs.getString("ConfirmPassword"));
   

    return user;
  }
}
