package com.example.rxdaggersampleapplication.login;

public interface LoginRepository {

    public User getUser();
    void saveUser(User user);
}
