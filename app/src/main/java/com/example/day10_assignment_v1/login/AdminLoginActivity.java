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
import com.example.day10_assignment_v1.admin.Admin;
import com.example.day10_assignment_v1.admin.AdminDB;

public class AdminLoginActivity extends AppCompatActivity
{
    Session session;

    EditText etAdminEmail, etAdminPassword;
    Button btnAdminLogin, btnAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        etAdminEmail = findViewById(R.id.etAdminEmail);
        etAdminPassword = findViewById(R.id.etAdminPassword);
        btnAdminLogin = findViewById(R.id.btnAdminLogIn);
        btnAgent = findViewById(R.id.btnAgent);

        btnAdminLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // string builder to get user session
                Uri.Builder adminLoginURL = new Uri.Builder();
                adminLoginURL.scheme("https").authority(DBHelper.apiAuth())
                        .appendPath("api")
                        .appendPath("admin_login.php")
                        .appendQueryParameter("email", String.valueOf(etAdminEmail.getText()))
                        .appendQueryParameter("password", String.valueOf(etAdminPassword.getText()));
                String adminLoginAPI = adminLoginURL.build().toString();

                session = new Session(AdminLoginActivity.this);
                AdminDB.SetAdminLoginSession(adminLoginAPI, AdminLoginActivity.this, session);

                // check for session
                if (session.getsessionid() != null)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("sessionid", session.getsessionid());
                    // intent.putExtra("sessionrole", session.getsessionrole());
                    Toast.makeText(getApplicationContext(), "Login Successful",
                            Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });

        btnAgent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
