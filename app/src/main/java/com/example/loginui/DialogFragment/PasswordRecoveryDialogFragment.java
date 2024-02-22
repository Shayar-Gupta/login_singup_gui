package com.example.loginui.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.loginui.R;

public class PasswordRecoveryDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_password_recovery, null);

        final EditText emailEditText = view.findViewById(R.id.emailEditText);
        final EditText otpEditText = view.findViewById(R.id.otpEditText);

        Button sendOtpButton = view.findViewById(R.id.sendOtpButton);
        sendOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                if (!email.isEmpty()) {
                    String otp = generateOTP();
                    sendOTPByEmail(email, otp);
                } else {
                    emailEditText.setError("Email cannot be empty");
                }
            }
        });

        builder.setView(view)
                .setTitle("Recover Password")
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email = emailEditText.getText().toString();
                        String otp = otpEditText.getText().toString();
                        if (!email.isEmpty() && !otp.isEmpty()) {
                            // Handle submission of email and OTP
                        } else {
                            if (email.isEmpty()) {
                                emailEditText.setError("Email cannot be empty");
                            }
                            if (otp.isEmpty()) {
                                otpEditText.setError("OTP cannot be empty");
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }

    private String generateOTP() {
        // Implement your OTP generation logic here
        return "123456"; // Dummy OTP for demonstration
    }

    private void sendOTPByEmail(String email, String otp) {
        // Implement your method to send OTP via email here
    }
}
