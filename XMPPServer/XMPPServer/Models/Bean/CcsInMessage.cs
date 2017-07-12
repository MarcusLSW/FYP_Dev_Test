using System.Collections.Generic;

namespace XMPPServer.Models.Bean
{
    /// <summary>
    /// Cloud Connection Server Provides endpoint that provides a 
    /// persistent, asynchronous, bidirectional connection to FCM.
    /// <para>This class handles incoming messages from FCM.</para>
    /// </summary>
    public class CcsInMessage
    {
        ///<summary>
        ///This stores senders Registration ID
        ///</summary>
        public string From { get; set; }

        ///<summary>
        ///Sender app's package
        ///</summary>
        public string Category { get; set; }

        ///<summary>
        ///Unique message ID
        ///</summary>
        public string MessageId { get; set; }

        ///<summary>
        ///The message body 
        ///<para>Storing JSON/XML in a Dictionary</para>
        ///</summary>
        public Dictionary<string , string> Message { get; set; }

        public CcsInMessage(string from , string category , string messageId, Dictionary<string , string> message)
        {
            From = from;
            Category = category;
            MessageId = messageId;
            Message = message;
        }
    }
}