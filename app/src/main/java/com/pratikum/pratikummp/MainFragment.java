package com.pratikum.pratikummp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pratikum.pratikummp.Fragment.FragementTwo;
import com.pratikum.pratikummp.Fragment.FragmentOne;

public class MainFragment extends AppCompatActivity {

    Button buttonfOne,buttonfTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        buttonfOne = findViewById(R.id.fragmentOne);
        buttonfTwo = findViewById(R.id.fragmentTwo);

    }

    @Override
    protected void onResume() {
        super.onResume();

        buttonfOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new FragmentOne());

            }
        });

        buttonfTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new FragementTwo());

            }
        });
    }

    private void loadFragment(Fragment fragment){

        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}