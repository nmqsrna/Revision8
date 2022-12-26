package com.example.revision8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public final static String USERNAME = "com.example.revision8.username";

    EditText et_Username, et_Password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_Username = findViewById(R.id.etUsername);
        et_Password = findViewById(R.id.etPassword);
        btn_login = findViewById(R.id.btnLogin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_Username.getText().toString().equals("mas qasrina") && et_Password.getText().toString().equals("1234")){
                    String username = et_Username.getText().toString();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                    intent.putExtra(USERNAME,username);
                    startActivity(intent);

                }else{
                    alertDialogBox();
                }
            }
        });
    }

    public void send_data(View v){
        et_Username = findViewById(R.id.etUsername);

        String username = et_Username.getText().toString();

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

        intent.putExtra(USERNAME,username);

        startActivity(intent);
    }

    public void alertDialogBox(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Authentication Failed");
        builder.setMessage("Wrong! Try Again");
        builder.setPositiveButton("OK",null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}