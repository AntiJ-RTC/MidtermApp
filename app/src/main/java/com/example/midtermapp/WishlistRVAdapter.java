package com.example.midtermapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WishlistRVAdapter extends RecyclerView.Adapter<WishlistRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<WishlistModal> wishlistModalArrayList;
    private Context context;

    // constructor
    public WishlistRVAdapter(ArrayList<WishlistModal> wishlistModalArrayList, Context context) {
        this.wishlistModalArrayList = wishlistModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        WishlistModal modal = wishlistModalArrayList.get(position);
        holder.productNameTV.setText(modal.getProductName());
        holder.brandNameTV.setText(modal.getBrandName());
        holder.priceTV.setText(modal.getPrice());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateWishlistActivity.class);

                // below we are passing all our values.
                i.putExtra("product", modal.getProductName());
                i.putExtra("brand", modal.getBrandName());
                i.putExtra("price", modal.getPrice());

                // starting our activity.
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return wishlistModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView productNameTV, brandNameTV, priceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            productNameTV = itemView.findViewById(R.id.tvProdName);
            brandNameTV = itemView.findViewById(R.id.tvBrandName);
            priceTV = itemView.findViewById(R.id.tvPrice);
        }
    }
}

