package daa.practice.graphs;

import java.util.Arrays;

import daa.practice.graphs.Graph.Node;

public class Coloring {
	
	 static Node[] arr;
	 
	 public static boolean dfsbi(int start,boolean[] visited,int[] color,int c)
	 {
		 if(!visited[start])
		 {
			 visited[start]=true;
			 color[start]=c;
			 for (Node temp = arr[start]; temp != null; temp = temp.next)
			 {
				 if(!dfsbi(temp.vertex,visited,color,-c))
					 return false;
			 }
		 }
		 else if(color[start]==-c)
		  return false;
		 return true;
	 }
	 
	public static boolean mcolor(int vertex, int[] c,int m) {
		if (vertex == c.length)
			return true;
		for (int i = 1; i <= m; i++) {
			boolean flag = true;
			for (Node temp = arr[vertex]; temp != null; temp = temp.next) {
				if (c[temp.vertex] == i) {
					flag = false;
					break;
				}
			}
			if (flag) {
				c[vertex] = i;
				if (mcolor(vertex + 1, c,m))
					return true;
				c[vertex] = 0;
			}
		}
		return false;
	}
	 
	 public static void bfsbi(int start,int size, int[] color)
	 {
		 boolean[] visited=new boolean[size];
		 Queue q=new Queue();
		 q.addToTail(start);
		 visited[start]=true;
		 int c=1;
		while (q.length != 0) {
			int len = q.length;
			while (len-- != 0) {
				Node pop = q.removeFromHead();
				color[pop.vertex]=c;
				for (Node temp = arr[pop.vertex]; temp != null; temp = temp.next) {
					if(color[temp.vertex]==c)
					{
						System.out.println("Not Bipartite");
						return;
					}
					if (!visited[temp.vertex]) {
						q.addToTail(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
				
			}
			c=c*-1;

		}
		System.out.println("Bipartite");
	 }
	 
	 public static void main(String[] args)
	 {
		Graph g=new Graph(4,"ud");
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 3);
		g.addEdge(3, 0);

		arr=g.arr;
		int[] color=new int[4];
		//bfsbi(1,6,color);
		//boolean res=dfsbi(1, new boolean[6], color, 1);
		mcolor(0, color,8);
		System.out.println(Arrays.toString(color));
	 }
}
