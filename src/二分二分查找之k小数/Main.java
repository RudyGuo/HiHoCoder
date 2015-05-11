package 二分二分查找之k小数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	private static Scanner sc;

	private int binarySearch(int []num,int k){
		Arrays.sort(num);
		return num[k-1];
	}
	
	public static void main(String args[]){
		Main main =new Main();
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int num[] = new int[n];
		int idx = 0;
		while(n-->0){
			num[idx++] = sc.nextInt();
		}
		System.out.println(main.binarySearch(num, k));
	}
}
