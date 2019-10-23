package com.example.day10_assignment_v1.supplier;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
//import com.example.day10_assignment_v1.R;

import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.Validation.Validation;
import com.example.day10_assignment_v1.agent.AgentDB;
import com.example.day10_assignment_v1.agent.AgentEditActivity;
import com.example.day10_assignment_v1.agent.AgentListActivity;
import com.example.day10_assignment_v1.customer.CustomerEditActivity;
import com.example.day10_assignment_v1.customer.CustomerListActivity;
import com.example.day10_assignment_v1.product.ProductListActivity;
import com.example.day10_assignment_v1.product.ProductSuppliersListActivity;

import java.util.regex.Pattern;

public class SupplierEditActivity extends AppCompatActivity {
    EditText etSupplierContactId, etSupCompany,etSupFirstName,etSupLastName,
            etSupAddress,etSupCity,etSupProv,etSupPostal,etSupCountry, etSupBusPhone,
            etSupFax,etSupEmail, etSupURL,etAffiliationId;
    Button btnSaveSupplier, btnDeleteSupplier, btnCancel;
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_edit);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


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
        etSupplierContactId=findViewById(R.id.etSupplierContactId);


        btnSaveSupplier=findViewById(R.id.btnSaveSupplier);
        btnDeleteSupplier=findViewById(R.id.btnDeleteSupplier);
        btnCancel=findViewById(R.id.btnCancel);

        final Intent intent = getIntent();

        String supplierContactId = intent.getStringExtra("supplierContactId");
        String supConFirstName = intent.getStringExtra("supConFirstName");
       String supConLastName = intent.getStringExtra("supConLastName");
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
       // String supplierId = intent.getStringExtra("supplierId");


       // etSupplierId.setText(supplierId);
        etSupplierContactId.setText(supplierContactId);
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
//
//        if(!supConFirstName.equals("null")){
//        etSupFirstName.setText(supConFirstName);}
//        if(!supConLastName.equals("null")){
//        etSupLastName.setText(supConLastName);}
//        if(!supConCompany.equals("null")){
//        etSupCompany.setText(supConCompany);}
//        if(!supConAddress.equals("null")){
//        etSupAddress.setText(supConAddress);}
//        if(!supConCity.equals("null")){
//        etSupCity.setText(supConCity);}
//        if(!supConProv.equals("null")){
//        etSupProv.setText(supConProv);}
//        if(!supConPostal.equals("null")){
//        etSupPostal.setText(supConPostal);}
//        if(!supConCountry.equals("null")){
//        etSupCountry.setText(supConCountry);}
//        if(!supConBusPhone.equals("null")){
//        etSupBusPhone.setText(supConBusPhone);}
//        if(!supConFax.equals("null")){
//        etSupFax.setText(supConFax);}
//        if(!supConEmail.equals("null")){
//        etSupEmail.setText(supConEmail);}
//        if(!supConURL.equals("null")){
//        etSupURL.setText(supConURL);}
//        if(!affiliationId.equals("null")){
//        etAffiliationId.setText(affiliationId);}



        btnSaveSupplier.setOnClickListener(new View.OnClickListener() {
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
                        "api_update_activitySecret",
                        DBHelper.apiURL() + "/api/supplier_update.php",
                        SupplierEditActivity.this);
                    Toast.makeText(SupplierEditActivity.this, "Changes Saved", Toast.LENGTH_LONG).show();
                    Intent savedIntent = new Intent(SupplierEditActivity.this, ProductListActivity.class);
                    //intent.putExtra("supplierContactId", etCustomerId.getText());
                    SupplierEditActivity.this.startActivity(savedIntent);
            }}
        });

        btnDeleteSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SupplierEditActivity.this)
                        .setTitle("Delete Supplier")
                        .setMessage("Are you sure you want to delete Supplier, " + etSupCompany.getText()  + "?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton)
                            {
                                SupplierDB.DeleteSupplier(etSupplierContactId.getText().toString(),
                                        "api_secretKey",
                                        DBHelper.apiURL() + "/api/supplier_delete.php",
                                        SupplierEditActivity.this);
                                Toast.makeText(SupplierEditActivity.this, "Supplier Deleted Successfully", Toast.LENGTH_LONG).show();
                                Intent savedIntent = new Intent(SupplierEditActivity.this, ProductListActivity.class);
                                SupplierEditActivity.this.startActivity(savedIntent);
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent savedIntent = new Intent(SupplierEditActivity.this, SupplierDetailActivity.class);
                SupplierEditActivity.this.startActivity(savedIntent);
            }
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
        if(!Validation.isValidAddressOrNull(address)){
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
        if(!Validation.isValidPostalOrNull(postal)){
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
