package com.vload.ex;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vload.ex.pojo.Terms_condition_Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();
    ViewGroup container;
    // Movies json url
    private static final String url = "https://www.googleapis.com/youtube/v3/search?part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs";
    private static final String EXTRA_MESSAGE ="message" ;
    private ProgressDialog pDialog;
    private List<RoyList> rlist = new ArrayList<RoyList>();
    private ListView listView;
    private CustomListAdapter adapter;
    // ViewPagerAdapter viewpageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, rlist);
        //  viewpageradapter=new ViewPagerAdapter(this,movieList);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
              //  Intent intent = new Intent(MainActivity.this, SendMessage.class);
              /*  // String message = "abc";
                Bundle bundle = new Bundle();
               *//* for (int i = 0; i<movieList.size(); i++)
                    bundle.putSerializable("extras"+i, movieList.get(i));*//*
                bundle.putSerializable("listvalue", (Serializable) movieList);
                intent.putExtras(bundle);

                intent.putExtra("EXTRA_TITLE", movieList.get(position).getTitle());
                intent.putExtra("EXTRA_image", movieList.get(position).getThumbnailUrl());
                intent.putExtra("EXTRA_rating", movieList.get(position).getRating());
                intent.putExtra("EXTRA_genre", movieList.get(position).getGenre());
                intent.putExtra("EXTRA_year", movieList.get(position).getYear());
                intent.putExtra("position",position);
                Toast.makeText(getApplication(),""+position,Toast.LENGTH_LONG).show();
                startActivity(intent);*/
            }
        });
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(RoyListItems.class, new APIResponseDeserializer())
//                .create();

           Retrofit retrofit = new Retrofit.Builder()
//                   .baseUrl("https://www.googleapis.com")
                   .baseUrl("https://www.worldvision.in")
                   .addConverterFactory(GsonConverterFactory.create())
                    .build();
// try again
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.googleapis.com")
//                .addConverterFactory(new GsonConverter(gson))
//                .build();

        // prepare call in Retrofit 2.0
        ApiInterface interfaceObj = retrofit.create(ApiInterface.class);
//https://www.googleapis.com/youtube/v3/search?
// part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs
//  not showing anything how did you do? // let me think
//        Call<RoyListItems> call = interfaceObj.getTopRatedMovies("id,snippet","20","UCCq1xDJMBRF61kiOgU90_kw","AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs");
        Call<List<Terms_condition_Model>> call = interfaceObj.getTermsConditions();
        //asynchronous call
        call.enqueue(new Callback<List<Terms_condition_Model>>() {
//            @Override
//            public void onResponse(Call<RoyList>call, Response<RoyList> response) {
//                List<RoyList> movies = response.body().getResults();
//                Log.d(TAG, "Number of movies received: " + movies.size());
//            }

            @Override
            public void onResponse(Call<List<Terms_condition_Model>> call, retrofit2.Response<List<Terms_condition_Model>> response) {
                List<Terms_condition_Model> responseModel = response.body();
//                RoyListItems listItems = responseModel.getItemsArray();    /// u saw all null? yes thats the prob here// can you post this on main site SO tomrw



//                rlist = responseModel.getItems();
//                Log.d(TAG, "Number of movies received: " + movies.size());
//                rlist = movies;
                adapter.notifyDataSetChanged();
                hidePDialog();
            }

            @Override
            public void onFailure(Call<List<Terms_condition_Model>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                hidePDialog();
            }
        });



        // changing action bar color
       /* getActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));*/

//        // Creating volley request obj
//        JsonObjectRequest movieReq = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, response.toString());
//                        hidePDialog();
//
//                        try {
//                            JSONObject response1 = new JSONObject(response.toString());
//                            JSONArray list = response1.getJSONArray("items");    // you have done this wrong
//
//
//                            // parsing json
//                            for(int i = 0; i<list.length();i++) {
//                                try {
//                                    JSONObject obj = list.getJSONObject(i);
//
//                                    RoyList roy = new RoyList();
//                                    roy.setTitle(obj.getJSONObject("snippet").getString("title")); // this will work, but its not the good way
//
//                                    // the better way will be like this below
//
//                                    JSONObject snippetJSONObject = obj.getJSONObject("snippet");
//                                    roy.setDescription(snippetJSONObject.getString("description"));
//                                    roy.setDatetime(snippetJSONObject.getString("publishedAt"));
//                                    String img = snippetJSONObject.getJSONObject("thumbnails").getJSONObject("default").getString("url");
//
//                                    roy.setThumbnailurl(img);
//
//                                    // adding movie to movies array
//                                    rlist.add(roy);
//                                    Log.d("rlist",""+rlist);
//
//                                } catch(Exception e) {
//                                    e.printStackTrace();
//                                }
//
//                            }
//
//
//
//                        } catch(Exception e) {
//                            e.printStackTrace();
//                        }
//
//
//
//                        // notifying list adapter about data changes
//                        // so that it renders the list view with updated data
//                        adapter.notifyDataSetChanged();
//
//                       /* Gson gson = new Gson();
//                        String jsonoutput = response.toString();
//                        Type listType = new TypeToken<List<RoyList>>(){}.getType();
//                        List<RoyList> posts = gson.fromJson(jsonoutput, listType);
//                        Log.d("gsondd", "gsonposts"+posts);*/
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                hidePDialog();
//
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(movieReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    }
