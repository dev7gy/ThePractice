using System;
using System.Collections;
using System.Collections.Generic;

namespace BreadthFirstSearch
{
    class Program
    {
        /*
         * < 그래프 >
         * 정점(node)와 간선(edge)로 이루어져있다.
         * 이어진 정점은 이웃(neighbor)이라고 한다.
         * 방향 그래프 - 무방향 그래프
         * 
         * 
         * BFS
         * 정점A에서 B로 가는 경로가 존재하는가?
         * 정점A에서 B로 가는 최단 경로는 무엇인가?
         * 
         * <큐>
         * 큐는 큐 안의 원소에 임의로 접근할 수 없다.
         * enqueue, dequeue라고 하는 두가지 연산이 있다.
         * FIO 자료 구조
         */
        static void Main(string[] args)
        {
            Dictionary<string, string[]> graph = new Dictionary<string, string[]>();
            graph.Add("you", new string[] { "alice", "bob", "claire" });
            graph.Add("bob", new string[] { "anuj", "peggy" });
            graph.Add("alice", new string[] { "peggy" });
            graph.Add("claire", new string[] { "thom", "jonny" });
            graph.Add("anuj", new string[] { });
            graph.Add("peggy", new string[] { });
            graph.Add("thom", new string[] { });
            graph.Add("jonny", new string[] { });

            FindNodeUsingBFS(graph, "you");
        }

        public static bool FindNodeUsingBFS(Dictionary<string, string[]> graph, string name)
        {
            Queue<string> searchQueue = new Queue<string>();
            string[] personNameList;
            if (graph.TryGetValue(name, out personNameList))
            {
                foreach(var personName in personNameList)
                {
                    searchQueue.Enqueue(personName);
                }
            }
            
            while (searchQueue.Count > 0)
            {
                string personName = searchQueue.Dequeue();
                if (IsSeller(personName))
                {
                    Console.WriteLine(personName + "is a mango Seller");
                    return true;
                }
                else
                {
                    if (graph.TryGetValue(personName, out personNameList))
                    {
                        foreach ( var pName in personNameList)
                        {
                            searchQueue.Enqueue(pName);
                        }
                    }
                        
                }
            }
            
            return false;
        }

        private static bool IsSeller(string personName)
        {
            return personName[personName.Length - 1] == 'm'; 
        }
    }
}
