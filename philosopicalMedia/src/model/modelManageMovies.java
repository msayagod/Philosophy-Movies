package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class modelManageMovies {

	private String db = "philMedia.db";

	private String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n" + "	id integer PRIMARY KEY,\n"
			+ "	name text NOT NULL,\n" + "	capacity real\n" + ");";

	private Connection conn;

	public modelManageMovies() {
		super();
		conn = Databases.connect(db);
	}

	//Add new movie (not yet director)
	public void newMovie(String title, int year, String synopsis) {
		
		String sql = "INSERT INTO Movies (title, year, synopsis) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			
			pstmnt.setString(1, title);
			pstmnt.setInt(2, year);
			pstmnt.setString(3, synopsis);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
