package com.xmppserver.model.dao;

import com.xmppserver.model.entities.GroupChat;
import com.xmppserver.util.QueryManager;

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

    HashMap<String , GroupChat> groupMap;
    private final String GET_ALL_GROUP_CHATS = "select * from group_chats";

    public GroupChatDAO(){
        groupMap = new HashMap<>();
        try {

            ResultSet rs = QueryManager.executeQuery(GET_ALL_GROUP_CHATS);

            while(rs.next()){
                String groupId = rs.getString(1);
                String name = rs.getString(2);
                boolean isActive = rs.getBoolean(3);

                ArrayList<String> memberList = new GroupUserDAO().getGroupUser(groupId);

                groupMap.put(groupId , new GroupChat(memberList,name,isActive,groupId));
            }

        } catch (SQLException e) {
            logger.log(Level.INFO, e.getSQLState());
        }
    }

    public HashMap<String, GroupChat> getGroupMap() {
        return groupMap;
    }

    public GroupChat getGroupChat(String groupId){
        return groupId == null ? null : groupMap.get(groupId);
    }
}
