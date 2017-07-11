using System;
using System.IO;
using System.Net;
using System.Text;
using RestSharp;

namespace AdminAccessService
{
    public class Services
    {
        private static string Authorization = "x7Y6fOCX25pSoFsm";
        private static string ContextType = "application/json";
        private string Ip;
        public Services(string ip)
        {
            Ip = ip;
        }

        public string CreateUser(string username, string password)
        {
            var client = new RestClient("http://"+ Ip +":9090/plugins/restapi/v1/users");
            var request = new RestRequest(Method.POST);
            request.AddHeader("authorization", "x7Y6fOCX25pSoFsm");
            request.AddHeader("content-type", "application/json");
            request.AddParameter("application/json", "{\n\t\"username\": \""+username+"\",\n    \"password\": \""+password+"\"\n}", ParameterType.RequestBody);
            var response = client.Execute(request);

            return response.ToString();
        }

        public string GetUser(string username)
        {
            var client = new RestClient("http://" + Ip + ":9090/plugins/restapi/v1/users/"+username);
            var request = new RestRequest(Method.GET);
            request.AddHeader("authorization", Authorization);
            request.AddHeader("Accept", ContextType);
            var response = client.Execute(request);
            return response.Content.ToString();
        }

        public class Req
        {
            public string username;
            public string password;
            public Req(string u , string p)
            {
                username = u;
                password = p;
            }
        }
    }
}
