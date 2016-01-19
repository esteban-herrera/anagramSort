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
        ArrayList sortableStringArray = buildArrayFromFile(new File("/Users/estebanherrera/NetBeansProjects/anagramSort/src/anagramsort/sortableAnagramList.txt"));
        System.out.println(sortableStringArray.toString());
        
        Map mapOfSignaturesAndIndexes = makeMap(sortableStringArray);
        System.out.println(mapOfSignaturesAndIndexes.toString());
        
        printSortedArray(sortableStringArray, mapOfSignaturesAndIndexes);
    }

    public static ArrayList buildArrayFromFile(File f) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(f);
        ArrayList sortableStringArray = new ArrayList();
        while(fileScanner.hasNextLine()) {
            sortableStringArray.add(fileScanner.nextLine());
        }
        return sortableStringArray;
    }

    public static Map makeMap(ArrayList sortableStringArray) {            
        Map mapOfSignaturesAndIndexes = new HashMap<String,ArrayList>();
        for(int i=0; i<sortableStringArray.size(); i++) {
            String signature = alphabetizeString(sortableStringArray.get(i).toString());
            
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
        return mapOfSignaturesAndIndexes;
    }
        
    private static String alphabetizeString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);    
        return String.valueOf(charArray);
    }
    
    public static void printSortedArray(ArrayList unsortedList, Map indexes) {
        indexes.keySet().stream().forEach((key) -> {
            for(Object i : (ArrayList) indexes.get(key)) {                
                System.out.print(unsortedList.get((int)i) + " ");
            }
        });
    }
}
