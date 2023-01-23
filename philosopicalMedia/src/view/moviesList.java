package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.List;
import java.awt.Label;

public class moviesList extends JFrame {

	private JFrame frame;
	private JMenu mnMenu;
	private JMenuItem mntmLoad;
	private Panel panel;
	private List listMovies;
	
	/**
	 * Quitamos el main ya que la vista la arranca el controlador
	 */

	public JMenu getMnMenu() {
		return mnMenu;
	}

	public JMenuItem getMntmLoad() {
		return mntmLoad;
	}

	public Panel getPanel() {
		return panel;
	}

	public List getListMovies() {
		return listMovies;
	}

	/**
	 * Create the application.
	 */
	public moviesList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 584, 568);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		mnMenu = new JMenu("Archivos");
		menuBar.add(mnMenu);

		mntmLoad = new JMenuItem("Cargar archivo");
		mnMenu.add(mntmLoad);

		JMenuItem mntmSave = new JMenuItem("Guardar archivo");
		mnMenu.add(mntmSave);
		this.getContentPane().setLayout(null);

		panel = new Panel();
		panel.setBounds(0, 0, 568, 507);
		this.getContentPane().add(panel);
		panel.setLayout(null);

		listMovies = new List();
		listMovies.setBounds(0, 26, 284, 481);
		panel.add(listMovies);

		Label labelMovies = new Label("Pel\u00EDculas");
		labelMovies.setBounds(10, 0, 62, 22);
		panel.add(labelMovies);
	}
}
