package crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

	public Connection get_connection() {
		Connection conn = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_crud", "root", "");

		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

	public static void main(String[] args) {
		DB_Connection obj_db_conn = new DB_Connection();
		System.out.println(obj_db_conn.get_connection());
		

	}

}
