package kando.es.buyit.interfaces;

import android.app.Activity;

/**
 * Created by nico95k on 16/07/2018.
 */

public interface Register {

    interface View{
        void showSuccess();
        void showError();
        Activity getActivity();
    }

    interface Presenter{
        void registerValidation(String email, String pass, String passConf);
        void showSuccess();
        void showError();
    }

    interface Model{
        void register(String email, String pass, String passConf);
    }

}
