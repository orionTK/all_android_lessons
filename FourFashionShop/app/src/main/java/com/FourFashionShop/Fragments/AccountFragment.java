package com.FourFashionShop.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.FourFashionShop.R;
import com.FourFashionShop.Models.AccountModel;
import com.FourFashionShop.ui.FavoriteProductActivity;
import com.FourFashionShop.ui.OrdersManagementActivity;
import com.FourFashionShop.ui.ProductsPurchasedActivity;
import com.FourFashionShop.ui.SupportActivity;
import com.FourFashionShop.ui.UserInfoActivity;
import com.FourFashionShop.Adapters.AccountAdapter;

import java.util.ArrayList;
import java.util.List;


public class AccountFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private List<AccountModel> accountModels;
    private AccountAdapter accountAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar =  ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Cá nhân");

        accountModels = new ArrayList<>();
        accountModels.add(new AccountModel(R.drawable.ic_account_circle_black_24dp, "Quản lí thông tin cá nhân"));
        accountModels.add(new AccountModel(R.drawable.ic_receipt_black_24dp, "Quản lí đơn hàng"));
        accountModels.add(new AccountModel(R.drawable.ic_shopping_cart_black_24dp, "Sản phẩm đã mua"));
        accountModels.add(new AccountModel(R.drawable.ic_favorite_border_black_24dp, "Sản phẩm yêu thích"));
        accountModels.add(new AccountModel(R.drawable.ic_comment_black_24dp, "Nhận xét"));
        accountModels.add(new AccountModel(R.drawable.ic_headset_black_24dp, "Hỗ trợ"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_account, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewAccount);
        recyclerView.setHasFixedSize(true);

        accountAdapter = new AccountAdapter(accountModels, getContext());

        recyclerView.setAdapter(accountAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        //Toast.makeText(getContext(), "Recycle Click" + position, Toast.LENGTH_SHORT).show();
                        switch (position)
                        {
                            case 0:
                                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                Intent intent1 = new Intent(getActivity(), OrdersManagementActivity.class);
                                startActivity(intent1);
                                break;
                            case 2:
                                Intent intent2 = new Intent(getActivity(), ProductsPurchasedActivity.class);
                                startActivity(intent2);
                                break;
                            case 3:
                                Intent intent3 = new Intent(getActivity(), FavoriteProductActivity.class);
                                startActivity(intent3);
                                break;
                            case 4:
//                                Intent intent4 = new Intent(getActivity(), UserInfoActivity.class);
//                                startActivity(intent4);
                                break;
                            case 5:
                                Intent intent5 = new Intent(getActivity(), SupportActivity.class);
                                startActivity(intent5);
                                break;
                        }
                    }
                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        return view;
    }


}
