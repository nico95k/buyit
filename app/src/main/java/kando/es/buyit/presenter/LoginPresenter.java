package kando.es.buyit.presenter;

import kando.es.buyit.interfaces.Login;
import kando.es.buyit.model.LoginModel;
import kando.es.buyit.view.LoginActivity;

/**
 * Created by nico95k on 16/07/2018.
 */

public class LoginPresenter implements Login.Presenter {

    Login.View view;
    Login.Model model;

    public LoginPresenter(Login.View view){
        this.view = view;
        model = new LoginModel(this,view.getActivity());
    }


    @Override
    public void loginValidation(String email, String pass) {
        if (!email.isEmpty() && !pass.isEmpty()){
            model.login(email, pass);
        }else{
            view.showErrors();
        }
    }

    @Override
    public void showSuccess() {
        view.showSuccess();
    }

    @Override
    public void showError() {
        view.showErrors();
    }
}
