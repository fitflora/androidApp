package com.example.fitflora_proto_one.ui.plant;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitflora_proto_one.R;

public class PlantFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plant, container, false);

        // Set up your views here
        ImageView tomatoImage = view.findViewById(R.id.tomatoImage);
        TextView plantTitle = view.findViewById(R.id.plantTitle);
        TextView plantDescription = view.findViewById(R.id.plantDescription);
        // Set the values or add more code logic

        return view;
    }
}