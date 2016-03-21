package com.example.ameet.gpacalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity {

    EditText classNameEdit;
    EditText gradeEdit;
    ArrayList<Class> classArrayList;
    Calculator calculator;
    ClassArrayAdapter classArrayAdapter;
    ListView classList;
    TextView yourGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calculator = new Calculator();
        classArrayAdapter = new ClassArrayAdapter(CalculatorActivity.this, R.layout.list_item, classArrayList);
        classList = (ListView) (findViewById(R.id.classList));
        classArrayList = new ArrayList<>();
        classList.setAdapter(classArrayAdapter);


        View view = findViewById(R.id.class_add);
        yourGPA = (TextView) findViewById(R.id.yourGPAText);
        classNameEdit = (EditText) view.findViewById(R.id.nameEdit);
        gradeEdit = (EditText) view.findViewById(R.id.gradeEdit);
        Button addClassButton = (Button) view.findViewById(R.id.addClass);
        addClassButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(calculator.checkValidGrade(gradeEdit.getText().toString())) {
                    createNewClass();
                }
                else {
                    Toast.makeText(CalculatorActivity.this, "Please enter a valid grade", Toast.LENGTH_LONG).show();
                }

            }
        });



    }

    public void createNewClass() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        String tempGrade = gradeEdit.getText().toString();
        String tempName = classNameEdit.getText().toString();

        if (tempGrade.length() != 0) {
            if (tempName.length() != 0) {
                Class c = new Class(tempGrade, tempName);
                classArrayAdapter.add(c);
                classArrayAdapter.notifyDataSetChanged();
                classArrayList.add(c);
            } else {

                Class c = new Class(tempGrade,
                        "class " + String.valueOf(classArrayList.size()+1)
                );
                classArrayAdapter.add(c);
                classArrayAdapter.notifyDataSetChanged();
                classArrayList.add(c);

            }

        } else {

            Toast.makeText(CalculatorActivity.this, "You must enter a grade", Toast.LENGTH_LONG).show();

        }

        if (classArrayList.size() != 0) {
            yourGPA.setText(calculator.calculate(classArrayList));
        }

    }
}
