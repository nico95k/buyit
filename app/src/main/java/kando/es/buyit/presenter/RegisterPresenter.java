package kando.es.buyit.presenter;

import kando.es.buyit.interfaces.Register;
import kando.es.buyit.model.RegisterModel;

/**
 * Created by nico95k on 16/07/2018.
 */

public class RegisterPresenter implements Register.Presenter {

    private Register.View view;
    private Register.Model model;

    public RegisterPresenter(Register.View view){
        this.view = view;
        model = new RegisterModel(this,view.getActivity());
    }


    @Override
    public void registerValidation(String email, String pass, String passConf) {

        if (!email.isEmpty() && !pass.isEmpty() && !passConf.isEmpty()){
            model.register(email, pass, passConf);
        }else{
            view.showError();
        }

    }


    @Override
    public void showSuccess() {
        view.showSuccess();
    }

    @Override
    public void showError() {
        view.showError();
    }


}
