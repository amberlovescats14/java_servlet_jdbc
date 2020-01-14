package dao;

import config.Config;
import models.Ad;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;

public class MySQLAdDao implements Ads {

    private Connection connection;
    private Statement statement;

    public MySQLAdDao() {


        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createAd(long user_id, String title, String description) {
        try {
            String query = String.format("insert into ads (user_id, title, description) VALUES" +
                            "(%d, '%s', '%s')",
                    user_id,title, description);
            System.out.println(query);
            boolean success = statement.execute(query);

            System.out.println(success);
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }

    @Override
    public ArrayList<Ad> getAll() {
        ArrayList<Ad> ads = new ArrayList<>();
        try {
            String query = "select * from ads";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()){
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return ads;
    }

    @Override
    public Ad getById(long id) {
        Ad ad = new Ad();
        try {
            String query = "select * from ads where id = " + id;
            System.out.println(query);
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            ad.setId(rs.getLong("id"));
            ad.setUserId(rs.getLong("user_id"));
            ad.setTitle(rs.getString("title"));
            ad.setDescription(rs.getString("description"));
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return ad;

    }

    @Override
    public ArrayList<Ad> updateById(long id, long user_id) {
        try {
            Ad newAd = new Ad(
                    user_id,
                    "Nail Polish",
                    "Lady Glitter Sparkles"
            );

            String updateQuery = String.format("update ads set title = '%s', description = '%s' where id = %d",
                    newAd.getTitle(),
                    newAd.getDescription(),
                    newAd.getId()
            );
            boolean success = statement.execute(updateQuery);
            System.out.println(success);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MySQLAdDao().getAll();
    }

    @Override
    public void deleteById(long id) {
        try {
            String query = "delete from ads where id = " + id;
            boolean success = statement.execute(query);

            System.out.println(success);
        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }

    }

    public static void main(String[] args) {



//        System.out.println(new MySQLAdDao().getById(2));

//        ArrayList<Ad> updated = new MySQLAdDao().updateById(2,2);
//        for (Ad ad : updated) {
//            System.out.println(ad);
//        }
//    MySQLAdDao mySQLAdDao = new MySQLAdDao();
//        mySQLAdDao.createAd(1, "Need Starbuck", "Coffee First");
        new MySQLAdDao().deleteById(2);

        ArrayList<Ad> all = new MySQLAdDao().getAll();
        for (Ad ad : all) {
            System.out.println(ad);
        }
    }
}
