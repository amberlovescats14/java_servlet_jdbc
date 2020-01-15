package dao.ads;

import models.Ad;

import java.util.ArrayList;

public interface Ads {

    Long createAd(Ad ad);
    ArrayList<Ad> getAll();
    Ad getById(long id);
    int updateById(Ad ad);
    int deleteById(long id);
}
