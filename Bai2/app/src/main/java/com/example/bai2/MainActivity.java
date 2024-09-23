package com.example.bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initControl();
    }
    EditText txtC, txtF;
    Button btnSangC, btnSangF, btnClear;

    private void initControl() {
        txtC = findViewById(R.id.txtC);
        txtF = findViewById(R.id.txtF);
        btnSangC = findViewById(R.id.btnSangC);
        btnSangF = findViewById(R.id.btnSangF);
        btnClear = findViewById(R.id.btnClear);

        btnSangF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float c = Float.parseFloat(txtC.getText().toString());
                float f = c * 9/5 + 32;
                txtF.setText(String.valueOf(f));

            }
        });
        btnSangC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float f = Float.parseFloat(txtF.getText().toString());
                float c = (f - 32) * 5/9;
                txtC.setText(String.valueOf(c));

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtC.setText("");
                txtF.setText("");
            }
        });
    }
}