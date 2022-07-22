import java.util.*;
public class Decode {
	int calDecodeWaysRec(String decodeString, int index,int[] dp) {
		if(dp[index]!=0)
			return dp[index];
		else if(index == 0)
			dp[index] =1;
		else {
			int decodeValue =0;
			String subs = decodeString.substring(index-1, index+1);
			int a = Integer.parseInt(subs);
			System.out.println(a);
			if(decodeString.charAt(index) =='0'||a>26 || subs.charAt(0) == '0')
				decodeValue =0;
			else 
				decodeValue =1;
			dp[index]=decodeValue + calDecodeWaysRec(decodeString,index-1,dp);
				
		}
		return dp[index];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string to decode ");
		String decodeString = sc.next();
		Decode ds = new Decode();
		int dp[] = new int[decodeString.length()];
		System.out.println("Total no of ways to decode is "+ds.calDecodeWaysRec(decodeString,decodeString.length()-1,dp));
	} 

}
