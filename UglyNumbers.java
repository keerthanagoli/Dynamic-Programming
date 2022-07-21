package main.java;
import java.util.*;



public class UglyNumbers {
	
	/* My solution */
	public int getUglyNumber(int n) {
	
		HashMap<Integer,Boolean> hp = new HashMap<>();
		hp.put(0, true);
		hp.put(1, true);
		int count =1;
		int result = 1;
		int i=2;
		while(count <=n) {
			if(i%2==0) {
				hp.put(i, hp.get(i/2));
				if(hp.get(i)) {
					++count;
					result = i;
				}
			}
			else if(i%3 ==0) {
				hp.put(i, hp.get(i/3));
				if(hp.get(i)) {
					++count;
					result = i;
				}
				
			}
			else if(i%5 ==0) {
				hp.put(i, hp.get(i/5));
				if(hp.get(i)) {
					++count;
					result = i;
				}
			}
			else {
				hp.put(i, false);
			}
			i++;
		}
		return result;
	}
	
	private int getMin(int a , int b,int c) {
		int min =a;
		if(b<a && b<c) 
			min=b;
		if(c<a && c<b)
			min=c;
		return min;
	}
	
	/*GFG Solution Dynamic Programming*/ 
	
	public int getUglyNumber2(int n) {
		
		int ugly[] = new int[n+1];
		ugly[0] =1;
		int i2 = 0,i3 =0,i5 = 0;
		int nexti2 = ugly[i2]*2;
		int nexti3 = ugly[i3]*3;
		int nexti5 = ugly[i5]*5;
		for(int i=1;i<ugly.length;i++) {
			ugly[i] = Math.min(nexti2, Math.min(nexti3, nexti5));
			if(ugly[i] == nexti2) {
				++i2;
				nexti2=ugly[i2]*2;
			}
			if(ugly[i] == nexti3) {
				++i3;
				nexti3 = ugly[i3]*3;
			}
			if(ugly[i] == nexti5) {
				++i5;
				nexti5 = ugly[i5]*5;
			}
		}
		return ugly[n-1];
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UglyNumbers ug = new UglyNumbers();
		//int n = ug.getUglyNumber(150);
		//System.out.println("Ugly number n "+n);
		int x = ug.getUglyNumber2(7);
		System.out.println("Ugly number n "+x);

	}

}
