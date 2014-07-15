package algoHw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * improvement:
 * 1. use insertion for small subarray
 * 2. tested if whether array is already sorted
 * 3. eliminate the copy of aux array
 */
public class Merge {

	/**
	 * @param args
	 */
	private static final int CUTOFF = 0;
	public static void main(String[] args) {
//		int[] array = {5, 1, 2, 4, 3};
		int[] array = {21,38,24,53,39,58,42,79,41,90,12,49};
		sort(array);
		System.out.println("*****");
		System.out.println(Arrays.toString(array));
	}
	
	public static void sort(int[] a){
		int[] aux = a.clone();
		sort(a, aux, 0, a.length-1);
	}
	
	private static void sort(int[]src, int[] dst, int lo, int hi){
		if(hi <= lo + CUTOFF){
			insertionSort(src, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
        sort(dst, src, lo, mid);
        sort(dst, src, mid+1, hi);
        if (!less(dst[mid+1], dst[mid])) {
            System.arraycopy(dst, lo, src, lo, hi - lo + 1);
            return;
        }

        merge(dst, src, lo, mid, hi);
		
	}
	
	private static void merge(int[]src, int[] dst, int lo, int mid, int hi){
		System.out.println(lo + " " + mid +" " + hi + ":" +Arrays.toString(src));
		assert isSorted(src, lo, mid);
		assert isSorted(src, mid+1, hi);
		int i = lo, j = mid+1;
		for(int k = lo; k<= hi; ++k){
			if (i > mid) dst[k] = src[j++];
			else if (j > hi) dst[k] = src[i++];
			else if (less(src[i], src[j])) dst[k] = src[i++];
			else dst[k] = src[j++];
		}
	}
	
	private static boolean less(int a, int b){
		return a < b;
	}
	
	
	private static boolean isSorted(int[] src, int lo, int hi){
		for(int i = lo + 1; i <= hi; ++i){
			if( less(src[i], src[i-1])) return false;
		}
		return true;
	}
	
	private static void swap(int[] a, int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void insertionSort(int[] a, int lo, int hi){
		for(int i = 0; i <= hi; i++){
			for(int j = i; j > lo && less(a[j], a[j-1]); j--){
				swap(a, j, j-1);
			}
		}		
	}
	

	
}
