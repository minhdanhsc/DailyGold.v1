package com.example.danh.dailygold;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.danh.dailygold.Adater.NgoaiTeAdapter;
import com.example.danh.dailygold.Model.NgoaiTe;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NgoaiTeActivity extends AppCompatActivity {
    // khai bao bien
    private String[] symbols = {"EURUSD","GBPUSD","USDJPY","AUDUSD","USDCHF","NZDUSD","USDCAD"};
    private String url = "https://www.freeforexapi.com/api/live?pairs=EURUSD,GBPUSD,USDJPY,AUDUSD,USDCHF,NZDUSD,USDCAD";
    private ListView lvNgoaiTe;
    private ArrayList<NgoaiTe> ngoaiTeArrayList;
    private NgoaiTeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngoaite_layout_main);
        // anh xa
        lvNgoaiTe = (ListView) findViewById(R.id.lv_ngoaite);
        ngoaiTeArrayList = new ArrayList<>();
        adapter = new NgoaiTeAdapter(NgoaiTeActivity.this, R.layout.ngoaite_layout_item_lv, ngoaiTeArrayList);
        lvNgoaiTe.setAdapter(adapter);
        GetData(url, symbols);
        UpdateRate();
    }

    // ham tu dong update du lieu Timer 1s update 1 lần
    private  void UpdateRate() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                GetData(url, symbols);
            }
        }, 1000,1000);
    }
    // ham lay du lieu
    private void GetData(String url, final String[] symbols){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // xoa mang de không ghi them
                            ngoaiTeArrayList.clear();
                            // lay doi tuong cha cua cac symbols
                            JSONObject data = response.getJSONObject("rates");
                            // duyet het mang de lay symbols
                            for (int i = 0; i < symbols.length; i++) {
                                JSONObject object = data.getJSONObject(symbols[i]);
                                ngoaiTeArrayList.add(new NgoaiTe(
                                    symbols[i],
                                        object.getString("rate")
                                ));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(NgoaiTeActivity.this,"Lỗi ứng dụng, cần bảo trì",Toast.LENGTH_LONG).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}
