package ��Ŀ1������ϷNim��Ϸ;

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int res = 0;
		while(num-->0){
			res ^= sc.nextInt();
		}
		if(res==0){
			System.out.println("Bob");
		}else{
			System.out.println("Alice");
		}
		sc.close();
	}
}
