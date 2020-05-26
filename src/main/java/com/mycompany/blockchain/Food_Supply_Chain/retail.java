/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchain.Food_Supply_Chain;

import com.mycompany.blockchain.main;
import static com.mycompany.blockchain.main.blockchain;
import com.mycompany.blockchain.blockchain;
import java.util.Calendar;
import com.mycompany.blockchain.main;
import javax.swing.JOptionPane;


/**
 *
 * @author Madesh Mahadev
 */
public class retail {
    
   public String data;
   public String date;
    public boolean Sales;
    public boolean Defective;
    public boolean flag;
    public String code;
    public String location;
    public Calendar time = Calendar.getInstance();
    
    public retail(){
         code = main.tag;
      checkSales();
      checkDefective();
    }
    
        private void checkSales() {
         int reply = JOptionPane.showConfirmDialog(null, "Check For Sale Performance Issues\n RFID Triggered: "+code+"\n  Yes - Verified \n  No - Not Verified ", "Retail - Sale Performance Check", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Sales=true;
        }
        else {
            Sales=false;
        }
        
        if(Sales)
        {
            data = "Sales is Good and Moving; VERIFIED";
            time.add(Calendar.DATE, 7);
            date=time.getTime().toString();
            location="Sales Divison, Big Bazar Shopping Complex, Ram Nagar, Delhi";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash,date,location));		
	}
        else
        {
            data = "Sales is not Good and Not Moving; NOT VERIFIED";
            time.add(Calendar.DATE, 7);
            date=time.getTime().toString();
            location="Sales Divison, Big Bazar Shopping Complex, Ram Nagar, Delhi";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash,date,location));		
	}
    }
    
    private void checkDefective() {
         int reply = JOptionPane.showConfirmDialog(null, "Check For Defection Or Tamper\n RFID Triggered: "+code+"\n  Yes - Verified \n  No - Not Verified ", "Retail - Product Defective Check", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Defective=true;
        }
        else {
            Defective=false;
        }
        
        if(Defective)
        {
            data = "No Defective Found; VERIFIED";
            time.add(Calendar.DATE, 7);
            date=time.getTime().toString();
            location="Service Center, Big Bazar Shopping Complex, Ram Nagar, Delhi";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash,date,location));		
	}
        else
        {
            data = "Defective Product!; NOT VERIFIED";
            time.add(Calendar.DATE, 7);
            date=time.getTime().toString();
            location="Service Center, Big Bazar Shopping Complex, Ram Nagar, Delhi";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash,date,location));		
	}
    }
   
   
}
