package com.example.fnk.rftbead;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Főnök on 2015.12.30..
 */
public class Connection  extends AsyncTask<String, Void, String> {

    private Context context;
    private String processName;

    public Connection(Context context,String processName)
    {
        this.processName = processName;
        this.context = context;
    }

    protected String doInBackground(String... params)
    {
        if(!isOnline())
            return "nonet";

        String jsonResponse = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            // Read the whole InputStream
            Scanner s = new Scanner(in).useDelimiter("\\A");
            jsonResponse = s.hasNext() ? s.next() : null;
        } catch (IOException e) {
            return "404error";
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return jsonResponse;
    }

    protected void onPostExecute(String result)
    {
        if(result.equals("nonet"))
        {
            Toast.makeText(context, "Nincs internet!", Toast.LENGTH_SHORT).show();
        }
        else if(result.equals("404error"))
        {
            switch (processName) {
                case "login":
                {
                    Toast.makeText(context,"Nincs ilyen felhasználó!",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
        else
        {
            switch (processName)
            {
                case "login":
                {
                    //{"alma":{"id":34663927,"name":"ALMA","profileIconId":689,"summonerLevel":30,"revisionDate":1448056954000}}

                    JSONObject jsonobject = null;
                    try{
                         jsonobject = new JSONObject(result);
                         Storage mystorage = new Storage(context);
                         String summoner_name = mystorage.getSummonerName();
                         summoner_name = summoner_name.toLowerCase();

                         JSONObject data = jsonobject.getJSONObject(summoner_name);
                         int id = data.getInt("id");
                         String name=data.getString("name");

                        mystorage.setSummonerId(id);
                        Intent i = new Intent(context,Page2.class);
                        context.startActivity(i);

                    }catch(Exception e)
                    {
                       e.printStackTrace();
                    }


                    break;
                }
                case "getgamedataranked":
                {
                    Intent i = new Intent(context,RankedStat.class);
                    i.putExtra("result",result);
                    context.startActivity(i);
                    break;
                }
                case "getgamedatasummary":
                {
                    Intent i = new Intent(context,SummaryStatActivity.class);
                    i.putExtra("result",result);
                    context.startActivity(i);
                    break;
                }
            }
        }
    }

    private boolean isOnline()
    {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
