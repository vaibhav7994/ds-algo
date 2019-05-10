package daa.practice.graphs;

import daa.practice.graphs.Graph.Node;

public class Queue {

	Node head;
	Node tail;
	int length=0;
	
	public void addToTail(int val) {
		Node tmp = new Node(val);
		if (head == null) {
			head = tmp;
			tail = tmp;
		} else {
			tail.next = tmp;
			tail = tail.next;
		}
		length++;
	}

	public Node removeFromHead() {
		Node tmp = head;
		head = head.next;
		tmp.next = null;
		length--;
		return tmp;
	}
}
