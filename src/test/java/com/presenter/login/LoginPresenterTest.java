package com.presenter.login;

import com.model.tag.Tag;
import com.model.tag.TagService;
import com.model.user.UserService;
import com.presenter.tag.TagPresenter;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.view.login.LoginView;
import com.view.tag.NewTagLayout;
import com.view.tag.TagListLayout;
import com.view.tag.TagView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class LoginPresenterTest {

    private LoginView view;
    private UserService service;
    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        view = mock(LoginView.class);

        service = mock(UserService.class);
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void isLoginWorking() throws Exception {
        when(view.getTxtUsername()).thenReturn(new TextField("Jimmy"));
        when(view.getTxtPassword()).thenReturn(new TextField("Jimmy123"));

        presenter.login();

        Mockito.verify(service, times(1)).login(anyString(), anyString());
        Mockito.verify(view, times(1)).afterSuccessfulLogin();
    }

}
