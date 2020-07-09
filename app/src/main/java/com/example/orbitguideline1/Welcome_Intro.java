package com.example.orbitguideline1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class Welcome_Intro extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter ;
    int position = 0 ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__intro);


        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custome_toolbar);
        View view = getSupportActionBar().getCustomView();
        ImageView close_tab  = view.findViewById(R.id.close);


        close_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
           screenPager =findViewById(R.id.screen_viewpager);

        final List<ScreenItem> mList = new ArrayList<>();

        mList.add(new ScreenItem("Know the birthdays of all friends.\n" +
                "Celebrate with your friends and family.\n" +
                "Know the popular birthday everyday.\n" +
                "Celebrate birthdays as a group.",
                R.drawable.birthday));

        mList.add(new ScreenItem("Share your Interesting things.\n" +
                "Photos, Thoughts, Memories and Fun.\n" +
                "Visible with your Contact friends.\n" +
                "Best posts will gain more likes, views.",
                R.drawable.share));

        mList.add(new ScreenItem("Chat with your friends.\n" +
                "Wish to your friends on birthday.\n" +
                "Share fun with each other.", R.drawable.chat));

        mList.add(new ScreenItem("Save posts privately.\n" +
                "Only you can see them on profile.\n" +
                "Get any post quickly from saves.", R.drawable.pin));

        mList.add(new ScreenItem("Shows your public profile.\n" +
                "you can customize profile from setting.\n" +
                "All shared posts are visible to everyone.\n" +
                "Your friends' friends can see you.", R.drawable.profile ));

        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        position = screenPager.getCurrentItem();
        if (position < mList.size()) {

            position++;
            screenPager.setCurrentItem(position);


        }

          }

}

