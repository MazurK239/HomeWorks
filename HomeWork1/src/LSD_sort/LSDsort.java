package LSD_sort;

import java.util.ArrayList;
import java.util.List;

public class LSDsort {

	// base = 10
	
	private static int[] sort(int[] array, final int iter) {
		
		int[] count = new int[11];
		int[] aux = new int[array.length];
		for (int idx = 0; idx < array.length; idx++) {
			int number = (array[idx] / (int)Math.pow(10.0, (float)iter)) % 10;
			count[number+1]++;
		}
		
		for (int idx = 0; idx < 10; idx++){
			count[idx+1] += count[idx];
		}
//		for (int i = 0; i < count.length; i++) {
//			System.out.println(count[i]);
//		}
		for (int idx = 0; idx < array.length; idx++) {
			int number = (array[idx] / (int)Math.pow(10.0, (float)iter)) % 10;
			aux[count[number]++] = array[idx];
		}
		
		for (int idx = 0; idx < aux.length; idx++) {
			array[idx] = aux[idx];
		}
		
		return array;
	}
	
	public static int[] LSDsort(int[] array) {
		int iter = 0;
		int maxval = 0;
		
		for (int idx = 0; idx < array.length; idx++) {
			if (array[idx] > maxval) {
				maxval = array[idx];
			}
		}
		
		while ((int)Math.pow(10.0, (float)iter) < maxval) {
			sort(array, iter);
			iter++;
		}
		
		return array;
	}
	
	public static void main(final String[] args) {
		
		int[] array = {13, 43, 2, 157, 52};
		for (int i = 0; i < array.length; i++) {
			System.out.println(LSDsort(array)[i]);			
		}
		
	}
	
}
