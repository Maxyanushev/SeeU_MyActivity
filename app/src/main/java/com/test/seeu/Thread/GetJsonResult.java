package com.test.seeu.Thread;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.test.seeu.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import static com.test.seeu.NetworkUtils.getResponseFromUrl;

public class GetJsonResult extends AsyncTask<URL, Void, String> {

    MainActivity mainActivity;

    public GetJsonResult() {
        mainActivity = new MainActivity();
    }

    @Override
    protected String doInBackground(URL... urls) {
        String response = "";
        try {
            response = getResponseFromUrl(urls[0]);
            System.out.println("-----------" + response);
        } catch (IOException e) {
            e.printStackTrace();

        }

        return response;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onPostExecute(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonO = jsonArray.getJSONObject(i);
                mainActivity.setmImage(jsonO.getString("thumbnail"));
                mainActivity.setmNames(jsonO.getString("title"));
                mainActivity.setmAutors(jsonO.getString("title"));
                mainActivity.setmDetails(jsonO.getString("title"));
                System.out.println(mainActivity.getmNames().get(i));
            }
            mainActivity.initRV();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
