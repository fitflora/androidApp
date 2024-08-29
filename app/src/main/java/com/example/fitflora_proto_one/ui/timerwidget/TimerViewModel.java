package com.example.fitflora_proto_one.ui.timerwidget;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimerViewModel extends ViewModel {

    private final MutableLiveData<Long> timeElapsed = new MutableLiveData<>();
    private Handler handler = new Handler(Looper.getMainLooper());
    private long startTime;
    private boolean isRunning = false;

    public LiveData<Long> getTimeElapsed() {
        return timeElapsed;
    }

    public boolean isTimerRunning() {
        return isRunning;
    }

    public void startTimer() {
        if (isRunning) return;

        isRunning = true;
        startTime = System.currentTimeMillis();
        handler.post(timerRunnable);
    }

    public void stopTimer() {
        isRunning = false;
        handler.removeCallbacks(timerRunnable);
    }

    private final Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long elapsedMillis = System.currentTimeMillis() - startTime;
            timeElapsed.setValue(elapsedMillis);
            handler.postDelayed(this, 1000);
        }
    };
}