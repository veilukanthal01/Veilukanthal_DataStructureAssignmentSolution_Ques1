package com.greatlearning.service;

class Node {
	int data;
	Node next;

	Node(int key) {
		this.data = key;
		next = null;
	}
}

public class LinkedListSortedImplementaion {

	static Node arrangeFloorBySize(Node head) {
		if (head == null)
			return null;

		while (BuildingBlueprint.getCurrentMaximumFloorSize() != 0 && head != null
				&& BuildingBlueprint.getCurrentMaximumFloorSize() == head.data) {
			head = head.next;
			int floorSizeToBePlaced = BuildingBlueprint.removeMaximumFloorSize();
			System.out.print(floorSizeToBePlaced + " ");
		}

		return head;
	}

	static Node push(Node head, int new_data) {
		/* allocate node */
		Node new_node = new Node(new_data);

		/* link the old list off the new node */
		new_node.next = head;

		/* move the head to point to the new node */
		head = new_node;

		head = mergeSort(head);

		return head;
	}

	static Node mergeSort(Node head) {
		if (head.next == null)
			return head;

		Node mid = findMid(head);
		Node head2 = mid.next;
		mid.next = null;
		Node newHead1 = mergeSort(head);
		Node newHead2 = mergeSort(head2);
		Node finalHead = merge(newHead1, newHead2);

		return finalHead;
	}

	static Node merge(Node head1, Node head2) {
		Node merged = new Node(-1);
		Node temp = merged;

		while (head1 != null && head2 != null) {
			if (head1.data > head2.data) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}

		while (head1 != null) {
			temp.next = head1;
			head1 = head1.next;
			temp = temp.next;
		}

		while (head2 != null) {
			temp.next = head2;
			head2 = head2.next;
			temp = temp.next;
		}
		return merged.next;
	}

	static Node findMid(Node head) {
		Node slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

}
