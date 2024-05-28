package com.example.onser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.onser.Login_preference;
import com.example.onser.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StarterPage extends AppCompatActivity {

    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_page);

        mAuth = FirebaseAuthSingleton.getInstance(); // Using Singleton pattern for FirebaseAuth

        progressBar = findViewById(R.id.starterProgress);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                startApp();
            }
        });
        thread.start();
    }

    private void dowork() {
        for (int progress = 10; progress <= 100; progress += 50) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        Intent intent = IntentFactory.getIntent(this, firebaseUser); // Using Factory pattern for Intent creation
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

// Singleton pattern for FirebaseAuth
class FirebaseAuthSingleton {
    private static FirebaseAuth instance;

    private FirebaseAuthSingleton() {}

    public static synchronized FirebaseAuth getInstance() {
        if (instance == null) {
            instance = FirebaseAuth.getInstance();
        }
        return instance;
    }
}

// Factory pattern for Intent creation
class IntentFactory {
    public static Intent getIntent(Context context, FirebaseUser firebaseUser) {
        Intent intent;
        if (firebaseUser != null) {
            intent = new Intent(context, Login_preference.class);
        } else {
            intent = new Intent(context, MainActivity.class);
        }
        return intent;
    }
}
