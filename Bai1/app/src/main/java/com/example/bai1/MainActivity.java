package com.example.bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        innitControl();
    }

    EditText txtX, txtY;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMultifly, btnDivide, btnUCLN, btnOut;

    private void innitControl() {
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtKQ);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultifly = findViewById(R.id.btnMultifly);
        btnDivide = findViewById(R.id.btnDivide);
        btnUCLN = findViewById(R.id.btnUCLN);
        btnOut = findViewById(R.id.btnOut);

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Đóng Activity hiện tại
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x + y;
                txtResult.setText(String.valueOf(result));

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x - y;
                txtResult.setText(String.valueOf(result));

            }
        });

        btnMultifly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                long result = x * y;
                txtResult.setText(String.valueOf(result));

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                float result = (float) x / y;
                txtResult.setText(String.format("%.10f", result));

            }
        });

        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputA = txtX.getText().toString();
                String inputB = txtY.getText().toString();

                if (inputA.isEmpty() || inputB.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ 2 số!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lấy giá trị từ EditText và chuyển thành số nguyên
                int numA = Integer.parseInt(inputA);
                int numB = Integer.parseInt(inputB);

                // Tính UCLN và hiển thị kết quả
                int gcd = findGCD(numA, numB);
                txtResult.setText(String.valueOf(gcd));
            }
        });
    }

    // Hàm tính UCLN (GCD) theo thuật toán Euclid
    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}