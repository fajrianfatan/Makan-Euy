package com.example.makaneuy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DetailActivity extends AppCompatActivity {

    ImageView detImageView;
    TextView titleMakanan, namaMakanan, jelasMakanan, isiMakanan, langkahPembuatan, langkahBikin;

    RecyclerView recyclerView;

    String data4, data5;
    String s4[], s5[];

    int imageButton;
    int imageMakanan[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.recyclerView);

        s4 = getResources().getStringArray(R.array.resep_masak);
        s5 = getResources().getStringArray(R.array.subtitle);

        detImageView = findViewById(R.id.detImageView);
        titleMakanan = findViewById(R.id.titleMakanan);

        namaMakanan = findViewById(R.id.namaMakanan);
        jelasMakanan = findViewById(R.id.jelasMakanan);
        isiMakanan = findViewById(R.id.isiMakanan);
        langkahPembuatan = findViewById(R.id.langkahPembuatan);
        langkahBikin = findViewById(R.id.langkahBikin);

        DetailAdapter detailAdapter = new DetailAdapter(this, s4, s5, imageMakanan);
        recyclerView.setAdapter(detailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getDetailData();
        setDetailData();
    }

    private void getDetailData(){
        if(getIntent().hasExtra("imageButton") && getIntent().hasExtra("data4")
                && getIntent().hasExtra("data5")){
            data4 = getIntent().getStringExtra("data4");
            data5 = getIntent().getStringExtra("data5");
            imageButton = getIntent().getIntExtra("imageButton",1);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setDetailData(){
        titleMakanan.setText(data4);
        namaMakanan.setText(data5);
        detImageView.setImageResource(imageButton);
    }
}
