package com.xmppserver.model.dao.impl;

import com.xmppserver.model.dao.DAOFactory;

/**
 * Created by Marcus on 16-Jul-17.
 */
public class MysqlDAOFactory extends DAOFactory{
    @Override
    public UserDAO getUserDAO() {
        return new UserDAO();
    }

    @Override
    public GroupChatDAO getGroupChatDAO() {
        return new GroupChatDAO();
    }

    @Override
    public GroupUserDAO getGroupUserDAO() {
        return new GroupUserDAO();
    }

    @Override
    public UserRegDAO getUserReg() {
        return new UserRegDAO();
    }
}
