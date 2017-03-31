package scott;

import java.util.Arrays;

public class OptimalArrayCompare {
	
	public void executeArrayComparison(){
    	
    	int[] a1 = new int[]{1,3,5,7,9,11,13,15,17,19,21,23};
    	int[] a2 = new int[]{2,4,6,8,10,12,14,16,18,23};
    	
    	// runs at O(n)+O(log(n))
    	long t1 = System.currentTimeMillis();
    	for(int iA1 : a1){
    		int[] subArray = getSubarray(a2,iA1);
    		if(subArray.length <= 2){
    			printValue(subArray,iA1);
    		}else{
    			System.out.println("Hmmm, something went wrong here... failed to converge");
    		}
    	}
    	long t2 = System.currentTimeMillis();
    	
    	System.out.println("Total time is: " + (t2-t1));
    	
    	
    	// runs at O(a(n)xb(n))
    	t1 = System.currentTimeMillis();
    	for(int iA1 : a1){
    		for(int iA2 : a2){
    			if(iA1 == iA2){
    				System.out.println("Found a matching pair : " + iA1);
    			}
    		}
    	}
    	t2 = System.currentTimeMillis();
    	
    	System.out.println("Total time is: " + (t2-t1));
    }
    
    private int[] getSubarray(int[] arrayIn, int targetValue){
    	int midIndex = arrayIn.length/2;
    	
    	if(arrayIn[midIndex] == targetValue){
    		return new int[]{targetValue};
    	}else if(arrayIn.length <= 2){
    		return arrayIn;
    	}else if(arrayIn[midIndex] > targetValue){
    		return getSubarray(Arrays.copyOfRange(arrayIn, 0, midIndex),targetValue);
    	}else{
    		//(arrayIn[midIndex] < targetValue)
    		return getSubarray(Arrays.copyOfRange(arrayIn, midIndex,arrayIn.length),targetValue);
    	}
    }
    
    private void printValue(int[] a2, int iA2){
    	for(int i : a2){
			if(i == iA2){
				System.out.println("Found a matching pair : " + i);
			}
		}
    }
    
    public static void main(String[] args){
    	OptimalArrayCompare oac = new OptimalArrayCompare();
    	oac.executeArrayComparison();
    }
}
