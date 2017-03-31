package scott;

import java.util.Hashtable;
import java.util.Set;

public class AnagramSolution {

	public void runSolution(){
		String thingOne = "kbbzbbtvzk";
		String thingTwo = "wkrbbzippy";
		
		Hashtable<String,Integer> countOne = getThingCounts(thingOne);
		Hashtable<String,Integer> countTwo = getThingCounts(thingTwo);
		
		System.out.println(countOne);
		System.out.println(countTwo);
		
		Set<String> letters = countOne.keySet();
        for(String letter : letters){
            if(countTwo.containsKey(letter)){
            	int countValOne = countOne.get(letter).intValue();
            	int countValTwo = countTwo.get(letter).intValue();
            	
            	if(countValOne>countValTwo){
            		System.out.println(countValTwo);
            	}else{
            		System.out.println(countValOne);
            	}
            }
        }
	}
	
	private Hashtable<String,Integer> getThingCounts(String input){
		
		Hashtable<String,Integer> returnHashtable = new Hashtable<String,Integer>();
		
		for(String letter : input.toLowerCase().split("")){
			if(!returnHashtable.containsKey(letter)){
				returnHashtable.put(letter, new Integer(1));
			}else{
				returnHashtable.replace(letter, new Integer(returnHashtable.get(letter).intValue() + 1));
			}
		}
		
		return returnHashtable;
	}
	
	public static void main(String[] args){
		AnagramSolution as = new AnagramSolution();
		as.runSolution();
	}
}
