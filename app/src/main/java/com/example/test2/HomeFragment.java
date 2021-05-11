package com.example.test2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener{

    public HomeFragment(){
        //required empty public constructor
    }

    public CardView card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home2, container, false);


        card1 = (CardView) v.findViewById(R.id.c1);
            card1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(getActivity(), MadAffald.class);
                    in.putExtra("some", "some data");
                    startActivity(in);
                }
            });


        card2 = (CardView) v.findViewById(R.id.c2);
        card3 = (CardView) v.findViewById(R.id.c3);
        card4 = (CardView) v.findViewById(R.id.c4);
        card5 = (CardView) v.findViewById(R.id.c5);
        card6 = (CardView) v.findViewById(R.id.c6);
        card7 = (CardView) v.findViewById(R.id.c7);
        card8 = (CardView) v.findViewById(R.id.c8);
        card9 = (CardView) v.findViewById(R.id.c9);
        card10 = (CardView) v.findViewById(R.id.c10);

        return v;

    }


   @Override
  public void onClick(View v) {
    //required empty constructor

   }
}
