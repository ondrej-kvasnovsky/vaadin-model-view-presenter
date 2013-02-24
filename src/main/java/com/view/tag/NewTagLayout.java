package com.view.tag;

import com.vaadin.ui.TextField;

public interface NewTagLayout extends TagLayout {

    public TextField getTxtTagName();

    void afterSuccessfulSave();
}
