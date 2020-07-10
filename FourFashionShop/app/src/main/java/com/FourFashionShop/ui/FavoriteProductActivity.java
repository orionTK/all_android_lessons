package com.FourFashionShop.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.FourFashionShop.Models.ProductModel;
import com.FourFashionShop.R;
import com.FourFashionShop.Adapters.FavoriteProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoriteProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ProductModel> productModelList;
    private FavoriteProductAdapter favoriteProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_product);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Sản phẩm yêu thích");

        initItem();

        recyclerView = findViewById(R.id.recyclerViewFavoriteProduct);
        favoriteProductAdapter = new FavoriteProductAdapter(productModelList, this);
        recyclerView.setAdapter(favoriteProductAdapter);
        buildRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void initItem(){
        productModelList = new ArrayList<>();
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
        productModelList.add(new ProductModel(R.drawable.tra, "Ao cute", "500000"));
    }

    public void removeItem(int position) {
        productModelList.remove(position);
        favoriteProductAdapter.notifyItemRemoved(position);
    }

    public void buildRecyclerView() {

        favoriteProductAdapter.setOnIteamClickListener(new FavoriteProductAdapter.OnItemFavoriteProductClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"Item: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
