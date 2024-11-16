package com.example.midtermapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewWishlist extends AppCompatActivity {

    //code borrowed from https://www.geeksforgeeks.org/how-to-read-data-from-sqlite-database-in-android/

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<WishlistModal> wishlistModalArrayList;
    private DBHandler dbHandler;
    private WishlistRVAdapter wishlistRVAdapter;
    private RecyclerView wishlistRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_wishlist);

        // initializing our all variables.
        wishlistModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewWishlist.this);

        // getting our course array
        // list from db handler class.
        wishlistModalArrayList = dbHandler.readWishlist();

        // on below line passing our array list to our adapter class.
        wishlistRVAdapter = new WishlistRVAdapter(wishlistModalArrayList, ViewWishlist.this);
        wishlistRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewWishlist.this, RecyclerView.VERTICAL, false);
        wishlistRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        wishlistRV.setAdapter(wishlistRVAdapter);
    }
}
