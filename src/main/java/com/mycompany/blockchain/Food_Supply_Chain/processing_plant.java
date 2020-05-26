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
public class processing_plant {
    
    public String data;
    public String date;
    public boolean freshness;
    public boolean flag;
    public String location;
     public String code;
    public Calendar time = Calendar.getInstance();
    
    public processing_plant(){
        code = main.tag;
        checkFreshness();
        
    }
    
    private void checkFreshness() {
           int reply = JOptionPane.showConfirmDialog(null, "Check For Freshness & Quality\n RFID Triggered: "+code+"\n  Yes - Verified \n  No - Not Verified ", "Product Freshness Check", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            freshness=true;
        }
        else {
            freshness=false;
        }
        
        if(freshness)
        {
            data = "Freshness VERIFIED";
            time.add(Calendar.DATE, 1);
            date=time.getTime().toString();
            location="Qualitiy Check Divison, Mahindra Agri Food, REIDSVILLE, Delhi";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash ,date,location));		
	}
        else
        {
            data = "Freshness NOT VERIFIED";
            time.add(Calendar.DATE, 1);
            date=time.getTime().toString();
            location="Qualitiy Check Divison, Mahindra Agri Food, REIDSVILLE, Delhi";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash ,date,location));		
	}
    }
    
}
