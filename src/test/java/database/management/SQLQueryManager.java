package database.management;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQueryManager extends JDBCConnectionManager{
	private Statement createStatement(){
		try {
			return postgresConnection().createStatement();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}
	public ResultSet getQueryResult(String sqlQueryString){
		ResultSet result = null;
		try {
			result = createStatement().executeQuery( sqlQueryString );
		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally {
			closeOpenConnection( postgresConnection() );
		}
		return result;
	}

	public ResultSetMetaData getResultMetaData(ResultSet resultSet){
		try {
			return resultSet.getMetaData();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main( String[] args ) {
		SQLQueryManager sqlQueryManager= new SQLQueryManager();
		ResultSet resultSet = sqlQueryManager.getQueryResult( "SELECT * FROM moviedata;" );
		try{
			while ( resultSet.next()){
				System.out.println(resultSet.getString( "movie_title" ));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

	}
}

