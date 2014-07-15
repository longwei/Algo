package ch4;

import java.util.Arrays;


public class UnionFind {
	private int[] id;
	private int count;
	
	public UnionFind(int N){
		count = N;
		id = new int[N];
		for(int i= 0; i < N; ++i){
			id[i] = i;
		}
	}
	private int root(int i){
		while(id[i] != i){
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q){
		return root(p) == root(q);
	}
	
	public int find(int p){
		return id[p];
	}
	
	public void union(int p, int q){
		int pid = find(p);
		int qid = find(q);
		for(int i=0; i < count; ++i){
			if(id[i] == pid) id[i] = qid;
		}
	}
	public String toString(){
		return Arrays.toString(id);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionFind uf = new UnionFind(10);
		uf.union(0, 4);
		uf.union(7, 6);
		uf.union(4, 9);
		uf.union(2, 6);
		uf.union(5, 0);
		uf.union(7, 3);
		System.out.println(uf.toString());
	}

}
