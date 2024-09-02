package com.example.fitflora_proto_one.ui.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitflora_proto_one.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng targetLocation = new LatLng(39.99956073432481, 116.32638515042089);
            LatLng Mudanyuan = new LatLng(40.001288533167994, 116.31981540696573);
            LatLng HeQingYuan = new LatLng(40.01403090836011, 116.32598072282485);
            LatLng BaJia = new LatLng(40.01698899165884, 116.3332977891097);
            LatLng DongShengBaJia = new LatLng(40.02094933575741, 116.34035736301917);

            LatLng Haidian1 = new LatLng(39.98587171724489, 116.29541007816289);
            LatLng Haidian2 = new LatLng(39.98812493524617, 116.29817443700992);
            LatLng YanNanYuan = new LatLng(39.98995268371175, 116.30870861829568);
            googleMap.addMarker(new MarkerOptions().position(targetLocation).title("Current Location"));

            float zoomLevel = 13.0f;
            googleMap.addMarker(new MarkerOptions().position(Mudanyuan).title("Mudanyuan Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            googleMap.addMarker(new MarkerOptions().position(HeQingYuan).title("Ritan Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            googleMap.addMarker(new MarkerOptions().position(BaJia).title("BaJia Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            googleMap.addMarker(new MarkerOptions().position(DongShengBaJia).title("DongShengBaJia Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            googleMap.addMarker(new MarkerOptions().position(Haidian1).title("Haidian Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            googleMap.addMarker(new MarkerOptions().position(Haidian2).title("Haidian Tree 2").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            googleMap.addMarker(new MarkerOptions().position(YanNanYuan).title("YanNanYuan Tree 1").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));



            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(targetLocation, zoomLevel));

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}