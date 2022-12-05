import com.mysql.jdbc.Connection;

import connectionManagement.Connector;
import connectionManagement.ModelDB;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = (Connection) Connector.ConnectToDB();
		ModelDB element = new ModelDB(1, "Luca", "Ferri", "123 456 789", "luca.ferri@solera.com");
		
		Connector.CreateTable(connection, "Pruebita");
		Connector.InsertElement(connection, "Pruebita", element);
	}

}
