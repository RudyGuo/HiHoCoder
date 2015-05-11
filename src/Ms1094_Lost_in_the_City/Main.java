package Ms1094_Lost_in_the_City;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	private boolean isHere(char[][] hi, char[][] cityMap, int row, int column) {
		if (hi[1][1] != cityMap[row][column])
			return false;
		boolean res = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (hi[i][j] != cityMap[row + i - 1][column + j - 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String args[]){
		class Pair implements Comparable{
			int x, y;
			Pair(int x,int y){
				this.x = x;
				this.y = y;
			}
			@Override
			public int compareTo(Object o) {
				Pair other = (Pair)o;
				if(this.x==other.x){
					return this.y - other.y;
				}
				// TODO Auto-generated method stub
				return this.x - other.x;
			}
		}
		
/*		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream("D:\\Desktop\\test.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		int row = sc.nextInt();
		int column = sc.nextInt();
		char [][]cityMap = new char[row][column];
		for(int i=0;i<row;i++){
			String str = sc.next();
			for(int j=0;j<column;j++){
				cityMap[i][j]= str.charAt(j);
			}
		}
		char[][] hi1 = new char[3][3];
		char[][] hi2 = new char[3][3];
		char[][] hi3 = new char[3][3];
		char[][] hi4 = new char[3][3];
		for(int i=0;i<3;i++){
			String str = sc.next();
			for(int j=0;j<3;j++){
				char c = str.charAt(j);
				hi1[i][j] = c;
				hi2[2-i][2-j] =c;
				hi3[2-j][i] =c;
				hi4[j][2-i] =c;
			}
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i=1;i<row-1;i++){
			for(int j=1;j<column-1;j++){
				if(main.isHere(hi1, cityMap, i, j)||main.isHere(hi2, cityMap, i, j)
						||main.isHere(hi3, cityMap, i, j)||main.isHere(hi4, cityMap, i, j)){
					pq.add(new Pair(i,j));
				}
			}
		}
		Pair p = pq.poll();
		
		while(p!=null){
			System.out.println((p.x+1)+" "+(p.y+1));
			p = pq.poll();
		}
	}
}
