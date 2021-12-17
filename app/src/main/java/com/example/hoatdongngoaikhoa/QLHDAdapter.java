package com.example.hoatdongngoaikhoa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class QLHDAdapter extends FragmentStatePagerAdapter {


    public QLHDAdapter(@NonNull FragmentManager fm, int behavior) {

        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new QLhoatdongdd();
            case 1:
                return new QLhoatdongcd();
            default:
                return new QLhoatdongdd();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                return title = "Đã duyệt";
            case 1:
                return title ="Chưa Duyệt";
            default:
                return title = "Đã duyệt";
        }

    }
}
