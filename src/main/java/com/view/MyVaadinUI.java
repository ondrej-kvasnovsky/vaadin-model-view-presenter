package com.view;

import com.model.tag.TagServiceDummy;
import com.presenter.tag.TagPresenter;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
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

        navigator.addView("", view);
        setNavigator(navigator);
        navigator.navigateTo("");
    }
}
