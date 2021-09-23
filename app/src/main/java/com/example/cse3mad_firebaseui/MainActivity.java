package com.example.cse3mad_firebaseui;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private String TAG = "MAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check if we need to launch the AuthUI
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            // already signed in
            Log.d(TAG, user.getDisplayName() + " is already logged in");
            startApp();
        } else {
            // not signed in
            Log.d(TAG, "User not logged in starting signin");
            startSignIn();
        }
    }

    private ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            (result) -> {
                // Handle the FirebaseAuthUIAuthenticationResult
                IdpResponse response = result.getIdpResponse();
                if (result.getResultCode() == RESULT_OK) {
                    // Successfully signed in
                    FirebaseUser user = auth.getCurrentUser();
                    Log.d(TAG, "Logged in " + user.getDisplayName());
                    startApp();
                } else {
                    // Sign in failed. If response is null the user canceled the
                    // sign-in flow using the back button. Otherwise check
                    int errorCode = response.getError().getErrorCode();
                    String errorString =FirebaseUIErrorHelper.getErrorDefinition(errorCode);
                    Log.d(TAG, "Sign in fail Errorcode:  " + errorCode);
                    Toast.makeText(getApplicationContext(),"Sign in fail Errorcode: " + errorCode, Toast.LENGTH_SHORT).show();
                    startSignIn();
                }
            });

    private void startSignIn() {
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(Arrays.asList(
                        new AuthUI.IdpConfig.GoogleBuilder().build(),
                        new AuthUI.IdpConfig.EmailBuilder().build()))
                .setLogo(R.drawable.mylogo)
                .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                .build();
        signInLauncher.launch(signInIntent);
    }

    private void startApp()
    {
        //In this case we are opening another activity
        Intent intent = new Intent(this, LoggedIn.class);
        startActivity(intent);
    }
}