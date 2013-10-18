package com.victor.sort.numbers;

public class ShellSort extends Sort {

	private static void sort(int[] a) {
		int N = a.length;
		int h = 1;
		
		while (h < N) h = h*3 + 1;
		while (h > 0) {
			for (int i = 0; i < N; i++) {
				for (int j = i+h; j < N; ) {
					if (less(a[j], a[j-h])) {
						swap(a, j-h, j);
					} else {
						break;
					}
					j += h;
				}
			}
			
			h = h/3;
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
