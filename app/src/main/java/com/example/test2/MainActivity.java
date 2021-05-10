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
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   // public CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        card1 = (CardView) findViewById(R.id.c1);
//        card2 = (CardView) findViewById(R.id.c2);
//        card3 = (CardView) findViewById(R.id.c3);
//        card4 = (CardView) findViewById(R.id.c4);
//        card5 = (CardView) findViewById(R.id.c5);
//        card6 = (CardView) findViewById(R.id.c6);
//        card7 = (CardView) findViewById(R.id.c7);
//        card8 = (CardView) findViewById(R.id.c8);
//        card9 = (CardView) findViewById(R.id.c9);
//        card10 = (CardView) findViewById(R.id.c10);
//
//        card1.setOnClickListener(this);
//        card2.setOnClickListener(this);
//        card3.setOnClickListener(this);
//        card4.setOnClickListener(this);
//        card5.setOnClickListener(this);
//        card6.setOnClickListener(this);
//        card7.setOnClickListener(this);
//        card8.setOnClickListener(this);
//        card9.setOnClickListener(this);
//        card10.setOnClickListener(this);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

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
            }
        }
}

