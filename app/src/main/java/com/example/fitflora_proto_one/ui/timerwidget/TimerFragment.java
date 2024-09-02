package com.example.fitflora_proto_one.ui.timerwidget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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


        timerViewModel = new ViewModelProvider(requireActivity()).get(TimerViewModel.class);
        timerViewModel.resetTimer();

        timerViewModel.getTimeElapsed().observe(getViewLifecycleOwner(), elapsedMillis -> {
            String formattedTime = String.format("%02d:%02d",
                    TimeUnit.MILLISECONDS.toMinutes(elapsedMillis) % 60,
                    TimeUnit.MILLISECONDS.toSeconds(elapsedMillis) % 60);
            timerTextView.setText(formattedTime);
        });

        if (!timerViewModel.isTimerRunning()) {
            timerViewModel.startTimer();
        }

        Button stopButton = view.findViewById(R.id.stopButton);
        stopButton.setOnClickListener(v -> {
            long elapsedTime = timerViewModel.getTimeElapsed().getValue(); // Get the elapsed time from the ViewModel
            stopAndHideTimer(v);

            Bundle bundle = new Bundle();
            bundle.putLong("time_elapsed", elapsedTime); // Put the elapsed time into the bundle

            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
            navController.navigate(R.id.action_Plant_to_Summary, bundle); // Pass the bundle as an argument
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        timerViewModel.stopTimer();
    }

    private void stopAndHideTimer(View v) {

        timerViewModel.stopTimer();
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            parentFragment.getChildFragmentManager().beginTransaction()
                    .remove(TimerFragment.this)
                    .commit();
        } else {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .remove(TimerFragment.this)
                    .commit();
        }


    }
}