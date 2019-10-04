package com.example.day10_assignment_v1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day10_assignment_v1.agent.AgentListActivity;
import com.example.day10_assignment_v1.login.LoginActivity;
import com.example.day10_assignment_v1.login.Session;
import com.example.day10_assignment_v1.booking.BookingListActivity;
import com.example.day10_assignment_v1.customer.CustomerListActivity;
import com.example.day10_assignment_v1.product.ProductListActivity;


public class MainActivity extends AppCompatActivity
{
    private Session session;
    TextView tvSession;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // session set and check
        tvSession = findViewById(R.id.tvSession);
        session = new Session(this);
        if (session.getsessionid() == null)
        {
            startActivity(new Intent(this, LoginActivity.class));
        }
        else
        {
            tvSession.setText("Welcome, " + session.getsessionname());
            session.getsessionid();
            session.getsessionrole();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menu_agents:
                startActivity(new Intent(this, AgentListActivity.class));
                return true;
            case R.id.menu_bookings:
                startActivity(new Intent(this, BookingListActivity.class));
                return true;
            case R.id.menu_customers:
                startActivity(new Intent(this, CustomerListActivity.class));
                return true;
            case R.id.menu_products:
                startActivity(new Intent(this, ProductListActivity.class));
                return true;
            case R.id.menu_logout:
                session.setsessionid(null);
                startActivity(new Intent(this, MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
