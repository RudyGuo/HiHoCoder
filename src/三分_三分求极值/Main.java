package 三分_三分求极值;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	private static String minLen(int a,int b,int c,int x,int y){
		double zhou = -((double)b)/(2*a);
		double left = -1;
		double right = -1;
		if(b*b-4*a*(c-y)<0){
			left = zhou<x?zhou:x;
			right = zhou<x?x:zhou;
		}else{
			double as = x<zhou?(-b-Math.sqrt(b*b-4*a*(c-y)))/(2*a):(-b+Math.sqrt(b*b-4*a*(c-y)))/(2*a);
			left = as<x?as:x;
			right = as<x?x:as;
		}
	/*	left = x>zhou?zhou:left;
		right = x<=zhou?zhou:right;*/
		BigDecimal res = null;
		while(true){
			double lm = left+(right-left)/3;
			double rm = left+(right-left)/3*2;
			double lmval = len(a,b,c,x,y,lm);
			double rmval = len(a,b,c,x,y,rm);
			BigDecimal lvStr = new BigDecimal(lmval).setScale(3,BigDecimal.ROUND_HALF_UP);
			BigDecimal rvStr = new BigDecimal(rmval).setScale(3,BigDecimal.ROUND_HALF_UP);
			if(lvStr.equals(rvStr)&&right-left<0.0001){
				res = lvStr;
				break;
			}
			if(lmval<rmval){
				right = rm;
			}else{
				left = lm;
			}
		}
		return res.setScale(3,BigDecimal.ROUND_HALF_UP)+"";
	}
	
	private static double len(int a,int b,int c,int x,int y,double xx){
		return Math.sqrt((xx-x)*(xx-x)+Math.pow(a*xx*xx+b*xx+c-y, 2));
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(minLen(a, b, c, x, y));
		sc.close();
	}
}
