package com.view.tag.impl;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.view.tag.NewTagLayout;
import com.view.tag.TagViewHandler;

public class NewTagLayoutImpl extends HorizontalLayout implements NewTagLayout {

    private TextField txtTagName;
    TagViewHandler handler;
    private Button btnConfirm;

    @Override
    public void setHandler(TagViewHandler handler) {
        this.handler = handler;
    }

    @Override
    public void init() {
        setCaption("New tag");
        setSpacing(true);
        setMargin(true);

        txtTagName = new TextField("Tag name:");
        addComponent(txtTagName);

        btnConfirm = new Button("Confirm");
        btnConfirm.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                handler.addTag();
            }
        });
        addComponent(btnConfirm);
    }

    public Button getBtnConfirm() {
        return btnConfirm;
    }

    public TextField getTxtTagName() {
        return txtTagName;
    }

    @Override
    public void afterSuccessfulSave() {
        txtTagName.setValue("");
        txtTagName.focus();
    }
}
