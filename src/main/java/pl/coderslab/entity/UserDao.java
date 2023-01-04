package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.DbUtil;

import java.sql.*;

public class UserDao {
    private static final String CREATE_USER_QUERY = """
            INSERT INTO users (email, username, password)
            VALUES (?, ?, ?)
            """;
    private static final String READ_USER_QUERY = """
            SELECT * 
            FROM users
            WHERE id = ?
            """;
    private static final String UPDATE_USER_QUERY = """
            UPDATE users
            SET email = ?,
                username = ?,
                password = ?
            WHERE id = ?;
            """;
    private static final String DELETE_USER_QUERY = """
            DELETE FROM users
            WHERE id = ?
            """;
    public String hashPassword (String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public User create (User user){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public User read (int userId){
        User user = new User();
        try(Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_USER_QUERY);
            statement.setString(1, Integer.toString(userId));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user.setId(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                user.setUserName(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
            }
            return user;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void update (User user){
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(UPDATE_USER_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
