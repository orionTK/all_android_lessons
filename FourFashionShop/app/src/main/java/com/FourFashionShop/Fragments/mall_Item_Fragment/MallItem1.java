package com.FourFashionShop.Fragments.mall_Item_Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.FourFashionShop.R;
import com.FourFashionShop.Adapters.MallAdapter;

import java.util.ArrayList;
import java.util.List;


public class MallItem1 extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private List<Item> items;


    public MallItem1() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mall__item1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_item1);
        MallAdapter adapter = new MallAdapter(getContext(), items);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new ArrayList<>();
        items.add(new Item("21312", "232131", "3", R.drawable.item2));
        items.add(new Item("abc", "232131", "4", R.drawable.item2));
        items.add(new Item("ád", "232131", "5", R.drawable.item2));
        items.add(new Item("sda", "232131", "36", R.drawable.item2));
        items.add(new Item("ád", "232131", "37", R.drawable.item2));
        items.add(new Item("sada", "232131", "83", R.drawable.item2));
        items.add(new Item("ádas", "232131", "93", R.drawable.item2));
        items.add(new Item("sadas", "232131", "30", R.drawable.item2));
        items.add(new Item("2131áaa2", "232131", "32", R.drawable.item2));

    }

}