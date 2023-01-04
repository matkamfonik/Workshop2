package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

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
                password = ?,
            WHERE id = ?;
            """;
    private static final String DELETE_USER_QUERY = """
            DELETE FROM users
            WHERE id = ?
            """;
    public String hashPassword (String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
