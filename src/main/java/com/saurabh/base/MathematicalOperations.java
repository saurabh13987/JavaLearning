package com.saurabh.base;

public class MathematicalOperations {

	public static long power(long number, long power) {
		long multipliedNumber = number;
		for (int i = 0; i < power - 1; i++) {
			multipliedNumber = multipliedNumber * number;
		}
		return multipliedNumber;
	}

	public static void isArmstrong(String numberToBeVerified) {
		long digitsSum = 0;

		try {
			long number = Long.parseLong(numberToBeVerified);

			char[] digits = numberToBeVerified.toCharArray();
			int numberOfDigits = digits.length;

			for (int i = 0; i < digits.length; i++) {
				digitsSum = Math.addExact(digitsSum,
						(long) Math.pow(Character.getNumericValue(digits[i]), numberOfDigits));
				power((long) Character.getNumericValue(digits[i]), (long) numberOfDigits);
			}
			if (number == digitsSum) {
				System.out.println(numberToBeVerified + " : Armstrong number");
			} else {
				System.out.println(numberToBeVerified + " : Not an Armstrong number");
			}

		} catch (Exception e) {
			System.out.println(numberToBeVerified + " : Not a valid number");
		}
	}

	public static void main(String[] args) {
		isArmstrong("9474");
		isArmstrong("0");
		isArmstrong("1");
		isArmstrong("153");
		isArmstrong("407");
		isArmstrong("54748");
	}

}
