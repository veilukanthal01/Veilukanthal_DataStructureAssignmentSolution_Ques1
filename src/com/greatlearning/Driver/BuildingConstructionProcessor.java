package com.greatlearning.Driver;

import java.util.Scanner;

import com.greatlearning.service.FloorAssembler;

public class BuildingConstructionProcessor {

	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the total no of floors in the building");
		int totalNoOfFloors = sc.nextInt();

		// Storing user input in a Queue Class
		FloorAssembler floorAssembler = new FloorAssembler(totalNoOfFloors);
		floorAssembler.getFloorSizeValues(totalNoOfFloors);
		
		//calling method to construct floors
		floorAssembler.assembleFloorsWithBlueprint();

	}

}
