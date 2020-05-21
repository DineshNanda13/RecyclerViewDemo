package com.meterstoinches.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String name[], description[];

    int images[] = {R.drawable.breakingbad, R.drawable.got, R.drawable.moneyheist};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);

        name = getResources().getStringArray(R.array.series);
        description = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, name, description, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
