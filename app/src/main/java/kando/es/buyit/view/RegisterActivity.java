package kando.es.buyit.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import kando.es.buyit.R;
import kando.es.buyit.interfaces.Register;
import kando.es.buyit.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements Register.View {

    private Register.Presenter presenter;
    private EditText email;
    private EditText pass;
    private EditText passConf;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        presenter = new RegisterPresenter(this);

        email = findViewById(R.id.rgEmail);
        pass = findViewById(R.id.rgPass);
        passConf = findViewById(R.id.rgPassConf);
    }

    public void btnRegister(View view){
        presenter.registerValidation(
                email.getText().toString(),
                pass.getText().toString(),
                passConf.getText().toString()
        );
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this,"REGISTER SUCCESS",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this,"REGISTER ERROR",Toast.LENGTH_SHORT).show();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
