package dao.ads;

import config.Config;
import models.Ad;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;

public class MySQLAdDao implements Ads {

    private Connection connection;

    public MySQLAdDao() {


        try {
            Config config = new Config();
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Ad> getAll() {
        ArrayList<Ad> ads = new ArrayList<>();
        try {
            String query = "select * from ads";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

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
    public Long createAd(Ad ad) {
            long created = 0L;
        try {

            String query = "insert into ads (user_id, title, description) VALUES (?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Long.toString(ad.getUserId()));
            stmt.setString(2,ad.getTitle());
            stmt.setString(3, ad.getDescription());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            while (rs.next()){
                created = rs.getLong(1);
            }
            System.out.println(created);


        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return  created;
    }



    @Override
    public Ad getById(long id) {
        Ad ad = new Ad();
        try {
            String query = "select * from ads where id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, Long.toString(id));

            ResultSet rs = stmt.executeQuery(query);
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
    public int updateById(Ad ad) {
        int numberOfRowsEffected = 0;
        try {
            String query = "update ads set title = ?, description = ? where id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,ad.getTitle());
            stmt.setString(2,ad.getDescription());
            stmt.setString(3, Long.toString(ad.getId()));

            numberOfRowsEffected = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numberOfRowsEffected;
    }

    @Override
    public int deleteById(long id) {
        int numberOfRowsEffected = 0;
        try {
            String query = "delete from ads where id = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, Long.toString(id));

             numberOfRowsEffected = stmt.executeUpdate();

        } catch(SQLException ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        return numberOfRowsEffected;

    }

    public static void main(String[] args) {



//        System.out.println(new MySQLAdDao().getById(2));

        //w: update
//        Ad updateAd = new Ad(9L,"hello", "world");
//        System.out.println("here: "+ new MySQLAdDao().updateById(updateAd));


        //w: create
//        Ad newAdd = new Ad(1L, "prepared", "statment");
//
//         MySQLAdDao mySQLAdDao = new MySQLAdDao();
//        System.out.println(mySQLAdDao.createAd(newAdd));
        //w:delete
//        new MySQLAdDao().deleteById(7);
        //w: all

        ArrayList<Ad> all = new MySQLAdDao().getAll();
        for (Ad ad : all) {
            System.out.println(ad);
        }
    }
}
