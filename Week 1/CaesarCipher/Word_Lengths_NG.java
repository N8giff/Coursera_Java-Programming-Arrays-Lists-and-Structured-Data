
/**
 * Write a description of Word_Lengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Word_Lengths_NG
 {
    
    public int indexOfMax(int [] values){
        int maxCount = 0;
        int index = 0;
        
        for(int i = 1; i<values.length; i++){
            if(values[i]>maxCount){
                maxCount = values[i];
                index = i;
                //System.out.println("max is : " + max);
                //System.out.println("index is : " + index);
            }
        }
        return index;
    }
    
    public void countWordLengths(FileResource resource, int[] counts){
        
        for(String word : resource.words()){
            word = word.toLowerCase();
            
            //get rid of first and last characters if not letters
            if(!Character.isLetter(word.charAt(0))){
                word = word.substring(1);
            }
            
            int idxLength = (word.length() -1);
            
            if(!Character.isLetter(word.charAt(idxLength))){
                word = word.substring(0,idxLength);
            }
            
            System.out.println(word);
            
            //get word length and add to count
            int currLength = word.length();
            
            counts[currLength] += 1;
        } 
        
        int max = indexOfMax(counts);
        
        System.out.println("//      //      //      //      //");
        System.out.println("The most common word length is " + max);
    }
    
    public void testWordLengths(){
        FileResource resource = new FileResource();
        
        int[] counts = new int[31];
        
        countWordLengths(resource, counts);

    }
    
    
}
