package daa.practice.graphs;

import daa.practice.graphs.Graph.Node;

public class Traversal {

	 static Node[] arr;
	 public static void dfs(int start,boolean[] visited)
	 {
		 if(!visited[start])
		 {
			 visited[start]=true;
			 System.out.println(start);
			 for (Node temp = arr[start]; temp != null; temp = temp.next)
			 {
				 dfs(temp.vertex,visited);
			 }
		 }
	 }
	 
	 public static void bfs(int start,int size)
	 {
		 boolean[] visited=new boolean[size];
		 Queue q=new Queue();
		 q.addToTail(start);
		 visited[start]=true;
		while (q.length != 0) {
			int len = q.length;
			System.out.println();
			while (len-- != 0) {
				Node pop = q.removeFromHead();
				System.out.print(pop.vertex + " ");
				for (Node temp = arr[pop.vertex]; temp != null; temp = temp.next) {
					if (!visited[temp.vertex]) {
						q.addToTail(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}

		}
	 }
	 
	 public static void main(String[] args)
	 {
		Graph g=new Graph(6,"d");
		g.addEdge(1, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		g.addEdge(5, 2);
		arr=g.arr;
		//dfs(1,new boolean[6]);
		bfs(1,6);
	 }
}
