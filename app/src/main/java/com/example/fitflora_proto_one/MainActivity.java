package com.example.fitflora_proto_one;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fitflora_proto_one.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Your navigation setup code
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setOnItemSelectedListener(item -> {
            navController.popBackStack(navController.getGraph().getStartDestination(), false);
            Log.d("checking the item navigation","" +item.getItemId());
            navController.navigate(item.getItemId());
            return true;
        });


        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            // Get the ID of the current destination
            int id = destination.getId();

            // Check if the current fragment is the one where you want to hide the BottomNavigationView
            if (id == R.id.LoginFragment || id == R.id.SignupFragment) {  // Replace with your fragment's ID
                hideBottomNavigationView();
            } else {
                showBottomNavigationView();
            }
        });





    }

    public void showBottomNavigationView() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        if (navView != null) {
            navView.setVisibility(View.VISIBLE);
        }
    }

    public void hideBottomNavigationView() {
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Log.d("CHECK FOR NAV BAR","" + navView);
        if (navView != null) {
            navView.setVisibility(View.GONE);
        }
    }



}