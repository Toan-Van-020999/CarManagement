/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class RentalContract {
    private int tblContractId ;
    private Date borrowDate,returnDate,signDate;
    private int tblEmployeeId,tblCustomerId;

    public RentalContract(int tblContractId, String borrowDate, String returnDate, String signDate, int tblEmployeeId, int tblCustomerId) {
        try {
            this.tblContractId = tblContractId;
            this.borrowDate = new SimpleDateFormat("yyyy-MM-dd").parse(borrowDate);
            this.returnDate = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate);
            this.signDate = new SimpleDateFormat("yyyy-MM-dd").parse(signDate);;
            this.tblEmployeeId = tblEmployeeId;
            this.tblCustomerId = tblCustomerId;
        } catch (ParseException ex) {
            Logger.getLogger(RentalContract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
