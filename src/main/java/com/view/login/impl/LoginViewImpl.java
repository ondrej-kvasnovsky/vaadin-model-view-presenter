package com.view.login.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.view.login.LoginView;
import com.view.login.LoginViewHandler;

public class LoginViewImpl extends VerticalLayout implements LoginView {

    private LoginViewHandler handler;

    private TextField txtUsername;
    private TextField txtPassword;

    private Button btnLogin;

    @Override
    public void setHandler(LoginViewHandler handler) {
        this.handler = handler;
    }

    @Override
    public void init() {
        txtUsername = new TextField("Username:");
        addComponent(txtUsername);
        txtPassword = new TextField("Password:");
        addComponent(txtPassword);

        btnLogin = new Button("Login");
        addComponent(btnLogin);
        btnLogin.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                handler.login();
            }
        });
    }

    @Override
    public TextField getTxtUsername() {
        return txtUsername;
    }

    @Override
    public TextField getTxtPassword() {
        return txtPassword;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }

    @Override
    public Button getBtnLogin() {
        return btnLogin;
    }

    @Override
    public void afterSuccessfulLogin() {
        UI.getCurrent().getNavigator().navigateTo("tags");
    }
}
