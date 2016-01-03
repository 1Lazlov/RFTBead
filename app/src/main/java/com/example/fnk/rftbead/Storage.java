package com.example.fnk.rftbead;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Főnök on 2015.12.30..
 */
public class Storage {
    private static final String PREF_NAME = "com.example.fnk.rftbead.laci";
    private static final String KEY_SUMMONER_NAME = "summoner_name";
    private static final String KEY_SUMMONER_ID = "summoner_id";
    private static final String KEY_SUMMONER_REGION = "summoner_region";

    private SharedPreferences preferences;

    public Storage(Context ctx){
        preferences = ctx.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getSummonerId(){
        return preferences.getInt(KEY_SUMMONER_ID, -1);
    }

    public void setSummonerId(int id){
        preferences.edit().putInt(KEY_SUMMONER_ID, id).commit();
    }

    public String getSummonerName(){
        return preferences.getString(KEY_SUMMONER_NAME, "");
    }

    public void setSummonerName(String name){
        preferences.edit().putString(KEY_SUMMONER_NAME, name).commit();
    }

    public String getSummonerRegion(){
        return preferences.getString(KEY_SUMMONER_REGION, "");
    }

    public void setSummonerRegion(String reg){
        preferences.edit().putString(KEY_SUMMONER_REGION, reg).commit();
    }
}

