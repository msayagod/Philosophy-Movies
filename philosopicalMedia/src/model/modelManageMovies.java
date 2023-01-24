package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class modelManageMovies {

	private String db = "philMedia.db";
	private Connection conn;

	public modelManageMovies() {
		super();
		conn = Databases.connect(db);
	}

	// Add new movie (not yet director)
	public void newMovie(MovieEntity movie) {

		String sql = "INSERT INTO Movies (title, year, synopsis) VALUES (?, ?, ?)";

		try {
			PreparedStatement pstmnt = conn.prepareStatement(sql);

			pstmnt.setString(1, movie.getTitle());
			pstmnt.setInt(2, movie.getYear());
			pstmnt.setString(3, movie.getSynopsis());

			System.out.println("He llegado aqui");
			Boolean a = pstmnt.execute();
			System.out.println(a);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Obtiene una pelicula especifica
	public MovieEntity getMovie(int id) {
		MovieEntity m = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM Movies WHERE idMovie=?";

		try {
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			pstmnt.setInt(1, id);

			rs = pstmnt.executeQuery();

			if (rs != null) {
				m = new MovieEntity();
				// Rellenamos la entidad Movie
				m.setIdMovie(rs.getInt("idMovie"));
				m.setTitle(rs.getString("title"));
				m.setYear(rs.getInt("year"));
				m.setSynopsis(rs.getString("synopsis"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;
	}

	// Obtiene una lista de todas las peliculas
	public List<MovieEntity> getMovies() {
		MovieEntity mv;
		List<MovieEntity> m = new ArrayList<MovieEntity>();
		ResultSet rs = null;

		String sql = "SELECT * FROM Movies";

		try {

			Statement stmnt = conn.createStatement();

			rs = stmnt.executeQuery(sql);

			while (rs.next()) {
				mv = new MovieEntity();
				mv.setIdMovie(rs.getInt("idMovie"));
				mv.setTitle(rs.getString("title"));
				mv.setYear(rs.getInt("year"));
				mv.setSynopsis(rs.getString("synopsis"));
				m.add(mv);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;
	}

}
