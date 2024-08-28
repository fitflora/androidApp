package com.example.fitflora_proto_one.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import dagger.hilt.android.lifecycle.HiltViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Inject;

@HiltViewModel
public class LoginViewModel extends ViewModel {
        private final FirebaseAuth firebaseAuth;

        private final MutableLiveData<FirebaseUser> userLiveData = new MutableLiveData<>();

        private final MutableLiveData<String> errorLiveData = new MutableLiveData<>();
        private final MutableLiveData<Boolean> loading = new MutableLiveData<>(false);

        @Inject
        public LoginViewModel(FirebaseAuth firebaseAuth) {
            this.firebaseAuth = firebaseAuth;
        }

        public void login(String email, String password) {
            loading.setValue(true);
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        loading.setValue(false);
                        if (task.isSuccessful()) {
                            userLiveData.setValue(firebaseAuth.getCurrentUser());
                        } else {
                            errorLiveData.setValue(task.getException().getMessage());
                        }
                    });
        }

        public FirebaseUser getCurrentUser() {
            return firebaseAuth.getCurrentUser();
        }

        public MutableLiveData<FirebaseUser> getUserLiveData() {
            return userLiveData;
        }

    public MutableLiveData<String> getError() {
        return errorLiveData;
    }

    public MutableLiveData<Boolean> getloading() {
        return loading;
    }



}