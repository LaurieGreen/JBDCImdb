package database.management;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

import object.management.models.Film;

public class ImdbDataManager {

	private static final SQLQueryManager sqlQueryManager = new SQLQueryManager();

	private static final String SQL_QUERY = "SELECT * FROM moviedata ORDER BY RANDOM() LIMIT 1;";

	public String[] getRawRandomFilmFromDB()
	{
		ResultSet randomFilmQuery = sqlQueryManager.getQueryResult( SQL_QUERY );
		String[] randomFilm = new String[17];
		String[] filmColumnNames = getColumnNamesFromFileRecord( randomFilmQuery );

		try{
			randomFilmQuery.next();
			for ( int i = 0; i <filmColumnNames.length; i++ ) {
				randomFilm[i] = randomFilmQuery.getString( filmColumnNames[i] );
			}
		} catch ( SQLException e ){
			e.printStackTrace();
		}

		sqlQueryManager.closeOpenConnection( sqlQueryManager.postgresConnection() );

		return randomFilm;
	}

	public Film getFilmFromRawData(){
		String[] rawFilm = getRawRandomFilmFromDB();
		while(!validateFilm(rawFilm)){
			rawFilm = getRawRandomFilmFromDB();
		}
		return new Film( rawFilm );
	}

	public String[] getColumnNamesFromFileRecord(ResultSet resultSet){

		String[] filmColumnNames = new String[17];
		try {
			ResultSetMetaData metaData = resultSet.getMetaData();
			for ( int i = 0; i < metaData.getColumnCount(); i++ ) {
				filmColumnNames[i] = metaData.getColumnName( i +1);
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		return filmColumnNames;

	}

	private boolean validateFilm(String[] rawFilm){
		for (String attribute : rawFilm){
			if (attribute == null ){
				System.out.println("Bad data found: "+ Arrays.toString( rawFilm ));
				return false;
			}
		}
		return true;
	}

	public static void main( String[] args ) {
		ImdbDataManager imdbDataManager = new ImdbDataManager();
		System.out.println(imdbDataManager.getFilmFromRawData());
	}
}
