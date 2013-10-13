package com.victor.sort.numbers;

public class SelectionSort extends Sort {

	private static void sort(int[] a) {
		int N = a.length;
		
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(a[j], a[min])) min = j;
			}
			swap(a, i, min);
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
