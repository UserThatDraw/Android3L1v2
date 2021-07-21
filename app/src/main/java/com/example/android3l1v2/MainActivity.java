package com.example.android3l1v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.android3l1v2.databinding.ActivityMainBinding;
import com.example.android3l1v2.databinding.FragmentListBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction manager = getSupportFragmentManager().beginTransaction();
        manager.replace(R.id.frame_lay, new ListFragment()).commit();
    }


}