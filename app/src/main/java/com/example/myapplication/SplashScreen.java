package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SplashScreen extends AppCompatActivity {
    private DishesAdapter mAdapter;
    private List<Dishes> mDishesList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        new GetDishes().execute();
       /*new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
       },3000) ;*/
    }
    private  class GetDishes extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url= new URL("https://food.madskill.ru/dishes?version=1.2");
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();

                BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuilder result=new StringBuilder();
                String line="";

                while ((line=reader.readLine())!=null){
                    result.append(line);
                }
                return result.toString();
            }
            catch (Exception ex){
                return "ОШИБКААААААААААААААААААА"+ String.valueOf(ex);
            }

        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            try {
                JSONArray tempArray=new JSONArray(s);
                for (int i=0;i<tempArray.length();i++){
                    JSONObject DishesJson=tempArray.getJSONObject(i);
                    Dishes tempDish=new Dishes(DishesJson.getInt("dishId"),
                            DishesJson.getString("category"),
                            DishesJson.getString("nameDish"),
                            DishesJson.getInt("price"),
                            DishesJson.getString("icon"),
                            DishesJson.getString("version"));
                    mDishesList.add(tempDish);
                    mAdapter.notifyDataSetChanged();
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}