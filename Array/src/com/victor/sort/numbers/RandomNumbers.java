package com.victor.sort.numbers;

import java.util.Random;

public class RandomNumbers extends Sort {

	public static int[] generateRandomNumbers(int rangeMin, int rangeMax, int size) {
		assert ( rangeMin < rangeMax ): "rangeMin cannot be greater than rangeMax";
		
		int[] randomArray = new int[size];
		
		Random rand = new Random();
		
		for (int i = 0; i < size; i++) {
			randomArray[i] = rangeMin + rand.nextInt(rangeMax - rangeMin);
		}
		
		return randomArray;
	}
	
	public static void main(String[] args) {
		show(generateRandomNumbers(1, 100, 10));
	}
	
}
