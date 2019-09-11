package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Create_user {
	
	public static void main(String[] args) {
		Create_user obj_cu = new Create_user();
		
		String fname;
		String lname;
		String email;
		String username;
		String pw;
		String pw2;
		String gender;
		String image;
		String status = "active";
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Account registration.");
		System.out.print("Firstname: ");
		fname = sc.next();
		System.out.print("Lastname: ");
		lname = sc.next();
		System.out.print("Email: ");
		email = sc.next();
		System.out.print("Username: ");
		username = sc.next();
		System.out.print("Password: ");
		pw = sc.next();
		System.out.print("Confirm password: ");
		pw2 = sc.next();
		System.out.print("Gender (male/female): ");
		gender = sc.next();
		System.out.print("Image: ");
		image = sc.next();
//		System.out.print("Status: ");
//		status = sc.next();
		

		obj_cu.create_user(fname, lname, email, username, pw, pw2, gender, image, status);
		sc.close();
		
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


}
