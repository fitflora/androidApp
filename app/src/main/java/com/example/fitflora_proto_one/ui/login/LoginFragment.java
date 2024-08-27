package com.example.fitflora_proto_one.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitflora_proto_one.databinding.FragmentLoginBinding;
import com.example.fitflora_proto_one.R;
public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel mViewModel;
    private TextView SignUpText ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        SignUpText = root.findViewById(R.id.signup_text);

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

        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel

        return root;
    }
}