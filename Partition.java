import java.util.*;
public class Partition {
	
	boolean calcPartitionRec(int[] input,int index, int sum1, int sum2) {
		if(index == input.length ) {
			return sum1 == sum2;
		}
		else 
			return calcPartitionRec(input,index+1,sum1+input[index],sum2) || calcPartitionRec(input,index+1,sum1,sum2+input[index]);
	}
	
	boolean subsetSum(int[] input,int target,int index,boolean[][] dp ) {
		if(target==0)
			return true;
		else if(target<0 || index == input.length)
			return false;
		else 
			dp[index][target] = subsetSum(input,target-input[index],index+1,dp) || subsetSum(input,target,index+1,dp);
		return dp[index][target];
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		Partition pt = new Partition();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int input[] = new int[size];
		for(int i=0;i<size;i++)
			input[i] = sc.nextInt();

		System.out.println("Result is "+pt.calcPartitionRec(input,0,0,0));
		
		System.out.println("Another way of working");
	int sum = 0;
	for(int i=0;i<input[i];i++)
		sum+=input[i];
	
	if(sum%2!=0)
		System.out.println("Will not have two subsets");
	else {
		boolean dp[][] = new boolean[input.length][sum/2+1];
		System.out.println(pt.subsetSum(input,sum/2,0,dp));
	}
		
	

	}

}
