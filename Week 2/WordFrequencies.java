
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class WordFrequencies {

    private ArrayList<String> myWords ;
    private ArrayList<Integer> myFreqs ;
    
    public WordFrequencies(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer> ();
    }
    
    public void findUnique(){
        myWords.clear();
        
        FileResource file = new FileResource();
        
        for(String s : file.words()){
            s = s.toLowerCase();
            int idx = myWords.indexOf(s);
            
            if(idx == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(idx);
                myFreqs.set(idx,freq+1);
            }
        }
    }
    
    public int findMax(){
        int mostCommon = myFreqs.get(0);
        int mostCommonIndex = 0;
        
        for (int k = 0; k < myFreqs.size(); k++){
            if(myFreqs.get(k) > mostCommon){
                mostCommon = myFreqs.get(k);
                mostCommonIndex = k;
            }
        }
        return mostCommonIndex;
    }
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        System.out.println(myWords);
        int index = findMax();
        System.out.println("max word/freq: "+myWords.get(index)+" / "+myFreqs.get(index));
    }
    
}
