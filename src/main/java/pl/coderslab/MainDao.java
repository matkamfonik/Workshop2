package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.sql.SQLException;

public class MainDao {
    public static void main(String[] args) throws SQLException {
//        User user = new User();
//        user.setUserName("user1");
//        user.setEmail( "mail@wp.pl");
//        user.setPassword("12345");
        UserDao userDao = new UserDao();
//        userDao.create(user);
        User user = userDao.read(1);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        user.setId(3);
        user.setEmail("jakiś@email.com");
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        userDao.update(user);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
    }

}
