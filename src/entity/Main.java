package entity;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import control.MovieRepository;


public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		MovieRepository movieRep = new MovieRepository();
		
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=vote_average.desc&vote_count.gte=500"))
			    .header("accept", "application/json")
			    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYTU1YzY5MjZlMThkMGVkOGY1ZDA2YmNjMWVhYWM5YiIsInN1YiI6IjY1MWMyMzgyMjIzYThiMDBlMWZiNjk3NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.wVg-HIPvJQEDXr6f_ZpiyqmdEiVZk52fSDDkXEk_Pl0")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			JSONObject jsonObject = new JSONObject(response.body());
			JSONArray jsonArray = jsonObject.getJSONArray("results");
			Movie[] movies = new Movie[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject movieObject = jsonArray.getJSONObject(i);
				String name = movieObject.getString("title");
				float popularity = movieObject.getFloat("popularity");
				float voteAverage = movieObject.getFloat("vote_average");
				int voteCount = movieObject.getInt("vote_count");
				String releaseDate = movieObject.getString("release_date");
				Movie movie = new Movie(name, (i + 1), popularity, voteAverage, voteCount, releaseDate);
				movies[i] = movie;
				movieRep.createMovie(movie);
			}
			
			System.out.println(movieRep.readMovie(null));
		}
	}
