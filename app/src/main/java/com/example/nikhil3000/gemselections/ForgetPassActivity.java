package com.example.nikhil3000.gemselections;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgetPassActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText _email;
    private Button _submit;

    private String email;

    private InternetConnectivity connectivity;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        mAuth = FirebaseAuth.getInstance();
        connectivity = new InternetConnectivity();

        _email = (EditText)findViewById(R.id._frgtEmail);
        _submit = (Button)findViewById(R.id._forgetButton);
        _submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==_submit){
            send_email();
        }
    }

    private void send_email() {
        email = _email.getText().toString();
        boolean ready = true;

        if(!isEmailValid(email)){
            ready = false;
            _email.setError("Email address not correct");
        }
        if(!connectivity.STATUS){
            Toast toast = Toast.makeText(ForgetPassActivity.this, "Internet Connection Not Available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            ready = false;
        }
        if(ready){
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(!task.isSuccessful()){
                                Toast toast = Toast.makeText(ForgetPassActivity.this, "Error Occurred! Please Try Again", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                            }else {
                                Toast toast = Toast.makeText(ForgetPassActivity.this, "Check your Email Inbox for reset link", Toast.LENGTH_LONG);
                                toast.setGravity(Gravity.CENTER,0,0);
                                toast.show();
                                startActivity(
                                        new Intent(ForgetPassActivity.this, LoginActivity.class)
                                );
                                finish();
                            }
                        }
                    });
        }
    }

    private boolean isEmailValid(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
