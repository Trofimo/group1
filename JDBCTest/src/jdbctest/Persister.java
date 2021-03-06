package jdbctest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		
		Class clazz=object.getClass();
		System.out.println(clazz.getSimpleName());
		int indexOf=tables.indexOf(clazz.getSimpleName());
		if (indexOf == -1 ){
			System.out.println("table not found");
			return false;
		}
		String tableName=clazz.getSimpleName();
		Map<String,Object> properties=new HashMap<>();
		Method[] methods=clazz.getDeclaredMethods();
		for (Method method : methods) {
			if(method.getName().startsWith("get")){
				String property=method.getName().substring(3).toLowerCase();
			Object value=extractValue(object,method);
				properties.put(property,value);
			System.out.println(property+value);
			}
		}
		saveToDB(tableName,properties);
		return result;
	}

	private static void saveToDB(String tableName,
			Map<String, Object> properties) {
		try {
			Statement st = DBManager.connection().createStatement();
			StringBuilder sb=new StringBuilder();
			sb.append("insert into ").append(tableName).append(" set ");
			for (String property : properties.keySet()) {
				Object value=properties.get(property).toString();
				sb.append(property).append("= '").append(value).append("'");
				sb.append(',');
			}
		sb.deleteCharAt(sb.length()-1);
	    String query=sb.toString();
		st.execute(query);
		st.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	private static Object extractValue(Object object, Method method) {
		try {
			Object value = method.invoke(object, null);
			return value;
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return null;
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
