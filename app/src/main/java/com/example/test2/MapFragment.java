package com.example.test2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MapFragment extends Fragment {

    private ViewPager2 viewPager2;

    @Nullable // = Denotes that a parameter, field or method return value can be null
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {//LayoutInflater =  it takes an XML file as input and builds the View objects from it
        View v =  inflater.inflate(R.layout.fragment_map2, container, false);
//Image slider using View Pager 2:  https://www.youtube.com/watch?v=DocKN8yX9qc
        viewPager2 = v.findViewById(R.id.viewPagerImageSlider);


        List<SliderItem> sliderItems = new ArrayList<>(); //The arraylist of slideritems
        sliderItems.add(new SliderItem(R.drawable.niv1)); //Connects the new SliderItem with our picture.
        sliderItems.add(new SliderItem(R.drawable.niv3));


        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

        //Adapting the pictures to the screen
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        //viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER); //This makes sure the scrollin doesn't start over or that it doesn't stop scrolling.

        //Support class that helps set up viewPager
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

       return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}