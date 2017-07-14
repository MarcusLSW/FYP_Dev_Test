package com.xmppserver.model.dao;


/**
 * Created by MarcusLSW on 14-Jul-17.
 */
public class DAOManager {
    private static GroupUserDAO groupUserDAO = new GroupUserDAO();
    private static GroupChatDAO groupChatDAO = new GroupChatDAO();
    private static UserDAO userDAO = new UserDAO();

    public static GroupUserDAO getGroupUserDAO() {
        return groupUserDAO;
    }

    public static GroupChatDAO getGroupChatDAO() {
        return groupChatDAO;
    }

    public static UserDAO getUserDAO() {
        return userDAO;
    }
}
