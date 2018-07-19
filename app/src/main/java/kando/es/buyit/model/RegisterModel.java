package kando.es.buyit.model;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

import kando.es.buyit.interfaces.Register;

import static android.content.ContentValues.TAG;

/**
 * Created by nico95k on 16/07/2018.
 */

public class RegisterModel implements Register.Model {

    private Register.Presenter presenter;
    private FirebaseAuth mAuth;
    private Activity activity;

    public RegisterModel(Register.Presenter presenter, Activity activity){
        this.presenter = presenter;
        this.activity = activity;

        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void register(String email, String pass, String passConf) {
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            presenter.showSuccess();
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            presenter.showSuccess();

                        }

                        // ...
                    }
                });
    }
}
