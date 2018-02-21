package co.test;

public class MaxElementInArray {
	public static void main(String args[]) {
		int[] a = {5,7,1,100,989,201};
		int max = a[0];
		for(int i =0 ; i<a.length;i++) {
			if(a [i] > max) {
				max = a[i];
			}
		}
		System.out.println(max);
	}
	

}
