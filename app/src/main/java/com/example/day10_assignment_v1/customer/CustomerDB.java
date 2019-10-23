package com.example.day10_assignment_v1.customer;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.day10_assignment_v1.DBHelper;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CustomerDB
{
    public static void SelectedCustomerData(final String urlWebService, final Context cont,
                                            final TextView tvCustFirstName, final TextView tvCustLastName,
                                            final TextView tvCustPhone, final  TextView tvCustEmail)
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
                    String[] customers = new String[jsonArray.length()];
                    String[] cFName = new String[jsonArray.length()];
                    String[] cLName = new String[jsonArray.length()];
                    String[] cPhone = new String[jsonArray.length()];
                    String[] cEmail = new String[jsonArray.length()];

                    ArrayAdapter<Customer> arrayAdapter = new ArrayAdapter<>(cont, android.R.layout.simple_list_item_1);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        arrayAdapter.add(new Customer(Integer.parseInt(obj.getString("CustomerId")),
                                obj.getString("CustFirstName"),
                                obj.getString("CustLastName"),
                                obj.getString("CustHomePhone"),
                                obj.getString("CustEmail")));

                        customers[i] = obj.getString("CustFirstName") + " " + obj.getString("CustLastName");

                        // set variables
                        cFName[i] = obj.getString("CustFirstName");
                        cLName[i] = obj.getString("CustLastName");
                        cPhone[i] = obj.getString("CustHomePhone");
                        cEmail[i] = obj.getString("CustEmail");
                    }

                    // set text fields
                    tvCustFirstName.setText(cFName[0]);
                    tvCustLastName.setText(cLName[0]);
                    tvCustPhone.setText(cPhone[0]);
                    tvCustEmail.setText(cEmail[0]);

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
    public static void GetCustomerListData(final String urlWebService, final Context cont, final ListView list)
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

                    ArrayAdapter<Customer> arrayAdapter = new ArrayAdapter<>(cont, android.R.layout.simple_list_item_1);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        arrayAdapter.add(new Customer(Integer.parseInt(obj.getString("CustomerId")),
                                obj.getString("CustFirstName"),
                                obj.getString("CustLastName"),
                                obj.getString("CustAddress"),
                                obj.getString("CustCity"),
                                obj.getString("CustProv"),
                                obj.getString("CustPostal"),
                                obj.getString("CustCountry"),
                                obj.getString("CustHomePhone"),
                                obj.getString("CustBusPhone"),
                                obj.getString("CustEmail"),
                                obj.getString("AgentId")));

                    }
                    list.setAdapter(arrayAdapter);
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
    public static void UpdateCustomer(final String customerId, final String custFirstName, final String custLastName,
                                      final String custAddress, final String custCity, final String custProv,
                                      final String custPostal, final String custCountry, final String custHomePhone, final String custBusPhone,
                                      final String custEmail, final String agentId,final String apiSecret,
                                      final String url, final Context context)
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
                if (customerId != null) {
                    parameters.put("customerId", customerId);
                }
                parameters.put("custFirstName", custFirstName);
                parameters.put("custLastName", custLastName);
                parameters.put("custAddress", custAddress);
                parameters.put("custCity", custCity);
                parameters.put("custProv", custProv);
                parameters.put("custPostal", custPostal);
                parameters.put("custCountry", custCountry);
                parameters.put("custHomePhone", custHomePhone);
                parameters.put("custBusPhone", custBusPhone);
                parameters.put("custEmail", custEmail);
                parameters.put("agentId", agentId);
                parameters.put("apiSecret", apiSecret);
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }


    public static void DeleteCustomer(final String customerId, final String apiSecret,
                                      final String url, final Context context)
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
                parameters.put("customerId", customerId);
                parameters.put("apiSecret", apiSecret);
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
}