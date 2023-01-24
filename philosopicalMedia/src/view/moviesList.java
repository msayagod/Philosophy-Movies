package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.List;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class moviesList {
	private JFrame frame;
	private JTextField textFieldTitle;
	private JTextField textFieldYear;
	private JTable table;
	private JButton btnSave;
	private JButton btnShow;
	private JScrollPane scrollPane;
	private JLabel lblNoMovie;

	public JLabel getLblNoMovie() {
		return lblNoMovie;
	}

	/**
	 * Quitamos el main ya que la vista la arranca el controlador
	 */

	public JTable getTable() {
		return table;
	}

	public JFrame getFrame() {
		return frame;
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
		frame = new JFrame();
		frame.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(531, 51, 153, 140);
		frame.getContentPane().add(panel_1);

		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(31, 34, 86, 20);
		panel_1.add(textFieldTitle);

		textFieldYear = new JTextField();
		textFieldYear.setColumns(10);
		textFieldYear.setBounds(31, 70, 86, 20);
		panel_1.add(textFieldYear);

		JLabel lblTitle = new JLabel("Titulo");
		lblTitle.setBounds(31, 18, 46, 14);
		panel_1.add(lblTitle);

		JLabel lblYear = new JLabel("A\u00F1o");
		lblYear.setBounds(31, 57, 46, 14);
		panel_1.add(lblYear);

		btnSave = new JButton("Guardar pel\u00EDcula");
		btnSave.setBounds(6, 102, 125, 23);
		panel_1.add(btnSave);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 37, 453, 536);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnShow = new JButton("Poner peliculas");
		btnShow.setBounds(566, 224, 90, 28);
		frame.getContentPane().add(btnShow);
		
		lblNoMovie = new JLabel("Pel\u00EDcula no encontrada");
		lblNoMovie.setForeground(new Color(255, 0, 0));
		lblNoMovie.setBounds(541, 188, 143, 16);
		lblNoMovie.setVisible(false);
		frame.getContentPane().add(lblNoMovie);
	}

	public JButton getBtnShow() {
		return btnShow;
	}

	public JTextField getTextFieldTitle() {
		return textFieldTitle;
	}

	public JTextField getTextFieldYear() {
		return textFieldYear;
	}

	public JButton getBtnSave() {
		return btnSave;
	}
}
