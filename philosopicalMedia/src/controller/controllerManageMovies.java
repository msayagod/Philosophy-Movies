package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

public class controllerManageMovies {
	private moviesList view;
	private modelManageMovies model;

	public controllerManageMovies(moviesList view, modelManageMovies model) {
		super();
		this.view = view;
		this.model = model;
	}

	public void initView() {

		// Abre la vista
		view.getFrame().setVisible(true);
	}

	/**
	 * MANEJADORES DE EVENTOS
	 */
	public void initController() {

//Version elegante con funcion lambda
		view.getBtnSave().addActionListener(e -> addMovie());
		
		view.getBtnShow().addActionListener(e -> setMovies());

		initView();

//		view.getBtnSave().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				addMovie();
//			}
//		});

		// Cerrar ventana al darle a cancelar
		// view.get_btnCANCELA().addActionListener(e -> SwingUtil.exceptionWrapper(() ->
		// cancelar()));

		// Cerrar ventana al darle a cancelar

	}

	public void addMovie() {
		filmaffinityScrap fas = new filmaffinityScrap();
		
		MovieEntity movie = fas.getMovie(fas.getHTMLMovie(view.getTextFieldTitle().getText(), Integer.parseInt(view.getTextFieldYear().getText())));
		
		if(movie == null) {
			view.getLblNoMovie().setVisible(true);
			return;
		}
		
		model.newMovie(movie);
	

	}

	public void setMovies() {

		// Disponer columnas de la tabla
		DefaultTableModel table = new DefaultTableModel();
		table.addColumn("Id");
		table.addColumn("Titulo");
		table.addColumn("Año");
		table.addColumn("Sinopsis");

		// Obtener peliculas
		ArrayList<MovieEntity> movies = (ArrayList<MovieEntity>) model.getMovies();

		// Iterator de la lista con movies
		ListIterator<MovieEntity> it = movies.listIterator();

		MovieEntity mv;

		// Add rows a la tabla
		while (it.hasNext()) {
			mv = it.next();
			Vector<Object> row = new Vector<Object>();
			row.add(mv.getIdMovie());
			row.add(mv.getTitle());
			row.add(mv.getYear());
			row.add(mv.getSynopsis());
			table.addRow(row);
		}
		
		view.getTable().setModel(table);

	}

}
