package com.xmppserver.util;

import com.xmppserver.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marcus on 16-Jul-17.
 */
public class Authenticate {

    public static boolean authenticate(String email , String password){
        try (Connection conn = ConnectionManager.getConnection(true);
             PreparedStatement stmt =
                     conn.prepareStatement("select count(email) from user_password where email = ? AND password = ?")) {

            ResultSet rs = stmt.executeQuery();
            return rs.getInt(1) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
