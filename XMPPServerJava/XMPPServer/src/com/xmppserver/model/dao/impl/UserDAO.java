package com.xmppserver.model.dao.impl;

import com.xmppserver.model.dao.DAOFactory;
import com.xmppserver.model.entities.User;
import com.xmppserver.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MarcusLSW on 14-Jul-17.
 */
public class UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAO.class.getName());

    private static final String GET_ALL_USERS = "select * from users";
    private static final String GET_USER_BY_EMAIL = "select * from users where email = ?";

    private UserRegDAO getUserRegDAO(){
        DAOFactory daoFactory = DAOFactory.getDAOFactory(1);
        return daoFactory.getUserReg();
    }

    public ArrayList<User> getAllUsers(){
        UserRegDAO userRegDAO = getUserRegDAO();

        ArrayList<User> userList = new ArrayList<>();
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_USERS)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String email = rs.getString(1);
                String name = rs.getString(2);
                int contactNum = rs.getInt(3);
                String regionCode = rs.getString(4);
                boolean isAdmin = rs.getBoolean(5);
                boolean isMale = rs.getBoolean(6);

                ArrayList<String> regIds = userRegDAO.getUserReg(email);

                userList.add(new User(email, name, contactNum, regionCode, isAdmin, isMale, regIds));
            }
            return userList;
        } catch (SQLException e) {
            logger.log(Level.INFO, e.getStackTrace().toString());
        }
        return null;
    }

    public HashMap<String,User> getAllUsersByEmail(){
        UserRegDAO userRegDAO = getUserRegDAO();
        HashMap<String , User> userMap = new HashMap<>();

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_USERS)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String email = rs.getString(1);
                String name = rs.getString(2);
                int contactNum = rs.getInt(3);
                String regionCode = rs.getString(4);
                boolean isAdmin = rs.getBoolean(5);
                boolean isMale = rs.getBoolean(6);

                ArrayList<String> regIds = userRegDAO.getUserReg(email);

                userMap.put(email , new User(email, name, contactNum,
                        regionCode, isAdmin, isMale, regIds));
            }
            return userMap;
        } catch (SQLException e) {
            logger.log(Level.INFO, e.getStackTrace().toString());
        }
        return null;
    }

    public User getUserByEmail (String email){
        if(email == null || email.isEmpty()) return null;

        UserRegDAO userRegDAO = getUserRegDAO();

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_USER_BY_EMAIL)) {
            stmt.setString(1 , email);

            ResultSet rs = stmt.executeQuery();

            rs.next();
            String name = rs.getString(2);
            int contactNum = rs.getInt(3);
            String regionCode = rs.getString(4);
            boolean isAdmin = rs.getBoolean(5);
            boolean isMale = rs.getBoolean(6);

            ArrayList<String> regIds = userRegDAO.getUserReg(email);

            return  new User(email, name, contactNum, regionCode, isAdmin, isMale, regIds);
        } catch (SQLException e) {
            logger.log(Level.INFO, e.getStackTrace().toString());
        }
        return null;
    }
}
