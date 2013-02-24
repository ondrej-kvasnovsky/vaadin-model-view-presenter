package com.view.login.impl;

import com.view.login.LoginView;
import com.view.login.LoginViewHandler;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoginViewImplTest {

    private LoginView view;
    private LoginViewHandler handler;

    @Before
    public void setUp() {
        view = new LoginViewImpl();
        handler = mock(LoginViewHandler.class);
        view.setHandler(handler);
        view.init();
    }

    @Test
    public void isTagAddedAfterButtonIsClicked() {
        view.getBtnLogin().click();

        verify(handler, times(1)).login();
    }
}
