package control;
import java.util.ArrayList;
import java.util.List;

import entity.Movie;

public class MovieRepository implements IMovieRepository {
	List<Movie> movieList = new ArrayList<Movie>();

	@Override
	public boolean createMovie(Movie movie) {
		boolean ok;
		try {
			ok=movieList.add(movie);
		} catch (Exception e) {
			ok=false;
		}
		return ok;
	}

	@Override
	public List<Movie> readMovie(Movie movie) {
		return movieList;
	}

	@Override
	public boolean updateMovie(Movie movie) {
		for (int i = 0; i < movieList.size(); i++) {
			Movie existingMovie = movieList.get(i);
			
			if (existingMovie.getName() == movie.getName()) {
				movieList.set(i,  movie);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteMovie(String val) {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getName() == val) {
				movieList.remove(i);
				return true;
			}
		}
		return false;
	}
}
