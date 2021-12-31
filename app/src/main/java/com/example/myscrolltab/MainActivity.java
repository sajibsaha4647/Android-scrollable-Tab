package com.example.myscrolltab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity extends FragmentActivity {

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPages);

        FragmentManager fragmentManager = getSupportFragmentManager();

        CustomAdapder adapder = new CustomAdapder(fragmentManager,getLifecycle());

        viewPager.setAdapter(adapder);


    }
}

class  CustomAdapder extends FragmentStateAdapter{


    public CustomAdapder(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        Fragment fragment;

        if(position == 0){
            fragment = new FragmentTab1();
        }else if(position == 1){
            fragment = new FragmentTab2();
        }else if(position == 2){
            fragment = new FragmentTab3();
        }else {
            fragment = new FragmentTab1();
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}