

/* Give you an array which has n integers, it has both positive and negative integers.
 * Now you need sort this array in a special way. After that, the negative integers should 
 * in the front, and the positive integers should in the back.
 * Also the relative position should not be changed.
 * 
 * e.g. -1 1 3 -2 2 answer: -1 -2 1 3 2
 * 
 * O(N) time complexity and O(1) space complexity is perfect.
 * 
 * @author Victor Xiong
 * 
 */

public class Array {
	public static void main(String args[]) {
		int[] test_array = {-1,1,3,-2,2};
		int neg = 0;
		
		for (int i = 0; i < test_array.length; i++) {
			if (test_array[i] < 0)
				neg++;
		}
		
		int countneg = 0;
		int i = 0;
		int j = 1;
		int k = 0;
		int temp = 0;
		
		while(countneg < neg) {
			if (test_array[i] < 0) {
				countneg++;
				i++;
			} else {
				j = i;
				k = i;
				while(test_array[k] > 0) {
					k++;
				}
				
				temp = test_array[j];
				test_array[j] = test_array[k];
				for (int n = k; n > j; n--) {
					test_array[n] = test_array[n-1];
				}
				test_array[j+1] = temp;
				countneg++;
				i++;
			}
			
			
		}
		
		for (int m = 0; m < test_array.length; m++) {
			System.out.println(test_array[m]);
		}
	}
}
