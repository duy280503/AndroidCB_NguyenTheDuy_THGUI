package com.example.bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        iNitConTrol();
    }
    private EditText editTextName, editTextHeight, editTextWeight;
    private TextView textViewBMIResult, textViewDiagnosis;
    private Button buttonCalculate;

    private void iNitConTrol(){
        // Tham chiếu đến các thành phần giao diện
        editTextName = findViewById(R.id.editTextName);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        textViewBMIResult = findViewById(R.id.textViewBMIResult);
        textViewDiagnosis = findViewById(R.id.textViewDiagnosis);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        // Xử lý khi người dùng nhấn nút "TÍNH BMI"
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Lấy giá trị từ EditText
        String heightStr = editTextHeight.getText().toString();
        String weightStr = editTextWeight.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            // Tính BMI
            float bmi = weight / (height * height);
            textViewBMIResult.setText(String.format("%.2f", bmi));

            // Chẩn đoán dựa trên chỉ số BMI
            if (bmi < 18.5) {
                textViewDiagnosis.setText("Thiếu cân");
            } else if (bmi >= 18.5 && bmi < 24.9) {
                textViewDiagnosis.setText("Bình thường");
            } else if (bmi >= 25 && bmi < 29.9) {
                textViewDiagnosis.setText("Thừa cân");
            } else {
                textViewDiagnosis.setText("Béo phì");
            }
        } else {
            textViewBMIResult.setText("0.00");
            textViewDiagnosis.setText("Vui lòng nhập đủ thông tin.");
        }
    }
}