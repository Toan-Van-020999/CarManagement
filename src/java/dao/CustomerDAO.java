/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Admin
 */
public class CustomerDAO extends DAO {

    public CustomerDAO() {
        super();
    }

    public List<Customer> getCustomer(String name) {
        Customer customer = null;
        String sql = "SELECT * FROM tblcustomer WHERE name LIKE ?";

        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phoneNumber"), rs.getString("idCard"), rs.getString("note"), rs.getString("description"), rs.getString("license"));
                list.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Customer getCustomerById(String id) {
        Customer customer = null;
        String sql = "SELECT * FROM tblcustomer WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phoneNumber"), rs.getString("idCard"), rs.getString("note"), rs.getString("description"), rs.getString("license"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }
    public static void main(String[] args) {
        CustomerDAO cdao = new CustomerDAO();
        Customer c = cdao.getCustomerById("1");
        System.out.println(c.getName());
    }
    
}
