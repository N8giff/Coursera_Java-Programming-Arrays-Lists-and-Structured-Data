
/**
 * Write a description of Words_in_Files here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.File;
import java.util.*;

public class Words_in_Files {

    private HashMap<String, ArrayList<String>> myMap;
    
    public Words_in_Files(){
        myMap = new HashMap<String, ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        String fileName= f.getName();
        
        for(String word : fr.words()){
            if(!myMap.containsKey(word)){
                ArrayList<String> list = new ArrayList<String>();
                list.add(fileName);
                myMap.put(word,list);
            }
            else if(myMap.containsKey(word) && !myMap.get(word).contains(fileName)){
                ArrayList<String> currList = myMap.get(word);
                currList.add(fileName);
                myMap.put(word,currList);
            }
        }
    }
    
    public void buildWordFileMap(){
        myMap.clear();
        
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    public int maxNumber(){
        int maxNumber = 0;
            for(String word : myMap.keySet()){
                ArrayList<String> currFile = myMap.get(word);
                int currNumber = currFile.size();
                
                if(currNumber > maxNumber){
                    maxNumber = currNumber;
                }
            }
        return maxNumber;
    }
    
    public ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> answer = new ArrayList<String>();
        
        for(String word : myMap.keySet()){
                ArrayList<String> currFile = myMap.get(word);
                int currNumber = currFile.size();
                
                if(currNumber == number){
                    answer.add(word);
                }
            }
        return answer;
    }
    
    public void printFilesIn(String word){
        ArrayList<String> fileNames = myMap.get(word);
        for(int index = 0; index < fileNames.size(); index ++){
             System.out.println(fileNames.get(index));   
            }
    }
    
    public void tester() {
        buildWordFileMap();
        
        int fileNum = maxNumber();
        System.out.println("Max number files: " + fileNum);

        ArrayList<String> wordsInFiles = wordsInNumFiles(fileNum);
        System.out.println("Total words in all files: " + wordsInFiles.size());
        
        wordsInFiles = wordsInNumFiles(4);
        System.out.println("Total words in four files: " + wordsInFiles.size());
        
        printFilesIn("laid");
        System.out.println("\n");
        printFilesIn("tree");
    }
}
