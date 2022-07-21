package main.java;

import java.util.Scanner;

public class GoldMine {
	static int rows=0;
	static int cols =0;
	static int mine[][] = new int[rows][cols];
	
	public static int digMine(int[][] mine) {
		int maxSoFar = Integer.MIN_VALUE;
		int dp[][] = new int[mine.length][mine[0].length];
		for (int i=0;i<dp.length;i++) 
			dp[i][dp[0].length-1] = mine[i][mine[0].length-1];	
		
		for(int j=dp[0].length-2;j>=0;j--) {
			for(int k=0;k<dp.length;k++) {
				if(k==0) {
					int maxValue = Math.max(dp[k][j+1], dp[k+1][j+1]);
					dp[k][j] = mine[k][j]+maxValue;
				}
				else if(k==dp.length-1) {
					dp[k][j] = mine[k][j]+ Math.max(dp[k][j+1], dp[k-1][j+1]);
				}
				else {
					dp[k][j] = mine[k][j]+ Math.max(dp[k][j+1], Math.max(dp[k-1][j+1],dp[k+1][j+1]));
				}
				if(dp[k][j]>maxSoFar)
					maxSoFar = dp[k][j];
				}
			}
		
			for (int i=0;i<mine.length;i++) {
				for(int j=0;j<mine[0].length;j++) {
					System.out.print(dp[i][j]+ " ");
				}
				System.out.println();
			}
		return maxSoFar;	
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Lets start Gold Mine");
		System.out.println("Enter the number of rows ");
		rows = sc.nextInt();
		System.out.println("Enter the number of col ");
		cols = sc.nextInt();
		mine= new int[rows][cols];
		
		System.out.println("Enter the array in row  press new line for next row  ");
		
		for(int i=0;i<rows;i++) {
			for (int j=0;j<cols;j++) {
				mine[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		int result = digMine(mine);
		System.out.println("Cost is "+result);
	}

}
