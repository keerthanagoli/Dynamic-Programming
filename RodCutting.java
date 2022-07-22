import java.util.*;
public class RodCutting {

	int rodCutRec(int[] input,  int len) {
		if(len ==0)
			return 0;
		else {
			int max = 0;
			for(int i=1; i<=len;i++) {
				int res = input[i]+rodCutRec(input,len-i);
				max = max<res?res:max;
			}
			return max;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the rod length ");
		int length = sc.nextInt();
		System.out.println("Enter the price  of each length ");
		int input[] = new int[length+1];
		for(int i=0;i<input.length;i++) {
			input[i] = sc.nextInt();
		}
		RodCutting rc = new RodCutting();
		
		System.out.println("Maximun profit of cutting rods of length is "+rc.rodCutRec(input, length));

	}

}
