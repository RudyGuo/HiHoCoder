package v1_1039_×Ö·ûÏû³ý;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	int res = 0;
	String s = new String();
	private void  preFix(String str){
		if(str == null) return;
		StringBuilder sb = new StringBuilder();
		sb.append("$#");
		for(int i=0;i<str.length();i++){
			sb.append(str.charAt(i)+"#");
		}
		sb.append("&");
		s = sb.toString();
	}
	
	private void maxScore(String str) {
		if(str==null) return;
		int mx = 1,idx = 1;
		int p[] = new int[str.length()];
		int score = 0;
		for(int i=1;i<str.length()-1;i++){
			p[i] = Math.min(mx-i,p[2*idx-i]);
			while(str.charAt(i+p[i]+1)==str.charAt(i-p[i]-1)){
				p[i]++;
			}
			if(p[i]+i>mx){
				mx = p[i]+i;
				idx = i;
			}
			score = Math.max(score, p[i]);
		}
		res +=score+1; 
	}

	private void delete(String str) {
		if ( str.length() <= 1){
			s = str;
			return;
		}
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
			}else{
				res += num;
			}
		}
		if (sb.length() == str.length()) {
			s = str;
			return;
		}
		delete(sb.toString());

	}

	private int common(String str){
		if(str.length()==0) return 0;
		res = 0;
		s = new String();
		delete(str);
		preFix(s);
		maxScore(s);
		return res;
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
			System.out.println(main.common(str));
		}
		sc.close();
	}
}
