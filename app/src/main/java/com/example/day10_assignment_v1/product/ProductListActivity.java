package com.example.day10_assignment_v1.product;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.day10_assignment_v1.booking.BookingListActivity;
import com.example.day10_assignment_v1.customer.CustomerListActivity;

public class ProductListActivity extends AppCompatActivity  {
    ListView lvProduct, lvProdSup;
    Button btnNewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
//        Intent intent = new Intent(ProductListActivity.this,ProductSuppliersListActivity.class);
//        intent.putExtra(P)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lvProduct=findViewById(R.id.lvProduct);
        //lvProdSup=findViewById(R.id.lvProdSup);
        btnNewProduct=findViewById(R.id.btnNewProduct);



        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = getIntent();
                intent.putExtra("product", (Product) lvProduct.getItemAtPosition(position));
                startActivity(intent);
            }
        });

        btnNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addProductIntentn = new Intent(ProductListActivity.this, ProductNewActivity.class);
                startActivity(addProductIntentn);
               // ProductListActivity.this.startActivity(addProductIntentn);
            }
        });
        ProductDB.GetProductListData(DBHelper.apiURL()+"/api/product_data.php",this,lvProduct);

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
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;

    }
}
