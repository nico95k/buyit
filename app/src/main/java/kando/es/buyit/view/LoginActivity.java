package kando.es.buyit.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kando.es.buyit.R;
import kando.es.buyit.interfaces.Login;
import kando.es.buyit.interfaces.Register;
import kando.es.buyit.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements Login.View {

    private Login.Presenter presenter;
    private EditText email;
    private EditText pass;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);

        email = findViewById(R.id.loginEmail);
        pass = findViewById(R.id.loginPass);
    }


    public void btnLogin(View view){
        presenter.loginValidation(email.getText().toString(),pass.getText().toString());
    }


    public void btnToRegister(View view){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this,"REGISTER SUCCESS",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrors() {
        Toast.makeText(this,"REGISTER FAIL",Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
