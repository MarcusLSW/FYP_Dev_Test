package com.xmppserver.model.dao.impl;

import com.xmppserver.model.entities.EmergencyContact;
import com.xmppserver.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MarcusLSW on 17-Jul-17.
 */
public class EmergencyContactDAO {
    private static final Logger logger = Logger.getLogger(EmergencyContactDAO.class.getName());

    private static final String GET_ALL_EMERGENCY_CONTACTS = "select * from emergency_contacts";


    public ArrayList<EmergencyContact> getAllEmergencyContacts(){
        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_ALL_EMERGENCY_CONTACTS)){

            ResultSet rs = stmt.executeQuery();
            ArrayList<EmergencyContact> emergencyContactList = new ArrayList<>();

            while(rs.next()){
                String name = rs.getString(1);
                int number = rs.getInt(2);
                String regionCode = rs.getString(3);
                double lat = rs.getDouble(4);
                double longi = rs.getDouble(5);

                EmergencyContact econ = new EmergencyContact(name,number,regionCode,lat,longi);

                emergencyContactList.add(econ);
            }
            return emergencyContactList;

        } catch (SQLException e) {
            logger.log(Level.INFO,e.getStackTrace().toString());
        }

        return null;
    }
}
