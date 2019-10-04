package com.example.day10_assignment_v1.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session
{
    private SharedPreferences prefs;

    public Session(Context context)
    {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setsessionid(String sessionid)
    {
        prefs.edit().putString("sessionid", sessionid).commit();
    }

    public String getsessionid()
    {
        String sessionid = prefs.getString("sessionid",null);
        return sessionid;
    }
}
