package kando.es.buyit.model;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import kando.es.buyit.interfaces.Login;

/**
 * Created by nico95k on 16/07/2018.
 */

public class LoginModel implements Login.Model {

    Login.Presenter presenter;
    private FirebaseAuth mAuth;
    private Activity activity;

    public LoginModel(Login.Presenter presenter, Activity activity){
        this.presenter = presenter;
        this.activity = activity;

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String email, String pass) {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            presenter.showSuccess();
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            presenter.showError();
                        }

                        // ...
                    }
                });
    }
}
