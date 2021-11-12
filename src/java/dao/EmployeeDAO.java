/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EmployeeDAO extends DAO {

    public EmployeeDAO() {
        super();
    }

    public boolean checkLogin(Employee e) {
        try {
            Employee employee = null;
            String sql = "SELECT * FROM employee WHERE username = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getUserName());
            ps.setString(2, e.getPassWord());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    

}
