package com.bignerdranch.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private RecyclerView myRecyclerView;
    private RecyclerViewAdapter myRecyclerViewAdapter;

    EditText nameField;
    Button btnAdd;

    RadioGroup optGroupLayout;
    RadioButton optLinearLayoutVertical;

    private LinearLayoutManager linearLayoutManagerVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = (RecyclerView)findViewById(R.id.myrecyclerview);

        linearLayoutManagerVertical =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        myRecyclerViewAdapter = new RecyclerViewAdapter(this);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
        myRecyclerView.setLayoutManager(linearLayoutManagerVertical);

        //Add MyItemDecoration
        myRecyclerView.addItemDecoration(new MyitemDecoration());

        nameField = (EditText)findViewById(R.id.namefield);
        btnAdd = (Button)findViewById(R.id.addbutton);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String newName = nameField.getText().toString();

                if(!newName.equals("")){
                    if(myRecyclerViewAdapter.getItemCount()>1){
                        myRecyclerViewAdapter.add(1, newName);
                    }else{
                        myRecyclerViewAdapter.add(0, newName);
                    }
                }
            }
        });
        }
}
