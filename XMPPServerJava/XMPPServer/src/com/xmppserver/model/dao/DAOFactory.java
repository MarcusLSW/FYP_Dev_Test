package com.xmppserver.model.dao;

import com.xmppserver.model.dao.impl.*;

/**
 * Created by Marcus on 16-Jul-17.
 */
public abstract class DAOFactory {
    public static final int MYSQL = 1;

    public abstract UserDAO getUserDAO();
    public abstract GroupChatDAO getGroupChatDAO();
    public abstract GroupUserDAO getGroupUserDAO();
    public abstract UserRegDAO getUserReg();

    public static DAOFactory getDAOFactory(int option){
        if (option == MYSQL) return new MysqlDAOFactory();
        return null;
    }
}
