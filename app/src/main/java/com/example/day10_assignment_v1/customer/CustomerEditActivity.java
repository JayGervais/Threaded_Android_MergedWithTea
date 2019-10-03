package com.example.day10_assignment_v1.customer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.agent.AgentDB;
import com.example.day10_assignment_v1.agent.AgentDetailActivity;
import com.example.day10_assignment_v1.agent.AgentEditActivity;
import com.example.day10_assignment_v1.agent.AgentListActivity;

public class CustomerEditActivity extends AppCompatActivity {

    EditText etCustomerId, etCustFirstName, etCustLastName, etCustAddress,
            etCustCity, etCustProv, etCustPostal, etCustCountry, etCustHomePhone,
            etCustBusPhone, etCustEmail, etAgentId;
    Button btnSaveCustomer, btnCancel, btnDeleteCustomer;
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCustomerId = findViewById(R.id.etCustomerId);
        etCustFirstName=findViewById(R.id.etCustFirstName);
        etCustLastName = findViewById(R.id.etCustLastName);
        etCustAddress=findViewById(R.id.etCustAddress);
        etCustCity = findViewById(R.id.etCustCity);
        etCustProv=findViewById(R.id.etCustProv);
        etCustPostal = findViewById(R.id.etCustPostal);
        etCustCountry=findViewById(R.id.etCustCountry);
        etCustHomePhone = findViewById(R.id.etCustHomePhone);
        etCustBusPhone=findViewById(R.id.etCustHomePhone);
        etCustEmail = findViewById(R.id.etCustEmail);
        //etAgentId=findViewById(R.id.etAgentId);

        btnSaveCustomer=findViewById(R.id.btnSaveCustomer);
        btnCancel=findViewById(R.id.btnCancel);
        btnDeleteCustomer=findViewById(R.id.btnDeleteCustomer);

        Intent intent = getIntent();
        String customerId = intent.getStringExtra("customerId");
        String custFirstName = intent.getStringExtra("custFirstName");
        String custLastName = intent.getStringExtra("custLastName");
        String custAddress = intent.getStringExtra("custAddress");
        String custCity = intent.getStringExtra("custCity");
        String custProv = intent.getStringExtra("custProv");
        String custPostal = intent.getStringExtra("custPostal");
        String custCountry = intent.getStringExtra("custCountry");
        String custHomePhone = intent.getStringExtra("custHomePhone");
        String cutBusPhone = intent.getStringExtra("custBusPhone");
        String custEmail = intent.getStringExtra("custEmail");
        //String agentId = intent.getStringExtra("agentId");


        etCustomerId.setText(String.valueOf(customerId));
        etCustFirstName.setText(custFirstName);
        etCustLastName.setText(custLastName);
        etCustAddress.setText(custAddress);
        etCustCity.setText(custCity);
        etCustProv.setText(custProv);
        etCustPostal.setText(custPostal);
        etCustCountry.setText(custCountry);
        etCustHomePhone.setText(custHomePhone);
        etCustBusPhone.setText(cutBusPhone);
        etCustEmail.setText(custEmail);
        //etAgentId.setText(agentId);




        btnSaveCustomer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
             CustomerDB.UpdateCustomer(etCustomerId.getText().toString(),
                etCustFirstName.getText().toString(),
                etCustLastName.getText().toString(),
                etCustAddress.getText().toString(),
                etCustCity.getText().toString(),
                etCustProv.getText().toString(),
                etCustPostal.getText().toString(),
                etCustCountry.getText().toString(),
                etCustHomePhone.getText().toString(),
                etCustBusPhone.getText().toString(),
                etCustEmail.getText().toString(),
                etAgentId.getText().toString()
                ,
                "api_updateCustomer_activitySecret",
                DBHelper.apiURL() + "/api/customer_update.php",
                CustomerEditActivity.this);
                Toast.makeText(CustomerEditActivity.this, "Changes Saved", Toast.LENGTH_LONG).show();
                Intent savedIntent = new Intent(CustomerEditActivity.this, CustomerDetailActivity.class);
                CustomerEditActivity.this.startActivity(savedIntent);
    }
                });
        btnDeleteCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(CustomerEditActivity.this)
                        .setTitle("Delete Customer")
                        .setMessage("Are you sure you want to delete Customer, " + etCustFirstName.getText() + " " + etCustLastName.getText() + "?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton)
                            {
                                AgentDB.DeleteAgent(etCustomerId.getText().toString(),
                                        "api_secretKey_deleteCustomer",
                                        DBHelper.apiURL() + "/api/customer_delete.php",
                                        CustomerEditActivity.this);
                                Toast.makeText(CustomerEditActivity.this, "Customer Deleted Successfully", Toast.LENGTH_LONG).show();
                                Intent savedIntent = new Intent(CustomerEditActivity.this, CustomerListActivity.class);
                                CustomerEditActivity.this.startActivity(savedIntent);
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent savedIntent = new Intent(CustomerEditActivity.this, CustomerListActivity.class);
                CustomerEditActivity.this.startActivity(savedIntent);
            }
        });
    }
}