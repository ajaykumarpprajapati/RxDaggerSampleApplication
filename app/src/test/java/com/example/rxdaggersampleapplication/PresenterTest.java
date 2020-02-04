package com.example.rxdaggersampleapplication;

import com.example.rxdaggersampleapplication.login.LoginActivityMVP;
import com.example.rxdaggersampleapplication.login.LoginActivityPresenter;
import com.example.rxdaggersampleapplication.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterTest {
    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    LoginActivityPresenter presenter;
    User user;

    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User("Fox", "Holder");
        when(mockLoginModel.getUser()).thenReturn(user);
        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);
        presenter.setView(mockView);
    }

    @Test
    public void noInteractionWithView(){
        presenter.getCurrentUser();
        verifyZeroInteractions(mockView);
    }

    public void loadTheUserFromTheRepositoryWhenValidUserIsPresent(){

    }
}
