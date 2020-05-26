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
public class warehouse {
    
    public String data;
    public String date;
    public boolean InventoryIssue;
    public boolean BestBeforeDate;
    public boolean flag;
    public String code;
    public String location;
    public Calendar time = Calendar.getInstance();
    
    public warehouse(){
         code = main.tag;
        checkInventoryIssue();
        checkBestBeforeDate();
        
    }
    
    private void checkInventoryIssue() {
        int reply = JOptionPane.showConfirmDialog(null, "Check For Inventory Faults\n RFID Triggered: "+code+"\n  Yes - Verified \n  No - Not Verified ", "Inventory Issue Check", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            InventoryIssue=true;
        }
        else {
            InventoryIssue=false;
        }
        if(InventoryIssue)
        {
            data = "Inventory Issue VERIFIED";
            time.add(Calendar.DATE, 5);
            date=time.getTime().toString();
               location="Agri Food WAREHOUSE, Mahindra Industrial Estate, Delhi";
          
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash ,date,location));		
	}
        else
        {
            data = "Inventory Issue NOT VERIFIED";
            time.add(Calendar.DATE, 5);
            date=time.getTime().toString();
               location="Agri Food WAREHOUSE, Mahindra Industrial Estate, Delhi";
          
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash ,date,location));		
	}
    }
    
    
    private void checkBestBeforeDate() {
        int reply = JOptionPane.showConfirmDialog(null, "Check For Best Before Date\n RFID Triggered: "+code+"\n  Yes - Verified \n  No - Not Verified ", "Expiry Date Check", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            BestBeforeDate=true;
        }
        else {
            BestBeforeDate=false;
        }
        
        if(BestBeforeDate)
        {
            data = "Best Before Date VERIFIED";
            time.add(Calendar.DATE, 5);
            date=time.getTime().toString();
               location="Agri Food WAREHOUSE, Mahindra Industrial Estate, Delhi";
          
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash ,date,location));		
	}
        else
        {
            data = "Best Before Date NOT VERIFIED";
            time.add(Calendar.DATE, 5);
            date=time.getTime().toString();
               location="Agri Food WAREHOUSE, Mahindra Industrial Estate, Delhi";
          
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash ,date,location));		
	}
    }
   
}
