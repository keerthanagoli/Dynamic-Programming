package main.java;
import java.util.*;

public class EditDistance {
	
	int findCostRec(String word1, String word2, int index1,int index2,int[][] dp) {
		
		if(index1 == word1.length())
			return word2.length()-index2;
		else if(index2 == word2.length())
			return word1.length()-index1;
			
		else if(word1.charAt(index1) == word2.charAt(index2))
			dp[index1][index2] = findCostRec(word1,word2,index1+1,index2+1,dp);
		
		else 
			dp[index1][index2] = 1+ Math.min(findCostRec(word1,word2,index1,index2+1,dp),Math.min(findCostRec(word1,word2,index1+1,index2+1,dp),findCostRec(word1,word2,index1+1,index2,dp)));
		return dp[index1][index2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the two strings");
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String word2 = sc.next();
		EditDistance ed = new EditDistance();
		int dp[][] = new int[word1.length()][word2.length()];
		for(int i=0;i<dp.length;i++)
			Arrays.fill(dp[i], -1);
		System.out.println("Edit distnace "+ed.findCostRec(word1, word2, 0,0,dp));
		

	}

}
