package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Crud_test {
	
	public static void main(String[] args) {
		Crud_test obj_ct = new Crud_test();
//		obj_ct.create_user("Ghie", "Mahusay", "ghie@gmail.com", "ghie123", "ghie123", "ghie123", "female", "ghie.jpg", "active");
		obj_ct.select_user("2");
		
	}
	
	public void create_user(String fname, String lname, String email, String username, String pw, String pw2, String gender, String image, String status) {

		DB_Connection obj_db_conn = new DB_Connection();
		Connection conn = obj_db_conn.get_connection();
		
		PreparedStatement ps = null;
		
		try {
			String sql_insert_user = 
					"INSERT INTO `tbl_user` "
					+ "(`fname`, `lname`, `email`, `username`, `pw`, `pw2`, `gender`, `image`, `status`)"
					+ "VALUES"
					+ "(?,?,?,?,?,?,?,?,?);"; 
			ps = conn.prepareStatement(sql_insert_user);
			
//			ps.setString(1, user_id);
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, pw);
			ps.setString(6, pw2);
			ps.setString(7, gender);
			ps.setString(8, image);
			ps.setString(9, status);
			
			System.out.println(ps);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void select_user(String user_id) {

		DB_Connection obj_db_conn = new DB_Connection();
		Connection conn = obj_db_conn.get_connection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
//			String sql_select_user = "SELECT * FROM tbl_user WHERE user_id=?"; 
			String sql_select_user = "SELECT * FROM tbl_user"; 
			ps = conn.prepareStatement(sql_select_user);
			
//			ps.setString(1, user_id);
//			ps.setString(1, fname);
//			ps.setString(2, lname);
//			ps.setString(3, email);
//			ps.setString(4, username);
//			ps.setString(5, pw);
//			ps.setString(6, pw2);
//			ps.setString(7, gender);
//			ps.setString(8, image);
//			ps.setString(9, status);
			
			System.out.println(ps);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("User ID : " +rs.getString("user_id"));
				System.out.println("Firstname : " +rs.getString("fname"));
				System.out.println("Lastname : " +rs.getString("lname"));
				System.out.println("Email : " +rs.getString("email"));
				System.out.println("Usename : " +rs.getString("username"));
				System.out.println("Password : " +rs.getString("pw"));
				System.out.println("Confirm password : " +rs.getString("pw2"));
				System.out.println("Gender : " +rs.getString("gender"));
				System.out.println("Image : " +rs.getString("image"));
				System.out.println("Status : " +rs.getString("status"));

				System.out.println("-------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}


}
