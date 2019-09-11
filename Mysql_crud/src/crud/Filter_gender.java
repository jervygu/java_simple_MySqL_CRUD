package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Filter_gender {

	public static void main(String[] args) {
		Filter_gender obj_ct = new Filter_gender();
		Scanner sg = new Scanner(System.in);
		System.out.print("m = male, f = female: ");
		String gender = sg.next();
		if (gender.equals("m")) {
			gender = "male";
		} else if (gender.equals("f")) {
			gender = "female";
		} else {
			gender.toString();
		}
		obj_ct.select_user(gender);

		sg.close();
	}

	public void select_user(String gender) {

		DB_Connection obj_db_conn = new DB_Connection();
		Connection conn = obj_db_conn.get_connection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
//			String gender2 = gender
//				    .replace("!", "!!")
//				    .replace("%", "!%")
//				    .replace("_", "!_")
//				    .replace("[", "![");
//			String sql_select_user = "SELECT * FROM tbl_user WHERE gender LIKE ? ESCAPE '!'";
//			String sql_select_user = "SELECT * FROM tbl_user WHERE gender = ? OR gender LIKE ? ESCAPE '!'";
			String sql_select_user = "SELECT * FROM tbl_user WHERE gender = ? ";
			ps = conn.prepareStatement(sql_select_user);

//			ps.setString(1, "%" +gender +"%");
			ps.setString(1, gender);
//			ps.setString(2, "%" +gender2);

			System.out.println(ps);

			rs = ps.executeQuery();

			System.out.println("User ID | Firstname\t| Lastname \t| Email \t\t| Username \t\t| Password \t|"
					+ " Confirm Password | Gender | Image \t\t| Status |");
			System.out.printf("%7s%-13s%-13s%-21s%-21s%-13s%-16s%-6s%-17s%-6s", "--------+", "---------------+",
					"---------------+", "-----------------------+", "-----------------------+", "---------------+",
					"------------------+", "--------+", "-------------------+", "--------+\n");
			while (rs.next()) {

				System.out.printf("%7s | %-13s | %-13s | %-21s | %-21s | %-13s | %-16s | %-6s | %-17s | %-6s |",
						rs.getString("user_id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"),
						rs.getString("username"), rs.getString("pw"), rs.getString("pw2"), rs.getString("gender"),
						rs.getString("image"), rs.getString("status"));

				System.out.printf("\n%7s%-13s%-13s%-21s%-21s%-13s%-16s%-6s%-17s%-6s ", "--------+", "---------------+",
						"---------------+", "-----------------------+", "-----------------------+", "---------------+",
						"------------------+", "--------+", "-------------------+", "--------+");
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
