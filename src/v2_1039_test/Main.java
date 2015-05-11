package v2_1039_test;

import java.util.Random;

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
	
	private int delete2(String str) {
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
		return delete2(sb.toString())+str.length()-sb.length();

	}
	
	
	private String randomStr(){
		Random rand = new Random();
		Random rand2 = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<rand2.nextInt(100);i++){
			char c = (char) ('A' + rand.nextInt(3));
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	public static void main(String args[]){
		Main main = new Main();
		while(true){
			String str = main.randomStr();
			String str2 = new String(str);
//			System.out.println(str);
			int res = 0;
			for(int i=0;i<str.length();i++){
				for(char c ='A';c<='C';c++){
					StringBuilder sb = new StringBuilder(str);
					sb.insert(i, c);
					res = Math.max(res, main.delete2(sb.toString()));
				}
			}
			//System.out.println(res);
			int res2 = main.common(str2);
			if(res!=res2){
				System.out.println("res="+res+"  "+"res2="+res2);
				System.out.println(str);
				break;
			}
		}
	}
	
	

}
