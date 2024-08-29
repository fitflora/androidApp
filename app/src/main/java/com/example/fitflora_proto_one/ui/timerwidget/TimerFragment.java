package com.example.fitflora_proto_one.ui.timerwidget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fitflora_proto_one.R;

import java.util.concurrent.TimeUnit;

public class TimerFragment extends Fragment {

    private TextView timerTextView;
    private TimerViewModel timerViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        timerTextView = view.findViewById(R.id.timerTextView);

        // Initialize ViewModel
        timerViewModel = new ViewModelProvider(requireActivity()).get(TimerViewModel.class);

        // Observe the timer LiveData to update the UI
        timerViewModel.getTimeElapsed().observe(getViewLifecycleOwner(), elapsedMillis -> {
            String formattedTime = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(elapsedMillis) % 60,
                    TimeUnit.MILLISECONDS.toSeconds(elapsedMillis) % 60);
            timerTextView.setText(formattedTime);
        });

        // Start the timer if it hasn't started already
        if (!timerViewModel.isTimerRunning()) {
            timerViewModel.startTimer();
        }

        Button stopButton = view.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(v -> {
            timerViewModel.stopTimer();
            // Optionally, remove the TimerFragment from the UI
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .remove(TimerFragment.this).commit();
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Optional: stop timer when the view is destroyed
        // timerViewModel.stopTimer();
    }
}