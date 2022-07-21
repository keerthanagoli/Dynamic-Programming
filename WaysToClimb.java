package main.java;
import java.util.*;
public class WaysToClimb {
	
	int calcPathRec(int[] input,int index) {
		
		if(index == 0) 
			return 1;
			
		else {
			int sum =0;
			for(int i=0;i<input.length;i++) {
				if(index-input[i] >=0) {
					sum+=calcPathRec(input,index-input[i]);
					
				}
			}
			return sum;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of possibilities");
		int n = sc.nextInt();
		System.out.println("Enter the target");
		int target = sc.nextInt();
		int input[] = new int[n];
		System.out.println("Enter the possibilities");
		for(int i=0;i<n;i++)
			input[i] = sc.nextInt();
		WaysToClimb wb = new WaysToClimb();
		System.out.println("Total no of ways "+wb.calcPathRec(input,target));
	}

}
