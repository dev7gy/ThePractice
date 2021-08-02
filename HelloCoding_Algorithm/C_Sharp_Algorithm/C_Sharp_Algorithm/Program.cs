using System;
using System.Collections.Generic;

namespace C_Sharp_Algorithm
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("### Chapter1 ###");

            Chapter1 chap1 = new Chapter1();
            int[] sortedArray = { 1, 2, 3, 4, 5 };
            int searchItem = 4;
            Console.WriteLine($"index: {chap1.BasicSearch(sortedArray, searchItem)}");
            Console.WriteLine($"index: {chap1.BinarySearch(sortedArray, searchItem)}");

            Console.WriteLine("### Chapter1 ###");

            Chapter2 chap2 = new Chapter2();
            List<int> array = chap2.createRandomValues(7, 10);
            foreach (var n in array)
            {
                Console.Write($"{n} ");
            }
            Console.WriteLine();
            List<int> sortedList = chap2.selectionSort(array);
            foreach (var n in sortedList)
            {
                Console.Write($"{n} ");
            }

        }
    }
}
