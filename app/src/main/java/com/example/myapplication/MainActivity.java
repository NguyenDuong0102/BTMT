package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initcontrol();


    }


    EditText txtx,txty;
    TextView txtresult;
    Button btnPlus,btnTru,btnNhan,btnChia,btnpercent;

    private void initcontrol() {
        txtx = findViewById(R.id.txtx);
        txty = findViewById(R.id.txty);
        txtresult = findViewById(R.id.txtresult);
        btnPlus = findViewById(R.id.btnPlus);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnpercent = findViewById(R.id.btnpercent);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = getValue(txtx.getText().toString());
                float y = getValue(txty.getText().toString());
                float result = x + y;
                txtresult.setText(String.valueOf(result));
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = getValue(txtx.getText().toString());
                float y = getValue(txty.getText().toString());
                float result = x - y;
                txtresult.setText(String.valueOf(result));
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = getValue(txtx.getText().toString());
                float y = getValue(txty.getText().toString());
                float result = x * y;
                txtresult.setText(String.valueOf(result));
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = getValue(txtx.getText().toString());
                float y = getValue(txty.getText().toString());
                float result = x / y;
                txtresult.setText(String.valueOf(result));
            }
        });

        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xValue = txtx.getText().toString();
                String yValue = txty.getText().toString();

                // Nếu EditText txtx có giá trị và đang có focus
                if (!xValue.isEmpty() && txtx.hasFocus()) {
                    float x = Float.parseFloat(xValue);
                    txtx.setText(String.valueOf(x / 100));
                }
                else if (!yValue.isEmpty() && txty.hasFocus()) {
                    float y = Float.parseFloat(yValue);
                    txty.setText(String.valueOf(y / 100));
                }
            }
        });
    }

    private float getValue(String input) {
        if (input.contains("%")) {

            input = input.replace("%", "");
            return Float.parseFloat(input) / 100;
        } else {
            return Float.parseFloat(input);
        }
    }

}
