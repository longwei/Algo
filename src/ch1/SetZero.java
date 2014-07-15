package ch1;
/*
 * 1.7 if a element is M*N matrix is 0, set row and column to 0
 */
public class SetZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void setZero(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; ++i){
			for(int j =0; j < matrix[0].length; ++j){
				if(matrix[i][i] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i = 0; i < matrix.length; ++i){
			for(int j =0; j < matrix[0].length; ++j){
				if(row[i] || column[j]){
					matrix[i][j] =0;
				}
			}
		}
	}
}
