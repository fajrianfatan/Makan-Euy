package com.example.makaneuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description, titleMakanan, descMakanan;
    ImageButton imageButton;

    RecyclerView recyclerView;

    String data1, data2;
    String s4[], s5[];
    int myImage;
    int images2[] = {R.drawable.jabartimbel,R.drawable.jatengkudus,R.drawable.sumbarpadang,R.drawable.sulselcoto,R.drawable.sulutbubur};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        recyclerView = findViewById(R.id.recyclerView);

        s4 = getResources().getStringArray(R.array.makananjabar);
        s5 = getResources().getStringArray(R.array.makananjateng);

        imageButton = findViewById(R.id.imageButton);
        titleMakanan = findViewById(R.id.titleMakanan);
        descMakanan = findViewById(R.id.descMakanan);

        DetailAdapter detailAdapter = new DetailAdapter(this, s4, s5, images2);
        recyclerView.setAdapter(detailAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")
                && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage",1);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}