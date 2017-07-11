using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AdminAccessService;

namespace ConsoleApp1
{
    class App
    {
        static void Main()
        {
            Console.WriteLine("Enter IP Address");
            string ip = Console.ReadLine();
            
            Services service = new Services(ip);

            DisplayOptions();

            Console.WriteLine("Enter Option");
            int option = Int32.Parse(Console.ReadLine());

            if(option == 1)
            {
                AddUser(service);
            } else
            {
                QueryUser(service);
            }
        }

        private static void QueryUser(Services service)
        {
            Console.WriteLine("Enter username");
            string username = Console.ReadLine();

            Console.WriteLine(service.GetUser(username));
            Console.ReadLine();
        }

        private static void AddUser(Services service)
        {
            Console.WriteLine("Enter username");
            string username = Console.ReadLine();

            string password = "1";
            string password2 = "2";

            while (password != password2)
            {
                Console.WriteLine("Enter password");
                password = Console.ReadLine();

                Console.WriteLine("Enter re-enter password");
                password2 = Console.ReadLine();
            }

            string result = service.CreateUser(username, password);
            Console.WriteLine(result);
        }

        private static void DisplayOptions()
        {
            Console.WriteLine("1. Add User");
            Console.WriteLine("2. Query User ny Username");
        }
    }
}
