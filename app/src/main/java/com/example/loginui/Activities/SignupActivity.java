package com.example.loginui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.loginui.DialogFragment.PasswordRecoveryDialogFragment;
import com.example.loginui.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView recoverPasswordTextView = findViewById(R.id.textView4);
        recoverPasswordTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPasswordRecoveryDialog();
            }
        });

        ImageView imageView = findViewById(R.id.btnSignup);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open MainActivity
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showPasswordRecoveryDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        PasswordRecoveryDialogFragment dialogFragment = new PasswordRecoveryDialogFragment();
        dialogFragment.show(fragmentManager, "PasswordRecoveryDialogFragment");
    }
}
