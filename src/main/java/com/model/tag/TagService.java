package com.model.tag;

import com.model.ServiceException;

import java.util.List;

public interface TagService {

    List<Tag> findAll() throws ServiceException;

    void save(Tag tag) throws ServiceException;
}
