package v1_1039_lv2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private int delete(String str) {
		if ( str.length()<=1)return 0;
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		while(idx<str.length()){
			char cur = str.charAt(idx);
			int num = 0;
			while(idx<str.length()&&str.charAt(idx)==cur){
				num++;
				idx++;
			}
			if(num==1){
				sb.append(cur);
			}
		}
		if (sb.length() == str.length()) {
			return 0;
		}
		return delete(sb.toString())+str.length()-sb.length();

	}

	public static void main(String args[]) {
		
/*		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("D:\\Desktop\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Main main = new Main();
 		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num-- > 0) {
			String str = sc.next();
			int res = 0;
			for(int i=0;i<str.length();i++){
				for(char c ='A';c<='C';c++){
					StringBuilder sb = new StringBuilder(str);
					sb.insert(i, c);
					res = Math.max(res, main.delete(sb.toString()));
				}
			}
			System.out.println(res);
		}
		sc.close();
	}
}

