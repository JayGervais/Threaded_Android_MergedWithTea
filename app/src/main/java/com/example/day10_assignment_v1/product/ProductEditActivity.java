package com.example.day10_assignment_v1.product;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day10_assignment_v1.DBHelper;
import com.example.day10_assignment_v1.R;


public class ProductEditActivity extends AppCompatActivity {


    EditText etProdName,etProductId;
    Button btnUpdateProd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etProdName=findViewById(R.id.etProdName);
        etProductId=findViewById(R.id.etProductId);

        Intent intent = getIntent();
        String productId = intent.getStringExtra("productId");
        String prodName = intent.getStringExtra("prodName");


        etProdName.setText(prodName);

        btnUpdateProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDB.UpdateProduct(etProductId.getText().toString(),
                        etProdName.getText().toString(),

                        "api_updateProduct_activitySecret",
                        DBHelper.apiURL() + "/api/product_update.php",
                        ProductEditActivity.this);
                Toast.makeText(ProductEditActivity.this, "Changes Saved", Toast.LENGTH_LONG).show();
                Intent savedIntent = new Intent(ProductEditActivity.this, ProductListActivity.class);
                ProductEditActivity.this.startActivity(savedIntent);
            }
        });



    }
}
