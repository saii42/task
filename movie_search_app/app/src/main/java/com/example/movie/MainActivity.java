package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button buttonSearch;
    private Button buttonRecentSearches;
    private EditText editTextSearch;

    private RetrofitAPI retrofitAPI;

    private RecyclerView mRecyclerView;
    private MovieListAdapter movieListAdapter;
    private List<MovieDataItem> arrayList = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> searchHistoryList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSearch = findViewById(R.id.btn_search);
        buttonRecentSearches = findViewById(R.id.btn_recentSearches);
        mRecyclerView = findViewById(R.id.rv_movie_list);
        editTextSearch = findViewById(R.id.et_search);

        Intent intent = getIntent();
        String keyword = intent.getStringExtra("keyword");

        if (keyword != null) {
            editTextSearch.setText(keyword);
            searchMovieCallApi(keyword);

        }

        arrayList.add(new MovieDataItem("제목예시", "", "", "10", "0.0"));

        movieListAdapter = new MovieListAdapter(arrayList);
        mRecyclerView.setAdapter(movieListAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchMovieCallApi(editTextSearch.getText().toString());
            }
        });

        buttonRecentSearches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchHistoryActivity.class);
                intent.putStringArrayListExtra("list", searchHistoryList);
                startActivity(intent);
            }
        });
    }
    public void searchMovieCallApi (String keyword) {
        arrayList.clear();

        searchHistoryList.add(keyword);

        if (searchHistoryList.size() > 10)
            searchHistoryList.remove(0);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if (retrofitClient != null) {
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getMovieData(keyword).enqueue(new Callback<MovieData>() {

                @Override
                public void onResponse(Call<MovieData> call, Response<MovieData> response) {
                    MovieData movieData = response.body();

                    if (movieData != null) {
                        for (int i = 0; i < movieData.getMovieDataItems().length; i++) {
                            String image = movieData.getMovieDataItems()[i].getImage();
                            String link = movieData.getMovieDataItems()[i].getLink();
                            String title = Html.fromHtml(movieData.getMovieDataItems()[i].getTitle()).toString();
                            String pubDate = movieData.getMovieDataItems()[i].getPubDate();
                            String userRating = movieData.getMovieDataItems()[i].getUserRating();

                            arrayList.add(new MovieDataItem(title, link, image, pubDate, userRating));
                        }
                        movieListAdapter = new MovieListAdapter(arrayList);
                        mRecyclerView.setAdapter(movieListAdapter);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                }

                public void onFailure(Call<MovieData> call, Throwable t) {
                    Log.e("onFailure", t.toString());
                }
            });
        }
    }
}