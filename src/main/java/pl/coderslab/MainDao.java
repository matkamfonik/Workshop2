package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.sql.SQLException;

public class MainDao {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
//        userDao.deleteAll();
//        User user = new User();
//        user.setUserName("user4");
//        user.setEmail( "mail4@wp.pl");
//        user.setPassword("12345");
//        userDao.create(user);
//        User user = userDao.read(1);
//        System.out.println(user.getId());
//        System.out.println(user.getEmail());
//        System.out.println(user.getUserName());
//        System.out.println(user.getPassword());
//        user.setId(3);
//        user.setEmail("jakiś@email.com");
//        System.out.println(user.getId());
//        System.out.println(user.getEmail());
//        System.out.println(user.getUserName());
//        System.out.println(user.getPassword());
//        userDao.update(user);
//        System.out.println(user.getId());
//        System.out.println(user.getEmail());
//        System.out.println(user.getUserName());
//        System.out.println(user.getPassword());
//        userDao.delete(3);
        User[] users = userDao.findAll();
        System.out.println(users.length);
        System.out.println(users[0].getId());
        System.out.println(users[0].getEmail());
        System.out.println(users[0].getUserName());
        System.out.println(users[0].getPassword());
    }

}
