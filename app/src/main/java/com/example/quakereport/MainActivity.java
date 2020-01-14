package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final ArrayList<Earthquake> a = Quake.extractEarthquakes();

        CustomAdapter b = new CustomAdapter(this,a);

        ListView c =(ListView)findViewById(R.id.lst);
        c.setAdapter(b);
        c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Earthquake ur = a.get(i);
                Uri url = Uri.parse(ur.geturl());
                Intent bn = new Intent(Intent.ACTION_VIEW,url);
                startActivity(bn);
            }
        });
    }
}
