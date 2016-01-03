package com.example.fnk.rftbead.MyClassesRanked;

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

}
