package com.view.tag.impl;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;
import com.view.tag.TagView;
import com.view.tag.TagViewHandler;

public class TagViewImpl extends VerticalLayout implements TagView {

    private NewTagLayoutImpl newTagLayout;
    private TagListLayoutImpl tagListLayout;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }

    @Override
    public NewTagLayoutImpl getNewTagLayout() {
        return newTagLayout;
    }

    @Override
    public TagListLayoutImpl getTagListLayout() {
        return tagListLayout;
    }

    @Override
    public void setHandler(TagViewHandler handler) {
        newTagLayout.setHandler(handler);
        tagListLayout.setHandler(handler);
    }

    @Override
    public void init() {
        setSpacing(true);
        setMargin(true);

        newTagLayout = new NewTagLayoutImpl();
        addComponent(newTagLayout);
        tagListLayout = new TagListLayoutImpl();
        addComponent(tagListLayout);
    }
}
