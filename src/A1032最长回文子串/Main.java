package A1032最长回文子串;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	private int maxLen(String str){
		if(str.length()==0) return 0;
		int res = 1;
		boolean f[][] = new boolean[str.length()][str.length()];
		for(int i=0;i<str.length();i++) f[i][i]=true;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				f[i][i+1] =true;
				res = 2;
			}
		}
		boolean foo1 = false,foo2 = false;
		for(int i=2;i<str.length();i++){
			if(i%2==0){
				foo1 = false;
			}else{
				foo2 = false;
			}
			for(int j=0;j<str.length()-i;j++){
				if(str.charAt(j)==str.charAt(j+i)&&f[j+1][j+i-1]){
					f[j][j+i] =true;
					res = i+1;
					if(i%2==0){ 
						foo1 = true;
					}else{
						foo2 = true;
					}
				}
			}
			if(i%2!=0&&!foo1&&!foo2) break;
		}
		return res;
	}
	
	
	public static void main(String args[]){
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("D:\\Desktop\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Main main = new Main();
//		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(num-->0){
			String str = sc.next();
			System.out.println(main.maxLen(str));
		}
	}
}
