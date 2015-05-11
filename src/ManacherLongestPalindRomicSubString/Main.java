package ManacherLongestPalindRomicSubString;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
	
	private int longestPalindSubString(String str){
		if(str.length()==0) return 0;
		StringBuilder sb = new StringBuilder();
		sb.append("$#");
		for(int i=0;i<str.length();i++){
			sb.append(str.charAt(i)+"#");
		}
		sb.append("&");
		String s = sb.toString();
		int p[] = new int[s.length()-1];
		int id =1,mx = 1;
		for(int i=1;i<s.length()-1;i++){
			p[i] = Math.min(mx-i, p[2*id-i]);
			while(s.charAt(i+p[i]+1)==s.charAt(i-p[i]-1)){
				p[i]++;
			}
			if(i+p[i]>mx){
				id = i;
				mx = p[i]+i;
			}
		}
		int res = 0;
		int idx = 0;
		for(int i=0;i<p.length-1;i++){
			if(p[i]>res){
				idx = i;
				res = p[i];
			}
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
// 		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(num-->0){
			String str = sc.next();
			System.out.println(main.longestPalindSubString(str));
		}
	}
}
