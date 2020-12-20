package com.example.makaneuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s3[];
    int images[] = {R.drawable.jabartimbel,R.drawable.jatengkudus,R.drawable.sumbarpadang,R.drawable.sulselcoto,R.drawable.sulutbubur};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.resep_masak);
        s3 = getResources().getStringArray(R.array.subtitle);

        MyAdapter myAdapter = new MyAdapter(this, s1, s3, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}