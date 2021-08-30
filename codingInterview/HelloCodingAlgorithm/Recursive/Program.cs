using System;

namespace Recursive
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = { 5, 19, 8, 1 };
        }
        
        public static void countdown(int i)
        {
            if (i < 0)
            {
                return;
            }
            Console.WriteLine(i);
            countdown(i - 1);
        }

        public static int factorial(int n)
        {
            if (n <= 1)
            {
                return 1;
            }
            else
            {
                return n * factorial(n - 1);
            }
        }
        
    }
}
