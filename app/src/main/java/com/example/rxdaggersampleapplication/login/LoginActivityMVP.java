package com.example.rxdaggersampleapplication.login;

public interface LoginActivityMVP {

    interface  View{
        String getFirstName();
        String getLastName();
        void showUserNotAvaliable();
        void showInputError();
        void setFirstName(String fName);
        void setLastName(String lName);

        void showUserSavedMessage();
    }

    interface  Presenter{
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }

    interface Model{
        void createUser(String fName, String lName);
        User getUser();

    }
}
