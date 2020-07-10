package com.FourFashionShop.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.FourFashionShop.R;
import com.FourFashionShop.ui.BeforeOrderActivity;
import com.FourFashionShop.Models.CartModel;
import com.FourFashionShop.adapter.CartAdapter;
import com.FourFashionShop.Models.CartModel;
import com.FourFashionShop.adapter.CartAdapter;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
    public static int tongTien = 0;
    private View view;
    private RecyclerView recyclerView;
    public static List<CartModel> cartModels;
    private CartAdapter cartAdapter;
    private ImageButton imgBtnCloseCart, imgBtnAddPro, imgBtnRemovePro;
    private ActionBar actionBar;
    public TextView txtName, txtTotalPrice, txtSoLuong;
    public Button btnOrder;

    //dialog
    private Dialog dialog;

    public CartFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar =  ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        cartModels = new ArrayList<>();
        cartModels.add(new CartModel("Quần đùi", 200000, R.drawable.tra, 2));
        cartModels.add(new CartModel("Quần thun", 200000, R.drawable.tra, 3));
        cartModels.add(new CartModel("Quần tay", 200000, R.drawable.tra, 2));
        cartModels.add(new CartModel("Áo khoác", 200000, R.drawable.tra, 3));
        cartModels.add(new CartModel("Áo jean", 200000, R.drawable.tra, 4));
        cartModels.add(new CartModel("Áo sơ mi", 200000, R.drawable.tra, 1));


        actionBar.setTitle("Giỏ hàng(" + cartModels.size() + ")");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this Fragments
        //return inflater.inflate(R.layout.fragment_cart, container, false);



        view = inflater.inflate(R.layout.fragment_cart, container, false);
        imgBtnAddPro = (ImageButton) view.findViewById(R.id.imgBtnAddPro);
        imgBtnRemovePro = (ImageButton) view.findViewById(R.id.imgBtnRemovePro);
        imgBtnCloseCart = (ImageButton) view.findViewById(R.id.imgBtnCloseCart);
        txtSoLuong = (TextView) view.findViewById(R.id.txtSoLuong);
        txtName = (TextView) view.findViewById(R.id.txtName);
        txtTotalPrice = (TextView) view.findViewById(R.id.txtTongTien);

        cartAdapter = new CartAdapter(cartModels, getContext());
        recyclerView = view.findViewById(R.id.recycler_product);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(cartAdapter);

        btnOrder = (Button) view.findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ordered = new Intent(getActivity(), BeforeOrderActivity.class);
                startActivity(ordered);
            }
        });

        buildRecyclerView();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TongTien();
        return view;
    }

    public void removeItem(int position) {
        cartModels.remove(position);
        cartAdapter.notifyItemRemoved(position);
        Toast toast = Toast.makeText(getContext(), "Bạn vừa xóa một sản phẩm!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        TongTien();
    }



    public void addNumber(int position) {
        int num = Integer.valueOf(cartModels.get(position).getTxtSoLuong());
        num++;
        cartModels.get(position).setTxtSoLuong(num);
        cartAdapter.notifyItemChanged(position);
        TongTien();
    }

    public void removeNumber(int position) {
        int num = Integer.valueOf(cartModels.get(position).getTxtSoLuong());
        num--;
        if (num == 0){
            removeItem(position);
            cartAdapter.notifyItemRemoved(position);
        }
        else{
            cartModels.get(position).setTxtSoLuong(num);
            cartAdapter.notifyItemChanged(position);
        }

        TongTien();
    }

    public void buildRecyclerView() {



        cartAdapter.setOnIteamClickListener(new CartAdapter.OnItemCartClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDeleteClick(int position) {

                removeItem(position);
                NoficationCart();



            }

            @Override
            public void onAddNumberClick(int position) {
                addNumber(position);
            }

            @Override
            public void onRemoveNumberClick(int position) {
                removeNumber(position);
                NoficationCart();
            }


        });

    }

    public void NoficationCart() {
        if (cartModels.size() == 0) {
            Toast toast = Toast.makeText(getContext(), "Giỏ hàng trống!", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            actionBar.setTitle("Giỏ hàng(" + cartModels.size() + ")");
        }
        else {
            actionBar.setTitle("Giỏ hàng(" + cartModels.size() + ")");
        }
    }

    //Tổng tiền
    public void TongTien() {
        tongTien = 0;
        for (int k = 0; k < cartModels.size(); k++) {
            tongTien += cartModels.get(k).getTxtSoLuong() * cartModels.get(k).getTotalPrice();
        }
        txtTotalPrice.setText(String.valueOf(tongTien) + " đ");
    }

}
