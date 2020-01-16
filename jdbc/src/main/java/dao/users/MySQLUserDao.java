package dao.users;

import com.mysql.cj.jdbc.Driver;
import config.Config;
import models.User;

import java.sql.*;
import java.util.ArrayList;

public class MySQLUserDao implements Users {

    private Connection connection;
    private Statement statement;

    public MySQLUserDao() {
        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String query = "Select * from users";

            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                users.add(new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }

        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return users;
    }

    @Override
    public User getById(long id) {
        User found = new User();
        try {
            String query = "select * from users where id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, Long.toString(id));

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                found.setId(rs.getLong("id"));
                found.setUsername(rs.getString("username"));
                found.setEmail(rs.getString("email"));
                found.setPassword(rs.getString("password"));

            }

        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return found;
    }

    @Override
    public Long createUser(User user) {
        Long id = 0L;
        try {
            String query = "insert into users (username, email, password) values (?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if(rs.next()) id = rs.getLong(1);
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return id;
    }

    @Override
    public int updateUserById(User user) {
        int numberOfRowsEffected = 0;
        try {
            String query = "update users set username = ?, email = ?, password = ? where id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, Long.toString(user.getId()));

            numberOfRowsEffected = stmt.executeUpdate();
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return numberOfRowsEffected;
    }

    @Override
    public int deleteById(long id) {
        int numberOfRowsEffected = 0;
        try {
            String query = "delete from users where id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, Long.toString(id));

            numberOfRowsEffected = stmt.executeUpdate();
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return numberOfRowsEffected;
    }


//    public static void main(String[] args) {
////        //w: create
//////        User newUser = new User("momlovescats", "mm@mail.com", "mm");
//////        System.out.println(new MySQLUserDao().createUser(newUser));
//////
//////        //w: find by id
////////        System.out.println(new MySQLUserDao().getById(1));
//        //w: updte
//        User updatedUser = new User(1,"amberlovescats14", "amber@mail.com", "amj");
//        new MySQLUserDao().updateUserById(updatedUser);
//////        //w: get
//
//        ArrayList<User> users = new MySQLUserDao().getAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
}
