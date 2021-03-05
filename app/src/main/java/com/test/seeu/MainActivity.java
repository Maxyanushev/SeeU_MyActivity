package com.test.seeu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.seeu.forContainer.RvAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static com.test.seeu.NetworkUtils.generateURL;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText etSearch;

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mAutors = new ArrayList<>();
    private ArrayList<String> mDetails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);

        btnSearch.setOnClickListener(v -> {
            URL generateURL = NetworkUtils.generateURL(etSearch.getText().toString());
            try {
                String response = NetworkUtils.getResponseFromUrl(generateURL);
                jsonParse(response);
            } catch (IOException e) {
                System.out.println("exeption 1");
                e.printStackTrace();
            } catch (JSONException e) {
                System.out.println("exeption 2");
                e.printStackTrace();
            }
        });


//        initAttractions();
    }

    private void jsonParse(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        System.out.println("Json objedct - " + jsonObject.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        System.out.println("Json array - " + jsonArray.toString());
        for (int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonO = jsonArray.getJSONObject(i);
            mImage.add(jsonO.getString("thumbnail"));
            mNames.add(jsonO.getString("title"));
        }
        initRV();
    }

//    private void initAttractions() {
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        mImage.add("https://w.histrf.ru/uploads/media/article/0001/25/thumb_24300_article_middle.jpeg");
//        mNames.add("qwertyu");
//        mAutors.add("qwertyu");
//        mDetails.add("qwertyu");
//
//        initRV();
//    }

    private void initRV() {
        RecyclerView recyclerView = findViewById(R.id.rv);
        RvAdapter rvAdapter = new RvAdapter(this, mImage, mNames, mAutors, mDetails);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}