/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchain;

/**
 *ss
 * @author Madesh Mahadev
 */

import com.google.gson.GsonBuilder;
import com.mycompany.blockchain.Food_Supply_Chain.consumer;
import com.mycompany.blockchain.Food_Supply_Chain.factory;
import java.util.ArrayList;
import com.mycompany.blockchain.Food_Supply_Chain.farm;
import com.mycompany.blockchain.Food_Supply_Chain.processing_plant;
import com.mycompany.blockchain.Food_Supply_Chain.retail;
import com.mycompany.blockchain.Food_Supply_Chain.warehouse;
import com.mycompany.blockchain.Food_Supply_Chain.wholesale;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Chain_System {
    
    public static ArrayList<blockchain> blockchain = new ArrayList<blockchain>(); 
    public static String blockchainJson;
    public static int difficulty = 5;
                

    
    public Chain_System(){
         
      
                supplychain ob = new supplychain(null,true);
                               
                JOptionPane.showMessageDialog(null, "Food Supply Chain Established");
                ob.jSupplyTextArea.append("Stage 1: Farm");
                farm pro1 = new farm();
                ob.jSupplyTextArea.append("\nCompleted On "+pro1.date);
                ob.jSupplyTextArea.append("\nLocation "+pro1.location);
                
                JOptionPane.showMessageDialog(null, "Sent to Processing Plant");
                ob.jSupplyTextArea.append("\n\nStage 2: Sent to Processing Plant");
                processing_plant pro2 = new processing_plant();
                ob.jSupplyTextArea.append("\nCompleted On "+pro2.date);
                ob.jSupplyTextArea.append("\nLocation "+pro2.location);
                
                JOptionPane.showMessageDialog(null, "Sent to Factory");
                ob.jSupplyTextArea.append("\n\nStage 3: Sent to Factory");
                factory pro3 = new factory();
                ob.jSupplyTextArea.append("\nCompleted On "+pro3.date);
                ob.jSupplyTextArea.append("\nLocation "+pro3.location);
                
                JOptionPane.showMessageDialog(null, "Sent to Warehouse");
                ob.jSupplyTextArea.append("\n\nStage 4: Sent to Warehouse");
                warehouse pro4 = new warehouse();
                ob.jSupplyTextArea.append("\nCompleted On "+pro4.date);
                ob.jSupplyTextArea.append("\nLocation "+pro4.location);
                
                JOptionPane.showMessageDialog(null, "Sent to Wholesale Market");
                ob.jSupplyTextArea.append("\n\nStage 5: Sent to Wholesale Market");
                wholesale pro5 = new wholesale();
                ob.jSupplyTextArea.append("\nCompleted On "+pro5.date);
                ob.jSupplyTextArea.append("\nLocation "+pro5.location);
                
                JOptionPane.showMessageDialog(null, "Sent to Retail Market");
                ob.jSupplyTextArea.append("\n\nStage 6: Sent to Retail Market");
                retail pro6 = new retail();
                ob.jSupplyTextArea.append("\nCompleted On "+pro6.date);
                ob.jSupplyTextArea.append("\nLocation "+pro6.location);
                
                JOptionPane.showMessageDialog(null, "Sent to Consumer");
                ob.jSupplyTextArea.append("\n\nStage 7: Sent to Consumer");
                consumer pro7 = new consumer();
                ob.jSupplyTextArea.append("\nCompleted On "+pro7.date);
                ob.jSupplyTextArea.append("\nLocation "+pro7.location);
                
                JOptionPane.showMessageDialog(null, "Product Consumed...");
                ob.jSupplyTextArea.append("\n\nStage 8: Product Consumed...");
               
                ob.jSupplyTextArea.append("\n\nEnd Of Transaction");
              
                //ob.jSupplyTextArea.append("\n\nBlockchain is Valid: " + isChainValid());
         

                ob.setVisible(true);
                Supply_Chain_App.blockbtn.setEnabled(true);
                Supply_Chain_App.defectivebtn.setEnabled(true);


	         blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
               
                  try {
                       //write converted json data to a file named "CountryGSON.json"
                       FileWriter writer = new FileWriter("E:apple.json");
                       writer.write(blockchainJson);
                       JOptionPane.showMessageDialog(null, "Transaction Completed");
                       writer.close();
                       } catch (IOException e) {
                       e.printStackTrace();
                       }
  
             //   System.out.println("\nBlockchain is Valid: " + isChainValid());
	     //	System.out.println(blockchainJson);	
    }
    
    
    public static Boolean isChainValid() {
		blockchain currentBlock; 
		blockchain previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
		
               
                
	}
}
