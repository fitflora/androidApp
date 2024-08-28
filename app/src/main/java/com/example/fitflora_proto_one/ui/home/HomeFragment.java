package com.example.fitflora_proto_one.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.databinding.FragmentHomeBinding;

import com.example.fitflora_proto_one.utility.circularbitmap;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private HomeAdapter adapter;
    private FragmentHomeBinding binding;
    private HomeViewModel mViewModel;
    private ImageView profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        profile = root.findViewById(R.id.profileImageView);


        // THIS IS JUST TO MAKE profile picture CIRCULAR!
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.profilepic);
        profile.setImageBitmap(circularbitmap.getcircularbitmap(bitmap));

        adapter = new HomeAdapter(new ArrayList<>(), R.layout.tree_item );
        binding.recyclerViewTrees.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewTrees.setAdapter(adapter);


        return root;
    }



}