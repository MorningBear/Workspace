package com.victor.sort.numbers;

public class BubbleSort extends Sort {

	private static void sort(int[] a) {
		int N = a.length;
		boolean swapped = true;
		
		while (swapped) {
			swapped = false;
			
			for (int i = 0; i < N-1; i++) {
				if (less(a[i+1], a[i])) {
					swap(a, i, i+1);
					swapped = true;
				}
			}
			
			N--;
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = RandomNumbers.generateRandomNumbers(1, 1000, 100);
		if (isSorted(array)) {
			System.out.println("The array is already sorted!");
		} else {
			sort(array);
			if (isSorted(array)) {
				System.out.println("The array is sorted");
			} else {
				System.out.println("The array is not sorted");
			}
		}
		show(array);
	}
	
}
