package com.greatlearning.service;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FloorAssembler {

	public int totalNoOfFloors;
	public static int dayCount;
	public static ArrayDeque<Integer> floorSizeQueue;
	public static Node head;

	public FloorAssembler(int totalNoOfFloors) {
		this.totalNoOfFloors = totalNoOfFloors;
		floorSizeQueue = new ArrayDeque<>(totalNoOfFloors);
	}

	public void getFloorSizeValues(int totalNoOfFloors) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= totalNoOfFloors; i++) {

			// Get floor size from the user
			System.out.println("Enter the floor size given on day : " + i);
			int floorSize = sc.nextInt();
			floorSizeQueue.add(floorSize);

			// This will create a linked list with expected order in which floor should be
			// placed ex: 3,2,1 ... and 5,4,3,2,1
			BuildingBlueprint.createFloorBlueprint(totalNoOfFloors, i);
		}

		sc.close();
	}

	public void assembleFloorsWithBlueprint() {
		System.out.println("The order of construction is as follows : ");
		while (floorSizeQueue.size() != 0 && !floorSizeQueue.isEmpty()) {
			for (int i = 1; i <= totalNoOfFloors; i++) {
				int currentMaxFloorSize = BuildingBlueprint.getCurrentMaximumFloorSize();
				int fSize = floorSizeQueue.poll();
				head = LinkedListSortedImplementaion.push(head, fSize);
				dayCount++;
				System.out.println("\nDay: " + dayCount);
				if (fSize == currentMaxFloorSize && head != null) {
					head = LinkedListSortedImplementaion.arrangeFloorBySize(head);
					break;
				}
			}
		}
	}
}
