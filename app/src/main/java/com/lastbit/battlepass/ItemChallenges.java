package com.lastbit.battlepass;

public class ItemChallenges {

    String season_storage;
    String season_path;


    public ItemChallenges(String season_path,String season_storage) {
        this.season_path = season_path;
        this.season_storage = season_storage;
    }

    public String getSeason_storage() {
        return season_storage;
    }

    public String getSeason_path() {
        return season_path;
    }


    public void setSeason_storage(String season_storage) {
        this.season_storage = season_storage;
    }

    public void setSeason_path(String season_path) {
        this.season_path = season_path;
    }


}
