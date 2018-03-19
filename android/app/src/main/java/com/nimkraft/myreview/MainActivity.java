package com.nimkraft.myreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  final  String res="http://192.168.1.4:4000/details";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Anime> lstanime;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            lstanime=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request=new JsonArrayRequest(res, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject=null;
                for(int i=0;i<response.length();i++){

                    try{
                        jsonObject =response.getJSONObject(i);
                        Anime anime=new Anime();
                        anime.setName((jsonObject.getString("name")));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setRating(jsonObject.getString("rating"));
                        anime.setCatagorie(jsonObject.getString("categorie"));
                        anime.setEpisode(jsonObject.getInt("episodes"));
                        anime.setImg_url(jsonObject.getString("img"));

                        lstanime.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                setuprecyclerview();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview() {

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,lstanime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
