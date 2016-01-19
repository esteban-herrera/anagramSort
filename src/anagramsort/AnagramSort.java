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

    static Map mapOfSignaturesAndIndexes = new HashMap<String,ArrayList>();
    static ArrayList unsortedList = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
//        ArrayList sortableStringArray = buildArrayFromFile(new File("/Users/estebanherrera/NetBeansProjects/anagramSort/src/anagramsort/sortableAnagramList.txt"));
        
//        Map mapOfSignaturesAndIndexes = makeMap(sortableStringArray);
//        System.out.println(mapOfSignaturesAndIndexes.toString());
        
//        printSortedArray(sortableStringArray, mapOfSignaturesAndIndexes);
    }

//    public static ArrayList buildArrayFromFile(File f) throws FileNotFoundException {
//        Scanner fileScanner = new Scanner(f);
//        ArrayList sortableStringArray = new ArrayList();
//        while(fileScanner.hasNextLine()) {
//            sortableStringArray.add(fileScanner.nextLine());
//        }
//        return sortableStringArray;
//    }
    
    public static void acceptUnsortedArray(String[] ar) {
        unsortedList.addAll(Arrays.asList(ar));
    }

    public static void makeMap() {            
        for(int i=0; i<unsortedList.size(); i++) {
            String signature = alphabetizeString(unsortedList.get(i).toString());
            
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
    }
        
    private static String alphabetizeString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);    
        return String.valueOf(charArray);
    }
    
    public static void printSortedArray() {
        mapOfSignaturesAndIndexes.keySet().stream().forEach((key) -> {
            for(Object i : (ArrayList) mapOfSignaturesAndIndexes.get(key)) {                
                System.out.print(unsortedList.get((int)i) + " ");
            }
        });
    }
    
    public static String[] buildSortedArray() {
        String[] sortedArray = new String[unsortedList.size()];
//        mapOfSignaturesAndIndexes.keySet().stream().forEach((key) -> {            
//            for(Object i : (ArrayList) mapOfSignaturesAndIndexes.get(key)) {
//                sortedArray[index] = (String) unsortedList.get((int)i);
//                index += 1;
//            }
//        });
        
        int index = 0;
        for (Object key: mapOfSignaturesAndIndexes.keySet()){
            for(Object i : (ArrayList) mapOfSignaturesAndIndexes.get(key)) {
                sortedArray[index] = (String) unsortedList.get((int)i);
                index += 1;
            }
        }
        
        
        return sortedArray;
    }
}
