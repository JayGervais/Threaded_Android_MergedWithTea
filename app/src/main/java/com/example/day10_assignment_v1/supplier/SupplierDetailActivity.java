package com.example.day10_assignment_v1.supplier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.customer.Customer;
import com.example.day10_assignment_v1.customer.CustomerDetailActivity;
import com.example.day10_assignment_v1.customer.CustomerEditActivity;

public class SupplierDetailActivity extends AppCompatActivity {
TextView tvSupplierId,tvSupContactId,tvSupConCompany,tvSupConFirstName,tvSupConLastName,
    tvSupConAddress,tvSupConCity,tvSupConProv,tvSupConPostal,
    tvSupConCountry,tvSupConBusPhone,tvSupConFax,tvSupConEmail,
    tvSupConURL,tvAffiliationId;
Button btnUpdateSupplier;


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
        setContentView(R.layout.activity_supplier_detail);

        btnUpdateSupplier = (Button)findViewById(R.id.btnUpdateSup);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //tvSupplierId=findViewById(R.id.tvSupplierId);
       // tvSupContactId=findViewById(R.id.tvSupContactId);
        tvSupConCompany=findViewById(R.id.tvSupConCompany);
        tvSupConFirstName=findViewById(R.id.tvSupConFirstName);
        tvSupConLastName=findViewById(R.id.tvSupConLastName);
        tvSupConAddress=findViewById(R.id.tvSupConAddress);
        tvSupConCity=findViewById(R.id.tvSupConCity);
        tvSupConProv=findViewById(R.id.tvSupConProv);
        tvSupConPostal=findViewById(R.id.tvSupConPostal);
        tvSupConCountry=findViewById(R.id.tvSupConCountry);
        tvSupConBusPhone=findViewById(R.id.tvSupConBusPhone);
        tvSupConFax=findViewById(R.id.tvSupConFax);
        tvSupConEmail=findViewById(R.id.tvSupConEmail);
        tvSupConURL=findViewById(R.id.tvSupConURL);
        tvAffiliationId=findViewById(R.id.tvAffiliationId);

        btnUpdateSupplier=findViewById(R.id.btnUpdateSup);

        final Supplier supplierObj = getIntent().getParcelableExtra("supplier");


       // final Integer supplierId =supplierObj.getSupplierId();
        final Integer supplierContactId = supplierObj.getSupplierContactId();
        final String supConFirstName = supplierObj.getSupConFirstName();
        final String supConLastName = supplierObj.getSupConLastName();
        final String supConCompany = supplierObj.getSupConCompany();
        final String supConAddress = supplierObj.getSupConAddress();
        final String supConCity = supplierObj.getSupConCity();
        final String supConProv = supplierObj.getSupConProv();
        final String supConPostal  =supplierObj.getSupConPostal();
        final String supConCountry = supplierObj.getSupConCountry();
        final String supConBusPhone = supplierObj.getSupConBusPhone();
        final String supConFax = supplierObj.getSupConFax();
        final String supConEmail = supplierObj.getSupConEmail();
        final String supConURL = supplierObj.getSupConURL();
        final String affiliationId = supplierObj.getAffiliationId();


        //tvSupplierId.setText(supplierId);
       //tvSupContactId.setText(supContactId);
        tvSupConFirstName.setText(supConFirstName);
       tvSupConLastName.setText(supConLastName);
        tvSupConCompany.setText(supConCompany);
        tvSupConAddress.setText(supConAddress);
        tvSupConCity.setText(supConCity);
        tvSupConProv.setText(supConProv);
        tvSupConPostal.setText(supConPostal);
        tvSupConCountry.setText(supConCountry);
        tvSupConBusPhone.setText(supConBusPhone);
        tvSupConFax.setText(supConFax);
        tvSupConEmail.setText(supConEmail);
        tvSupConURL.setText(supConURL);
        tvAffiliationId.setText(affiliationId);


        btnUpdateSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupplierDetailActivity.this, SupplierEditActivity.class);
                //intent.putExtra("customerId",String.valueOf(customerId));
                intent.putExtra("supplierContactId", String.valueOf(supplierContactId));
                intent.putExtra("supConFirstName",supConFirstName);
                intent.putExtra("supConLastName",supConLastName);
                intent.putExtra("supConCompany",supConCompany);
                intent.putExtra("supConAddress",supConAddress);
                intent.putExtra("supConCity",supConCity);
                intent.putExtra("supConProv",supConProv);
                intent.putExtra("supConPostal",supConPostal);
                intent.putExtra("supConCountry",supConCountry);
                intent.putExtra("supConBusPhone",supConBusPhone);
                intent.putExtra("supConFax",supConFax);
                intent.putExtra("supConEmail",supConEmail);
                intent.putExtra("supConURL",supConURL);
                intent.putExtra("affiliationId",affiliationId);
                startActivity(intent);
            }
        });

    }
}
