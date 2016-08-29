package com.anil.sgp.gsonexample3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    StringRequest stringRequest;
    String url;
    List<Example> example;
    RecyclerView recyclerView;
    BindData bindData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        example = new ArrayList<>();
        loadserverdata();

        recyclerView = (RecyclerView) findViewById(R.id.myrid);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        bindData = new BindData();
        recyclerView.setAdapter(bindData);


    }

    void loadserverdata() {
        url = "http://toscanyacademy.com/blog/mp.php";
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Responce is : ", "" + response);
                //  example=new Gson().fromJson(response,Example.class);
                example = new Gson().fromJson(response, new TypeToken<List<Example>>() {
                }.getType());
                for (Example a : example) {
                    Log.e("Id", "" + a.getSongId());
                    Log.e("Artist Name", "" + a.getArtistName());
                    Log.e("Song Name", "" + a.getSongName());

                }
                bindData.notifyDataSetChanged();
                /*for(int i=0;i<example.size();i++){
                    Log.e("Song Name",""+example.get(i).getSongName());

                }
*/

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }


    class BindData extends RecyclerView.Adapter<BindData.VH> {
        @Override
        public BindData.VH onCreateViewHolder(ViewGroup parent, int viewType) {
            return new VH(getLayoutInflater().inflate(R.layout.mycardv, parent, false));
        }

        @Override
        public void onBindViewHolder(BindData.VH holder, int position) {
            String s1 = example.get(position).getSongId();
            String s2 = example.get(position).getArtistName();
            String s3 = example.get(position).getSongName();

            holder.text.setText(s1 + "\n" + s2 + "\n" + s3);

        }

        @Override
        public int getItemCount() {
            return example.size();
        }

        public class VH extends RecyclerView.ViewHolder {
            TextView text;

            public VH(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.list_title);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(getPosition()==0){
                            startActivity(new Intent(getApplicationContext(),Test1Activity.class));
                        }
                    }
                });
            }

        }
    }

}
