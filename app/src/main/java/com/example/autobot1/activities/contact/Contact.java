package com.example.autobot1.activities.contact;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.autobot1.activities.contact.data.EmailContent;
import com.example.autobot1.databinding.ActivityContactBinding;

public class Contact extends AppCompatActivity {
    private ActivityContactBinding binding;
    private String emailAddress;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        emailAddress = intent.getParcelableExtra("parcel").toString();
        phone = intent.getParcelableExtra("parcel").toString();
        binding.emailAddressEt.setText(emailAddress);
        binding.sendEmailBtn.setOnClickListener(v -> sendEmail());
        binding.callBtn.setOnClickListener(v -> call());
    }

    private void sendEmail() {
        String subject = binding.subjectEt.getText().toString();
        String description = binding.descriptionEt.getText().toString();
        emailAddress = binding.emailAddressEt.getText().toString();
        EmailContent emailContent = new EmailContent(emailAddress, subject, description);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra("content", emailContent);
        startActivity(intent);
    }
    private void call(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.putExtra("number",phone);
        startActivity(intent);
    }
}

