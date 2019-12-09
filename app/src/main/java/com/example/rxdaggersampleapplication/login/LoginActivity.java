package com.example.rxdaggersampleapplication.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rxdaggersampleapplication.R;
import com.example.rxdaggersampleapplication.root.App;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;

    private EditText firstNameET;
    private EditText lastNameET;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App)getApplication()).getComponent().inject(this);

        firstNameET = findViewById(R.id.editTextTextPersonName);
        lastNameET = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return firstNameET.getText().toString();
    }

    @Override
    public String getLastName() {
        return lastNameET.getText().toString();
    }

    @Override
    public void showUserNotAvaliable() {
        Toast.makeText(this, "Error the user is not avaliable", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "first name and last name can not be empty.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String fName) {
        firstNameET.setText(fName);
    }

    @Override
    public void setLastName(String lName) {
        lastNameET.setText(lName);
    }

    @Override
    public void showUserSavedMessage() {

    }
}
