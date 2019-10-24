package com.example.day10_assignment_v1.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.MainActivity;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.admin.AdminDB;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity
{
    EditText etEmail, etPassword;
    Button btnLogIn, btnAdmin;
    Spinner spinnerAccount;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogIn = findViewById(R.id.btnLogIn);
        // btnAdmin = findViewById(R.id.btnAdmin);
        spinnerAccount = findViewById(R.id.spinnerAccount);

        getSupportActionBar().hide();

        final List<String> spinnerArray = new ArrayList<>();
        spinnerArray.add("Agent");
        spinnerArray.add("Admin");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinnerAccount.setAdapter(adapter);

        btnLogIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (etEmail.getText() != null && etPassword != null)
                {
                    if (spinnerAccount.getSelectedItem().toString() == "Agent")
                    {
                        // string builder to get user session
                        Uri.Builder loginURL = new Uri.Builder();
                        loginURL.scheme("http").encodedAuthority(DBHelper.apiAuth())
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
                            Toast.makeText(getApplicationContext(), "Login Successful",
                                    Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        } else {
//                            Toast.makeText(getApplicationContext(), "Username or password does not match",
//                                    Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        // string builder to get user session
                        Uri.Builder adminLoginURL = new Uri.Builder();
                        adminLoginURL.scheme("http").encodedAuthority(DBHelper.apiAuth())
                                .appendPath("api")
                                .appendPath("admin_login.php")
                                .appendQueryParameter("email", String.valueOf(etEmail.getText()))
                                .appendQueryParameter("password", String.valueOf(etPassword.getText()));
                        String adminLoginAPI = adminLoginURL.build().toString();

                        session = new Session(LoginActivity.this);
                        AdminDB.SetAdminLoginSession(adminLoginAPI, LoginActivity.this, session);

                        // check for session
                        if (session.getsessionid() != null)
                        {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("sessionid", session.getsessionid());
                            // intent.putExtra("sessionrole", session.getsessionrole());
                            Toast.makeText(getApplicationContext(), "Login Successful",
                                    Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        } else {
//                            Toast.makeText(getApplicationContext(), "Username or password does not match",
//                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}
