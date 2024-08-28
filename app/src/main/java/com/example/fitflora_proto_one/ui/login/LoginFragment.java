package com.example.fitflora_proto_one.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitflora_proto_one.databinding.FragmentLoginBinding;
import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.ui.signup.SignupViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel mViewModel;
    private TextView SignUpText ;

    private Button LoginButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SignUpText = root.findViewById(R.id.signup_text);
        LoginButton = root.findViewById(R.id.login_button);

        String text = "Need an Account? Sign Up";
        int startIndex = text.indexOf("Sign Up");
        int endIndex = startIndex + "Sign Up".length();

        SpannableString spannableString = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle click event
                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                NavController navController = Navigation.findNavController(widget);
                navController.navigate(R.id.action_Login_to_Signup);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false); // Optionally remove underline
            }
        };

        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        SignUpText.setText(spannableString);
        SignUpText.setMovementMethod(LinkMovementMethod.getInstance());
        SignUpText.setHighlightColor(Color.TRANSPARENT); // Optional: to remove the highlight color

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: logic for validation and verification
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_Login_to_Home);
            }
        });



        root.findViewById(R.id.login_button).setOnClickListener(v -> {
            String email = ((EditText) root.findViewById(R.id.username)).getText().toString();
            String password = ((EditText) root.findViewById(R.id.password)).getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(getContext(), "Please enter email and password", Toast.LENGTH_SHORT).show();
            } else {
                mViewModel.login(email, password);
            }
        });
        observeViewModel(root);
        return root;
    }

    private void observeViewModel(View view) {
        mViewModel.getUserLiveData().observe(getViewLifecycleOwner(), firebaseUser -> {
            if (firebaseUser != null) {
                // Navigate to another fragment or activity on successful login
                NavHostFragment.findNavController(this).navigate(R.id.action_Login_to_Home);
            }
        });

        mViewModel.getError().observe(getViewLifecycleOwner(), error -> {
            if (error != null) {
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
            }
        });

        mViewModel.getloading().observe(getViewLifecycleOwner(), isLoading -> {
            // Show or hide a progress bar
            view.findViewById(R.id.progress_bar).setVisibility(isLoading ? View.VISIBLE : View.GONE);
        });
    }
}