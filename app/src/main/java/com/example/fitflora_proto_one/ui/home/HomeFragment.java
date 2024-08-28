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
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private HomeAdapter adapter;
    private FragmentHomeBinding binding;
    private HomeViewModel mViewModel;
    private ImageView profile;
    private MapView mapView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        profile = root.findViewById(R.id.profileImageView);


        mapView = root.findViewById(R.id.unexpanded_map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                // Set the camera position and zoom level
                LatLng targetLocation = new LatLng(39.99956073432481, 116.32638515042089);
                float zoomLevel = 10.0f;

                // Move the camera to the specified location with the desired zoom level
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(targetLocation, zoomLevel));
                googleMap.addMarker(new MarkerOptions().position(targetLocation).title("Current Location"));
            }
        });


        // THIS IS JUST TO MAKE profile picture CIRCULAR!
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.profilepic);
        profile.setImageBitmap(circularbitmap.getcircularbitmap(bitmap));


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }



}