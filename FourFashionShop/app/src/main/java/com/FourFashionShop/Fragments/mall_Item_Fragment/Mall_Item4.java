package com.FourFashionShop.Fragments.mall_Item_Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.FourFashionShop.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mall_Item4#newInstance} factory method to
 * create an instance of this Fragments.
 */
public class Mall_Item4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the Fragments initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mall_Item4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this Fragments using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of Fragments Mall_Item1.
     */
    // TODO: Rename and change types and number of parameters
    public static Mall_Item4 newInstance(String param1, String param2) {
        Mall_Item4 fragment = new Mall_Item4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this Fragments
        return inflater.inflate(R.layout.fragment_mall__item4, container, false);
    }
}
