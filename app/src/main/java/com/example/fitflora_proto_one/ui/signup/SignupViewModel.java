package com.example.fitflora_proto_one.ui.signup;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fitflora_proto_one.data.model.SessionTree;
import com.example.fitflora_proto_one.data.model.Tree;
import com.example.fitflora_proto_one.data.model.User;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

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
                            // we will save user under User firestore
                            fetchCurrentLocationAndCreateUser(firebaseUser, email);
                        }
                    } else {
                        signUpError.setValue(task.getException().getMessage());
                    }
                });
    }

    private void fetchCurrentLocationAndCreateUser(FirebaseUser firebaseUser, String email) {
        try {
            fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
                String locationString = (location != null) ? location.getLatitude() + ", " + location.getLongitude() : "Location not available";
                createUserInFirestore(firebaseUser, email,locationString);
            });
        } catch (SecurityException e) {
            Log.e("SignupViewModel", "Location permission not granted: " + e.getMessage());
            signUpError.setValue("Location permission not granted");
        }
    }

    private void createUserInFirestore(FirebaseUser firebaseUser, String email,String location) {
        String userId = firebaseUser.getUid();
        User newUser = new User(null, userId, email, null, 1, 0, location);

        firestore.collection("users").document(userId).set(newUser)
                .addOnSuccessListener(aVoid -> {
                    currentUser.setValue(newUser);
                    isSignUpSuccessful.setValue(true);
                })
                .addOnFailureListener(e -> signUpError.setValue(e.getMessage()));
    }
}