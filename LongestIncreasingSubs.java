import java.util.*;
public class LongestIncreasingSubs {
	
	/*More in terms of knapsack*/
	public int lcs(int[] array, int index, int prev) {
		if(index == array.length)
			return 0;
		else if(array[index]<= prev)
			return lcs(array,index+1,prev);
		else 
			return Math.max(1+lcs(array,index+1,array[index]), lcs(array,index+1,prev));
	}
	
	/*proper dynamic problem*/
	 public int dplcs(int[] input) {
		 int[] dp = new int[input.length];
		 dp[0] =1;
		 int max =0;
		 for(int i=1;i<dp.length;i++) {
			 max = 0;
			 for(int j=i-1;j>=0;j--) {
				 System.out.print("Input i " +input[i] + "Input j "+input[j]);
				 System.out.println("");
				 if(input[i] > input[j] && dp[j] >max) {
					 System.out.println("Max is "+max);
					 System.out.println("DP is "+dp[j]);
					 max = dp[j];
				 }
			 }
			 dp[i] = 1+max;
		 }
		 max =0;
		 for(int i=0;i<dp.length;i++) {
			 System.out.print(dp[i]+" ");
			 if(dp[i]>max)
				 max = dp[i];
		 }
		 return max;
	 }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array");
		int size = sc.nextInt();
		int input[] = new int[size];
		for(int i=0;i<input.length;i++) {
			input[i] = sc.nextInt();
		}
		LongestIncreasingSubs sb = new LongestIncreasingSubs();
		System.out.println("Longest common subs " +sb.dplcs(input));

}
}
