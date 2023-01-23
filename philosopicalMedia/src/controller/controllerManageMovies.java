package controller;
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

		// Cerrar ventana al darle a cancelar
		//view.get_btnCANCELA().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cancelar()));

		// Cerrar ventana al darle a cancelar
		//view.get_btnACEPTAR().addActionListener(e -> SwingUtil.exceptionWrapper(() -> aceptar()));

		// Anadir eventos con reportaje al combobox correspondiente al guardar
		//view.get_btnGUARDAR().addActionListener(e -> SwingUtil.exceptionWrapper(() -> distribuir()));

		// Obtener empresas del evento seleccionado por defecto y activa el boton
		// distribuir si hubiera
		//if (view.get_comboEVREPOR().getItemCount() > 0) {
		//	getEmpresas();
		//	activaDistribuir();
		//}

		// Comprobar si hay empresas a las que se le ha ofrecido un reportaje de un
		// evento
		//view.get_comboEVREPOR().addItemListener(e -> SwingUtil.exceptionWrapper(() -> {
		//	getEmpresas();
			//activaDistribuir();
		//}));

	}

	
	
}
