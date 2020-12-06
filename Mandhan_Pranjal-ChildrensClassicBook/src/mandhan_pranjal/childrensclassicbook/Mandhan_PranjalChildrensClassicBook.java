/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mandhan_pranjal.childrensclassicbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/** Programmer: Pranjal Mandhan 637535
 * Date: Thursday October 22 2020
 * Assignment:  Children's Classic Book
 * Description: This program allows you to Search from a book catalogue using both Linear Search and Binary Search 
 */
public class Mandhan_PranjalChildrensClassicBook {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        ArrayList <String> booksList = new ArrayList <>();
       
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader("BooksList.txt"));
            String word;
            while ((word = br.readLine()) != null ){
                booksList.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


 Integer [] Numbers = new Integer[booksList.size()/2];
 String [] Titles = new String[booksList.size()/2];

 
        for (int i =0; i < booksList.size(); i = i+2) {
            Numbers[i/2] = Integer.parseInt(booksList.get(i));
    } 
        
        for (int j =1; j < booksList.size(); j = j+2) {
            
            Titles[j/2] = (booksList.get(j));
        } 


        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, Welcome to the Childrens Classic Book Catalouge");
        System.out.println("Could you please enter you Library refrence number:");
        int LRN = Integer.parseInt(scan.nextLine());    
        System.out.println("Finding your book based on Linear Search: " + linSearch(Numbers,LRN, Titles));
        System.out.println("Find your book based on Binary Search: " + binSearch(Numbers, 0, Numbers.length-1, Titles, LRN));

       
        
        }
    public static String linSearch(Integer [] A, Integer B, String [] D) {
        for (int c=0; c < A.length; c++) {
            int compare = A[c].compareTo(B);
            if (compare == 0) {
                return "Book Found: " + A[c] + " " + D[c];
            }
            if (compare > 0) {
                return "Book Not Found";
            }
        }
        return "Book Not Found";
    }
    
    public static String binSearch(Integer[]A, Integer left, Integer right,  String[] D,Integer B) {
       int middle;
       if (left > right){
           return "Book Not Found";
       }
       middle = ((left + right)/2);
         int compare = B.compareTo(A[middle]);
         if (compare == 0) {
             return "Book Found: " + A[middle] + " " + D[middle];
         }
         if (compare < 0) {
             return binSearch(A, left, middle-1, D, B);
         } else {
             return binSearch(A, middle + 1, right, D, B);
         }
     }
        
    }

        
        
        
        
      
        
    
    

