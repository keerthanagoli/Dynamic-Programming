package main.java;

import java.util.Scanner;

/*
 * 1)When nth number gets in , it is either added as indiviual member hence no of ways = f(n-1)
 * 2)When nth number is added , it gets paired with remaining n-1 (n-1)f(n-2)
 * Recurrence relation f(n) = f(n-1) + (n-1)f(n-2)
 */

public class FriendPairing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of friemds to pair");
		int n = sc.nextInt();
		 int dp[] = new int[n+1];
		 dp[0] = 1;
		 dp[1] = 1;
		 for(int i=2;i<dp.length;i++) {
			 dp[i] = dp[i-1] + (i-1)*dp[i-2];
		 }
		System.out.println(dp[n]);
	}

}
