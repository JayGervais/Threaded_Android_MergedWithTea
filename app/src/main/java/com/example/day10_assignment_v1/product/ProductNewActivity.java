package com.example.day10_assignment_v1.product;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;
import com.example.day10_assignment_v1.Validation.Validation;
import com.example.day10_assignment_v1.customer.CustomerListActivity;
import com.example.day10_assignment_v1.customer.CustomerNewActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductNewActivity extends AppCompatActivity {
EditText etNewProdName;

Button btnSaveNewProd, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_new);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNewProdName=findViewById(R.id.etNewProdName);
        btnSaveNewProd=findViewById(R.id.btnSaveNewProd);
        btnCancel=findViewById(R.id.btnCancel);


        btnSaveNewProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String alpha= etNewProdName.getText().toString();
                if(!Validation.isValidAlpha(alpha)){
                    etNewProdName.setError("Must be alphabetic characters A-Z");
                }
                else
                {




                ProductDB.UpdateProduct(null,
                        etNewProdName.getText().toString(),
                        "sait_oosd_2019_updateSecret",
                        DBHelper.apiURL() + "/api/product_add.php",
                        ProductNewActivity.this);

                Toast.makeText(ProductNewActivity.this, "New Product Added", Toast.LENGTH_LONG).show();
                Intent savedIntent = new Intent(ProductNewActivity.this, ProductListActivity.class);
                ProductNewActivity.this.startActivity(savedIntent);
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent savedIntent = new Intent(ProductNewActivity.this, ProductListActivity.class);
                ProductNewActivity.this.startActivity(savedIntent);
            }
        });
    }



}
