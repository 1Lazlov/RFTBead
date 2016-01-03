package com.example.fnk.rftbead.MyClassesRanked;

import com.example.fnk.rftbead.RankedStat;

import java.util.List;

/**
 * Created by Főnök on 2015.12.30..
 */
public class RankedStatRowCalculator
{

    public int getAllChampionKill(List<RankedStatRow> list)
    {
        int sum = 0;
        for(RankedStatRow item:list)
        {
            sum += item.getTotalChampionKills();
        }
        return sum;
    }

    public int getAllChampionAssist(List<RankedStatRow> list)
    {
        int sum = 0;
        for(RankedStatRow item:list)
        {
            sum += item.getTotalAssists();
        }
        return sum;
    }

    public int getAllMinionKill(List<RankedStatRow> list)
    {
        int sum=0;
        for(RankedStatRow item:list)
        {
            sum+=item.getTotalFarm();
        }
        return sum;
    }

    public int getTotalDeaths(List<RankedStatRow> list)
    {
        int sum=0;
        for(RankedStatRow item:list)
        {
            sum+=item.getTotalDeaths();
        }
        return sum;
    }

    public int getTotalWins(List<RankedStatRow> list)
    {
        int sum=0;
        for(RankedStatRow item:list)
        {
            sum+=item.getTotalWins();
        }
        return sum;
    }

    public int getTotalLost(List<RankedStatRow> list)
    {
        int sum=0;
        for(RankedStatRow item:list)
        {
            sum+=item.getTotalLost();
        }
        return sum;
    }

    public int getTotalMatch(List<RankedStatRow> list)
    {
        int w= 0;
        int l=0;

        for(RankedStatRow item:list)
        {
            w+=item.getTotalLost();
        }
        for(RankedStatRow item:list)
        {
            l+=item.getTotalWins();
        }
        return w+l;
    }

}
