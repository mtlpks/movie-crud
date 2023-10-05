package control;

import java.util.List;

import entity.Movie;

public interface IMovieRepository {
	boolean createMovie(Movie movie);
	public List<Movie> readMovie(Movie movie);
	public boolean updateMovie(Movie movie);
	public boolean deleteMovie(String val);
}
