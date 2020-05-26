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

import java.util.Calendar;
import java.util.Date;

public class blockchain {

	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.;
        private String location; //our data will be a simple message.;
        private long ProductID; //as number of milliseconds 
        private String date;  // Date of production
        private int nonce;
        
        //Block Constructor.
	 
        public blockchain(String data,String previousHash, String time, String loc) {
		this.data = data;
                this.location = loc;
		this.previousHash = previousHash;
		this.ProductID = new Date().getTime();
                this.date = time;
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
	}
        
        public String calculateHash() {
	String calculatedhash = StringUtil.applySha256( 
			previousHash +
			Long.toString(ProductID) +
			data +
                        location +        
                        date
			);
	return calculatedhash;
        }
        
      
        
       
}