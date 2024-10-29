package com.example.listnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private RadioGroup radioGroup;
    private RadioButton radioEven, radioOdd, radioSquare;
    private Button buttonShow;
    private ListView listView;
    private TextView textViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        radioGroup = findViewById(R.id.radioGroup);
        radioEven = findViewById(R.id.radioEven);
        radioOdd = findViewById(R.id.radioOdd);
        radioSquare = findViewById(R.id.radioSquare);
        buttonShow = findViewById(R.id.buttonShow);
        listView = findViewById(R.id.listView);
        textViewError = findViewById(R.id.textViewError);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewError.setVisibility(View.GONE);
                String input = editTextNumber.getText().toString();

                if (input.isEmpty()) {
                    textViewError.setText("Vui lòng nhập số nguyên dương.");
                    textViewError.setVisibility(View.VISIBLE);
                    return;
                }

                int n;
                try {
                    n = Integer.parseInt(input);
                    if (n <= 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    textViewError.setText("Vui lòng nhập số nguyên dương hợp lệ.");
                    textViewError.setVisibility(View.VISIBLE);
                    return;
                }

                ArrayList<Integer> numbers = new ArrayList<>();

                // Kiểm tra loại số được chọn
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == radioEven.getId()) {
                    for (int i = 0; i <= n; i += 2) {
                        numbers.add(i);
                    }
                } else if (selectedId == radioOdd.getId()) {
                    for (int i = 1; i <= n; i += 2) {
                        numbers.add(i);
                    }
                } else if (selectedId == radioSquare.getId()) {
                    for (int i = 0; i * i <= n; i++) {
                        numbers.add(i * i);
                    }
                } else {
                    textViewError.setText("Vui lòng chọn loại số.");
                    textViewError.setVisibility(View.VISIBLE);
                    return;
                }

                ArrayAdapter<Integer> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, numbers);
                listView.setAdapter(adapter);
            }
        });
    }
}
