package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Read_user {

	public static void main(String[] args) {
		Read_user obj_ct = new Read_user();
		String s_uname = "";
		obj_ct.select_user(s_uname);
	}

	public void select_user(String username) {

		DB_Connection obj_db_conn = new DB_Connection();
		Connection conn = obj_db_conn.get_connection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql_select_user = "SELECT * FROM tbl_user";
			ps = conn.prepareStatement(sql_select_user);

			System.out.println(ps);

			rs = ps.executeQuery();

			System.out.printf("%7s%-13s%-13s%-21s%-21s%-13s%-16s%-6s%-17s%-6s", "--------+", "---------------+",
					"---------------+", "-----------------------+", "-----------------------+", "---------------+",
					"------------------+", "--------+", "-------------------+", "--------+\n");
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
