package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		view.setVisible(true);
	}

	/**
	 * MANEJADORES DE EVENTOS
	 */
	public void initController() {

//Version elegante con funcion lambda
		view.getBtnSave().addActionListener(e -> addMovie());

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
		model.newMovie(view.getTextFieldTitle().getText(), Integer.parseInt(view.getTextFieldYear().getText()), view.getTextFieldSynopsis().getText());

	}

}
