package main.java;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

	int lcs(String s1, String s2,int i,int j,int dp[][]) {
		
		if(i>=s1.length() || j>=s2.length())
			return 0;
		if(dp[i][j] !=-1)
			return dp[i][j];
		else if(s1.charAt(i) == s2.charAt(j)) 
			dp[i][j] = 1+lcs(s1,s2,i+1,j+1,dp);
		
		else 
			dp[i][j] = Math.max(lcs(s1,s2,i+1,j,dp), lcs(s1,s2,i,j+1,dp));
		return dp[i][j];
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two strings ");
		String s1 = sc.next();
		String s2 = sc.next();
		System.out.println(s1);
		System.out.println(s2);
		int[][] dp = new int[s1.length()][s2.length()];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], -1);
		LongestCommonSubsequence sq = new LongestCommonSubsequence();
		System.out.println(sq.lcs(s1, s2,0,0,dp));
		
	}

}
