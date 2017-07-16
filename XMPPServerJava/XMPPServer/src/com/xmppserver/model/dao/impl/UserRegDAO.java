package com.xmppserver.model.dao.impl;

import com.xmppserver.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Marcus on 16-Jul-17.
 */
public class UserRegDAO {
    private static final Logger logger = Logger.getLogger(UserRegDAO.class.getName());

    private static final String GET_ALL_USERS = "select * from users_reg";
    private static final String GET_USER_REG = "select regId from users_reg where email = ?";


    public ArrayList<String> getUserReg(String email){
        if (email == null || email.isEmpty()) return null;

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_USER_REG)){
            stmt.setString(1 , email);
            ResultSet rs = stmt.executeQuery();

            ArrayList<String> regList = new ArrayList<>();

            while(rs.next()){
                regList.add(rs.getString(1));
            }

            return regList;
        } catch (SQLException e) {
            logger.log(Level.INFO, e.getStackTrace().toString());
        }

        return null;
    }

}
