using System;
using System.Collections.Generic;

namespace DijkstraAlgorithm
{
    /*
     * 가중 그래프: 그래프의 간선에 가중치가 존재한다.
     * < 다익스트라 알고리즘 >
     * 1. 가장 가중치가 적게 드는 노드를 찾습니다.
     * 2. 이 정점의 이웃 노드들의 가중치를 조사합니다.
     * 3. 그래프 상의 모든 노드에 대해 이러한 일을 반복합니다.
     * 4. 최종 경로를 계산합니다.
     * 
     * 다익스트라 알고리즘은 사이클을 지나면 최단 거리를 구할 수 없다.
     */
    class Program
    {
        static void Main(string[] args)
        {
            Dictionary<string, string[]> graphVertex = new Dictionary<string, string[]>();
            /*
             * 정점 이웃 저장
             * you: [alice, bob, claire]
             */
            graphVertex.Add("you", new string[] { "alice", "bob", "claire" });

            /*
             * 간선 표현도 다른 해시 테이블을 사용
             * 
             * start: 
             * {
             *      A: 6,
             *      B: 2
             * },
             * A:
             * {
             *      fin: 1
             * }
             * B:
             * {
             *      A: 3,
             *      fin: 5
             * }
             * fin:
             * {
             * }
             */
            /*
             * 전체 그래프의 해시테이블
             */ 
            Dictionary<string, Dictionary<string, int>> graphAll = new Dictionary<string, Dictionary<string, int>>();
            Dictionary<string, int> startToVertex = new Dictionary<string, int>()
            {
                {"a", 6},
                {"b", 2}
            };
            graphAll.Add("start", startToVertex);
            Dictionary<string, int> aToVertex = new Dictionary<string, int>()
            {
                {"fin", 1}
            };
            graphAll.Add("a", aToVertex);

            Dictionary<string, int> bToVertex = new Dictionary<string, int>()
            {
                {"a", 3},
                {"fin", 5}
            };
            graphAll.Add("b", bToVertex);
            Dictionary<string, int> finToVertex = new Dictionary<string, int>() { };
            graphAll.Add("fin", finToVertex);
            /*
            var startNeighbor = graphAll["start"];
            foreach (var key in startNeighbor.Keys)
            {
                Console.WriteLine($"{key}:{startNeighbor.GetValueOrDefault(key)}");
            }
            */

            /*
             * 가격표
             */
            int infinity = int.MaxValue;
            Dictionary<string, int> costsMap = new Dictionary<string, int>()
            {
                {"a", 6 },
                {"b", 2 },
                {"fin", infinity }
            };

            /*
             * 부모 저장
             */
            Dictionary<string, string> parentsMap = new Dictionary<string, string>()
            {
                {"a", "start" },
                {"b", "start" },
                {"fin", null }
            };

            /*
             * 처리한 정점을 추적하기 위한 배열 
             */
            List<string> processed = new List<string>();
            Console.WriteLine("Before using DijkstraAlgorithm");
            foreach(string nodeName in costsMap.Keys)
            {
                Console.WriteLine($"{nodeName}: {costsMap[nodeName]}");
            }
            
            /* 
             * 정점 추척을 위한 배열
             * 1. 모든 정점을 처리할 때까지 반복한다.
             * 2. 출발점에서 가장 가까운 정점을 찾는다.
             * 3. 이웃 정점의 가격을 갱신한다.
             * 4. 만약 이웃 정점의 가격을 갱신하면 부모도 갱신한다.
             * 5. 해당 정점을 처리했다는 사실을 기록한다.
             * -> 반복
             */
            string node = findLowestCostNode(costsMap, processed); // 아직 처리하지 않은 가장 싼 정점을 찾는다.
            while (node != null) // 모든 정점을 처리하면 반복문 종료
            {
                int cost = costsMap[node];
                var neighbors = graphAll[node];
                foreach(var nodeName in neighbors.Keys) // 모든 이웃에 대해 반복
                {
                    int newCost = cost + neighbors[nodeName]; 
                    if (costsMap[nodeName] > newCost) // 해당 정점을 지나는 것이 가격이 더 싸다면
                    {
                        costsMap[nodeName] = newCost; // 정점 가격을 갱신한다.
                        parentsMap[nodeName] = node; // 부모를 이 정점으로 새로 설정한다.
                    }
                }
                processed.Add(node); // 정점을 처리한 사실을 기록한다.
                node = findLowestCostNode(costsMap, processed); // 다음으로 처리할 정점을 찾아 반복한다.
            }

            Console.WriteLine("After using DijkstraAlgorithm");
            foreach (string nodeName in costsMap.Keys)
            {
                Console.WriteLine($"{nodeName}: {costsMap[nodeName]}");
            }
        }

        private static string findLowestCostNode(Dictionary<string, int> costsMap, List<string> processed) 
        {
            int lowestCost = int.MaxValue;
            string lowestCostNode = null;
            foreach (string node in costsMap.Keys)
            {
                int cost = costsMap[node];
                if (cost < lowestCost && !processed.Contains(node))
                {
                    lowestCost = cost;
                    lowestCostNode = node;
                }
            }
            return lowestCostNode;
        }
    }
}
