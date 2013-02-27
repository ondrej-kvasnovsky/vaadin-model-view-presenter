package com.view.tag.impl;

import com.model.tag.Tag;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.view.tag.TagListLayout;
import com.view.tag.TagViewHandler;

import java.util.List;

public class TagListLayoutImpl extends HorizontalLayout implements TagListLayout {

    private ListSelect tagList;
    private TagViewHandler handler;

    @Override
    public void init() {
        setCaption("Tag list");
        setSpacing(true);
        setMargin(true);

        tagList = new ListSelect();
        tagList.setItemCaptionPropertyId("name");
        addComponent(tagList);

        handler.showTagList();
    }

    @Override
    public void setHandler(TagViewHandler handler) {
        this.handler = handler;
    }

    @Override
    public void afterSuccessfulFetch(List<Tag> tags) {
        tagList.setContainerDataSource(new BeanItemContainer<Tag>(Tag.class, tags));
    }
}
