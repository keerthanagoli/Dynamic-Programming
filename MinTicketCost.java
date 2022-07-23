
import java.util.*;
public class MinTicketCost {
	
	
	int calCostRec(int[] trainDays, int[] cost, int n, int day,HashMap<Integer,Boolean> hp) {
		if(day>=n)
			return 0;
		else if(!hp.containsKey(day))
			return calCostRec(trainDays,cost,n,day+1,hp);
		else 
			return Math.min(cost[0]+calCostRec(trainDays,cost,n,day+1,hp),Math.min(cost[1]+calCostRec(trainDays,cost,n,day+7,hp), cost[2]+calCostRec(trainDays,cost,n,day+30,hp)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of trip days");
		int n = sc.nextInt();
		System.out.println("Enter total number of train days");
		int len = sc.nextInt();
		 int[] trainDays = new int[len];
		 System.out.println("Enter the train days");
		 HashMap<Integer,Boolean> hp = new HashMap<Integer,Boolean>();
		 for(int i=0;i<len;i++) {
			 trainDays[i] = sc.nextInt();
			 hp.put(trainDays[i], true);
		 }
		 System.out.println("Enter the cost for 1 , 7 and 30  days");
		 int cost[] = new int[3];
		 for(int i=0;i<3;i++)
			 cost[i] = sc.nextInt();
		 
		 
		 MinTicketCost mt = new MinTicketCost(); 
		 System.out.println("Minimum cost to get into train is "+ mt.calCostRec(trainDays,cost,n,0,hp));

	}

}
