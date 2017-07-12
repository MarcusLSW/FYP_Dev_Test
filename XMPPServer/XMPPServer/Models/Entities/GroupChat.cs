using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace XMPPServer.Models.Entities
{
    public class GroupChat
    {
        List<User> Members { get; set; }

        string GroupName { get; set; }

        bool IsActive { get; set; }

        public GroupChat (List<User> members , string groupName , bool isActive)
        {
            Members = members;
            GroupName = groupName;
            IsActive = isActive;
        }

        public void AddMember (User user)
        {
            Members.Add(user);
        }
    }
}