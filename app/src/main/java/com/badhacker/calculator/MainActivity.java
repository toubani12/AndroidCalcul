package com.badhacker.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText input1, input2;
    private TextView result;
    private Button addBtn, subtractBtn, multiplyBtn, divideBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the layout programmatically
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        // Input fields
        input1 = new EditText(this);
        input1.setHint("Enter first number");
        layout.addView(input1);

        input2 = new EditText(this);
        input2.setHint("Enter second number");
        layout.addView(input2);

        // Result display
        result = new TextView(this);
        result.setTextSize(18);
        result.setPadding(0, 20, 0, 20);
        layout.addView(result);

        // Buttons for operations
        addBtn = new Button(this);
        addBtn.setText("Add");
        layout.addView(addBtn);

        subtractBtn = new Button(this);
        subtractBtn.setText("Subtract");
        layout.addView(subtractBtn);

        multiplyBtn = new Button(this);
        multiplyBtn.setText("Multiply");
        layout.addView(multiplyBtn);

        divideBtn = new Button(this);
        divideBtn.setText("Divide");
        layout.addView(divideBtn);

        // Set the layout to the Activity
        setContentView(layout);

        // Add button click listeners
        addListeners();
    }

    private void addListeners() {
        addBtn.setOnClickListener(v -> calculate("+"));
        subtractBtn.setOnClickListener(v -> calculate("-"));
        multiplyBtn.setOnClickListener(v -> calculate("*"));
        divideBtn.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operation) {
        try {
            double num1 = Double.parseDouble(input1.getText().toString());
            double num2 = Double.parseDouble(input2.getText().toString());
            double calcResult = 0;

            switch (operation) {
                case "+":
                    calcResult = num1 + num2;
                    break;
                case "-":
                    calcResult = num1 - num2;
                    break;
                case "*":
                    calcResult = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        calcResult = num1 / num2;
                    } else {
                        result.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }

            result.setText("Result: " + calcResult);
        } catch (NumberFormatException e) {
            result.setText("Error: Invalid input");
        }
    }
}
