// https://programmers.co.kr/learn/courses/30/lessons/42860
using System;
using System.Collections.Generic;

// log N + log N^2 -> log N^2 
public class Solution {
    public int solution(string name)
    {
        int answer = 0;
        // 문자열 길이
        int length = name.Length;
        // 시작 index
        int current = 0;
        
        // str에서 A가 아닌 Index 저장
        HashSet<int> notAIndex = new HashSet<int>(); 
        for (int i = 1; i < length; i++) // 0번 index는 시작할때 계산할 것이기 때문에 1부터 A인지 아닌지 확인
        {
            if (name[i] != 'A')
            {
                notAIndex.Add(i);
            }
        }
        
        // 방문한 index 기록 set
        HashSet<int> visits = new HashSet<int>();
        // 0번 index 방문
        visits.Add(current);
        int diff = getDiff(name[current]);
        answer += diff;
        
        // str에서 A가 아닌 Index를 모두 방문했으면 종료
        while (notAIndex.Count > 0)
        {
            int distance = 1;
            int before = 0;
            while (true)
            {
                // distance 기준으로 우측 실제 index값
                int plusCurrent = current + distance;
                plusCurrent %= length;
                
                // distance 기준으로 좌측 실제 index값
                int minusCurrent = current - distance;
                if (minusCurrent < 0)
                {
                    minusCurrent += length;
                }
                
                // 우측이 가까운지, 좌측이 가까운지 판단, 양쪽에 다 존재하지 않으면 distance를 하나씩 증가
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
                } 
                else
                {
                    distance++;
                }
            }

            // 방문 목록에 현재 current가 존재하지 않으면 == 한번도 방문하지 않은 index라면 
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

    private int getDiff(char ch)
    {
        int diff = ch - 'A';
        if (diff > 13)
        {
            diff = 26 - diff;
        }
        return diff;
    }
}