package com.xmppserver.servlets;

import com.xmppserver.model.dao.DAOFactory;
import com.xmppserver.model.dao.impl.GroupUserDAO;
import com.xmppserver.model.entities.GroupChat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marcus on 16-Jul-17.
 */
public class ChatGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private ArrayList<GroupChat> getGroupChats (String email) {
        GroupUserDAO groupUserDAO = DAOFactory.getDAOFactory(1).getGroupUserDAO();

        return null;
    }
}
