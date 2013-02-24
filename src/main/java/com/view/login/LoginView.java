package com.view.login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public interface LoginView extends View {

    void setHandler(LoginViewHandler handler);
    void init();

    TextField getTxtUsername();

    TextField getTxtPassword();
    Button getBtnLogin();

    void afterSuccessfulLogin();
}
