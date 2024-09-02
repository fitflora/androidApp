package com.example.fitflora_proto_one.ui.camera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.ui.timerwidget.TimerFragment;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.List;

public class CameraFragment extends Fragment {

    private CompoundBarcodeView barcodeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        barcodeView = view.findViewById(R.id.barcode_scanner);
        barcodeView.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                if(result.getText() != null) {
                    handleQRCode(result.getText(), view);
                }
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        barcodeView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        barcodeView.pause();
    }

    private void handleQRCode(String qrText, View view) {
        // Show a toast message with the scanned QR code
        Toast.makeText(getActivity(), "QR Code Detected: " + qrText, Toast.LENGTH_LONG).show();

        // Enable and start the TimerFragment
        enableAndStartTimerFragment();

        // Navigate to PlantFragment and pass the QR code data
        Bundle bundle = new Bundle();
        bundle.putString("qrData", qrText);

        // Navigate using the correct NavController
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.action_Camera_to_Plant, bundle);
    }




    private void enableAndStartTimerFragment() {
        // Make the timer_frame visible
        View timerFrame = requireActivity().findViewById(R.id.timer_frame);
        if (timerFrame != null) {
            timerFrame.setVisibility(View.VISIBLE);
        }

        // Replace the fragment inside timer_frame
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        TimerFragment timerFragment = new TimerFragment();

        // Add or replace the TimerFragment inside the timer_frame
        fragmentTransaction.replace(R.id.timer_frame, timerFragment);
        fragmentTransaction.commit();
    }
}