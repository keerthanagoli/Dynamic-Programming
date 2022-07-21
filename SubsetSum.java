import java.util.*;

class SubsetSum {
	
	public int calSubsetSumRec(int target,int index,int[]input,int[][] dp) {
		if(target == 0)
			return 1;
		if(target<0 || index == input.length)
			return 0;
		else 
			dp[index][target] = calSubsetSumRec(target-input[index],index+1,input,dp) + calSubsetSumRec(target,index+1,input,dp);	
		return dp[index][target];
	}
	
	
	public static void main(String args[]) {
		SubsetSum sm = new SubsetSum();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input size");
		int n = sc.nextInt();
		int input[] = new int[n];
		System.out.println("Enter array");
		for(int i=0;i<n;i++)
			input[i] = sc.nextInt();
		System.out.println("enter the target sum");
		int target = sc.nextInt();
		int dp[][] = new int[input.length][target+1];
		System.out.println(sm.calSubsetSumRec(target,0,input,dp));	
	}
	
}
