package com.example.hoatdongngoaikhoa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class QLHoatDong extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    QLHDAdapter qlhdAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanlyhoatdong);

        tabLayout = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.view_paper);
        FragmentManager fm = getSupportFragmentManager();
        qlhdAdapter = new QLHDAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(qlhdAdapter);
        tabLayout.setupWithViewPager(pager);



    }
}
