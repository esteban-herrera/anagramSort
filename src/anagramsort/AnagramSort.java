/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagramsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author estebanherrera
 */
public class AnagramSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/estebanherrera/NetBeansProjects/anagramSort/src/anagramsort/sortableAnagramList.txt");
        Scanner fileScanner = new Scanner(file);
        ArrayList sortableStringArray = new ArrayList();
        while(fileScanner.hasNextLine()) {
            sortableStringArray.add(fileScanner.nextLine());
        }
        alphabetizeStringsInArray(sortableStringArray);
        Map mapOfSignaturesAndIndexes = new HashMap<String,ArrayList>();

        for(int i=0; i<sortableStringArray.size(); i++) {
            
            String str = sortableStringArray.get(i).toString();
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);    
            String signature = String.valueOf(charArray);
            
            if(mapOfSignaturesAndIndexes.containsKey(signature)) {                
                ArrayList indexesForThisSignature = (ArrayList)mapOfSignaturesAndIndexes.get(signature);
                indexesForThisSignature.add(i);
                mapOfSignaturesAndIndexes.put(signature, indexesForThisSignature);
            } else {
                ArrayList indexesOfWordsWithThisSignature = new ArrayList();
                indexesOfWordsWithThisSignature.add(i);
                mapOfSignaturesAndIndexes.put(signature,indexesOfWordsWithThisSignature);
            }
        }
        
        System.out.println(mapOfSignaturesAndIndexes.toString());
        
    }
    
    public static void alphabetizeStringsInArray(ArrayList ar) {
        for(Object s: ar) {
            alphabetizeString(s.toString());
        }
    }
    
    public static String alphabetizeString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);    
        return String.valueOf(charArray);
    }

}
