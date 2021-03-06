package com.example.labadmin.NewYorkTimesSearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by labadmin on 7/25/17.
 */


@Parcel(analyze={Article.class})
public class Article  {
    String webURL;
    String headline;
    String sectionName;
    String thumbNail;

    public String getThumbNail() {
        return thumbNail;
    }

    public String getHeadline() {
        return headline;
    }

    public String getWebURL() {
        return webURL;
    }





    public Article() {

    }

    public Article(JSONObject jsonObject) throws JSONException {

        this.webURL = jsonObject.getString("web_url");
        this.headline = jsonObject.getJSONObject("headline").getString("main");

        JSONArray multimedia = jsonObject.getJSONArray("multimedia");
        if (multimedia.length() > 0) {
            JSONObject multimediaObject = multimedia.getJSONObject(0);
            this.thumbNail = "http://www.nytimes.com/" + multimediaObject.getString("url");
        } else {
            this.thumbNail = "";
        }
    }

    public static ArrayList<Article> fromJSONArray(JSONArray array) {
        ArrayList<Article> result = new ArrayList<>();
        for (int ix = 0; ix < array.length(); ix++) {
            try {
                result.add(new Article(array.getJSONObject(ix)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
