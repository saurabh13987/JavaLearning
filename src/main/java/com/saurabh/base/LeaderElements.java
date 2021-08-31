package com.saurabh.base;

import java.util.ArrayList;

public class LeaderElements {

	public static void findLeaderElements(int numbersList[]) {
		int number = 0;
		int maxNumber = 0;
		ArrayList<Integer> leaders = new ArrayList<Integer>();
		if (numbersList.length != 0) {
			maxNumber = numbersList[numbersList.length - 1];
			leaders.add(maxNumber);
			System.out.print("Leader Number in the list {" + printList(numbersList) + "} are : ");
			for (int i = numbersList.length - 2; i >= 0; i--) {
				number = numbersList[i];
				if (number > maxNumber) {
					leaders.add(number);
					maxNumber = number;
				}
			}

			for (int num : leaders) {
				System.out.print(num + " ");
			}
		}
		else {
			System.out.print("The List is empty");
		}
		System.out.println("");
	}

	public static String printList(int numbersList[]) {
		String numbers = "";
		for (int i = 0; i < numbersList.length; i++) {

			if (i == numbersList.length - 1) {
				numbers = numbers + numbersList[i];
			}

			else if (numbers.isEmpty()) {
				numbers = numbersList[i] + ",";
			}

			else
				numbers = numbers + numbersList[i] + ",";
		}
		return numbers;
	}

	public static void main(String[] args) {
		int numbersList[] = { 92, 3, 4, 5, 2, 1, 12, 4 };
		findLeaderElements(numbersList);
		int numbersList1[] = { 92, 3, 4, 5, 2, 1, -12, 4 };
		findLeaderElements(numbersList1);
		int numbersList2[] = { 0 };
		findLeaderElements(numbersList2);
		int numbersList3[] = { 9, 9, 9, 9, 9 };
		findLeaderElements(numbersList3);
		int numbersList4[] = {};
		findLeaderElements(numbersList4);

	}

}
