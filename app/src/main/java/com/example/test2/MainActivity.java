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
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<WasteItem> wasteItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// BottomNavigationView with Fragment: https://www.youtube.com/watch?v=tPV8xA7m-iw
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        //This code makes sure that the home page is Home. So when you open the app, the Home fragment page opens up
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

// Button to the search function. With this onClick method we can click on the button and it will open the search function
        ImageButton btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               OpenSearch();
            } //Here it activates the method Open Search
        });


    }



// BottomNavigationView with Fragment: https://www.youtube.com/watch?v=tPV8xA7m-iw
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = // This code listenes to the user input
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) { // If there is a input, the code will run through this switch statement
                    Fragment selectedFragment = null;
//The switch statement makes sure the app can switch between the two fragments: Map and Home
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_map:
                            selectedFragment = new MapFragment();
                            break;

                    }
                //Here the fragment is selected and the code will replace the current fragment with the chosen fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true; //returns the selected fragment
                }
            };



// This method is connected to SearchActivity.class.
        private void OpenSearch(){
            Intent in = new Intent( this, SearchActivity.class);
            in.putExtra("some", "some data"); //User input
            startActivity(in);
    }
}

