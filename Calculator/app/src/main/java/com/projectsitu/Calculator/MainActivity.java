package com.projectsitu.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText value1, value2 ;
    TextView result ;
    Button add, subtract, multiply, divide ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        result = findViewById(R.id.result);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x, y, z;
                x = Integer.parseInt(value1.getText().toString());
                y = Integer.parseInt(value2.getText().toString());
                z = x+y;
                result.setText(+z);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x, y, z;
                x = Integer.parseInt(value1.getText().toString());
                y = Integer.parseInt(value2.getText().toString());
                z = x-y;
                result.setText(+z);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x, y, z;
                x = Integer.parseInt(value1.getText().toString());
                y = Integer.parseInt(value2.getText().toString());
                z = x*y;
                result.setText(+z);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x, y, z;
                x = Integer.parseInt(value1.getText().toString());
                y = Integer.parseInt(value2.getText().toString());
                z = x/y;
                result.setText(+z);
            }
        });
    }
}