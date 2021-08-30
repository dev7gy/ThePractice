﻿using System;

namespace DivideAndConquer
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(EuclideanAlgorithm(1680, 640));
            int[] arr = { 1, 2, 3, 4 };
            Console.WriteLine(SumArray(arr));
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

        /*
         * 분할 정복
         * pivot을 기준으로 하위 배열을 각각 따로 정렬
         */
        public static void QuickSort(int[] array)
        {
            quickSortRecursive(array, 0, array.Length - 1);
        }

        private static void quickSortRecursive(int[] array, int left, int right)
        {
            if (left >= right)
            {
                return;
            }

            // 실제 각 회차에 정렬을 수행하는 함수.
            int pivotIndex = partition(array, left, right);

            quickSortRecursive(array, left, pivotIndex - 1);
            quickSortRecursive(array, pivotIndex + 1, right);
        }

        private static int partition(int[] array, int left, int right)
        {
            /**
             * index:0, 1, 2, 3, 4
             * array[2, 5, 1, 3, 4]
             *       j ->  
             *       좌          우
             * pivot == 4
             * i == 좌 포인터
             */
            int pivot = array[right];
            int i = left;

            /*
             * 배열에서 pivot(제일 오른쪽)과 pivot 전까지의 원소들을 비교.
             * 
             * pivot보다 작을때만 교환하고 i를 오른쪽으로 증가시킨다. i가 가리키는 값과 j가 가리키는 값을 서로 교환함.
             * 배열에서 2는 4보다 작기 때문에 자기 자신을 교환하게 된다. swap(array, 0, 0);
             */
            for (int j = left; j < right; ++j)
            {
                // pivot보다 작을때, 클 때는 아무것도 하지 않음.
                if (array[j] < pivot)
                {
                    swap(array, i, j); // 교환하고 나면 i가 가리키는 값은 기준값보다 작은 값이 된다. 
                    i++;
                }
            }

            int pivotIndex = i;
            swap(array, pivotIndex, right);

            return pivotIndex;
        }

        private static void swap(int[] array, int index1, int index2)
        {
            int temp = array[index2];
            array[index2] = array[index1];
            array[index1] = temp;
        }
    }
}
