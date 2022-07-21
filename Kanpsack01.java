import java.util.*;
public class Kanpsack01 {
	
	public int calknapsackRec(int[] weights,int[] values, int maxWeight, int index) {
		if(index == weights.length)
			return 0;
		if(maxWeight < weights[index])
			return calknapsackRec(weights,values,maxWeight,index+1);
		else 
			return Math.max((values[index] + calknapsackRec(weights, values,maxWeight-weights[index],index+1)),calknapsackRec(weights, values,maxWeight,index+1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the max target weight");
		int maxWeight = sc.nextInt();
		System.out.println("Enter the size of kanpsack");
		int size = sc.nextInt();
		int[] weight = new int[size];
		int[] values = new int[size];
		System.out.println("Enter the array of weights");
		for(int i=0;i<size;i++)
			weight[i] = sc.nextInt();
		System.out.println("Enter the array of values");
		for(int i=0;i<size;i++)
			values[i] = sc.nextInt();
		Kanpsack01 ks = new Kanpsack01();
		int result = ks.calknapsackRec(weight,values,maxWeight,0);
		System.out.println(result);
	}

}
