package Databaseøving;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public abstract class DBConn {
    protected Connection conn;
    protected PreparedStatement statement;
	protected ResultSet rs;
	protected String navn;
    public DBConn (String navn) {
    	this.navn = navn;
    }
    public void connect() {
    	try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Properties for user and password. Here the user and password are both 'paulr'
            Properties p = new Properties();
            p.put("user", "eElBQ1FDrw");
            p.put("password", "jxMKDKzbh4");           
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/eElBQ1FDrw?autoReconnect=true&useSSL=false",p);
        } catch (Exception e)
    	{
            throw new RuntimeException("Unable to connect", e);
    	}
    }
    public ArrayList<ArrayList<String>> getAll(){
    	
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	try {
    		connect();
    		String sqlQuery = "SELECT * FROM "+navn;
    		statement = conn.prepareStatement(sqlQuery);
    		
    		this.rs = statement.executeQuery();
    		int colLength = rs.getMetaData().getColumnCount();
    		while(rs.next()) {
    			ArrayList<String> ob = new ArrayList<String>();
    			for(int i = 1; i <= colLength; ++i) {
    				ob.add(rs.getString(i));
    			}
    			result.add(ob);
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	return result;
    		
    		
    }
    
    public int getID(String colNavn, Object colVerdi) {
		try {
			connect();
			String sqlQuery = "SELECT "+ navn + "ID from "+navn+" WHERE " +colNavn + "=(?)";
		
			statement = conn.prepareStatement(sqlQuery);
			statement.setObject(1,colVerdi);
			rs = statement.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//Return -1 if it does not exist
		return -1;
	}
}
	
