package api.management;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import object.management.models.Film;

public class APIResponseManager {

	static String[] raw = {"1","Avatar","178","Color","James Cameron","CCH Pounder","Joel David Moore","Wes Studi","760505847","Action|Adventure|Fantasy|Sci-Fi","avatar|future|marine|native|paraplegic","English","USA","PG-13","237000000","2009","7.9"};

	public Film getFilmFromResponse( JsonArray rawData){
		String[] stringFromJson = getStringArrayFromJson(rawData);
		return new Film( stringFromJson );
	}

	private String[] getStringArrayFromJson(JsonArray rawFilm){
		String[] stringFilm = new String[17];
		for ( int i = 0; i < rawFilm.size();i++ ){
			stringFilm[i] = rawFilm.get( i ).getAsString();
		}
		return stringFilm;
	}
}
