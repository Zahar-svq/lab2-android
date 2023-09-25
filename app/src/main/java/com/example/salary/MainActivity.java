package com.example.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickSend(View view){
        EditText nameText = findViewById(R.id.name);
        EditText surnameText = findViewById(R.id.surname);
        EditText ageText = findViewById(R.id.age);
        EditText salaryText = findViewById(R.id.salary);

        String name = nameText.getText().toString();
        String surname = surnameText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());
        float salary = Float.parseFloat(salaryText.getText().toString());


        Gson gson = new Gson();
        User user = new User(name, surname, age, salary);
        String userString = gson.toJson(user);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("User", userString);
        startActivity(intent);
    }

}