package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.List;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class moviesList extends JFrame {

	private JFrame frame;
	private JMenu mnMenu;
	private JMenuItem mntmLoad;
	private Panel panel;
	private List listMovies;
	private JTextField textFieldTitle;
	private JTextField textFieldYear;
	private JTextField textFieldSynopsis;
	private JButton btnSave;

	/**
	 * Quitamos el main ya que la vista la arranca el controlador
	 */

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

		textFieldTitle = new JTextField();
		textFieldTitle.setBounds(316, 122, 86, 20);
		panel.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		textFieldYear = new JTextField();
		textFieldYear.setBounds(316, 158, 86, 20);
		panel.add(textFieldYear);
		textFieldYear.setColumns(10);

		textFieldSynopsis = new JTextField();
		textFieldSynopsis.setBounds(316, 204, 86, 20);
		panel.add(textFieldSynopsis);
		textFieldSynopsis.setColumns(10);

		JLabel lblTitle = new JLabel("Titulo");
		lblTitle.setBounds(316, 106, 46, 14);
		panel.add(lblTitle);

		JLabel lblYear = new JLabel("A\u00F1o");
		lblYear.setBounds(316, 145, 46, 14);
		panel.add(lblYear);

		JLabel lblSynop = new JLabel("Sinopsis");
		lblSynop.setBounds(316, 189, 46, 14);
		panel.add(lblSynop);

		btnSave = new JButton("Guardar pel\u00EDcula");
		btnSave.setBounds(316, 248, 125, 23);
		panel.add(btnSave);
	}

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

	public JTextField getTextFieldTitle() {
		return textFieldTitle;
	}

	public JTextField getTextFieldYear() {
		return textFieldYear;
	}

	public JTextField getTextFieldSynopsis() {
		return textFieldSynopsis;
	}

	public JButton getBtnSave() {
		return btnSave;
	}
}
