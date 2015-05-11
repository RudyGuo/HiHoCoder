package 题目1_骨牌覆盖问题一;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {
	
	private static long maxMethod(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		long cur= 2,pre = 1;
		long res = 0;
		for(int i=3;i<=n;i++){
			res = cur +pre;
			if(res>19999997){
				res = res%19999997;
			}
			pre = cur;
			cur = res;
		}
		return res;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a[][] = {{1,2,3},{2,2}};
		int n = sc.nextInt();
		System.out.println(maxMethod(n));
		sc.close();
	}

}
