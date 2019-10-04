package com.example.day10_assignment_v1.customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.MainActivity;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.agent.AgentListActivity;
import com.example.day10_assignment_v1.login.LoginActivity;
import com.example.day10_assignment_v1.booking.BookingListActivity;
import com.example.day10_assignment_v1.product.ProductListActivity;

public class CustomerListActivity extends AppCompatActivity {
    ListView lvCustomers;
    Button btnNewCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);




        lvCustomers = findViewById(R.id.lvCustomers);
        btnNewCustomer = findViewById(R.id.btnNewCustomer);
        lvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), CustomerDetailActivity.class);
                intent.putExtra("customer",(Customer) lvCustomers.getItemAtPosition(position));
                startActivity(intent);
            }
        });

        btnNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customerNewIntent = new Intent(CustomerListActivity.this,CustomerNewActivity.class);
                CustomerListActivity.this.startActivity(customerNewIntent);
            }
        });

        CustomerDB.GetCustomerListData(DBHelper.apiURL()+"/api/customer_data.php",this,lvCustomers);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;

    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

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
                startActivity(new Intent(this, LoginActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
