import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class question_1 {

    
    //public static void miniMaxSum(List<Integer> arr) 
	
	public static void main(String [] agrs )
    
    {
		List<Integer> arr = new ArrayList<Integer>();
    
       Collections.sort(arr);
       
       long maxValue=0;
       long minValue=0;
       long minCount=0;
       long maxCount=0;
       for(int i=0;i<arr.size()-1;i++)
       {
          minCount= minCount+arr.get(i);
       } 
       for(int j=1;j<arr.size();j++)
       {
           maxCount= maxCount+arr.get(j);
       }
    System.out.println(+minCount+" "+maxCount);

    }

}
