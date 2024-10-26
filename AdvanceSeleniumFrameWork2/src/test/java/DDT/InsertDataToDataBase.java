package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {

		//step1:-Register / load my SQL database
				Driver driverRef = new Driver();
		        DriverManager.registerDriver(driverRef);

		        //step2:- get connect to database
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Students_Table", "root", "root");
			
			//setp3:-
			Statement state = conn.createStatement();
	String query = "insert into student(id,first_name,last_name,address)values('4','rath','nith','blore'),values('5','rath','nith','blore')";

			int result = state.executeUpdate(query);
	
	if(result==1)
	{
		System.out.println("data created");
	}
	else
	{
		System.out.println("data not created");
	}
	conn.close();
	
	}

}
