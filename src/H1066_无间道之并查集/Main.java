package H1066_无间道之并查集;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	Map<String,String> map = new HashMap<>();
	
	private String find(String str){
		if(map.get(str)==str){
			return str;
		}
		String s = find(map.get(str));
		map.put(str,s);
		return s;
	}
	
	private void init(String str){
		if(map.get(str)==null){
			map.put(str, str);
		}
	}
	
	private void insert(String a,String b){
		String fda = find(a);
		String fdb = find(b);
		if(fda.equals(fdb)) return;
		map.put(fdb, fda);
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
		Main main = new Main();
		int num = sc.nextInt();
		while(num-->0){
			int in = sc.nextInt();
			String a = sc.next();
			String b = sc.next();
			if(in==0){
				main.init(a);
				main.init(b);
				main.insert(a, b);
			}else{
				String s1 = main.find(a),s2=main.find(b);
				if(s1==null||s2==null||!s1.equals(s2)){
					System.out.println("no");
				}else{
					System.out.println("yes");
				}
			}
		}
		sc.close();
	}
}
