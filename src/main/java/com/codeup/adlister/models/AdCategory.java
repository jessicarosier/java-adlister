package com.codeup.adlister.models;

import java.io.Serializable;

public class AdCategory implements Serializable {

    private long catId;

    private long adId;

    public AdCategory() {}

    public AdCategory(long catId, long adId) {
        this.catId = catId;
        this.adId = adId;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }
}
