package com.rupesh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectTest2 {
	static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static final  String username = "system";
	static final String password = "2002";
	static Connection con = null;
	private static final Logger logger = LoggerFactory.getLogger(SelectTest2.class);

	public static void main(String[] args) {
		logger.debug("SelectTest2:: Start of main method");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement("select *from customer67");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out
						.println(rs.getLong(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				logger.info("SelectTest2:: Retrieved record: {}");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("SelectTest2:: ResultSet processed successfully");

	}

}
