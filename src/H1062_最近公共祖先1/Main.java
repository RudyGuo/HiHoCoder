package H1062_最近公共祖先1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	Map<String,String> dic = new HashMap<>();
	Set<String> vis = new HashSet<>();
	private String find(String a,String b){
		String fda = a;
		while(fda!=null){
			vis.add(fda);
			fda = dic.get(fda);
		}
		String fdb = b;
		while(fdb!=null){
			if(vis.contains(fdb)){
				return fdb;
			}
			fdb = dic.get(fdb);
		}
		return "-1";
				
	}
	
	public static void main(String args[]){
/*		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("D:\\Desktop\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Scanner sc = new Scanner(System.in);
		Main main= new Main();
		int input = sc.nextInt();
		while(input-->0){
			String father = sc.next();
			String son = sc.next();
			main.dic.put(son, father);
		}
		int output = sc.nextInt();
		while(output-->0){
			String a = sc.next();
			String b = sc.next();
			main.vis.clear();
			System.out.println(main.find(a, b));
		}
	}
}
