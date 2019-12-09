package com.example.rxdaggersampleapplication.login;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;


    LoginActivityPresenter(LoginActivityMVP.Model model){
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if(view != null){
            if(view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")){
                view.showInputError();
            }
        } else {
            model.createUser(view.getFirstName(), view.getLastName());
            view.showUserSavedMessage();
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if(user == null){
            if(view != null){
                view.showUserNotAvaliable();
            }
        } else {
            if(view != null){
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}