package com.test.seeu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.seeu.Thread.GetJsonResult;
import com.test.seeu.forContainer.RvAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static com.test.seeu.NetworkUtils.generateURL;
import static com.test.seeu.NetworkUtils.getResponseFromUrl;

public class MainActivity extends AppCompatActivity {

    Button btnSearch;
    EditText etSearch;



    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mAutors = new ArrayList<>();
    private ArrayList<String> mDetails = new ArrayList<>();

    public void setmImage(String image) {
        this.mImage.add(image);
    }

    public ArrayList<String> getmNames() {
        return mNames;
    }

    public void setmNames(String names) {
        this.mNames.add(names);
    }

    public void setmAutors(String autors) {
        this.mAutors.add(autors);
    }

    public void setmDetails(String details) {
        this.mDetails.add(details);
    }

    public class GetJsonResult extends AsyncTask<URL, Void, String> {

        @Override
        protected String doInBackground(URL... urls) {
            String response = "";
            try {
                response = getResponseFromUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("doInBaxk");
            }
            return response;
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onPostExecute(String res) {
            try {
                JSONObject jsonObject = new JSONObject(res);
                System.out.println("--" + jsonObject);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i=0; i<jsonArray.length(); i++) {
                    JSONObject jsonO = jsonArray.getJSONObject(i);
                    setmImage(jsonO.getString("thumbnail"));
                    setmNames(jsonO.getString("title"));
                    setmAutors(jsonO.getString("title"));
                    setmDetails(jsonO.getString("title"));
                    System.out.println(getmNames().get(i));
                }
                initRV();
            } catch (JSONException e) {
                e.printStackTrace();
                System.out.println("ex1");
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btnSearch);
        etSearch = findViewById(R.id.etSearch);

        btnSearch.setOnClickListener(v -> {
            URL generateURL = NetworkUtils.generateURL(etSearch.getText().toString());
            new GetJsonResult().execute(generateURL);
//            try {
//                String response = NetworkUtils.getResponseFromUrl(generateURL);
//                jsonParse(response);
//            } catch (IOException e) {
//                System.out.println("exeption 1");
//                e.printStackTrace();
//            } catch (JSONException e) {
//                System.out.println("exeption 2");
//                e.printStackTrace();
//            }
        });


//        initAttractions();
    }

//    private void jsonParse(String response) throws JSONException {
//        JSONObject jsonObject = new JSONObject(response);
//        System.out.println("Json objedct - " + jsonObject.toString());
//        JSONArray jsonArray = jsonObject.getJSONArray("results");
//        System.out.println("Json array - " + jsonArray.toString());
//        for (int i=0; i<jsonArray.length(); i++) {
//            JSONObject jsonO = jsonArray.getJSONObject(i);
//            mImage.add(jsonO.getString("thumbnail"));
//            mNames.add(jsonO.getString("title"));
//        }
//        initRV();
//    }

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

    public void initRV() {
        RecyclerView recyclerView = findViewById(R.id.rv);
        RvAdapter rvAdapter = new RvAdapter(this, mImage, mNames, mAutors, mDetails);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}