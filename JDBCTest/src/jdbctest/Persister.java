package jdbctest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Persister {
	static List<String> tables;

	public static boolean persist(Object object){
		boolean result=false;
		if(object==null){
			return false;
		}
		if(tables==null){
			fetchTableList();
		}
		return result;
	}

	private static void fetchTableList() {
		tables=new LinkedList<>();
		try {
			Statement st=DBManager.connection().createStatement();
			ResultSet tablesNames=st.executeQuery("show tables");
			while(tablesNames.next()){
				tables.add(tablesNames.getString(1));
			}
			System.out.println(tables);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
