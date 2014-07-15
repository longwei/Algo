package algoHw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Median {

	/**
	 * @param args
	 */
	static PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>(10,Collections.reverseOrder());
	
	public static int return_median(Integer newAdd){
		if(rightMinHeap.size() == 0) {
			rightMinHeap.add(newAdd);
			return newAdd;
		}
		if( newAdd < rightMinHeap.peek()){
			leftMaxHeap.add(newAdd);
		} else {
			rightMinHeap.add(newAdd);
		}
		//rebalance
		if(leftMaxHeap.size() - rightMinHeap.size() > 1){
			rightMinHeap.add(leftMaxHeap.remove());
		}
		if(rightMinHeap.size() > leftMaxHeap.size()){
			leftMaxHeap.add(rightMinHeap.remove());
		}
		return leftMaxHeap.peek();
	}
	
	public static void main(String[] args) throws IOException {
//		int[] input = {8, 1, 9, 2, 3, 4, 5, 6, 7};
		
		BufferedReader br = new BufferedReader(new FileReader("input/Median.txt"));
		String line;
		int m = 0;
		while ((line = br.readLine()) != null) {
			int input = Integer.parseInt(line);
			m += return_median(input);
		}
		System.out.print(m % 1000);
		br.close();

	}

}
