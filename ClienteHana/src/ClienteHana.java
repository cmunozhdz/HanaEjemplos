import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteHana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection =null;
		try {	
			//1f3a4df5-3630-46ab-a410-ad0562f9b40d
			String SchemasName;
			System.out.println("Conectando a Hana");
			//Agregamos la conexion al schema.
			String ServerConnection= "1f3a4df5-3630-46ab-a410-ad0562f9b40d.hana.trial-us10.hanacloud.ondemand.com:443";	
			String Usuario= "DBADMIN";
			String Password = "Kl3m3n73$$";
			String JdbConnection = "jdbc:sap://" + ServerConnection + "?encrypt=true&validateCertificate=false&currentSchema=PWP" ; 		
			connection = DriverManager.getConnection(JdbConnection,Usuario,Password);                
			
			
		} 
		catch (SQLException e) {
						  		
			System.err.println("Connection Failed. User/Passwd Error?");
			System.err.println(e.toString());
			return;
			
		}
		if (connection !=null ) {
			try {
				
				System.out.println("Conexion establecida");
				Statement Stmt =connection.createStatement();
				ResultSet Rst = Stmt.executeQuery("Select * from CFDI");
				
				while ( Rst.next() ) {
					
					System.out.println("Id:" +Rst.getString(1));
					System.out.println("RFC:" + Rst.getString(2));
					System.out.println("Emisor:" + Rst.getString(3));
				}
						
				return;
			}
			catch (Exception e) {
				
				System.err.println(e.toString());
			}
			
		}
		
		
		
	}
}

