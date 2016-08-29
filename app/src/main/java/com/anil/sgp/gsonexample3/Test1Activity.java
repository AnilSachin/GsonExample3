package com.anil.sgp.gsonexample3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Test1Activity extends AppCompatActivity {
    StringRequest stringRequest;
    String url;
    List<Demo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getdata();

    }

    void getdata() {
        url = "http://demos.tricksofit.com/files/json.php";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Responce", "" + response);
                list = new Gson().fromJson(response, new TypeToken<List<Demo>>() {
                }.getType());
                for (Demo a : list) {
                    Log.e("ID", a.getId());
                    Log.e("NAME", a.getName());
                    Log.e("URL", a.getUrl());

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }


}
