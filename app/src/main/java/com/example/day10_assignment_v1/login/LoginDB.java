package com.example.day10_assignment_v1.login;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.agent.Agent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginDB
{
    public static void SetAgentSession(final String urlWebService, final Context cont, final Session session)
    {
        class DownloadJSON extends AsyncTask<Void, Void, String>
        {
            @Override
            protected void onPreExecute()
            {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s)
            {
                super.onPostExecute(s);
                try
                {
                    JSONArray jsonArray = new JSONArray(s);

                    ArrayAdapter<Agent> arrayAdapter = new ArrayAdapter<>(cont, android.R.layout.simple_list_item_1);
                    String[] agentId = new String[jsonArray.length()];
                    String[] agentName = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        arrayAdapter.add(new Agent(Integer.parseInt(obj.getString("AgentId")),
                                obj.getString("AgtFirstName"),
                                obj.getString("AgtMiddleInitial"),
                                obj.getString("AgtLastName"),
                                obj.getString("AgtBusPhone"),
                                obj.getString("AgtEmail"),
                                obj.getString("AgtPosition"),
                                Integer.parseInt(obj.getString("AgencyId")),
                                null));
                        agentId[i] = obj.getString("AgentId");
                        agentName[i] = obj.getString("AgtFirstName") + " " + obj.getString("AgtLastName");
                    }
                    session.setsessionid(String.valueOf(agentId[0]));
                    session.setsessionname(agentName[0]);
                    session.setsessionrole("agent");

                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids)
            {
                return DBHelper.urlInputStream(urlWebService);
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();
    }
}
