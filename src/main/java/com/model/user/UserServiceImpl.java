package com.model.user;

import com.model.ServiceException;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) throws ServiceException {
        return new User(username, password);
    }
}
