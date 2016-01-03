package com.example.fnk.rftbead;

/**
 * Created by Főnök on 2015.12.30..
 */
public class Queries
{
    private final static String apiKey = "dfa1a4ba-09c0-4200-80d5-6f42a4fc7fd9";

    public String getUserData(String region,String username)
    {
        username = username.replace(" ","%20");
        return "https://"+region+".api.pvp.net/api/lol/"+region+"/v1.4/summoner/by-name/"+username+"?api_key="+apiKey;
    }

    public String getGameData(boolean isSummary,int summonerid,String region)
    {
        String type = "";
        if(isSummary) type = "summary";
        else type = "ranked";

        return "https://"+region+".api.pvp.net/api/lol/"+region+"/v1.3/stats/by-summoner/"+summonerid+"/"+type+"?season=SEASON2015&api_key="+apiKey;
    }

}
