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
     public void testAnagram() {
         ArrayList ar = new ArrayList();
         ar.addAll(ar);
     }    
}