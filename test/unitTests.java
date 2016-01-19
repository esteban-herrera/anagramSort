/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author estebanherrera
 */
public class unitTests {    
    public static ArrayList sortableStringArray;
    
    public unitTests() {
        
    }
    
    @BeforeClass
    public static void setUpClass() throws FileNotFoundException {
        File file = new File("/Users/estebanherrera/NetBeansProjects/anagramSort/src/anagramsort/sortableAnagramList.txt");
        Scanner fileScanner = new Scanner(file);
        sortableStringArray = new ArrayList();
        while(fileScanner.hasNextLine()) {
            sortableStringArray.add(fileScanner.nextLine());
        }
        System.out.println(sortableStringArray.size());
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
         assertTrue(true);
     }
     
     @Test
     public void testAnagramShortList() {
         String[] unsorted = {"CAT", "BOB", "ACT"};
         // Build unsorted ArrayList
         anagramsort.AnagramSort.acceptUnsortedArray(unsorted);
         // Make map with signatures, indexes
         anagramsort.AnagramSort.makeMap();
         // Build sorted array
         String[] result = anagramsort.AnagramSort.buildSortedArray();
         String[] expected = {"CAT", "ACT", "BOB"};
         assertArrayEquals(expected, result);         
     }

     
     @Test
     public void testAnagramLongList() {
         String[] unsorted = {"CAT", "ACT", "BOB", "OBB", "LOB", "BOL", "TRAP", "PART", "DDA", "LICK", "PICK", "OHM", "HOM", "DOG", "GOD", "FOG", "GOLF", "FROG", "DAD", "ADD"};
         // Build unsorted ArrayList
         anagramsort.AnagramSort.acceptUnsortedArray(unsorted);
         // Make map with signatures, indexes
         anagramsort.AnagramSort.makeMap();
         // Build sorted array
         String[] result = anagramsort.AnagramSort.buildSortedArray();
         String[] expected = {"DDA", "DAD", "ADD", "CAT", "ACT", "LOB", "BOL", "PICK", "GOLF", "FROG", "LICK", "OHM", "HOM", "DOG", "GOD", "BOB", "OBB", "TRAP", "PART", "FOG"};
         assertArrayEquals(expected, result);         
     }
}