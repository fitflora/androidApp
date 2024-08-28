package com.example.fitflora_proto_one.ui.signup;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitflora_proto_one.data.model.SessionTree;
import com.example.fitflora_proto_one.data.model.Tree;
import com.example.fitflora_proto_one.data.model.User;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Priority;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SignupViewModel extends ViewModel {

    private final FirebaseAuth firebaseAuth;
    private final FirebaseFirestore firestore;
    private final FusedLocationProviderClient fusedLocationClient;

    private final MutableLiveData<Boolean> isSignUpSuccessful = new MutableLiveData<>();
    private final MutableLiveData<String> signUpError = new MutableLiveData<>();
    private final MutableLiveData<User> currentUser = new MutableLiveData<>();

    private final MutableLiveData<Boolean> loading = new MutableLiveData<>(false);


    @Inject
    public SignupViewModel(FirebaseAuth firebaseAuth, FirebaseFirestore firestore, FusedLocationProviderClient fusedLocationClient) {
        this.firebaseAuth = firebaseAuth;
        this.firestore = firestore;
        this.fusedLocationClient = fusedLocationClient;
    }

    public LiveData<Boolean> getIsSignUpSuccessful() {
        return isSignUpSuccessful;
    }

    public LiveData<String> getSignUpError() {
        return signUpError;
    }


    public void signUpUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser firebaseUser = task.getResult().getUser();
                        if (firebaseUser != null) {
                            Log.d("RUNNING FIRESTORE", "firestore");
                            // we will save user under User firestore
                            createUserInFirestore(firebaseUser, email);
                        }
                    } else {
                        signUpError.setValue(task.getException().getMessage());
                    }
                });
    }


    private void createUserInFirestore(FirebaseUser firebaseUser, String email) {
        String userId = firebaseUser.getUid();
        User newUser = new User(null, userId, email, null, 1, 0, "39.99963449628127, 116.32632587903583");

        firestore.collection("users").document(userId).set(newUser)
                .addOnSuccessListener(aVoid -> {
                    currentUser.setValue(newUser);
                    isSignUpSuccessful.setValue(true);
                    loading.setValue(false);
                    Log.d("User Added", "User Added: " + newUser);

                })
                .addOnFailureListener(e -> signUpError.setValue(e.getMessage()));
    }

    public MutableLiveData<Boolean> getloading() {
        return loading;
    }
}