package com.example.admin.contactfunctionality;


import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;


import com.example.admin.contactfunctionality.fragment.MainFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MainFragment fragment = new MainFragment();
        fragmentTransaction.replace(R.id.container_frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}