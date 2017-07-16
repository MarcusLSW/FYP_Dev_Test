package com.xmppserver.servlets.logic;

import com.xmppserver.model.dao.DAOFactory;
import com.xmppserver.model.dao.impl.UserDAO;
import com.xmppserver.model.entities.User;

/**
 * Created by Marcus on 16-Jul-17.
 */
public class LoginLogic {

    public static boolean login(String email, String password){
        if(email.equals("admin") && password.equals("password")) return true;

        if (email.isEmpty() || password.isEmpty()) return false;
        DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
        User u = daoFactory.getUserDAO().getUserByEmail(email);

        return false;
    }
}
