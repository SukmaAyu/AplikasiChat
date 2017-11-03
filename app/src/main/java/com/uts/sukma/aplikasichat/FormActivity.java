package com.uts.sukma.aplikasichat;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FormActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText inpName, inpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getSupportActionBar().setTitle("Tambah Pesan");

        inpName = (EditText) findViewById(R.id.inpName);
        inpText = (EditText)findViewById(R.id.inpText);
        preferences = getSharedPreferences(MainActivity.mainPrers,0);
        editor = preferences.edit();
    }

    public void send(View view) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Pengirim",inpName.getText().toString());
            jsonObject.put("Kontent",inpText.getText().toString());
            jsonObject.put("Waktu",new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
            jsonObject.put("Foto",R.drawable.2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(preferences.contains("message")) {
            String dataMessage = preferences.getString("message","");

            try {
                JSONArray jsonArray = new JSONArray(dataMessage);
                jsonArray.put(jsonObject);
                editor.putString("message", jsonArray.toString());
                editor.apply();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            editor.putString("message", jsonArray.toString());
            editor.apply();
        }

        finish();
    }
}
