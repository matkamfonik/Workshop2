package pl.coderslab;

import java.sql.*;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = Password.PASSWORD;




    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_URL,
                DB_USER,
                DB_PASS
        );
    }

    private static final String DELETE_QUERY = "DELETE FROM tableName where id = ?";

    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update(Connection conn, String query, int id, String... params) {
        try ( PreparedStatement statement =
                      conn.prepareStatement(query.replace("idNumber", String.valueOf(id)))) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
