package com.presenter.login;

import com.model.ServiceException;
import com.model.user.UserService;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.view.login.LoginView;
import com.view.login.LoginViewHandler;

public class LoginPresenter implements LoginViewHandler {

    private LoginView view;
    private UserService service;

    public LoginPresenter(LoginView view, UserService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void login() {
        TextField txtUsername = view.getTxtUsername();
        TextField txtPassword = view.getTxtPassword();

        String username = txtUsername.getValue();
        String password = txtPassword.getValue();

        try {
            service.login(username, password);

            view.afterSuccessfulLogin();
        } catch (ServiceException e) {
            // TODO: log exception
            // TODO: notify view about failure
        }
    }
}
