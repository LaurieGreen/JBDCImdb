package object.management.models;

public class Film {
	private int movieId;
	private String movieTitle;
	private int duration;
	private String colour;
	private String director;
	private String actorOne;
	private String actorTwo;
	private String actorThree;
	private int gross;
	private String genres;
	private String plotKeywords;
	private String language;
	private String country;
	private String contentRating;
	private int budget;
	private String titleYear;
	private double imdbScore;

	public Film(String[] filmData) {
		this.movieId = Integer.parseInt(filmData[0]);
		this.movieTitle = filmData[1];
		this.duration = Integer.parseInt(filmData[2]);
		this.colour = filmData[3];
		this.director = filmData[4];
		this.actorOne = filmData[5];
		this.actorTwo = filmData[6];
		this.actorThree = filmData[7];
		this.gross = Integer.parseInt(filmData[8]);
		this.genres = filmData[9];
		this.plotKeywords = filmData[10];
		this.language = filmData[11];
		this.country = filmData[12];
		this.contentRating = filmData[13];
		this.budget = Integer.parseInt(filmData[14]);
		this.titleYear = filmData[15];
		this.imdbScore = Double.parseDouble(filmData[16]);
	}

	public int getMovieId() {
		return movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public int getDuration() {
		return duration;
	}

	public String getColour() {
		return colour;
	}

	public String getDirector() {
		return director;
	}

	public String getActorOne() {
		return actorOne;
	}

	public String getActorTwo() {
		return actorTwo;
	}

	public String getActorThree() {
		return actorThree;
	}

	public int getGross() {
		return gross;
	}

	public String getGenres() {
		return genres;
	}

	public String getPlotKeywords() {
		return plotKeywords;
	}

	public String getLanguage() {
		return language;
	}

	public String getCountry() {
		return country;
	}

	public String getContentRating() {
		return contentRating;
	}

	public int getBudget() {
		return budget;
	}

	public String getTitleYear() {
		return titleYear;
	}

	public double getImdbScore() {
		return imdbScore;
	}

	@Override
	public String toString() {
		return "object.management.models.Film{" + "movieId=" + movieId + ", movieTitle='" + movieTitle + '\'' + ", duration=" + duration + ", colour='" + colour + '\'' + ", director='" + director + '\'' + ", actorOne='" + actorOne + '\'' + ", actorTwo='" + actorTwo + '\'' + ", actorThree='" + actorThree + '\'' + ", gross=" + gross + ", genres='" + genres + '\'' + ", plotKeywords='" + plotKeywords + '\'' + ", language='" + language + '\'' + ", country='" + country + '\'' + ", contentRating='" + contentRating + '\'' + ", budget=" + budget + ", titleYear='" + titleYear + '\'' + ", imdbScore=" + imdbScore + '}';
	}
}
