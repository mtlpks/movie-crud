package entity;

public class Movie {
	private String name;
	private int id;
	private float popularity;
	private float voteAverage;
	private int voteCount;
	private String releaseDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPopularity() {
		return popularity;
	}

	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}

	public float getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(float voteAverage) {
		this.voteAverage = voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String toString() {
		return  "Movie Title: " + name + "\n" +
				"Movie Popularity: " + popularity + "\n" +
				"Movie Vote Average: " + voteAverage + "\n" +
				"Movie Vote Count: " + voteCount + "\n" +
				"Movie Release Date: " + releaseDate + "\n";
	}
	
	public Movie(String name, int id, float popularity, float voteAverage, int voteCount, String releaseDate) {
		this.setName(name);
		this.setId(id);
		this.setPopularity(popularity);
		this.setVoteAverage(voteAverage);
		this.setVoteCount(voteCount);
		this.setReleaseDate(releaseDate);
	}
}
