using System;

namespace DivideAndConquer
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(EuclideanAlgorithm(1680, 640));
            int[] arr = { 1, 2, 3, 4 };
            Console.WriteLine(SumArray(arr));

            DFS(3);
        }
        public static int EuclideanAlgorithm(int x, int y)
        {
            if (x % y == 0)
            {
                return y;
            }
            
            return EuclideanAlgorithm(y, x % y);
        }

        public static int SumArray(int[] array)
        {
            if(array == null || array.Length < 1)
            {
                Console.Error.WriteLine("Check Array");
                return 0;
            }

            if(array.Length == 1)
            {
                return array[0];
            } else
            {

                return array[0] + SumArray(getSubArray(array, 1, array.Length - 1));
            }
        }

        private static int[] getSubArray(int[] original, int start, int end)
        {
            int[] newArray = new int[end - start + 1];
            for(int i = 0; i < newArray.Length; i++) 
            {
                newArray[i] = original[start + i];
            }
            return newArray;
        }

        public int[] QuickSort(int[] array)
        {
            int[] answer = new int[array.Length];
            return answer;
        }

        public static void DFS(int num)
        {
            int[] array = new int[11];
            HelperRecursive(1, num, array);
        }
        public static void HelperRecursive(int L, int num, int[] ch)
        {
            if (L == num + 1)
            {
                for (int i = 1; i <= num; i++)
                {
                    if(ch[i] == 1)
                    {
                        Console.Write($"{i} ");
                    }
                }
                Console.WriteLine();
            } 
            else
            {
                ch[L] = 1;
                HelperRecursive(L + 1, num, ch);
                ch[L] = 0;
                HelperRecursive(L + 1, num, ch);
            }

        }
    }
}
