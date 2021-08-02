using System;
using System.Collections.Generic;
using System.Text;

namespace C_Sharp_Algorithm
{
    class Chapter2
    {
        public List<int> createRandomValues(int length, int max)
        {
            Random random = new Random();
            List<int> randomValues = new List<int>();
            for (int i = 0; i < length; i++)
            {
                randomValues.Add(random.Next() % max);
            }
            return randomValues;
        }
        public List<int> selectionSort(List<int> array)
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
