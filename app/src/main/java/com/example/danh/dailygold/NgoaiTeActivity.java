package com.example.danh.dailygold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class NgoaiTeActivity extends AppCompatActivity {
    // khai bao bien
    String url = "https://www.freeforexapi.com/api/live?pairs=EURGBP,USDJPY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngoaite_layout_main);
        //

        GetData(url);
    }

    // ham lay du lieu
    private void GetData(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(NgoaiTeActivity.this,response.toString(),Toast.LENGTH_LONG);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NgoaiTeActivity.this,"Loi",Toast.LENGTH_LONG);
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
