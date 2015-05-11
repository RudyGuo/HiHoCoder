/*package ÌâÄ¿3Islands_Travel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	List<Node> nodes;
	int num;
	Edge
	class Edge{
		int to,cost;
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	class Node {
		int x,y,idx;
		Node(int x,int y,int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

	}
	
	public void face(){
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int idx =0;
		nodes = new ArrayList<>();
		while(num-->0){
			int x = sc.nextInt();
			int y = sc.nextInt();
			nodes.add(new Node(x,y,idx++));
		}
	}
	
	private void addx(){
		
		Collections.sort(nodes, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.x-o2.x;
			}
		});
		for(int i=0;i<nodes.size();i++){
			
		}

		
		
	}
	public static void main(String args[]){
		Main main = new Main();
		main.face();
	}
}*/
