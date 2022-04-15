package com.example.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.fragmenttutorial.fragments.FirstFragment;
import com.example.fragmenttutorial.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        linearLayout = findViewById(R.id.linerLayout);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FirstFragment firstFragment = new FirstFragment();
               // FragmentManager fragmentManager  = getFragmentManager();
               FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
               fragmentTransaction.replace(R.id.linerLayout, firstFragment);
               fragmentTransaction.commit();
           }
       });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                // FragmentManager fragmentManager  = getFragmentManager();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.linerLayout, secondFragment);
                fragmentTransaction.commit();
            }
        });






    }
}