package com.example.day10_assignment_v1.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.MainActivity;
import com.example.day10_assignment_v1.R;

public class LoginActivity extends AppCompatActivity
{
    EditText etEmail, etPassword;
    Button btnLogIn;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogIn = findViewById(R.id.btnLogIn);

        btnLogIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etEmail.getText() != null && etPassword !=null)
                {
                    // string builder to get user session
                    Uri.Builder loginURL = new Uri.Builder();
                    loginURL.scheme("https").authority(DBHelper.apiAuth())
                            .appendPath("api")
                            .appendPath("login.php")
                            .appendQueryParameter("email", String.valueOf(etEmail.getText()))
                            .appendQueryParameter("password", String.valueOf(etPassword.getText()));
                    String loginAPI = loginURL.build().toString();

                    session = new Session(LoginActivity.this);
                    LoginDB.SetAgentSession(loginAPI, LoginActivity.this, session);

                    // check for session
                    if (session.getsessionid() != null)
                    {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("sessionid", session.getsessionid());
                        Toast.makeText(getApplicationContext(), "Login successful",
                                Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
