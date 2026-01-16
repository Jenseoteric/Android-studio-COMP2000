package com.example.androidRestaurantApp.ui.adapter;


import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidRestaurantApp.R;
import com.example.androidRestaurantApp.data.model.MenuItems;

import java.util.ArrayList;
import java.util.List;


//recyclerview adapter for converting MenuItems into rows.

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuVH> {

    private final List<MenuItems> items = new ArrayList<>();

    //refreshes the list
    public void setItems(List<MenuItems> newItems) {

        items.clear();

        if (newItems != null) items.addAll(newItems);

        notifyDataSetChanged();

    }

    @NonNull
    @Override

    public MenuVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_menu_item, parent, false);

        return new MenuVH(v);

    }

    @Override

    public void onBindViewHolder(@NonNull MenuVH holder, int position)
    {
        MenuItems item = items.get(position);

        //adjust fields to match my menuitems model later

        holder.textName.setText(item.getName());
        holder.textPrice.setText(String.valueOf(item.getPrice()));

        //placeholder image

        holder.img.setImageResource(android.R.drawable.ic_menu_gallery);
    }

    @Override

    public int getItemCount() {
        return items.size();
    }

    //viewholder caches view ref for each row, and avoids repeated findViewById
    static class MenuVH extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textName, textPrice;

        MenuVH(@NonNull View itemView)
        {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);
        }

    }

}