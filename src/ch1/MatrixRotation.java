package ch1;
/*
 * rotate image by 90 degree
 */
import java.util.Arrays;

public class MatrixRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] matrix = {
			      { 1, 2, 3, 4, 5},
			      { 1, 2, 3, 4, 5},
			      { 1, 2, 3, 4, 5},
			      { 1, 2, 3, 4, 5},
			      { 1, 2, 3, 4, 5},
			    };
//		 for(int[] row : matrix){
//			 System.out.println(Arrays.toString(row));
//		 }
		 rotate(matrix, 5);
		 for(int[] row : matrix){
			 System.out.println(Arrays.toString(row));
		 }
	}
	
	public static void rotate(int[][] matrix, int n){
		for(int layer = 0; layer < (n/2); ++layer){
			int first = layer;
			int last = n - 1 - first;
			for(int i = first; i < last; i++){
				int mirror_i = first + last - i;
				int top = matrix[first][i];
				matrix[first][i] = matrix[mirror_i][first];
				matrix[mirror_i][first] = matrix[last][mirror_i];
				matrix[last][mirror_i] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
	// * * * * * *
	// * * * * * *
	// * * * * * *
	// * * * * * *
	// * * * * * *
	// * * * * * *
	
	public static void rotate1(int[][]matrix, int n){
		//power of 2 first
		for(int layer = 0; layer < (n/2); ++layer){
			int first = layer;
			int last = n - first -1;
			for(int i = first; i < last; i++){
				int mirror_i = last - i + first;
			}
		}
	}

}
