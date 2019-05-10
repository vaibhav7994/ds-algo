package daa.practice.graphs;

public class DisjointSet {

	int[] rank;
	int[] parent;
	int size;

	public DisjointSet(int size) {
		rank = new int[size];
		parent = new int[size];
		this.size = size;
		makeSet();
	}

	private void makeSet() {
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int s) {
		if (parent[s] != s)
			parent[s] = find(parent[s]);
		return parent[s];
	}

	public void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		if (rank[ap] > rank[bp])
			parent[bp] = ap;
		else if (rank[bp] > rank[ap])
			parent[ap] = bp;
		else {
			parent[ap] = bp;
			rank[bp]++;
		}
	}
}
