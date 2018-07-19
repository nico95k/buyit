package kando.es.buyit.interfaces;


import android.app.Activity;

/**
 * Created by nico95k on 16/07/2018.
 */

public interface Login {

    interface View{
        void showSuccess();
        void showErrors();
        Activity getActivity();
    }

    interface Presenter{
        void loginValidation(String email, String pass);
        void showSuccess();
        void showError();
    }

    interface Model{
        void login(String email, String pass);
    }

}
