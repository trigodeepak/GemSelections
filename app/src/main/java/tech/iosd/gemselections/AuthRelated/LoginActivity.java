package tech.iosd.gemselections.AuthRelated;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tech.iosd.gemselections.MainContent.MainActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.InternetConnectivity;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    private FirebaseAuth mAuth;
    private EditText _email, _password;
    private Button _login, _signup;
    private TextView _forgetPass;

    private String email, password;

    private ProgressDialog dialog;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        _email = (EditText) findViewById(R.id.email);
        _email.setOnFocusChangeListener(this);
        _password = (EditText) findViewById(R.id.pass);

        _login = (Button) findViewById(R.id.login_button);
        _login.setOnClickListener(this);
        _signup = (Button) findViewById(R.id.signup_button);
        _signup.setOnClickListener(this);

        _forgetPass = (TextView) findViewById(R.id.forget_pass);
        _forgetPass.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(SharedPreferencesUtils.prefsUserName, MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if (v == _login) {
            loginfunc();
        }

        if (v == _signup) {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        }

        if (v == _forgetPass) {
            try {
                _forgetPass.animate().translationY(8f).setDuration(300).start();
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            startActivity(new Intent(LoginActivity.this, ForgetPassActivity.class));
        }
    }

    private void loginfunc() {
        email = _email.getText().toString();
        password = _password.getText().toString();

        boolean login_ready = true;

        if (!isEmailValid(email)) {
            login_ready = false;
            _email.setError("Email address not correct");
        }
        if (!isPassValid(password)) {
            login_ready = false;
            _password.setError("Password length should be greater than 6 characters");
        }
        if (!InternetConnectivity.ISCONNECTED) {
            Toast toast = Toast.makeText(LoginActivity.this, "Internet Connection Not Available", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            login_ready = false;
        }

        if (login_ready) {
            dialog = new ProgressDialog(LoginActivity.this);
            dialog.setMessage("Please wait while we log you in....");
            dialog.show();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            dialog.dismiss();

                            if (!task.isSuccessful()) {
                                Snackbar.make(getCurrentFocus(), "Login Failed. Check Email/Password", Snackbar.LENGTH_LONG)
                                        .setAction("TRY AGAIN", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                loginfunc();
                                            }
                                        })
                                        .show();
                            } else {

                                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                                String name="";
                                String contact = "";

                                if (firebaseUser != null) {
                                    name = firebaseUser.getDisplayName();
                                    contact = firebaseUser.getPhoneNumber();

                                }
                                sharedPreferences.edit()
                                        .putBoolean(SharedPreferencesUtils.prefsLoggedIn, true)
                                        .putString(SharedPreferencesUtils.prefsUserName, name)
                                        .putString(SharedPreferencesUtils.prefsUserEmail, email)
                                        .putString(SharedPreferencesUtils.prefsUserNumber, contact)
                                        .apply();


                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            }
                        }
                    });

        } else {
            Toast.makeText(LoginActivity.this, "Check Login Credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmailValid(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private boolean isPassValid(String password) {
        return password.length() > 6;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            if (v == _email) {
                if (!isEmailValid(_email.getText().toString())) {
                    _email.setError("Email Address Not Valid");
                }
            }
        }
    }
}
