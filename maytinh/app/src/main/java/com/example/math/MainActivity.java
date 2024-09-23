package com.example.math;
import net.objecthunter.exp4j.ExpressionBuilder;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextExpression = findViewById(R.id.editText_expression);

        // Gán các nút với sự kiện click
        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
                R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
                R.id.button_8, R.id.button_9, R.id.button_dot,
                R.id.button_add, R.id.button_subtract, R.id.button_multiply, R.id.button_divide,
                R.id.button_open_parenthesis, R.id.button_close_parenthesis
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String currentText = editTextExpression.getText().toString();
                editTextExpression.setText(currentText + button.getText().toString());
            }
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(listener);
        }

        // Nút xóa (Backspace)
        findViewById(R.id.button_backspace).setOnClickListener(v -> {
            String currentText = editTextExpression.getText().toString();
            if (!TextUtils.isEmpty(currentText)) {
                editTextExpression.setText(currentText.substring(0, currentText.length() - 1));
            }
        });

        // Nút xóa toàn bộ (Clear)
        findViewById(R.id.button_clear).setOnClickListener(v -> editTextExpression.setText(""));

        // Nút "=" để tính kết quả
        findViewById(R.id.button_equals).setOnClickListener(v -> {
            String expression = editTextExpression.getText().toString();
            try {
                double result = evaluateExpression(expression);
                editTextExpression.setText(String.valueOf(result));
            } catch (Exception e) {
                editTextExpression.setText("Error");
            }
        });
    }

    // Hàm đánh giá biểu thức toán học
    private double evaluateExpression(String expression) {
        // Sử dụng một thư viện có sẵn như 'exp4j' để đánh giá biểu thức, hoặc bạn có thể tự viết parser.
        return new net.objecthunter.exp4j.ExpressionBuilder(expression).build().evaluate();
    }
}
