package com.example.fnk.rftbead.MyClasses;

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


}
