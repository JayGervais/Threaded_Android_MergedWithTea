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

    public void setsessionname(String sessionname)
    {
        prefs.edit().putString("sessionname", sessionname).commit();
    }

    public String getsessionname()
    {
        String sessionname = prefs.getString("sessionname",null);
        return sessionname;
    }

    public void setsessionrole(String sessionrole)
    {
        prefs.edit().putString("sessionrole", sessionrole).commit();
    }

    public String getsessionrole()
    {
        String sessionrole = prefs.getString("sessionrole",null);
        return sessionrole;
    }


}
