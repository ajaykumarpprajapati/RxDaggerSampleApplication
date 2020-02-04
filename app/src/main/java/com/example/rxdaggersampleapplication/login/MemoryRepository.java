package com.example.rxdaggersampleapplication.login;

public class MemoryRepository implements LoginRepository  {

    private User user;

    @Override
    public User getUser() {
        if(user == null){
            User user = new User("Lion", "Tiger");
            user.setId(0);
            this.user = user;
            return this.user;
        } else {
           return user;
        }
    }

    @Override
    public void saveUser(User user) {
        if(user == null){
            user = getUser();
        }
        this.user = user;
    }
}
