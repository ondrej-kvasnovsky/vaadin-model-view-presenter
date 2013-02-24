package com.view;

import com.model.tag.TagServiceDummy;
import com.model.user.UserServiceImpl;
import com.presenter.login.LoginPresenter;
import com.presenter.tag.TagPresenter;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.view.login.LoginView;
import com.view.login.impl.LoginViewImpl;
import com.view.tag.impl.TagViewImpl;
import com.view.tag.TagView;

@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        TagView view = new TagViewImpl();
        view.init();

        TagPresenter handler = new TagPresenter(view, new TagServiceDummy());
        view.setHandler(handler);

        view.getNewTagLayout().init();
        view.getTagListLayout().init();

        navigator.addView("tags", view);

        LoginView loginView = new LoginViewImpl();
        LoginPresenter loginPresenter = new LoginPresenter(loginView, new UserServiceImpl());
        loginView.setHandler(loginPresenter);
        loginView.init();
        navigator.addView("", loginView);

        setNavigator(navigator);
        navigator.navigateTo("");
    }
}
