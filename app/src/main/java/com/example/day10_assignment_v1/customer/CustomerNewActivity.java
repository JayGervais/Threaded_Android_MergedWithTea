package com.example.day10_assignment_v1.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.Validation.Validation;
import com.example.day10_assignment_v1.agency.Agency;
import com.example.day10_assignment_v1.agency.AgencyDB;
import com.example.day10_assignment_v1.agent.AddAgentActivity;
import com.example.day10_assignment_v1.agent.AgentDB;
import com.example.day10_assignment_v1.agent.AgentListActivity;

public class CustomerNewActivity extends AppCompatActivity {
    EditText etCustomerId, etCustFirstName, etCustLastName, etCustAddress,
            etCustCity, etCustProv, etCustPostal, etCustCountry, etCustHomePhone,
            etCustBusPhone, etCustEmail, etAgentId;
    Button btnSaveNewCustomer,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_new);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //etCustomerId = findViewById(R.id.etCustomerIdN);
        etCustFirstName=findViewById(R.id.etCustFirstNameN);
        etCustLastName = findViewById(R.id.etCustLastNameN);
        etCustAddress=findViewById(R.id.etCustAddressN);
        etCustCity = findViewById(R.id.etCustCityN);
        etCustProv=findViewById(R.id.etCustProvN);
        etCustPostal = findViewById(R.id.etCustPostalN);
        etCustCountry=findViewById(R.id.etCustCountryN);
        etCustHomePhone = findViewById(R.id.etCustHomePhoneN);
        etCustBusPhone=findViewById(R.id.etCustBusPhoneN);
        etCustEmail=findViewById(R.id.etCustEmailN);
        etAgentId=findViewById(R.id.etAgentidN);



        btnSaveNewCustomer = findViewById(R.id.btnSaveNewCustomer);
        btnCancel = findViewById(R.id.btnCancel);


        btnSaveNewCustomer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //Validation with error messages

                if (validateCust()==true){
                    CustomerDB.UpdateCustomer(null,
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
                            etAgentId.getText().toString(),
                            "sait_oosd_2019_updateSecret",
                            DBHelper.apiURL() + "/api/customer_add.php",
                            CustomerNewActivity.this);

                    Toast.makeText(CustomerNewActivity.this, "New Customer Added", Toast.LENGTH_LONG).show();
                    Intent savedIntent = new Intent(CustomerNewActivity.this, CustomerListActivity.class);
                    CustomerNewActivity.this.startActivity(savedIntent);
                }
            } });

        btnCancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent savedIntent = new Intent(CustomerNewActivity.this, CustomerListActivity.class);
                CustomerNewActivity.this.startActivity(savedIntent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;

    }
    public boolean validateCust(){
        String alpha = etCustFirstName.getText().toString();
        if (!Validation.isValidAlpha(alpha)) {
            etCustFirstName.setError(getString(R.string.Alpha));
            return false;
        }
        alpha = etCustLastName.getText().toString();
        if(!Validation.isValidAlpha(alpha)){
            etCustLastName.setError(getString(R.string.Alpha));
            return false;
        }
        String address = etCustAddress.getText().toString();
        if(!Validation.isValidAddress(address)){
            etCustAddress.setError(getString(R.string.Address));
            return false;
        }
        alpha= etCustCity.getText().toString();
        if(!Validation.isValidAlpha(alpha)){
            etCustCity.setError(getString(R.string.Alpha));
            return false;
        }
        alpha = etCustProv.getText().toString();
        if(!Validation.isValidAlpha(alpha)){
            etCustProv.setError(getString(R.string.Alpha));
            return false;
        }
        String postal = etCustPostal.getText().toString();
        if(!Validation.isValidPostal(postal)){
            etCustPostal.setError(getString(R.string.Postal));
            return false;
        }
        alpha = etCustCountry.getText().toString();
        if(!Validation.isValidAlpha(alpha)) {
            etCustCountry.setError(getString(R.string.Alpha));
            return false;
        }
        String phone = etCustHomePhone.getText().toString();
        if(!Validation.isValidPhoneNum(phone)){
            etCustHomePhone.setError(getString(R.string.Phone));
            return false;
        }
        phone = etCustBusPhone.getText().toString();
        if(!Validation.isValidPhoneNum(phone)){
            etCustBusPhone.setError(getString(R.string.Phone));
            return false;
        }
        String email = etCustEmail.getText().toString();

        if(!Validation.isValidEmailOrNull(email)){
            etCustEmail.setError(getString(R.string.Email));
            return false;
        }
        else{
            return true;}
    }

}
