package com.example.fnk.rftbead.MyClassesSummary;

/**
 * Created by Főnök on 2016.01.03..
 */
public class SummaryStatRow {


    private  int totalChampionKills;
    private int wins;
    private int assists;
    private int turrets;
    private int farm;


    public int getTotalChampionKills() {
        return totalChampionKills;
    }
    public void setTotalChampionKills(int totalChampionKills) {
        this.totalChampionKills = totalChampionKills;
    }

    public int getWins(){return wins;}
    public void setWins(int wins){
        this.wins=wins;
    }

    public int getAssists(){return assists;}
    public void setAssists(int assists){
        this.assists=assists;
    }

    public int getTurrets(){return turrets;}
    public void setTurrets(int turrets){
        this.turrets=turrets;
    }

    public int getFarm(){return farm;}
    public void setFarm(int farm){
        this.farm=farm;
    }

}

