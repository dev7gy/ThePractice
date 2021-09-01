using System;
using System.Collections.Generic;
using System.Text;

namespace HashTable
{
    class HashMap
    {
        public int[] CostTable { get; private set; }
        public HashMap(int num)
        {
            CostTable = new int[num];
            // int[] mCostTable = new int[num];
        }

        public void Add(string key, int value)
        {
            CostTable[HashFunction(key)] = value;
        }
        public int GetValue(string key)
        {
            long keyIndex = HashFunction(key);
            if (keyIndex > -1 
                && keyIndex < CostTable.Length 
                && CostTable[keyIndex] > 0)
            {
                return CostTable[keyIndex];
            }
            return -1;
        }

        private long HashFunction(string str)
        {
            int tableLength = CostTable.Length;
            long key = 0;
            for (int i = 0; i < str.Length; ++i)
            {
                int temp = str[i];
                key += temp;
            }
            return key % tableLength;
        }
    }
}
