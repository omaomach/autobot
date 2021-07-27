package com.example.autobot1.activities.credentials.frags;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.autobot1.R;
import com.example.autobot1.activities.landing.MapActivity;
import com.example.autobot1.databinding.FragmentSignUpBinding;
import com.example.autobot1.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;


public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;
    private Animation animation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animation = AnimationUtils.loadAnimation(requireContext(), R.anim.explosion_animation);
        animation.setDuration(500);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.loginPageButton.setOnClickListener(loginFab -> {
            View animationView = binding.animationView;
            animationView.setVisibility(View.VISIBLE);
            animationView.setAnimation(animation);
            animation.start();
            NavHostFragment.findNavController(SignUpFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment);
        });
        binding.signUpButton.setOnClickListener(signUpBtn -> {
            String accountType;
            String name = Objects.requireNonNull(binding.nameInputEt.getText()).toString().trim();
            String email = Objects.requireNonNull(binding.emailInpuEt.getText()).toString().trim();
            String password = Objects.requireNonNull(binding.passwordInputEt.getText()).toString().trim();
            int selectedAccount = binding.radioGroup.getCheckedRadioButtonId();
            if (selectedAccount == R.id.mechanic_radio) {
                accountType = "Mechanic";
            } else {
                accountType = "Client";
            }
            if (name.isEmpty()) {
                binding.nameInputEt.setError("Cannot be empty");
            } else {
                if (email.isEmpty()) {
                    binding.emailInputLayout.setError("Cannot be empty");
                } else {
                    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                        binding.emailInputLayout.setError("Invalid email address");
                    } else {
                        if (password.isEmpty()) {
                            binding.passwordInputEt.setError("Cannot be empty");
                        } else {
                            if (password.length() < 8) {
                                binding.passwordInputEt.setError("Try 8 character password");
                            } else {
                                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(task -> {
                                            if (task.isSuccessful()) {
                                                addUserToDb(name, email, accountType);
                                            }
                                        });
                            }
                        }
                    }
                }
            }
        });
    }

    private void addUserToDb(String name, String email, String accountType) {
        User user = new User(name, email, accountType);
        FirebaseFirestore.getInstance().collection("users/" + accountType)
                .add(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        requireContext().startActivity(new Intent(requireContext(), MapActivity.class));
                    }
                }).addOnFailureListener(e -> Toast.makeText(requireContext(), "Something went wrong try again", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}