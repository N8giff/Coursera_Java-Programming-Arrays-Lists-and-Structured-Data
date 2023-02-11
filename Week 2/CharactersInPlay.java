
/**
 * Write a description of characterNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class charactersInPlay {
    private ArrayList<String> names;
    private ArrayList<String> names2;
    private ArrayList<Integer> count;
    
     public charactersInPlay() {
        names = new ArrayList<String>();
        names2 = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int index = names.indexOf(person);
            
        if(index == -1){
            names.add(person);
            count.add(1);
        }
        else {
            int freq = count.get(index);
            count.set(index,freq+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource file = new FileResource();
        String period = ".";
        
        for (String s : file.lines()){
            s = s.toLowerCase();
            int index = s.indexOf(period);
            
            if(index != -1){
                String person = s.substring(0,index);
                update(person);
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        
        int x = 15; //minimum # times a character speaks 
        
        System.out.println("//      //      //      //      //      //");
        System.out.println("The characters who speak more than " + x + " times: ");
        
        for (int k = 0; k < names.size(); k++){
            if(count.get(k) > x) {
                System.out.print(names.get(k) + ": " + count.get(k) + "\n");
            }
        }
        
        charactersWithNumParts(10,15);
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for (int k = 0; k < names.size(); k++){
            if(count.get(k) >= num1 && count.get(k) < num2){
            names2.add(names.get(k));
            }
        }    
        
        System.out.println("Characters that speak more than " + num1 + " times, and < " + num2 + " times: ");
        
        for (int k = 0; k < names2.size(); k++){
            System.out.print(names2.get(k) + "\n");
        }
    }
}
