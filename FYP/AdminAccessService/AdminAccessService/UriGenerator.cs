using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminAccessService
{
    public class URIGenerator
    {
        public static Uri GetURI()
        {
            Uri uri = new Uri("/plugins/restapi/v1/");
            return uri;
        }
    }
}
