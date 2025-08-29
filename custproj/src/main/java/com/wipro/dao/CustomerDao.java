package com.wipro.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.model.Customermodel;
import com.wipro.util.MyDBConnection;

public class CustomerDao {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	CallableStatement cstmt;

	public void createCustomer(Customermodel cust) {
		try {
			con = MyDBConnection.getDBConnection();
			ps = con.prepareStatement("insert into wipcustomer values(?,?,?,?,?,?)");
			ps.setInt(1, cust.getCid());
			ps.setString(2, cust.getCname());
			ps.setInt(3, cust.getAddress().getDoorNo());
			ps.setString(4, cust.getAddress().getStreet());
			ps.setString(5, cust.getAddress().getCity());
			ps.setInt(6, cust.getAddress().getZip());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewCustomer() {

		try {
			con = MyDBConnection.getDBConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from wipcustomer");

			while (rs.next()) {
				System.out.println("CID :" + rs.getInt(1));
				System.out.println("CName :" + rs.getString(2));
				System.out.println("DoorNo :" + rs.getInt(3));
				System.out.println("Street :" + rs.getString(4));
				System.out.println("City :" + rs.getString(5));
				System.out.println("Zip :" + rs.getInt(6));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void getDBMetaData() {

		try {
			con = MyDBConnection.getDBConnection();
			DatabaseMetaData dbdata = con.getMetaData();
			System.out.println(dbdata.getDatabaseMajorVersion());
			System.out.println(dbdata.getDatabaseProductName());
			System.out.println(dbdata.getDriverName());
			System.out.println(dbdata.getDriverVersion());
			System.out.println(dbdata.getSQLKeywords());

			System.out.println(dbdata.getStringFunctions());
			System.out.println(dbdata.getDriverVersion());

			ResultSet rs = dbdata.getTables(null, null, "%", new String[] { "TABLE" });

			while (rs.next()) {
				System.out.println(rs.getString("TABLE_NAME"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void insertCustUsingPro(Customermodel cust) {
		try {
			con = MyDBConnection.getDBConnection();
			
			cstmt = con.prepareCall("{call pro_ins_cust(?,?,?,?,?,?)}");
			cstmt.setInt(1, cust.getCid());
			cstmt.setString(2, cust.getCname());
			cstmt.setInt(3, cust.getAddress().getDoorNo());
			cstmt.setString(4, cust.getAddress().getStreet());
			cstmt.setString(5, cust.getAddress().getCity());
			cstmt.setInt(6, cust.getAddress().getZip());
			cstmt.execute();
			System.out.println("Procedure successfully inserted...");

		} catch (SQLException e) {
			try {
				if(con != null) {
					con.rollback();
					System.out.println("Transaction Rolledback :");
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
			e.printStackTrace();

		}
     }
}