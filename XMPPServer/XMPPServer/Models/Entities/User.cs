using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace XMPPServer.Models.Entities
{
    public class User
    {

        public User(string email, int empId, string contact, string domain, bool isAdmin, bool isMale)
        {
            Email = email;
            EmpId = empId;
            Contact = contact;
            Domain = domain;
            IsAdmin = isAdmin;
            IsMale = isMale;
        }

        public string Email { get; set; }

        public int EmpId { get; set; }

        public string Contact { get; set; }

        public string Domain { get; set; }

        public bool IsAdmin { get; set; }

        public bool IsMale { get; set; }

        public override bool Equals( object obj )
        {
            if (obj == null) return false;

            if (obj.GetType().IsAssignableFrom(this.GetType()))
            {
                User otherUser = (User)obj;

                if (this.EmpId == otherUser.EmpId) return true;
            }

            return false;
        }

        public override int GetHashCode()
        {
            return EmpId;
        }
    }

    
}