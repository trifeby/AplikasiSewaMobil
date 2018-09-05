package com.trifeby.aplikasisewamobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class DashboardActivity extends AppCompatActivity {

    protected GridView gv;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> myList;
    String[] Ing;
    String[] Gbr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Mobil");
        setContentView(R.layout.activity_dashboard);

        gv = (GridView) findViewById(R.id.gv);
        Ing = new String[]{"Mobil Coklat","Mobil Hitam","Mobil Merah","Mobil Putih","Mobil Coklat"};
        Gbr = new String[] {Integer.toString(R.drawable.browncar),
                Integer.toString(R.drawable.blackcar),
                Integer.toString(R.drawable.redcar),
                Integer.toString(R.drawable.whitecar),
                Integer.toString(R.drawable.redcar),
                Integer.toString(R.drawable.browncar),
        };
        myList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < Ing.length; i++){
            map = new HashMap<String, String>();
            map.put("list-ing", Ing[i]);
            map.put("gbr", Gbr[i]);
            myList.add(map);
        }
        Adapter = new SimpleAdapter(this, myList, R.layout.layout_isi_gv,
                new String[]{"list-ing","gbr"},
                new int[] {R.id.tv, R.id.imgv}
        );
        gv.setAdapter(Adapter);
    }
}