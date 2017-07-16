package com.xmppserver.model.dao.impl;

import com.xmppserver.model.entities.GroupChat;
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
public class GroupChatDAO {

    //Setting up the logger
    private static final Logger logger = Logger.getLogger(GroupChatDAO.class.getName());

    private final String GET_ALL_GROUP_CHATS = "select * from group_chats";
    private final String GET_GROUP_CHAT_BY_GROUP_ID = "select groupName, isActive from group_chats where groupId = ?";

    public HashMap<String , GroupChat> getAllGroupChatByGroupId(){
        HashMap<String , GroupChat> groupMap = new HashMap<>();
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_ALL_GROUP_CHATS)){

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String groupId = rs.getString(1);
                String name = rs.getString(2);
                boolean isActive = rs.getBoolean(3);

                ArrayList<String> memberList = new GroupUserDAO().getGroupUser(groupId);

                groupMap.put(groupId , new GroupChat(memberList,name,isActive,groupId));
            }

        } catch (SQLException e) {
            logger.log(Level.INFO, e.getStackTrace().toString());
        }
        return null;
    }

    public GroupChat getGroupChat(String groupId){
        if (groupId == null || groupId.isEmpty()) return null;

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_GROUP_CHAT_BY_GROUP_ID)) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String name = rs.getString(2);
                boolean isActive = rs.getBoolean(3);

                ArrayList<String> memberList = new GroupUserDAO().getGroupUser(groupId);

                return new GroupChat(memberList,name,isActive,groupId);
            }
        } catch (SQLException e) {
            logger.log(Level.INFO, e.getStackTrace().toString());
        }
        return null;
    }
}
