package algoHw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
/*
 * homework#3, random contraction algorithm for min cut problem
 */
public class Graph {
	private Map<Integer, Vertex> adj;;
	private List<Edge> edges = new ArrayList<Edge>();

	private static class Vertex {
		private int lbl;
		private ArrayList<Integer> adjv;

		public Vertex(int lbl) {
			this.lbl = lbl;
			adjv = new ArrayList<Integer>();
		}

		public void addV(int v2) {
			adjv.add(v2);
		}

		public void rmV(int v2) {
			for (int i = 0; i < adjv.size(); ++i) {
				if (adjv.get(i) == v2) {
					adjv.remove(i);
					return;
				}
			}
		}

		public String toString() {
			return adjv.toString();
		}

		public boolean contains(int i) {
			return adjv.contains(i);
			// return false;
		}
	}

	static class Edge {
		private int first;
		private int second;

		public Edge(int f, int s) {
			first = f;
			second = s;
		}

		public boolean contains(int f, int s) {
			return (f == first && s == second);
		}

		public String toString() {
			return new String(first + "-" + second);
		}

		public boolean equals(Object c) {
			Edge other = (Edge) c;
			return other.first == this.first && other.second == this.second;
		}

		public int hashCode() {
			return first * 31 + second;
		}
	}

	public Graph(int[][] arr) {
		// V = arr.length;
		adj = new TreeMap<Integer, Vertex>();
		for (int[] row : arr) {
			adj.put(row[0], new Vertex(row[0]));
		}

		for (int[] row : arr) {
			if (row != null) {
				for (int i = 1; i < row.length; ++i) {
					if (!adj.get(row[i]).contains(row[0])) {
						addEdge(row[0], row[i]);
					}
				}
			}
		}
	}

	public void addEdge(int v, int w) {
		Edge e = new Edge(v, w);
		edges.add(e);
		if (adj.get(v) == null) {
			adj.put(v, new Vertex(v));
		}
		if (adj.get(w) == null) {
			adj.put(w, new Vertex(w));
		}
		adj.get(v).addV(w);
		adj.get(w).addV(v);
	}

	public Vertex adj(int v) {
		return adj.get(v);
	}

	public void rmEdge(int v, int w) {
		// System.out.println("-: " + v + ":" + w);
		if (!edges.contains(new Edge(v, w)) && !edges.contains(new Edge(w, v)))
			throw new IllegalArgumentException("invalid edge");
		if (!edges.remove(new Edge(v, w))) {
			edges.remove(new Edge(w, v));
		}
		;
		Vertex lv = adj.get(v);
		lv.rmV(w);
		Vertex lw = adj.get(w);
		lw.rmV(v);
	}

	public void fuse(int from, int to) {
		Vertex vfrom = adj.get(from);
		int[] list = new int[vfrom.adjv.size()];
		for (int i = 0; i < list.length; ++i) {
			list[i] = vfrom.adjv.get(i);
		}
		for (int i = 0; i < list.length; ++i) {
			int other = list[i];
			this.rmEdge(from, other);
			if (to != other)
				this.addEdge(to, other);
		}
		adj.remove(from);
	}

	public String toString() {
		StringBuffer str = new StringBuffer("V: " + adj.size() + " E: "
				+ edges.size() + "\n");
		for (Map.Entry<Integer, Vertex> entry : adj.entrySet()) {
			int v = entry.getKey();
			Vertex list = entry.getValue();
			str.append(v + ": " + list.toString() + "\n");
		}
		str.append(edges.toString());
		return str.toString();
	}

	public static int minCut(Graph g) {
		Random rnd = new Random();
		while (g.adj.size() > 2) {
			int index = rnd.nextInt(g.edges.size());
			Edge e = g.edges.get(index);
			g.fuse(e.first, e.second);
		}
		System.out.println(g.edges.size());
		return g.edges.size();
	}

	public static void main(String[] args) {
		// int[][] arr = { { 1, 2, 5, 6 }, { 2, 1, 5, 6, 3 }, { 3, 2, 4, 7, 8 },
		// { 4, 3, 7, 8 }, { 5, 1, 2, 6 }, { 6, 1, 2, 5, 7 },
		// { 7, 3, 6, 8, 4 }, { 8, 3, 4, 7 } };
		int[][] arr = read("input/kargerMinCut.txt");
		Map<Integer, Integer> statistics = new LinkedHashMap<Integer, Integer>();
		int min = arr.length;
//		int iter = arr.length * arr.length;
		int iter = 20;
		for (int i = 0; i < iter; i++) {
			Graph gr = new Graph(arr);
			int currMin = minCut(gr);
			min = Math.min(min, currMin);

			Integer counter;
			if ((counter = statistics.get(currMin)) == null) {
				counter = 0;
			}
			statistics.put(currMin, counter + 1);
		}
		System.out.println("Min: " + min + " stat: "
				+ (statistics.get(min) * 100 / iter) + "%");

	}

	public static int[][] read(String filename) {
		int[][] ret = new int[200][];
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String[] tmp = scanner.nextLine().split("(\\s)+");
			int[] row = new int[tmp.length];
			for (int i = 0; i < tmp.length; ++i) {
				row[i] = Integer.parseInt(tmp[i]);
			}
			ret[row[0] - 1] = row;
		}
		scanner.close();
		return ret;
	}

}
