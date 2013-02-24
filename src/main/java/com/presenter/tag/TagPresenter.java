package com.presenter.tag;

import com.model.ServiceException;
import com.model.tag.Tag;
import com.model.tag.TagService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.view.tag.TagView;
import com.view.tag.TagViewHandler;

import java.util.List;

public class TagPresenter implements TagViewHandler {

    private TagView tagView;
    private TagService tagService;

    public TagPresenter(TagView tagView, TagService tagService) {
        this.tagView = tagView;
        this.tagService = tagService;
    }

    @Override
    public void addTag() {
        TextField txtTagName = tagView.getNewTagLayout().getTxtTagName();
        String value = txtTagName.getValue();

        try {
            Tag tag = new Tag(value);
            tagService.save(tag);
            tagView.getNewTagLayout().afterSuccessfulSave();

            showTagList();
        } catch (ServiceException e) {
            // TODO: log the exception
            // TODO: notify view about failure
        }
    }

    @Override
    public void showTagList() {
        try {
            List<Tag> tags = tagService.findAll();
            tagView.getTagListLayout().afterSuccessfulFetch(tags);
        } catch (ServiceException e) {
            // TODO: log the exception
            // TODO: notify view about failure
        }
    }
}
