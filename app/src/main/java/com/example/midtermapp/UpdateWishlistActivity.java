package com.example.midtermapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateWishlistActivity extends AppCompatActivity {

    //Referred to geeksforgeeks to get this code.
    //https://www.geeksforgeeks.org/how-to-update-data-to-sqlite-database-in-android/
    //https://www.geeksforgeeks.org/how-to-delete-data-in-sqlite-database-in-android/

    // variables for our edit text, button, strings and dbhandler class.
    private EditText productNameEdt, brandNameEdt, priceEdt;
    private Button updateItemBtn, deleteItemBtn;
    private DBHandler dbHandler;
    String productName, brandName, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_wishlist);

        // initializing all our variables.
        productNameEdt = findViewById(R.id.edtProdName);
        brandNameEdt = findViewById(R.id.edtBrandName);
        priceEdt = findViewById(R.id.edtPrice);
        updateItemBtn = findViewById(R.id.btnUpdate);
        deleteItemBtn = findViewById(R.id.btnDelete);

        // on below line we are initializing our dbhandler class.
        dbHandler = new DBHandler(UpdateWishlistActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        productName = getIntent().getStringExtra("product");
        brandName = getIntent().getStringExtra("brand");
        price = getIntent().getStringExtra("price");

        // setting data to edit text
        // of our update activity.
        productNameEdt.setText(productName);
        brandNameEdt.setText(brandName);
        priceEdt.setText(price);

        // adding on click listener to our update course button.
        updateItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                dbHandler.updateItem(productName, productNameEdt.getText().toString(), brandNameEdt.getText().toString(), priceEdt.getText().toString());

                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateWishlistActivity.this, "Wishlist Item Updated.", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateWishlistActivity.this, ViewWishlist.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our course.
        deleteItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteItem(productName);
                Toast.makeText(UpdateWishlistActivity.this, "Deleted the item", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateWishlistActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //I cannot get the update and delete function to work currently, it works for the code we did in week three, but I guess
        //changing the variables around completely breaks it.

    }
}
