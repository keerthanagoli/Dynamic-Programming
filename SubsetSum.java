package main.java;
import java.util.*;

public class SubsetSum {

	int targetSum;
	int[] inputArray;
	
	SubsetSum(int targetSum, int[] inputArray) {
		this.targetSum = targetSum;
		this.inputArray = inputArray;
	}
	
	public boolean checkSum() {
		
		boolean dp[][] = new boolean[inputArray.length][targetSum+1];
		dp[0][0] = true;
		for (int i=1;i<dp[0].length;i++) {
			dp[0][i] = false;
		}
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
			 if(inputArray[i] > j)
				 dp[i][j] = dp[i-1][j];
			 else {
				 dp[i][j] = dp[i-1][j] || dp[i-1][j-inputArray[i]];
			 }
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[inputArray.length-1][targetSum];
		
	}
	
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the target sum ");
	int targetSum = sc.nextInt();
	System.out.println("Enter the length of array");
	int len = sc.nextInt();
	int subsetArray [] = new int[len+1];
	subsetArray[0] = 0;
	System.out.println("Enter the elements");
	for (int i=1;i<len+1;i++) {
		subsetArray[i] = sc.nextInt();
	}
	SubsetSum sm = new SubsetSum(targetSum,subsetArray);
	System.out.println("Result is "+sm.checkSum());
}
}
