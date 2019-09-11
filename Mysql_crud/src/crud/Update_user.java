package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.util.Scanner;

public class Update_user {

	public static void main(String[] args) {
		Select_user obj_su = new Select_user();
		
		Update_user obj_uu = new Update_user();
		
		String fname;
		String lname;
		String email;
		String new_username;
		String pw;
		String pw2;
		String gender;
		String image;
		String username;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username? ");
		username = sc.next();

		obj_su.select_user(username);
		
		System.out.println("Please enter your new data.");
		System.out.print("Firstname: ");
		fname = sc.next();
		System.out.print("Lastname: ");
		lname = sc.next();
		System.out.print("Email: ");
		email = sc.next();
		System.out.print("New Username: ");
		new_username = sc.next();
		System.out.print("Password: ");
		pw = sc.next();
		System.out.print("Confirm password: ");
		pw2 = sc.next();
		System.out.print("Gender (male/female): ");
		gender = sc.next();
		System.out.print("Image: ");
		image = sc.next();
		
		obj_uu.update_user(fname, lname, email, username, pw, pw2, gender, image, new_username);

		sc.close();
	}

	public void update_user(String fname, String lname, String email, String username, String pw, String pw2,
			String gender, String image, String new_username) {

		DB_Connection obj_db_conn = new DB_Connection();
		Connection conn = obj_db_conn.get_connection();

		PreparedStatement ps = null;

		try {
			String sql_update_user = "Update tbl_user SET fname=?, lname=?, email=?, username=?, pw=?, pw2=?, gender=?, image=? WHERE username = ?";
			ps = conn.prepareStatement(sql_update_user);

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, email);
			ps.setString(4, new_username);
			ps.setString(5, pw);
			ps.setString(6, pw2);
			ps.setString(7, gender);
			ps.setString(8, image);
			ps.setString(9, username);

			System.out.println(ps);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
