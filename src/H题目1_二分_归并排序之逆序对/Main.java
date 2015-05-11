package H题目1_二分_归并排序之逆序对;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	long res = 0;
	private void sort(int start,int end,int[]arr){
		if(start>=end) return;
		int mid = (start+end)/2;
		sort(start,mid,arr);
		sort(mid+1,end,arr);
		merge(start,end,arr);
	}
	
	private void merge(int start,int end,int[]arr){
		int mid = (start+end)/2;
		int insert[] = new int[mid-start+1];
		insert = Arrays.copyOfRange(arr, start, mid+1);
		int idx = start;
		int left = 0;
		int right = mid+1;
		while(left<=insert.length-1&&right<=end){
			if(arr[right]<insert[left]){
				arr[idx++] = arr[right++];
			}else{
				res += right-(mid+1);
				arr[idx++]=insert[left++];
			}
		}
		while(left<=insert.length-1){
			arr[idx++] = insert[left++];
			res+= right-(mid+1);
		}
	}
	
	public static void main(String args[]){
		
/*		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("D://desktop//test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int []arr = new int[num];
		for(int i=0;i<num;i++){
			arr[i] = sc.nextInt();
		}
		Main main = new Main();
		main.res = 0;
		main.sort(0,arr.length-1,arr);
		System.out.println(main.res);
	}
}
