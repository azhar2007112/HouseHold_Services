package com.example.onser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

// Factory Method for creating ProgressDialog instances
class DialogFactory {
    public static ProgressDialog createProgressDialog(MainActivity activity, String title, String message) {
        ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setTitle(title);
        dialog.setMessage(message);
        return dialog;
    }
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView forgetpassword, reg;
    private EditText editemail, editpass;
    private Button login;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Singleton pattern: get the single instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();
        editemail = (EditText) findViewById(R.id.email);
        editpass = (EditText) findViewById(R.id.loginpass);

        reg = (TextView) findViewById(R.id.register);
        reg.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        forgetpassword = (TextView) findViewById(R.id.forgetpass);
        forgetpassword.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Exit OnSer");
        alert.setMessage("Do you want to exit?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
                finish();
                break;

            case R.id.login:
                userlogin();
                break;

            case R.id.forgetpass:
                startActivity(new Intent(MainActivity.this, ForgetPassword.class));
                finish();
                break;
        }
    }

    // Template Method Pattern: Refactored the sequence of operations
    private void userlogin() {
        ProgressDialog dialog = DialogFactory.createProgressDialog(this, "Loading", "Please Wait...");
        dialog.show();

        String loginemail = editemail.getText().toString().trim();
        String loginpass = editpass.getText().toString().trim();

        if (!validateInputs(loginemail, loginpass, dialog)) {
            return;
        }

        performLogin(loginemail, loginpass, dialog);
    }

    private boolean validateInputs(String email, String password, ProgressDialog dialog) {
        if (email.isEmpty()) {
            dialog.dismiss();
            editemail.setError("Email can't be empty");
            editemail.requestFocus();
            return false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            dialog.dismiss();
            editemail.setError("Enter valid email");
            editemail.requestFocus();
            return false;
        }
        if (password.isEmpty()) {
            dialog.dismiss();
            editpass.setError("Password can't be empty");
            editpass.requestFocus();
            return false;
        }
        if (password.length() < 6) {
            dialog.dismiss();
            editpass.setError("Password length should be greater than 6 char");
            editpass.requestFocus();
            return false;
        }
        return true;
    }

    private void performLogin(String email, String password, ProgressDialog dialog) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    try {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "LogIn Successful...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Login_preference.class));
                        finish();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "LogIn Failed! Try again...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
