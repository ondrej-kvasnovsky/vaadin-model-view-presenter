package com.view.tag.impl;

import com.view.tag.TagViewHandler;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class NewTagLayoutImplTest {

    private NewTagLayoutImpl layout;
    private TagViewHandler handler;

    @Before
    public void setUp() {
        layout = new NewTagLayoutImpl(handler);
        handler = mock(TagViewHandler.class);
    }

    @Test
    public void isTagAddedAfterButtonIsClicked() {
        layout.getBtnConfirm().click();

        verify(handler, times(1)).addTag();
    }
}
