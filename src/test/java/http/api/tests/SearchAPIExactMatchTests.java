package http.api.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import api.management.APIResponseManager;
import config.management.ConfigManager;
import database.management.ImdbDataManager;
import object.management.models.Film;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonArray;

public class SearchAPIExactMatchTests {

	private static final String API_ADDRESS = ConfigManager.apiAddress();
	private static Response response;
	private static JsonArray movieArray;
	private static Film apiFilm;
	private static Film dbFilm;

	@BeforeAll
	private static void setup(){
		String url = "http://"+API_ADDRESS+"/search?title=";

		APIResponseManager apiResponseManager = new APIResponseManager();
		ImdbDataManager imdbDataManager = new ImdbDataManager();

		dbFilm = imdbDataManager.getFilmFromRawData();

		response = given().get(url+dbFilm.getMovieTitle());

		movieArray = response.as( JsonArray.class ).get(0).getAsJsonObject().getAsJsonArray("movie_id");

		apiFilm = apiResponseManager.getFilmFromResponse( movieArray );
	}

	@Test
	public void validateTitle(){
		assertEquals( apiFilm.getMovieTitle(), dbFilm.getMovieTitle() );
	}
	@Test
	public void validateDuration(){
		assertEquals( apiFilm.getDuration(), dbFilm.getDuration() );
	}
	@Test
	public void validateColour(){
		assertEquals( apiFilm.getColour(), dbFilm.getColour() );
	}
	@Test
	public void validateDirector(){
		assertEquals( apiFilm.getDirector(), dbFilm.getDirector() );
	}
	@Test
	public void validateActorOne(){
		assertEquals( apiFilm.getActorOne(), dbFilm.getActorOne() );
	}
	@Test
	public void validateActorTwo(){
		assertEquals( apiFilm.getActorTwo(), dbFilm.getActorTwo() );
	}
	@Test
	public void validateActorThree(){
		assertEquals( apiFilm.getActorThree(), dbFilm.getActorThree() );
	}
	@Test
	public void validateGross(){
		assertEquals( apiFilm.getGross(), dbFilm.getGross() );
	}
	@Test
	public void validateGenres(){
		assertEquals( apiFilm.getGenres(), dbFilm.getGenres() );
	}
	@Test
	public void validatePlotKeywords(){
		assertEquals( apiFilm.getPlotKeywords(), dbFilm.getPlotKeywords() );
	}
	@Test
	public void validateLanguage(){
		assertEquals( apiFilm.getLanguage(), dbFilm.getLanguage() );
	}
	@Test
	public void validateCountry(){
		assertEquals( apiFilm.getCountry(), dbFilm.getCountry() );
	}
	@Test
	public void validateContentRating(){
		assertEquals( apiFilm.getContentRating(), dbFilm.getContentRating() );
	}
	@Test
	public void validateBudget(){
		assertEquals( apiFilm.getBudget(), dbFilm.getBudget() );
	}
	@Test
	public void validateTitleYear(){
		assertEquals( apiFilm.getTitleYear(), dbFilm.getTitleYear() );
	}
	@Test
	public void validateImdbScore(){
		assertEquals( apiFilm.getImdbScore(), dbFilm.getImdbScore() );
	}



}
