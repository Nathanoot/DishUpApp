package com.infs.dishupapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infs.dishupapp.R;
import com.infs.dishupapp.activities.RecipeDetailActivity;
import com.infs.dishupapp.models.CategoryItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryItemViewHolder> {
    public List<CategoryItem> categoryToAdapt;


    public void setData(List<CategoryItem> categoryToAdapt) {
        this.categoryToAdapt = categoryToAdapt;

    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recipe, parent, false);
        CategoryItemViewHolder categoryItemViewHolder = new CategoryItemViewHolder(view);
        return categoryItemViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemViewHolder holder, int position) {
        final CategoryItem categoryItemAtPosition = categoryToAdapt.get(position);

        holder.nameTextView.setText(categoryItemAtPosition.getStrMeal());

        String imageUrl = categoryItemAtPosition.getStrMealThumb();
//        Picasso.get().load(imageUrl).into(imageView2);
        Picasso.get().load(imageUrl).into(holder.imageView2);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(context, RecipeDetailActivity.class);
                intent.putExtra("idMeal", categoryItemAtPosition.getIdMeal());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() { return categoryToAdapt.size(); }

    public static class CategoryItemViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView nameTextView;
        public ImageView imageView2;


        public CategoryItemViewHolder(View v) {
            super(v);
            view = v;
            nameTextView = v.findViewById(R.id.recipeName);
            imageView2 = v.findViewById(R.id.imageView2);

        }
    }

}