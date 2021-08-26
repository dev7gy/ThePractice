using System;

namespace BinarySearch
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] sortedArray = { 1, 2, 3, 4, 5 };
            int searchItem = 4;
            Console.WriteLine($"index: {BasicSearch(sortedArray, searchItem)}");
            Console.WriteLine($"index: {BinarySearch(sortedArray, searchItem)}");
        }

        /*
         * log 에서 밑, 지수는 밑을 몇번 곱해야 지수가 될까? 라고 묻는것이다.
         */
        public static int BasicSearch(int[] sortedArray, int searchItem)
        {
            int index = -1;
            int count = 0;
            for (int i = 0; i < sortedArray.Length; ++i)
            {
                count++;
                if (sortedArray[i] == searchItem)
                {
                    index = i;
                    break;
                }
            }

            Console.WriteLine($"Basic Search Count: {count}");
            return index;
        }

        public static int BinarySearch(int[] sortedArray, int searchItem)
        {
            int low = 0;
            int high = sortedArray.Length - 1;


            int count = 0;
            int index = 0;
            while (count < sortedArray.Length) // while (low <= high)
            {
                count++;
                int mid = (low + high) / 2;
                if (sortedArray[mid] == searchItem)
                {
                    index = mid;
                    break;
                }
                else if (sortedArray[mid] > searchItem)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }

            }

            Console.WriteLine($"Binary Search Count: {count}");
            return index;
        }
    }
}
