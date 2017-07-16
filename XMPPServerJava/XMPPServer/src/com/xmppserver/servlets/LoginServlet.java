package com.xmppserver.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.xmppserver.servlets.logic.LoginLogic;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Marcus on 16-Jul-17.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        if (LoginLogic.login(email , password)){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonObject returnVal = new JsonObject();

            //TODO: Add in JWT token valiation and generation (note: might be handled by active directory)
            returnVal.addProperty("token" , "1234");
            out.println(gson.toJson(returnVal));
        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        // returns Error 501 not implemented
        response.setStatus(response.SC_NOT_IMPLEMENTED );
    }
}
