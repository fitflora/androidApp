package com.example.fitflora_proto_one.ui.timer_end;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.utility.circularbitmap;

import java.util.concurrent.TimeUnit;

public class SummaryFragment extends Fragment {

    private static final String ARG_TIME_ELAPSED = "time_elapsed";

    public static SummaryFragment newInstance(long timeElapsed) {
        SummaryFragment fragment = new SummaryFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_TIME_ELAPSED, timeElapsed);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);
        ImageView profile = view.findViewById(R.id.profileImageView);

        // THIS IS JUST TO MAKE profile picture CIRCULAR!
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.profilepic);
        profile.setImageBitmap(circularbitmap.getcircularbitmap(bitmap));
        TextView summaryTextView = view.findViewById(R.id.summaryTextView);

        if (getArguments() != null) {
            long timeElapsed = getArguments().getLong("time_elapsed"); // Retrieve the time_elapsed argument
            String formattedTime = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(timeElapsed) % 60,
                    TimeUnit.MILLISECONDS.toSeconds(timeElapsed) % 60);
            summaryTextView.setText("Timer ran for: " + formattedTime);
        }

        return view;
    }
}