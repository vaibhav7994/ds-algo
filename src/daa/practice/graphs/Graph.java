package daa.practice.graphs;

public class Graph {

	Node[] arr;
	int size;
	String type;

	public static class Node {
		int vertex;
		Node next;

		public Node(int v) {
			vertex = v;
		}
	}

	public Graph(int size, String type) {
		this.size=size;
		arr = new Node[size];
		this.type = type;
	}
	
	void addEdge(int u, int v) {
		Node head = arr[u];
		Node temp = new Node(v);
		if (head == null) {
			head = temp;
		} else {
			temp.next = head;
			head = temp;
		}
		arr[u] = head;

		if (type.equals("ud")) {
			head = arr[v];
			temp = new Node(u);
			if (head == null) {
				head = temp;
			} else {
				temp.next = head;
				head = temp;
			}
			arr[v] = head;
		}

	}
	
	void printGraph() {
		for (int i = 0; i < size; i++) {
			System.out.println("\nFor Vertex " + i + " adjacent are:");
			for (Node temp = arr[i]; temp != null; temp = temp.next)
				System.out.print(temp.vertex+" ");
		}
	}
	
	public static void main(String[] args)
	{
		Graph g=new Graph(5,"ud");
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.printGraph();
	}
}
