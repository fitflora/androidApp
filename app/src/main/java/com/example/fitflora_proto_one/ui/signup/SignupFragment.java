package com.example.fitflora_proto_one.ui.signup;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fitflora_proto_one.MainActivity;
import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.databinding.FragmentSignupBinding;
import com.example.fitflora_proto_one.ui.home.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SignupFragment extends Fragment {

    private EditText emailEditText, passwordEditText,cfmpasswordEditText;
    private Button signUpButton;
    private FragmentSignupBinding binding;
    private SignupViewModel mViewModel;
    private ImageButton goback;

    private BottomNavigationView bottomNavigationView;

    public static SignupFragment newInstance() {
        return new SignupFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private boolean validateInput(String email, String password, String cfmpassword) {
        if (email.isEmpty()) {
            emailEditText.setError("Email is required");
            return false;
        }
        if (password.isEmpty()) {
            passwordEditText.setError("Password is required");
            return false;
        }
        if (password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            return false;
        }

        if(!password.equals(cfmpassword)){

            passwordEditText.setError("Password and Confirm Password not the same");
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        mViewModel = new ViewModelProvider(this).get(SignupViewModel.class);
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ((MainActivity) getActivity()).hideBottomNavigationView();
        goback = root.findViewById(R.id.backButton);
        Log.d("PLEASE WORK", "ImageButton reference: " + goback);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_Signup_to_Login);
            }
        });

        emailEditText = root.findViewById(R.id.username);
        passwordEditText = root.findViewById(R.id.password);
        cfmpasswordEditText = root.findViewById(R.id.confirm_password);
        signUpButton = root.findViewById(R.id.signup_button);




        mViewModel.getIsSignUpSuccessful().observe(getViewLifecycleOwner(), isSuccess -> {
            if (isSuccess) {
                Toast.makeText(getContext(), "Sign-Up Successful!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(getView()).navigate(R.id.action_Signup_to_Home);
            }
        });

        mViewModel.getSignUpError().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(getContext(), "Error: " + error, Toast.LENGTH_SHORT).show();
            }
        });

        signUpButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String cfmpassword = cfmpasswordEditText.getText().toString().trim();

            if (validateInput(email, password,cfmpassword)) {
                mViewModel.signUpUser(email,password); // this will then set the issuccessful to be true or false.
            }
        });

        mViewModel.getloading().observe(getViewLifecycleOwner(), isLoading -> {
            root.findViewById(R.id.progress_bar).setVisibility(isLoading ? View.VISIBLE : View.GONE);
        });


        return root;
    }

}