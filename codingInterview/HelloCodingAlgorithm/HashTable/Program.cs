using System;

namespace HashTable
{
    class Program
    {
        static void Main(string[] args)
        {

            HashMap map = new HashMap(7);
            string obj = "apple";
            int cost = 100;
            map.Add(obj, cost);
            Console.WriteLine(map.GetValue(obj));
            Console.WriteLine(map.GetValue("pear"));
        }

        


    }
}
