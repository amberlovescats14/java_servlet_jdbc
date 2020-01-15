package dao;

import dao.ads.Ads;
import dao.ads.MySQLAdDao;
import dao.users.MySQLUserDao;
import dao.users.Users;

public class DaoFactory {
    //w: user

    private static Users userDao;

    public static Users getUserDao(){
        if(userDao == null) userDao = new MySQLUserDao();
        return userDao;
    }

    //w: ad
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if(adsDao == null) adsDao = new MySQLAdDao();
        return adsDao;
    }


}
