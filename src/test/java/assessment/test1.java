package assessment;

import java.util.Scanner;

import org.testng.annotations.Test;

public class test1 {
	
	@Test 
	void minMax()
	
	{
		int arr[] = new int[5];
		
		//Scanner read = new Scanner(System.in);
		//System.out.println("Please enter number");
		//int num = read.nextInt();
		
		
		int min = arr[0]; //5
		int max = arr[0]; //5
		int total = 0;
		
		for (int n: arr)
		{
			total = total+n; 
			//total=+n;
			
			if (n < min) min =n;
			if (n > max) max = n;
				
			
		}
		
		System.out.println("miniMinSum = "+(total-min) +" "+ "miniMaxSum = "+ (total-max));
		
	}
	

}
