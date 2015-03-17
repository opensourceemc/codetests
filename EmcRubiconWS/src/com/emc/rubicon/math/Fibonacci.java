/**
 * @author Ryan.Swenson
 *
 */
package com.emc.rubicon.math;
import java.util.EmptyStackException;


public class Fibonacci {
	
	String result ="";
	
	public String Fib(Integer n) {
		
		if ( n<0) {
			 throw new EmptyStackException();
		}
		
		if (n==0) {
			result =n+" for input is not allowed. Please provide a non-negative whole number greater than 0. Thank you";
		} else if (n>0) {
			
			for (int i=0; i<=n-1; i++) {
				//System.out.println(ProduceFibonacci(i)+"");
				if (i<n) {
				result = result + ProduceFibonacci(i) +" ";
				} else if (i==(n-1)) {
					result = result + ProduceFibonacci(i);
				}
			
			}
		}
		result = disposeLastChar(result);
		System.out.println(result);		
		return result+"\n";
	}
	private static int ProduceFibonacci(int n) {
		
		if (n ==1 || n==2) {
			return 1;
		}
		if (n ==0) {
			return 0;
		}
		
		return ProduceFibonacci(n-1) + ProduceFibonacci(n-2);
		
	}
	
	private static String disposeLastChar(String result) {
        return result.substring(0,result.length()-1);
    }

}
