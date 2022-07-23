import java.util.Scanner;

public class SquareMatrix1 {

	int recMatrix(int[][] input,int i,int j) {
		if(i<0 || j<0 || input[i][j] == 0)
			return 0;
		else 
			return 1+ Math.min(recMatrix(input,i-1,j-1), Math.min(recMatrix(input,i,j-1), recMatrix(input,i-1,j)));
	}
	
	int calcMaxArea(int[][] matrix) {
		int max =0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				max  = Math.max(max,  recMatrix(matrix,i,j));
				System.out.println(max);
			}
		}
		return max*max;	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows ");
		int rows = sc.nextInt();
		System.out.println("Enter the number of cols ");
		int cols = sc.nextInt();
		
		System.out.println("Enter the matrix");
		int inputArray[][] = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				inputArray[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		System.out.println("Entered matrix");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(inputArray[i][j]+" ");
			}
			System.out.println();
		}
		SquareMatrix1 pm = new SquareMatrix1();
		int result = pm.calcMaxArea(inputArray);
		System.out.println("Total no of ways "+result);
		

	}

}
