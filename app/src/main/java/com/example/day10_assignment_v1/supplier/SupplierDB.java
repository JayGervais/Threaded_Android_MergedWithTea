package com.example.day10_assignment_v1.supplier;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SyncRequest;
import android.os.AsyncTask;
import android.util.Log;
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
import com.example.day10_assignment_v1.customer.Customer;
import com.example.day10_assignment_v1.product.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SupplierDB {


    public static void SelectedSupplierData(final String urlWebService, final Context cont,
                                            final ListView list)
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
                Log.d("test", "Suppliers data:" + s);
                try
                {
                    JSONArray jsonArray = new JSONArray(s);
                    String[] suppliers = new String[jsonArray.length()];
                    String[] prodName = new String[jsonArray.length()];
                    String[] supplierId = new String[jsonArray.length()];
                    String[] supplierContactId = new String[jsonArray.length()];
                    String[] supConFirstName = new String[jsonArray.length()];
                    String[] supConLastName = new String[jsonArray.length()];
                    String[] supConCompany = new String[jsonArray.length()];
                    String[] supConAddress = new String[jsonArray.length()];
                    String[] supConCity = new String[jsonArray.length()];
                    String[] supConProv = new String[jsonArray.length()];
                    String[] supConPostal = new String[jsonArray.length()];
                    String[] supConCountry = new String[jsonArray.length()];
                    String[] supConBusPhone = new String[jsonArray.length()];
                    String[] supConFax = new String[jsonArray.length()];
                    String[] supConEmail = new String[jsonArray.length()];
                    String[] supConURL = new String[jsonArray.length()];
                    String[] affiliationId = new String[jsonArray.length()];


                    ArrayAdapter<Supplier> arrayAdapter = new ArrayAdapter<>(cont, android.R.layout.simple_list_item_1);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        arrayAdapter.add(new Supplier(Integer.parseInt(obj.getString("ProductId")),
                                obj.getString("ProdName"),
                                (Integer.parseInt(obj.getString("SupplierId"))),
                                (Integer.parseInt(obj.getString("SupplierContactId"))),
                                obj.getString("SupConFirstName"),
                                obj.getString("SupConLastName"),
                                obj.getString("SupConCompany"),
                                obj.getString("SupConAddress"),
                                obj.getString("SupConCity"),
                                obj.getString("SupConProv"),
                                obj.getString("SupConPostal"),
                                obj.getString("SupConCountry"),
                                obj.getString("SupConBusPhone"),
                                obj.getString("SupConFax"),
                                obj.getString("SupConEmail"),
                                obj.getString("SupConURL"),
                                obj.getString("AffiliationId")));

                        suppliers[i] = obj.getString("ProdName") + " " + obj.getString("SupConCompany");



                              prodName[i]=  obj.getString("ProdName");
                                      supplierId[i]= obj.getString("SupplierId");
                                      supplierContactId[i]=obj.getString("SupplierContactId");
                                      supConFirstName[i]=obj.getString("SupConFirstName");
                                      supConLastName[i]=obj.getString("SupConLastName");
                                      supConCompany[i]=obj.getString("SupConCompany");
                                      supConAddress[i]=obj.getString("SupConAddress");
                                      supConCity[i]= obj.getString("SupConCity");
                                      supConProv[i]=obj.getString("SupConProv");
                                      supConPostal[i]=obj.getString("SupConPostal");
                                      supConCountry[i]=obj.getString("SupConCountry");
                                      supConBusPhone[i]=obj.getString("SupConBusPhone");
                                      supConFax[i]=obj.getString("SupConFax");
                                      supConEmail[i]=obj.getString("SupConEmail");
                                      supConURL[i]=obj.getString("SupConURL");
                                      affiliationId[i]=obj.getString("AffiliationId");


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
    public static void UpdateSupplier(final String supplierContactId, final String supConFirstName, final String supConLastName,
                                      final String supConCompany, final String supConAddress, final String supConCity, final String supConProv,
                                      final String supConPostal, final String supConCountry, final String supConBusPhone, final String supConFax,
                                      final String supConEmail, final String supConURL, final String affiliationId, final String apiSecret,
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
                if (supplierContactId != null)
                {
                    parameters.put("supplierContactId", supplierContactId);
                }
                parameters.put("supConFirstName", supConFirstName);
                parameters.put("supConLastName", supConLastName);
                parameters.put("supConCompany", supConCompany);
                parameters.put("supConAddress", supConAddress);
                parameters.put("supConCity", supConCity);
                parameters.put("supConProv", supConProv);
                parameters.put("supConPostal", supConPostal);
                parameters.put("supConCountry", supConCountry);
                parameters.put("supConBusPhone", supConBusPhone);
                parameters.put("supConFax", supConFax);
                parameters.put("supConEmail", supConEmail);
                parameters.put("supConURL", supConURL);
                parameters.put("affiliationId", affiliationId);

                parameters.put("apiSecret", apiSecret);
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
    public static void DeleteSupplier(final String supplierContactId, final String apiSecret,
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
                parameters.put("supplierContactId", supplierContactId);
                parameters.put("apiSecret", apiSecret);
                return parameters;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }

}
