package com.example.testinglagi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.testinglagi.adapter.MovieAdapter;
import com.example.testinglagi.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Movie> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        recyclerView = findViewById(R.id.rvm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        movieList = new ArrayList<>();
        fetchMovies();
    }

    private void fetchMovies() {
//        String url = "https://jsonkeeper.com/b/J239";
//        https://www.json-generator.com/api/json/get/cfsXpFGwwO?indent=2
//          String url = "https://www.json-generator.com/api/json/get/cfsXpFGwwO?indent=2";
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=f032350dce150decbe2e820e627a3a49&language=en-US&page";
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i = 0; i < response.length(); i++){
//                    Toast.makeText(MovieList.this, i, Toast.LENGTH_LONG).show();
//                    System.out.println("Hellooooooooooo" + i);
//
//                    try {
//                        System.out.println(i);
//                        System.out.println(i);
//
//                        JSONObject jsonObject = response.getJSONObject(i);
//                        String title = jsonObject.getString("original_title");
//                        String desc = jsonObject.getString("overview");
//                        String poster = jsonObject.getString("backdrop_path");
//
//                        Movie movie = new Movie(title, poster, desc);
//                        movieList.add(movie);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//
//                    MovieAdapter movieAdapter = new MovieAdapter(MovieList.this, movieList);
//
//                    recyclerView.setAdapter(movieAdapter);
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MovieList.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                System.out.println(error.getMessage());
//            }
//        });
//
//        requestQueue.add(jsonArrayRequest);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++){
                        JSONObject jsonObject = results.getJSONObject(i);
                        String title = jsonObject.getString("original_title");
                        String desc = jsonObject.getString("overview");
                        String poster = jsonObject.getString("backdrop_path");

                        Movie movie = new Movie(title, poster, desc);
                        movieList.add(movie);
                    }

                    MovieAdapter movieAdapter = new MovieAdapter(MovieList.this, movieList);
                    recyclerView.setAdapter(movieAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // handle error
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

}