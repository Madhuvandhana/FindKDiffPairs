package interviewQuestions;
import java.util.*;
import java.util.Map.Entry;

public class Kdifference {

	static int countPairsWithDiffK(int arr[],  
            int n, int k) { 
		int count = 0; 
		Arrays.sort(arr);
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++)   {
			for (int j = i + 1; j < n; j++) {
				if ((arr[i] - arr[j] >= 0 && arr[i] - arr[j] == k) || 
				(arr[j] - arr[i] >= 0 &&  arr[j] - arr[i] == k)) {
				if(!set.contains(arr[j]) ) {
				set.add(arr[j]);
				count++; 
				}
				}
			}
		}
		return count; 
} 
	static int countPairsWithDiffOptimised(int arr[],  
            int n, int k) { 
		int count =0;
		   Map<Integer, Integer> m = new TreeMap<Integer, Integer>(); 
		   for (int i = 0; i < n; i++) 
	        { 
	   
	            if (!m.containsKey(arr[i])) 
	            { 
	                m.put(arr[i], 1); 
	       
	            } 
	  
	            else m.put(arr[i], m.get(arr[i]) + 1); 
	        }
	            for (Entry<Integer, Integer> mp:m.entrySet()) 
	            { 
	            	System.out.println(mp.getKey());
	            	if(k == 0 && mp.getValue() > 1) {
	            		count++;
	            	}
	            	else if(k > 0 && m.containsKey(mp.getKey() + k)) {
	            		count++;
	            	}
	            }
	            return count;
	
	}

// Driver code 
public static void main(String args[]) 
{ 
int arr[] = { 3,1,4,1,5}; 
int k = 2; 
//int arr[] = {1,2,3,4,5};
//int k = -1;
int n = arr.length; 

System.out.println("Count of pairs with given diff is "
+ countPairsWithDiffOptimised(arr, n, k)); 
} 

}
