/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchain.Food_Supply_Chain;

import com.mycompany.blockchain.main;
import static com.mycompany.blockchain.main.blockchain;
import com.mycompany.blockchain.blockchain;
import com.mycompany.blockchain.main;
import java.util.Calendar;
import javax.swing.JOptionPane;



/**
 *
 * @author Madesh Mahadev
 */
public class consumer {
    
  public String data;
  public String date;
  public boolean Defective;
  public boolean flag;
  public String location;
  public String code;
  public Calendar time = Calendar.getInstance();
    
  
    public consumer(){
       code = main.tag;
      checkDefective();
    }
    
    private void checkDefective() {
        int reply = JOptionPane.showConfirmDialog(null, "Check For Consumer Satisfaction\n RFID Triggered: "+code+"\n  Yes - Verified \n  No - Not Verified ", "Consumer Return Check", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Defective=true;
        }
        else {
            Defective=false;
        }
        if(Defective)
        {
            data = "Consumer SATISFIED";
            time.add(Calendar.DATE, 12);
            date=time.getTime().toString();
            location = "Ramapuram, Chennai";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash,date,location));		
	}
        else
        {
            data = "Consumer NOT SATISFIED";
            time.add(Calendar.DATE, 12);
            date=time.getTime().toString();
            location = "Ramapuram, Chennai";
            main.blockchain.add(new blockchain(data, blockchain.get(blockchain.size()-1).hash,date,location));		
	}
    }
   
    
}
