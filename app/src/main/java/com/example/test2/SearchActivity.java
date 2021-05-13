package com.example.test2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.text.Editable;
import android.text.TextWatcher;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";
    ListView listView;
    private ArrayList<WasteItem> wasteItems = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView)findViewById(R.id.listview);

        EditText searchfunction = findViewById(R.id.search);

        ArrayList<String> wastenames = new ArrayList<>();



        wasteItems.add(new WasteItem("pizzabakker", "restaffald"));
        wasteItems.add(new WasteItem("pizza", "madaffald"));
        wasteItems.add(new WasteItem("Banan", "madaffald"));
        wasteItems.add(new WasteItem("Bananskrald", "madaffald"));
        wasteItems.add(new WasteItem("håndsprit", "farligt affald"));
        wasteItems.add(new WasteItem("mundbind", "restaffald"));
        wasteItems.add(new WasteItem("æble", "madaffald"));
        wasteItems.add(new WasteItem("papir", "pap"));
        //hvis beskidt, så restaffald. Der kan implementeres en if-statement
        wasteItems.add(new WasteItem("serviet", "restaffald"));

                searchfunction.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Log.d(TAG, "onTextChanged: "+ s);
                wastenames.clear();
                for (int counter = 0; counter < wasteItems.size(); counter++)
                {
                    if (wasteItems.get(counter).getName().contains(s)) {
                        wastenames.add(wasteItems.get(counter).getName())    ;
//                        Log.d(TAG, "onTextChanged:" + wasteItems.get(counter).getCategory());
                    }
                }
                UpdateSearch(wastenames);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,wastenames);

        listView.setAdapter(arrayAdapter);
    }

    private void UpdateSearch(ArrayList<String> wastenames){
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,wastenames);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: ");
            }
        });

    }

}
