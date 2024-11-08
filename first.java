package newpackage;
import java.sql.*;
public class Main {
public static void main(String[] args) throws Exception {
String url = "jdbc:mysql://localhost:3306/library";
String user = "root";
String pass = "Hys@1508";
String driver = "com.mysql.cj.jdbc.Driver";
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, user, pass);
System.out.println("Successfully connected to database!!");
Statement st = conn.createStatement();
String query = "select * from staff";
ResultSet rs = st.executeǪuery(query);
System.out.println("\nContents of table are:\n");
System.out.println("Staff_id\t| Name\t\t| Contact");
while (rs.next()) {
	System.out.println(rs.getString(1) + "\t| " + rs.getString(2) + "\t| " + rs.getString(3));
	}
	rs.close();
	String insertquery = "INSERT INTO staff (Staff_id, Name, Contact) VALUES ('S006', 'Mousami
	Turuk', '9876543213')";
	Statement insert = conn.createStatement();
	insert.executeUpdate(insertquery);
	System.out.println("\nSuccessfully inserted a new row!\n");
	ResultSet rs1 = st.executeǪuery(query);
	System.out.println("Staff_id\t| Name\t\t| Contact");
	while (rs1.next()) {
	System.out.println(rs1.getString(1) + "\t| " + rs1.getString(2) + "\t| " + rs1.getString(3));
	}
	rs1.close();
	String updatequery = "UPDATE staff SET Name = 'Lalit Patil' WHERE Staff_id = 'S002'";
	Statement update = conn.createStatement();
	update.executeUpdate(updatequery);
	System.out.println("\nSuccessfully updated a row!\n");
	ResultSet rs2 = st.executeǪuery(query);
	System.out.println("Staff_id\t| Name\t\t| Contact");
	while (rs2.next()) {
	System.out.println(rs2.getString(1) + "\t| " + rs2.getString(2) + "\t| " + rs2.getString(3));
	}
	rs2.close();
	String deletequery = "DELETE FROM staff WHERE Staff_id = 'S003'";
	Statement del = conn.createStatement();
	del.executeUpdate(deletequery);
	System.out.println("\nSuccessfully deleted a row!\n");
	ResultSet rs3 = st.executeǪuery(query);
	System.out.println("Staff_id\t| Name\t\t| Contact");
	while (rs3.next()) {
		System.out.println(rs3.getString(1) + "\t| " + rs3.getString(2) + "\t| " + rs3.getString(3));
		}
		rs3.close();
		st.close();
		conn.close();
		}
		}