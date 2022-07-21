package main.java;

import java.util.Scanner;

public class HouseRoberry {
	
	
	
	int calCost(int[] costArray,int i,int[] dp) {
		
		if(dp[i] !=-1)
			return dp[i];
		if(i==0 || i==1)
			dp[i] = costArray[i];
		else 
			dp[i]=Math.max(costArray[i] + calCost(costArray,i-2,dp), calCost(costArray,i-1,dp));
		
		return dp[i];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of houses");
		int n = sc.nextInt();
		int[] costArray = new int[n];
		System.out.println("Enter the cost in each house");
		for(int i=0;i<n;i++)
			costArray[i]= sc.nextInt();
		int[] dp = new int[n];
		for(int i=0;i<n;i++) 
			dp[i] = -1;
		HouseRoberry hb = new HouseRoberry();
		System.out.println("Max amount robbed is "+hb.calCost(costArray,n-1,dp));	
	}

}
