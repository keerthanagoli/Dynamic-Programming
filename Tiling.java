package main.java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class Tiling {
	static HashMap<Integer,Integer> hp = new HashMap<>();
	
	static int noOfWays = 0;
	static int dp[] = new int[noOfWays];
	
	public static int countWays(int n) {
		
	if(n<=2)
		hp.put(n,n);
	if(hp.containsKey(n))
		return hp.get(n);
	else {
		int result = countWays(n-1) + countWays(n-2);
		hp.put(n, result);
	}
	
	return hp.get(n);
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the n value in 2*n");
		Scanner sc = new Scanner(System.in);
		noOfWays = sc.nextInt();
		//Arrays.fill(dp, -1);
		System.out.println(countWays(noOfWays));

	}

}
