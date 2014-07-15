package algoHw;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * tim homework1
 */
public class Inversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] array = read("input/IntegerArray.txt", 100000);
		int[] array = read("input/sample", 4);
		System.out.println(Arrays.toString(array));
		System.out.println(sort(array));
	}

	public static int[] read(String filename, int count) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] tall = new int[count];
		int i = 0;
		while (scanner.hasNextInt()) {
			tall[i++] = scanner.nextInt();
		}
		scanner.close();
		return tall;
	}

	public static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
		// assert a left and right is sorted
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo, j = mid + 1;
		long inversionCount = 0;
		for (int k = lo; k <= hi; ++k) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (aux[i] < aux[j]) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
//				 inversion happens
				inversionCount += (mid - i + 1);
				System.out.println(lo + " " + mid + " " + hi + " " + i);
			}
		}
		return inversionCount;
	}

	private static long sort(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return 0;
		int mid = lo + (hi - lo) / 2;
		return sort(a, aux, lo, mid) + sort(a, aux, mid + 1, hi)
				+ merge(a, aux, lo, mid, hi);
	}

	public static long sort(int[] a) {
		int[] aux = new int[a.length];
		return sort(a, aux, 0, a.length - 1);
	}

}

