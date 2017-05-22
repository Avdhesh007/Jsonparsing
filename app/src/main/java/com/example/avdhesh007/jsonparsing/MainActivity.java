package com.example.avdhesh007.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://192.168.1.107/Android/Attendance/android_login_api/test5.php";
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject1= new JSONObject(response);
                    String jsn1=jsonObject1.getString("tag");
                    String jsn2=jsonObject1.getString("error");
                    String jsn3=jsonObject1.getString("attendance");
                    JSONArray jsnarr=jsonObject1.getJSONArray("ar");
                    JSONObject jsonObject2=jsonObject1.getJSONObject("user");
                    String jasn1=jsonObject2.getString("name");
                    String jasn2=jsonObject2.getString("email");
                    String jasn3=jsonObject2.getString("created_at");
                    String jasn4=jsonObject2.getString("updated_at");
                    Toast.makeText(getApplicationContext(),jsnarr+jsn1+" "+jsn2+" "+jsn3+" "+jasn1+" "+jasn2+" "+jasn3+" "+jasn3+" "+jasn4,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }
}
