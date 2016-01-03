package com.example.fnk.rftbead;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnk.rftbead.MyClassesRanked.RankedStatRow;
import com.example.fnk.rftbead.MyClassesRanked.RankedStatRowCalculator;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RankedStat extends Activity {


    TextView Kills, Assits, Farm, Deaths, Win, Lose, Match;


    private String resultString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranked_stat);

        List<RankedStatRow> allRow = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            resultString= extras.getString("result");
            allRow = getjson(resultString);
        }
        RankedStatRowCalculator calculator = new RankedStatRowCalculator();
        int totalKill = calculator.getAllChampionKill(allRow);
        int totalAssist = calculator.getAllChampionAssist(allRow);
        int totalFarm=calculator.getAllMinionKill(allRow);
        int totalDeath=calculator.getTotalDeaths(allRow);
        int totalWin=calculator.getTotalWins(allRow);
        int totalLose=calculator.getTotalLost(allRow);
        int totalMatch=calculator.getTotalMatch(allRow);
        

        Kills = (TextView) findViewById(R.id.kills);
        Assits=(TextView) findViewById(R.id.assits);
        Farm=(TextView) findViewById(R.id.farm);
        Deaths=(TextView) findViewById(R.id.deaths);
        Win=(TextView) findViewById(R.id.win);
        Lose=(TextView) findViewById(R.id.lose);
        Match=(TextView) findViewById(R.id.match);


        Kills.append(""+totalKill);
        Assits.append(""+totalAssist);
        Farm.append("" + totalFarm);
        Deaths.append(""+totalDeath);
        Win.append(""+totalWin);
        Lose.append(""+totalLose);
        Match.append(""+totalMatch);

       // Toast.makeText(this,"Összes gyilkosság: "+totalKill+"  Összes assziszt: "+totalAssist+" Összes farm: "+totalFarm,Toast.LENGTH_LONG).show();
    }


    private List<RankedStatRow> getjson(String jsonstring)
    {
        List<RankedStatRow> statsList = new ArrayList<>();

        JSONObject jsonObject = null;
        try
        {
            jsonObject = new JSONObject(jsonstring);
            JSONArray champions = jsonObject.getJSONArray("champions");
            for(int i = 0; i < champions.length()-1;i++)
            {
                JSONObject champData = champions.getJSONObject(i);
                JSONObject stats = champData.getJSONObject("stats");

                int championID = champData.getInt("id");
                int totalAssists = stats.getInt("totalAssists");
                int totalChampionKills = stats.getInt("totalChampionKills");
                int totalMinonKills=stats.getInt("totalMinionKills");
                int totalDeaths=stats.getInt("totalDeathsPerSession");
                int totalSessionWon=stats.getInt("totalSessionsWon");
                int totalSessionLost=stats.getInt("totalSessionsLost");

                Log.d("MYLOGGER", "champid: " + championID + "  totalassziszt:" + totalAssists + " totalgyilok" + totalChampionKills + " totalfarm" + totalMinonKills + " totalhalal" + totalDeaths);

                RankedStatRow rankedStat = new RankedStatRow();
                rankedStat.setTotalAssists(totalAssists);
                rankedStat.setTotalChampionKills(totalChampionKills);
                rankedStat.setTotalFarm(totalMinonKills);
                rankedStat.setTotalDeaths(totalDeaths);
                rankedStat.setTotalWins(totalSessionWon);
                rankedStat.setTotalLost(totalSessionLost);

                statsList.add(rankedStat);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return statsList;
    }


}

