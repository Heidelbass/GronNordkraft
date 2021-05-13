package com.example.test2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private ArrayList<WasteItem> wasteItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        wasteItems.add(new WasteItem("pizzabakker", "restaffald"));
        wasteItems.add(new WasteItem("pizza", "madaffald"));
        wasteItems.add(new WasteItem("Banan", "madaffald"));
        wasteItems.add(new WasteItem("håndsprit", "farligt affald"));
        wasteItems.add(new WasteItem("mundbind", "restaffald"));
        wasteItems.add(new WasteItem("æble", "madaffald"));
        wasteItems.add(new WasteItem("papir", "pap"));
        //hvis beskidt, så restaffald. Der kan implementeres en if-statement
        wasteItems.add(new WasteItem("serviet", "restaffald"));


//        EditText searchfunction = findViewById(R.id.search);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               OpenSearch();
            }
        });

//        searchfunction.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                Log.d(TAG, "onFocusChange: ");
//                if (hasFocus) {
//                    Fragment selectedFragment = new ListItem();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).commit();
//                }
//            }
//        });

//        searchfunction.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // Log.d(TAG, "onTextChanged: "+ s);
//
//                Fragment selectedFragment = new ListItem();
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        selectedFragment).commit();
//
//                for (int counter = 0; counter < wasteItems.size(); counter++)
//                {
//                    if (wasteItems.get(counter).getName().contains(s)) {
//                        Log.d(TAG, "onTextChanged:" + wasteItems.get(counter).getCategory());
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

    }




    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_map:
                            selectedFragment = new MapFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };



    public void onClick (View v) {
            Intent i;

            switch (v.getId()) {
                case R.id.c1:
                    i = new Intent(this, MadAffald.class);
                    startActivity(i);
                    break;

                case R.id.c2:
                    i = new Intent(this, Papir.class);
                    startActivity(i);
                    break;

                case R.id.c3:
                    i = new Intent(this, Pap.class);
                    startActivity(i);
                    break;

                case R.id.c4:
                    i = new Intent(this, Metal.class);
                    startActivity(i);
                    break;

                case R.id.c5:
                    i = new Intent(this, Glas.class);
                    startActivity(i);
                    break;

                case R.id.c6:
                    i = new Intent(this, Plast.class);
                    startActivity(i);
                    break;

                case R.id.c7:
                    i = new Intent(this, Tekstiler.class);
                    startActivity(i);
                    break;

                case R.id.c8:
                    i = new Intent(this, Kartoner.class);
                    startActivity(i);
                    break;

                case R.id.c9:
                    i = new Intent(this, Restaffald.class);
                    startActivity(i);
                    break;

                case R.id.c10:
                    i = new Intent(this, FarligtAffald.class);
                    startActivity(i);
                    break;
            }
        }

        private void OpenSearch(){
            Intent in = new Intent( this, SearchActivity.class);
            in.putExtra("some", "some data");
            startActivity(in);
    }
}

