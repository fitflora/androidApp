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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.fitflora_proto_one.MainActivity;
import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.databinding.FragmentHomeBinding;

import com.example.fitflora_proto_one.utility.circularbitmap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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

    private ImageView expandbutton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        profile = root.findViewById(R.id.profileImageView);
        expandbutton = root.findViewById(R.id.expand_button);



        mapView = root.findViewById(R.id.unexpanded_map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng targetLocation = new LatLng(39.99956073432481, 116.32638515042089);
                float zoomLevel = 12.0f;
                LatLng Mudanyuan = new LatLng(40.001288533167994, 116.31981540696573);
                LatLng HeQingYuan = new LatLng(40.01403090836011, 116.32598072282485);
                LatLng BaJia = new LatLng(40.01698899165884, 116.3332977891097);
                LatLng DongShengBaJia = new LatLng(40.02094933575741, 116.34035736301917);

                LatLng Haidian1 = new LatLng(39.98587171724489, 116.29541007816289);
                LatLng Haidian2 = new LatLng(39.98812493524617, 116.29817443700992);
                LatLng YanNanYuan = new LatLng(39.98995268371175, 116.30870861829568);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(targetLocation, zoomLevel));
                googleMap.addMarker(new MarkerOptions().position(targetLocation).title("Current Location"));
                googleMap.addMarker(new MarkerOptions().position(Mudanyuan).title("Mudanyuan Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                googleMap.addMarker(new MarkerOptions().position(HeQingYuan).title("Ritan Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                googleMap.addMarker(new MarkerOptions().position(BaJia).title("BaJia Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                googleMap.addMarker(new MarkerOptions().position(DongShengBaJia).title("DongShengBaJia Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                googleMap.addMarker(new MarkerOptions().position(Haidian1).title("Haidian Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                googleMap.addMarker(new MarkerOptions().position(Haidian2).title("Haidian Tree 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                googleMap.addMarker(new MarkerOptions().position(YanNanYuan).title("YanNanYuan Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));


            }
        });


        // THIS IS JUST TO MAKE profile picture CIRCULAR!
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.profilepic);
        profile.setImageBitmap(circularbitmap.getcircularbitmap(bitmap));

        // domain expansion on google maps
        expandbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_Home_to_Map);
            }
        });



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