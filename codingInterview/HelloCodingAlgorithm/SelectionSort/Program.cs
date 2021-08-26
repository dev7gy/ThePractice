using System;
using System.Collections.Generic;

namespace SelectionSort
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("### Chapter2 ###");

            List<int> array = CreateRandomValues(7, 10);
            foreach (var n in array)
            {
                Console.Write($"{n} ");
            }
            Console.WriteLine();
            List<int> sortedList = SelectionSort(array);
            foreach (var n in sortedList)
            {
                Console.Write($"{n} ");
            }
        }
        public static List<int> CreateRandomValues(int length, int max)
        {
            Random random = new Random();
            List<int> randomValues = new List<int>();
            for (int i = 0; i < length; i++)
            {
                randomValues.Add(random.Next() % max);
            }
            return randomValues;
        }
        public static List<int> SelectionSort(List<int> array)
        {
            List<int> sortedArray = new List<int>();
            int startLength = array.Count;
            for (int i = 0; i < startLength; i++)
            {
                int minValue = array[0];
                for (int j = 0; j < array.Count; j++)
                {
                    if (minValue > array[j])
                    {
                        minValue = array[j];
                    }
                }
                sortedArray.Add(minValue);
                array.Remove(minValue);
            }
            return sortedArray;
        }
    }
}
