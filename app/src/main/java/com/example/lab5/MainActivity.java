package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey, "").equals("")) {
            String username = sharedPreferences.getString("username", "");
            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("username", username);
            startActivity(intent);
        }
        else {
            setContentView(R.layout.activity_main);
        }
    }

    public void buttonClick(View view) {
        EditText username = (EditText) findViewById(R.id.username);
        String str = username.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", str).apply();

        login(str);
        //Toast.makeText(MainActivity.this, myTextField.getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void login(String s){
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("username", s);
        startActivity(intent);
    }
}