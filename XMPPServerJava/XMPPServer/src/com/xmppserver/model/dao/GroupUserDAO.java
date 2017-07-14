package com.xmppserver.model.dao;

import com.xmppserver.util.QueryManager;
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
public class GroupUserDAO {

    private static final Logger logger = Logger.getLogger(GroupUserDAO.class.getName());

    private HashMap<String , ArrayList<String>> groupUser;
    private final String GET_USER_GROUP_LIST = " select * from group_user";


    public GroupUserDAO(){
        try{

            ResultSet rs = QueryManager.executeQuery(GET_USER_GROUP_LIST);
            while(rs.next()){
                String gid = rs.getString(1);
                String uid = rs.getString(2);

                ArrayList<String> memberList = groupUser.get(gid);
                if(memberList == null) memberList = new ArrayList<>();
                memberList.add(uid);
                groupUser.put(gid , memberList);
            }

        } catch (SQLException e) {
            logger.log(Level.INFO, e.getSQLState());
        }
    }

    public HashMap<String, ArrayList<String>> getAllGroupUser() {
        return groupUser;
    }

    // Returns null if group does not exist
    public ArrayList<String> getGroupUser(String groupId) {
        return groupId == null ? null : groupUser.get(groupId);
    }

}
