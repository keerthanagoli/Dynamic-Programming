package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class GoldMine2 {
	
	int calCostRec(int[][]input,int i,int j,int[][] dp) {
		if(i == 0)
			return input[i][j];
		else if(dp[i][j] !=-1)
			return dp[i][j];
		else if(j==0 && i > 0)
			return input[i][j] + Math.max(calCostRec(input,i-1,j,dp), calCostRec(input,i-1,j+1,dp));
		else if(j==input[0].length -1 && i>0)
			return input[i][j] + Math.max(calCostRec(input,i-1,j,dp), calCostRec(input,i-1,j-1,dp));
		else 
			return input[i][j] + Math.max(calCostRec(input,i-1,j,dp), Math.max(Math.max(calCostRec(input,i-1,j+1,dp),calCostRec(input,i-1,j-1,dp)),calCostRec(input,i-1,j,dp)));
		
		
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
		int dp[][] = new int[rows][cols];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		GoldMine2 pm = new GoldMine2();
		int max = Integer.MIN_VALUE;
		for(int i=0;i<inputArray.length;i++) {
			int result = pm.calCostRec(inputArray,rows-1,i,dp);
			max = result>max?result:max;
		}
		
		System.out.println("Total no of ways "+max);
	}

}
