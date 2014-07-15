package ch4;

import java.util.Arrays;

/*
 * weighted version
 * keep track of the height of the tree
 */

public class QuickUnion {
	private int[] id;
	private int[] sz;
	private int count;

	public QuickUnion(int N) {
		count = N;
		sz = new int[N];
		for (int i = 0; i < N; ++i) {
			sz[i] = 1;
		}
		id = new int[N];
		for (int i = 0; i < N; ++i) {
			id[i] = i;
		}
	}

	private int root(int i) {
		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else if (sz[i] > sz[j]) {
			id[j] = i;
			sz[i] += sz[j];
		} else {
				id[j] = i;
				sz[i] += sz[j];

		}
//		System.out.println(this.toString());
	}

	public String toString() {
		return Arrays.toString(id);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnion uf = new QuickUnion(10);
		uf.union(4, 2);
		uf.union(0, 8);
		uf.union(1, 5);
		uf.union(3, 6);
		uf.union(4, 8);
		uf.union(3, 1);
		uf.union(1, 9);
		uf.union(8, 5);
		uf.union(5, 7);
		System.out.println(uf.toString());
	}

}
