package com.example.android.myadvancecourseproject.features.recyclertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.myadvancecourseproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RecyclerTest extends AppCompatActivity implements ClickHelper{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_test);

        ArrayList<String> myList = new ArrayList<String>();
        myList.add("aaa");
        myList.add("bbb");
        myList.add("ccc");

        RecyclerView recyclerView = findViewById(R.id.recycler);
        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(myList, this);
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.setLayoutManager(new  LinearLayoutManager(this, RecyclerView.VERTICAL, false));



    }

    @Override
    public void onClick(@NotNull String item) {
       Toast.makeText(RecyclerTest.this, "this is " + item, Toast.LENGTH_LONG).show();
    }
}
