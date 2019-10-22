package com.example.day10_assignment_v1.supplier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.Validation.Validation;
import com.example.day10_assignment_v1.customer.CustomerEditActivity;

import java.util.regex.Pattern;

public class SupplierEditActivity extends AppCompatActivity {
    EditText etSupplierContactId, etSupCompany,etSupFirstName,etSupLastName, etSupAddress,etSupCity,etSupProv,etSupPostal,etSupCountry, etSupBusPhone, etSupFax,etSupEmail, etSupURL,etAffiliationId;
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

        etSupplierContactId=findViewById(R.id.etSupplierContactId);
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

        if(!supConFirstName.equals("null")){
        etSupFirstName.setText(supConFirstName);}
        if(!supConLastName.equals("null")){
        etSupLastName.setText(supConLastName);}
        if(!supConCompany.equals("null")){
        etSupCompany.setText(supConCompany);}
        if(!supConAddress.equals("null")){
        etSupAddress.setText(supConAddress);}
        if(!supConCity.equals("null")){
        etSupCity.setText(supConCity);}
        if(!supConProv.equals("null")){
        etSupProv.setText(supConProv);}
        if(!supConPostal.equals("null")){
        etSupPostal.setText(supConPostal);}
        if(!supConCountry.equals("null")){
        etSupCountry.setText(supConCountry);}
        if(!supConBusPhone.equals("null")){
        etSupBusPhone.setText(supConBusPhone);}
        if(!supConFax.equals("null")){
        etSupFax.setText(supConFax);}
        if(!supConEmail.equals("null")){
        etSupEmail.setText(supConEmail);}
        if(!supConURL.equals("null")){
        etSupURL.setText(supConURL);}
        if(!affiliationId.equals("null")){
        etAffiliationId.setText(affiliationId);}


        btnUpdateSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(validateSup()==true){
                SupplierDB.UpdateSupplier(
                        etSupplierContactId.getText().toString(),
                        etSupFirstName.getText().toString(),
                        etSupLastName.getText().toString(),
                        etSupCompany.getText().toString(),
                        etSupAddress.getText().toString(),
                        etSupCity.getText().toString(),
                        etSupProv.getText().toString(),
                        etSupPostal.getText().toString(),
                        etSupCountry.getText().toString(),
                        etSupBusPhone.getText().toString(),
                        etSupFax.getText().toString(),
                        etSupEmail.getText().toString(),
                        etSupURL.getText().toString(),
                        etAffiliationId.getText().toString(),
                        "sait_oosd_2019_update_supSecret",
                        DBHelper.apiURL() + "/api/supplier_update.php",
                        SupplierEditActivity.this



                );
            }}
        });

    }
    public boolean validateSup(){
        String alpha = etSupFirstName.getText().toString();
        if (!Validation.isValidAlphaOrNull(alpha)) {
            etSupFirstName.setError(getString(R.string.Alpha));
            return false;
        }
        alpha = etSupLastName.getText().toString();
        if(!Validation.isValidAlphaOrNull(alpha)) {
            etSupLastName.setError(getString(R.string.Alpha));
            return false;
        }
        String address = etSupAddress.getText().toString();
        if(!Validation.isValidAlphaOrNull(address)){
            etSupAddress.setError(getString(R.string.Address));
            return false;
        }
        alpha = etSupCity.getText().toString();
        if(!Validation.isValidAlphaOrNull(alpha)) {
            etSupCity.setError(getString(R.string.Alpha));
            return false;
        }
        alpha = etSupProv.getText().toString();
        if(!Validation.isValidAlphaOrNull(alpha)){
            etSupProv.setError(getString(R.string.Alpha));
            return false;
        }
        String postal = etSupPostal.getText().toString();
        if(!Validation.isValidPhoneNumOrNull(postal)){
            etSupPostal.setError(getString(R.string.Postal));
            return false;
        }
        alpha = etSupCountry.getText().toString();
        if(!Validation.isValidAlphaOrNull(alpha)){
            etSupCountry.setError(getString(R.string.Alpha));
            return false;
        }
        String phone = etSupBusPhone.getText().toString();
        if(!Validation.isValidPhoneNumOrNull(phone)){
            etSupBusPhone.setError(getString(R.string.Phone));
            return false;
        }
        phone = etSupFax.getText().toString();
        if(!Validation.isValidPhoneNumOrNull(phone)){
            etSupFax.setError(getString(R.string.Fax));
            return false;
        }
        String email = etSupEmail.getText().toString();
        if(!Validation.isValidEmailOrNull(email)){
            etSupEmail.setError(getString(R.string.Email));
            return false;
        }
        String url = etSupURL.getText().toString();
        if(!Validation.isValidUrlOrNull(url)){
            etSupURL.setError(getString(R.string.Url));
            return false;
        }
        else
        {
            return true;
        }











    }
}
