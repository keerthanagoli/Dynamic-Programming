package main.java;
import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
	
	int amount;
	int denominations[];
	
	CoinChange(int amount, int denom[]) {
		this.amount = amount;
		this.denominations = denom;
	}
	
	public int findTotalWays() {
		int ways[] = new int[amount+1];
		
		Arrays.fill(ways, 0);
		ways[0]=1;
		for(int denom:denominations) {
		 for(int i=1; i<ways.length;i++) {
			 //This allows not to count duplicates like 3-2 -> {2,1} and 3-1 ->{1,2} 
			 if(denom<=i) {
				ways[i]+=ways[i-denom];
			 }
		 }
		}
		return ways[amount];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the value ");
	int amt= sc.nextInt();
	System.out.println("Enter the length of denomination array ");
	int lenden = sc.nextInt();
	int way[] = new int[lenden];
	for (int i=0;i<way.length;i++) {
		way[i] = sc.nextInt();
	}
	CoinChange ch = new CoinChange(amt,way);
	int result = ch.findTotalWays();
	System.out.println("Total number of ways "+result);   
	}
}
