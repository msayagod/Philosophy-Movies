package philosopicalMedia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import controller.*;
import model.*;
import view.*;

import java.awt.Panel;
import java.awt.Button;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Button btnManageMovies = new Button("Manage Movies");
		btnManageMovies.setBounds(95, 82, 244, 71);
		btnManageMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Nuevo controlador que recibe modelo y vista e inicio del controller
				controllerManageMovies controller = new controllerManageMovies(new moviesList(), new modelManageMovies());
				controller.initController();
			}
		});
		
		panel.add(btnManageMovies);
		
		
	
		
	}

}
