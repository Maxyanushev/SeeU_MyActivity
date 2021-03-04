package com.test.seeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.test.seeu.forContainer.RvAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mAutors = new ArrayList<>();
    private ArrayList<String> mDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAttractions();
    }

    private void initAttractions() {
        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
        mNames.add("qwertyu");
        mAutors.add("qwertyu");
        mDetails.add("qwertyu");

        initRV();
    }

    private void initRV() {
        RecyclerView recyclerView = findViewById(R.id.rv);
        RvAdapter rvAdapter = new RvAdapter(this, mImage, mNames, mAutors, mDetails);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}