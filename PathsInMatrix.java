package main.java;

import java.util.Scanner;

public class PathsInMatrix {
	int noOfWaysRec(int input[][],int i,int j) {
		if(input[i][j] == 1)
			return 0;
		if(i==0 && j==0)
			return 1;
		else if(i==0)
			return noOfWaysRec(input,i,j-1);
		else if(j==0)
			return noOfWaysRec(input,i-1,j);
		else 
			return noOfWaysRec(input,i-1,j) + noOfWaysRec(input,i,j-1);
			
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows ");
		int rows = sc.nextInt();
		System.out.println("Enter the number of cols ");
		int cols = sc.nextInt();
		
		System.out.println("Enter the matrix");
		int inputArray[][] = new int[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				inputArray[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
		System.out.println("Entered matrix");
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(inputArray[i][j]+" ");
			}
			System.out.println();
		}
		PathsInMatrix pm = new PathsInMatrix();
		int result = pm.noOfWaysRec(inputArray,rows-1,cols-1);
		System.out.println("Total no of ways "+result);
	}
	

}
