package com.example.fnk.rftbead.MyClassesRanked;

/**
 * Created by Főnök on 2015.12.30..
 */
public class RankedStatRow
{

    /*
    "totalSessionsPlayed":24,
    "totalSessionsLost":10,
    "totalSessionsWon":14,
    "totalChampionKills":52,
    "totalDamageDealt":595069,
    "totalDamageTaken":597025,
    "mostChampionKillsPerSession":6,
    "totalMinionKills":791,
    "totalDoubleKills":3,
    "totalTripleKills":0,
    "totalQuadraKills":0,
    "totalPentaKills":0,
    "totalUnrealKills":0,
    "totalDeathsPerSession":127,
    "totalGoldEarned":223899,
    "mostSpellsCast":0,
    "totalTurretsKilled":4,
    "totalPhysicalDamageDealt":188035,
    "totalMagicDamageDealt":288831,
    "totalFirstBlood":0,
    "totalAssists":450,
    "maxChampionsKilled":6,
    "maxNumDeaths":13
     */

    private  int totalAssists;
    private  int totalChampionKills;
    private  int totalFarm;
    private  int totalDeaths;
    private  int totalWins;
    private  int totalLose;

    public int getTotalChampionKills() {
        return totalChampionKills;
    }
    public void setTotalChampionKills(int totalChampionKills) {
        this.totalChampionKills = totalChampionKills;
    }

    public int getTotalAssists() { return totalAssists; }
    public void setTotalAssists(int totalAssists) {
        this.totalAssists = totalAssists;
    }


    public int getTotalFarm(){return totalFarm;}
    public void setTotalFarm(int totalFarm){
        this.totalFarm=totalFarm;
    }


    public int getTotalDeaths(){return totalDeaths;}
    public void setTotalDeaths(int totalDeaths){
        this.totalDeaths=totalDeaths;
    }

    public int getTotalWins(){return totalWins;}
    public void setTotalWins(int totalWins)
    {
        this.totalWins=totalWins;
    }

    public int getTotalLost(){return totalLose;}
    public void setTotalLost(int totalLose)
    {
        this.totalLose=totalLose;
    }

}
