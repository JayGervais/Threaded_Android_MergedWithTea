package com.example.day10_assignment_v1.supplier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.day10_assignment_v1.R;

public class SupplierEditActivity extends AppCompatActivity {
    EditText etSupCompany,etSupFirstName,etSupLastName, etSupAddress,etSupCity,etSupProv,etSupPostal,etSupCountry, etSupBusPhone, etSupFax,etSupEmail, etSupURL,etAffiliationId;
    Button btnUpdateSupplier, btnDeleteSupplier, btnCancel;
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
        setContentView(R.layout.activity_supplier_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etSupCompany = findViewById(R.id.etSupCompany);
        etSupFirstName = findViewById(R.id.etSupFirstName);
        etSupLastName = findViewById(R.id.etSupLastName);
        etSupAddress = findViewById(R.id.etSupAddress);
        etSupCity = findViewById(R.id.etSupCity);
        etSupProv = findViewById(R.id.etSupProv);
        etSupPostal = findViewById(R.id.etSupPostal);
        etSupCountry = findViewById(R.id.etSupCountry);
        etSupBusPhone = findViewById(R.id.etSupBusPhone);
        etSupFax = findViewById(R.id.etSupFax);
        etSupEmail = findViewById(R.id.etSupEmail);
        etSupURL = findViewById(R.id.etSupURL);
        etAffiliationId = findViewById(R.id.etAffiliationId);


        btnUpdateSupplier=findViewById(R.id.btnUpdateSupplier);
        btnDeleteSupplier=findViewById(R.id.btnDeleteSupplier);
        btnCancel=findViewById(R.id.btnCancel);

        Intent intent = getIntent();


        String supConFirstName = intent.getStringExtra("supConFirstName");
       String supConLastName = intent.getStringExtra("subConLastName");
         String supConCompany = intent.getStringExtra("supConCompany");
       String supConAddress = intent.getStringExtra("supConAddress");
        String supConCity = intent.getStringExtra("supConCity");
         String supConProv = intent.getStringExtra("supConProv");
        String supConPostal  =intent.getStringExtra("supConPostal");
      String supConCountry = intent.getStringExtra("supConCountry");
       String supConBusPhone = intent.getStringExtra("supConBusPhone");
        String supConFax = intent.getStringExtra("supConFax");
        String supConEmail = intent.getStringExtra("supConEmail");
        String supConURL = intent.getStringExtra("supConURL");
        String affiliationId = intent.getStringExtra("affiliationId");

        etSupFirstName.setText(supConFirstName);
        etSupLastName.setText(supConLastName);
        etSupCompany.setText(supConCompany);
        etSupAddress.setText(supConAddress);
        etSupCity.setText(supConCity);
        etSupProv.setText(supConProv);
        etSupPostal.setText(supConPostal);
        etSupCountry.setText(supConCountry);
        etSupBusPhone.setText(supConBusPhone);
        etSupFax.setText(supConFax);
        etSupEmail.setText(supConEmail);
        etSupURL.setText(supConURL);
        etAffiliationId.setText(affiliationId);





    }
}
