/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Car;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CarDAO extends DAO {

    public CarDAO() {
        super();
    }

    private java.sql.Date convertDate(java.util.Date date) {
        if (date == null) {
            return null;
        }
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public List<Car> getListCar() {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM car";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Car c = new Car(rs.getInt("id"), rs.getString("name"), rs.getString("image"), rs.getString("licensePlate"), rs.getString("brand"), rs.getString("theFirm"), rs.getString("color"), rs.getInt("storeId"), rs.getString("description"), rs.getInt("price"), rs.getString("status"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Car getCarById(String id) {
        Car c = null;
        String sql = "SELECT * FROM car WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
                
            while (rs.next()) {
                c = new Car(rs.getInt("id"), rs.getString("name"), rs.getString("image"), rs.getString("licensePlate"), rs.getString("brand"), rs.getString("theFirm"), rs.getString("color"), rs.getInt("storeId"), rs.getString("description"), rs.getInt("price"), rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<Car> searchCar(Date fromDate, Date toDate, String type) {
        List<Car> list = new ArrayList<>();
        String sql = "SELECT * FROM car EXCEPT SELECT car.* from car,tblbookedcar WHERE car.id = tblbookedcar.tblCarId AND tblbookedcar.toDate > ? OR tblbookedcar.fromDate < ? AND car.theFirm NOT LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, convertDate(fromDate));
            ps.setDate(2, convertDate(toDate));
            ps.setString(3, "%" + type + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Car c = new Car(rs.getInt("id"), rs.getString("name"), rs.getString("image"), rs.getString("licensePlate"), rs.getString("brand"), rs.getString("theFirm"), rs.getString("color"), rs.getInt("storeId"), rs.getString("description"), rs.getInt("price"), rs.getString("status"));
                list.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
