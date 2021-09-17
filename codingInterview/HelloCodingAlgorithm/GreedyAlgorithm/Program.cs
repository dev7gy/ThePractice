using System;
using System.Collections.Generic;

namespace GreedyAlgorithm
{
    class Program
    {
        /**
         * Greedy
         * https://programmers.co.kr/learn/courses/30/lessons/42860?language=csharp
         * 
         */
        static void Main(string[] args)
        {
            solution("JAZ");
        }

        public static int solution(string name)
        {
            int length = name.Length;
            int answer = 0;
            int current = 0;
            HashSet<int> visits = new HashSet<int>();
            HashSet<int> notAIndex = new HashSet<int>();
            for (int i = 0; i < length; i++)
            {
                if (name[i] != 'A')
                {
                    notAIndex.Add(i);
                }
            }

            // 시작값 add
            visits.Add(current);
            int diff = getDiff(name[current]);
            answer += diff;
            // 방문한 곳은 제외
            notAIndex.Remove(current);

            while (notAIndex.Count > 0)
            {
                int distance = 1;
                int before = 0;
                while (true)
                {
                    int plusCurrent = current + distance;
                    plusCurrent %= length;
                    int minusCurrent = current - distance;
                    if (minusCurrent < 0)
                    {
                        minusCurrent += length;
                    }
                    if (notAIndex.Contains(plusCurrent))
                    {
                        before = current;
                        current = plusCurrent;
                        break;
                    } 
                    else if (notAIndex.Contains(minusCurrent))
                    {
                        before = current;
                        current = minusCurrent;
                        break;
                    } else
                    {
                        distance++;
                    }
                }

                if (!visits.Contains(current))
                {
                    answer += getDiff(name[current]);
                    answer += distance;
                    visits.Add(current);
                    notAIndex.Remove(current);
                }
            }
            return answer;
        }

        private static int getDiff(char ch)
        {
            int diff = ch - 'A';
            if (diff > 13)
            {
                diff = 26 - diff;
            }
            return diff;
        }
    }
}
