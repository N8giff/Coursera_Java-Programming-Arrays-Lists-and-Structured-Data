
/**
 * Write a description of Codon_Count here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class Codon_Count {
    private HashMap<String, Integer> myMap;
    
    public Codon_Count(){
        myMap = new HashMap<String, Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        myMap.clear();
        
        for(int index = start; dna.length() - index > 3; index += 3){
            String currCodon = dna.substring(index, index +3);
            if(!myMap.containsKey(currCodon)){
                myMap.put(currCodon, 1);
            }
            else{
                myMap.put(currCodon, myMap.get(currCodon) +1);
            }
        }
    }
    
    public String getMostCommonCodon(){
        int currMax = 0;
        String mostCommon = "";
        
        for(String s : myMap.keySet()){
            int currCount = myMap.get(s);
            if(currCount > currMax){
                mostCommon = s;
                currMax = currCount;
            }
        }
        return mostCommon;
    }
    
    public void printCodonCounts(int start, int end){
        System.out.println("Codons that occur between " + start + " and " + end + " times:");
        for(String s : myMap.keySet()){
            int currCount = myMap.get(s);
            if(currCount >= start && currCount <= end){
                System.out.println(s);
            }
        }
    }
    
    public void tester(){
        FileResource file = new FileResource();
        String dna = file.asString();
        dna = dna.trim();
        dna = dna.toUpperCase();
        
        for(int index = 0; index <=2; index ++){
            System.out.println("\n Start position " + index + ":\n");
            buildCodonMap(index, dna);
            
            String mostCommon = getMostCommonCodon();
            
            System.out.println("Number of unique codons: " + myMap.size());
            System.out.println("\nMost common codon: " + mostCommon
                    + "\t" + myMap.get(mostCommon));
                    
            printCodonCounts(7, 7);
        }
        
    
    
    }
}
