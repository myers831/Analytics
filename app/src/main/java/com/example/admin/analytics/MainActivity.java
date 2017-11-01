package com.example.admin.analytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.flurry.android.FlurryAgent;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String MY_TIME_EVENT = "myTimeEvent";
    private MixpanelAPI mixpanel;
    private boolean isDownloaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new FlurryAgent.Builder()
                .withLogEnabled(true)
                .build(this, "B3PDPR53K9982B44CTDJ");

        mixpanel = MixpanelAPI.getInstance(this, BuildConfig.MIX_PANAL_TOKEN);


    }

    public void onJump(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            props.put("activity", "Jumping");
            mixpanel.track("MainActivity - onCreate called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onAttack(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            props.put("activity", "Attack");
            mixpanel.track("MainActivity - onCreate called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onSkyDive(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            props.put("activity", "SkyDive");
            mixpanel.track("MainActivity - onCreate called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onPowerSlide(View view) {
        try {
            JSONObject props = new JSONObject();
            props.put("Gender", "Female");
            props.put("Logged in", true);
            props.put("activity", "PowerSlide");
            mixpanel.track("MainActivity - onCreate called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mixpanel.flush();
    }

    public void onStartTime(View view) {
        mixpanel.timeEvent(MY_TIME_EVENT);
        isDownloaded = true;
    }

    public void onTrackTime(View view) {
        if(isDownloaded){
            mixpanel.track(MY_TIME_EVENT);
        }
    }
}
