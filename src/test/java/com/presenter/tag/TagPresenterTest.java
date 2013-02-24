package com.presenter.tag;

import com.model.tag.Tag;
import com.model.tag.TagService;
import com.vaadin.ui.TextField;
import com.view.tag.NewTagLayout;
import com.view.tag.TagListLayout;
import com.view.tag.TagView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class TagPresenterTest {

    private TagPresenter tagPresenter;
    private TagService tagService;
    private TagView tagView;
    private NewTagLayout newTagLayout;
    private TagListLayout tagListLayout;

    @Before
    public void setUp() throws Exception {
        tagView = mock(TagView.class);
        newTagLayout = mock(NewTagLayout.class);
        when(tagView.getNewTagLayout()).thenReturn(newTagLayout);

        tagListLayout = mock(TagListLayout.class);
        when(tagView.getTagListLayout()).thenReturn(tagListLayout);

        tagService = mock(TagService.class);
        tagPresenter = new TagPresenter(tagView, tagService);
    }

    @Test
    public void isValidTagNameSaved() throws Exception {
        when(newTagLayout.getTxtTagName()).thenReturn(new TextField("new-tag"));

        tagPresenter.addTag();

        Mockito.verify(tagService, times(1)).save((Tag) any());
        Mockito.verify(newTagLayout, times(1)).afterSuccessfulSave();
    }

//    // TODO: uncomment the code and implement the feature described in the test
//    @Test
//    public void isEmptyInputIgnored() throws Exception {
//        when(newTagLayout.getTxtTagName()).thenReturn(new TextField(""));
//
//        tagPresenter.addTag();
//
//        Mockito.verify(tagService, times(0)).save((Tag) any());
//    }

    @Test
    public void areTagsFetchedFromService() throws Exception {
        tagPresenter.showTagList();

        Mockito.verify(tagService, times(1)).findAll();
        Mockito.verify(tagListLayout, times(1)).afterSuccessfulFetch((List<Tag>) any());
    }
}
