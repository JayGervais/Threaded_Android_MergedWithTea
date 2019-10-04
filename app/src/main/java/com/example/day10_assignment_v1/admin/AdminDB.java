package com.example.day10_assignment_v1.admin;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.agent.Agent;
import com.example.day10_assignment_v1.login.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminDB
{
    public static void AddAdmin(final String url, final Context context, final String adminId,
                                final String adminFirstName, final String adminLastName,
                                final String adminPosition, final String adminEmail,
                                final String password)
    {
        final StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String ServerResponse)
            {
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.dismiss();
            }
        },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError volleyError)
                    {
                        ProgressDialog progressDialog = new ProgressDialog(context);
                        progressDialog.dismiss();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> parameters = new HashMap<>();
                if (adminId != null)
                {
                    parameters.put("AdminId", adminId);
                }
                parameters.put("AdminFirstName", adminFirstName);
                parameters.put("AdminLastName", adminLastName);
                parameters.put("AdminEmail", adminEmail);
                parameters.put("AdminPosition", adminPosition);
                parameters.put("AdminPassword", password);
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }

    public static void SetAdminLoginSession(final String urlWebService, final Context cont, final Session session)
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

                    ArrayAdapter<Admin> arrayAdapter = new ArrayAdapter<>(cont, android.R.layout.simple_list_item_1);
                    String[] adminId = new String[jsonArray.length()];
                    String[] adminName = new String[jsonArray.length()];
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        arrayAdapter.add(new Admin(Integer.parseInt(obj.getString("AdminId")),
                                obj.getString("AdminFirstName"),
                                obj.getString("AdminLastName"),
                                obj.getString("AdminEmail"),
                                obj.getString("AdminPosition"),
                                null));
                        adminId[i] = obj.getString("AdminId");
                        adminName[i] = obj.getString("AdminFirstName") + " " + obj.getString("AdminLastName");
                    }
                    session.setsessionid(String.valueOf(adminId[0]));
                    session.setsessionname(adminName[0]);
                    session.setsessionrole("admin");

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
