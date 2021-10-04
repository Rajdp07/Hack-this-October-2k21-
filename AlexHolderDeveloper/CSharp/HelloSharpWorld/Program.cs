using System;

namespace HelloSharpWorld
{
    class Program
    {
        static string userName = Environment.UserName;
        static OperatingSystem osName = Environment.OSVersion;
        static void Main(string[] args)
        {
            Console.WriteLine($"Hello there, {userName}!");
            Console.WriteLine($"It looks like your operating system is {osName.Platform}");
            Console.Write("Press any key to close this window.");
            Console.ReadKey();
        }
    }
}
