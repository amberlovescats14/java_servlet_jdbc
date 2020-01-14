package dao;

import models.Ad;

import java.util.ArrayList;

public interface Ads {

    void createAd( long user_id, String title, String description);
    ArrayList<Ad> getAll();
    Ad getById(long id);
    ArrayList<Ad> updateById(long id, long user_id);
    void deleteById(long id);
}
