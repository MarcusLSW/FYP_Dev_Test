package com.xmppserver.util;

import com.xmppserver.util.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MarcusLSW on 14-Jul-17.
 */
public class QueryManager {

    public static ResultSet executeQuery(String query) throws SQLException {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            return stmt.executeQuery();

        }
    }
}
