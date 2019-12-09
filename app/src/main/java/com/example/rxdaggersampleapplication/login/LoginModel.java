package com.example.rxdaggersampleapplication.login;

public class LoginModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginModel(LoginRepository repository){
        this.repository = repository;
    }

    @Override
    public void createUser(String fName, String lName) {
        repository.saveUser(new User(fName, lName));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
