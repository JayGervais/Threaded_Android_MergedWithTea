package com.example.day10_assignment_v1.customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.day10_assignment_v1.MainActivity;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.agent.AgentListActivity;
import com.example.day10_assignment_v1.booking.BookingListActivity;
import com.example.day10_assignment_v1.login.LoginActivity;
import com.example.day10_assignment_v1.product.ProductListActivity;

public class CustomerDetailActivity extends AppCompatActivity {

    TextView tvCustFirstName, tvCustLastName, tvCustAddress, tvCustCity,
            tvCustProv,tvCustPostal,tvCustCountry,tvCustHomePhone,tvCustBusPhone,tvCustEmail,
            tvAgentIdCust, tvCustomerId;
    Button btnUpdateCust,btnDeleteCust;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail2);


        tvCustomerId=findViewById(R.id.tvCustomerId);
        tvCustFirstName=findViewById(R.id.tvCustFirstName);
        tvCustLastName=findViewById(R.id.tvCustLastName);
        tvCustAddress=findViewById(R.id.tvCustAddress);
        tvCustCity=findViewById(R.id.tvCustCity);
        tvCustProv=findViewById(R.id.tvCustProv);
        tvCustPostal=findViewById(R.id.tvCustPostal);
        tvCustCountry=findViewById(R.id.tvCustCountry);
        tvCustHomePhone=findViewById(R.id.tvCustHomePhone);
        tvCustBusPhone=findViewById(R.id.tvCustBusPhone);
        tvCustEmail=findViewById(R.id.tvCustEmail);
        tvAgentIdCust=findViewById(R.id.tvAgentIdCust);

        btnUpdateCust=findViewById(R.id.btnUpdateCust);
        btnDeleteCust=findViewById(R.id.btnDeleteCustomer);




        final Customer customerObj = getIntent().getParcelableExtra("customer");

      final Integer customerId = customerObj.getCustomerId();
        final String custFirstName =customerObj.getCustFirstName();
        final String custLastName = customerObj.getCustLastName();
        final String custAddress = customerObj.getCustAddress();
        final String custCity = customerObj.getCustCity();
        final String custProv = customerObj.getCustProv();
        final String custPostal = customerObj.getCustPostal();
        final String custCountry = customerObj.getCustCountry();
        final String custHomePhone = customerObj.getCustHomePhone();
        final String custBusPhone  =customerObj.getCustBusPhone();
        final String custEmail = customerObj.getCustEmail();
        final String agentid = customerObj.getAgentId();

       // tvCustomerId.setText(customerId);
        tvCustFirstName.setText(custFirstName);
        tvCustLastName.setText(custLastName);
        tvCustAddress.setText(custAddress);
        tvCustCity.setText(custCity);
        tvCustProv.setText(custProv);
        tvCustPostal.setText(custPostal);
        tvCustCountry.setText(custCountry);
        tvCustHomePhone.setText(custHomePhone);
        tvCustBusPhone.setText(custBusPhone);
        tvCustEmail.setText(custEmail);
        tvAgentIdCust.setText(agentid);



        btnUpdateCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerDetailActivity.this, CustomerEditActivity.class);
                intent.putExtra("customerId",String.valueOf(customerId));
                intent.putExtra("custFirstName",custFirstName);
                intent.putExtra("custLastName",custLastName);
                intent.putExtra("custAddress",custAddress);
                intent.putExtra("custCity",custCity);
                intent.putExtra("custProv",custProv);
                intent.putExtra("custPostal",custPostal);
                intent.putExtra("custCountry",custCountry);
                intent.putExtra("custHomePhone",custHomePhone);
                intent.putExtra("custBusPhone",custBusPhone);
                intent.putExtra("custEmail",custEmail);
                intent.putExtra("agentid",agentid);
                CustomerDetailActivity.this.startActivity(intent);
            }
        });


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