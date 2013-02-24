package com.view.tag;

import com.model.tag.Tag;

import java.util.List;

public interface TagListLayout extends TagLayout {

    void afterSuccessfulFetch(List<Tag> tags);
}
