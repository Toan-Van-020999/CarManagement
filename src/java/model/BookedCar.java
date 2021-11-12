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
public class BookedCar {
    private int id,tblCarId,tblRentalContract;
    private Date fromDate,toDate;
    private double price;

    public BookedCar(int id, String fromDate, String toDate, double price,int tblCarId, int tblRentalContract) {
        try {
            this.id = id;
            this.tblCarId = tblCarId;
            this.tblRentalContract = tblRentalContract;
            this.fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            this.toDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);
            this.price = price;
        } catch (ParseException ex) {
            Logger.getLogger(BookedCar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
