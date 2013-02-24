package com.model.user;

import com.model.ServiceException;

public interface UserService {

    User login(String username, String password) throws ServiceException;
}
