/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchain;

/**
 *
 * @author Madesh Mahadev
 */
    
public class rfid { 
  
    static String getAlphaNumericString() 
    { 
      int n=10;  
      String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
  
 //   public static void main(String[] args) 
   // { 
  
     //   int n = 20; 
  
       // System.out.println(RandomString.getAlphaNumericString()); 
   // } 
} 
