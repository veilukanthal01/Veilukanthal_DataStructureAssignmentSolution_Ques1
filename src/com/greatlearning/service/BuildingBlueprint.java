package com.greatlearning.service;

import java.util.Stack;

public class BuildingBlueprint {

	public static Stack<Integer> stack = new Stack<Integer>();

	public static void createFloorBlueprint(int totalNoOfFloors, int floorSize) {
		if (stack.size() > totalNoOfFloors)
			System.out.println("Stack size exceeds the total number of floors " + totalNoOfFloors);
		else
			stack.push(floorSize);
	}

	public static boolean isEmpty() {
		if (stack.empty())
			return true;
		else
			return false;
	}

	public static int getCurrentMaximumFloorSize() {
		if (isEmpty())
			return 0;
		else {
			int maxFloorSize = (Integer) stack.peek();
			return maxFloorSize;
		}
	}

	public static int removeMaximumFloorSize() {
		if (isEmpty())
			return 0;
		else {
			int maxFloorSize = (Integer) stack.pop();
			return maxFloorSize;
		}
	}
}
