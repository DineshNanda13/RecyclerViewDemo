package com.meterstoinches.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    ImageView theImage;
    TextView name,desc;

    String data1,data2;
    int imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        theImage = (ImageView) findViewById(R.id.seriesImageIdSecond);
        name = (TextView) findViewById(R.id.seriesTitleIdSecond);
        desc = (TextView) findViewById(R.id.seriesDescriptionIdSecond);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("image") && getIntent().hasExtra("name")
            && getIntent().hasExtra("desc")){

            data1 = getIntent().getStringExtra("name");
            data2 = getIntent().getStringExtra("desc");
            imageData = getIntent().getIntExtra("image", 1);

        }else {
            Toast.makeText(this, "No Data", Toast.LENGTH_LONG).show();
        }
    }

    private void setData(){


        name.setText(data1);
        desc.setText(data2);
        theImage.setImageResource(imageData);

    }

}
