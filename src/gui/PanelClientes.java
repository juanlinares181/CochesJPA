package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.Cliente;
import model.Fabricante;
import model.controllers.ControladorCliente;
import model.controllers.ControladorCoche;
import model.controllers.ControladorFabricante;

import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClientes extends JPanel {

	Cliente actual = null;

	private JTextField jtfId;
	private JLabel lblNewLabel_1;
	private JTextField jtfNombre;
	private JLabel lblNewLabel_2;
	private JTextField jtfApellidos;
	private JLabel lblNewLabel_3;
	private JTextField jtfLocalidad;
	private JLabel lblNewLabel_4;
	private JTextField jtfDniNie;
	private JLabel lblNewLabel_5;
	private JTextField jtfFechaNac;
	private JLabel lblNewLabel_6;
	private JTextField jtfActivo;
	private JPanel panel;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnBorrar;

	/**
	 * Create the application.
	 */
	public PanelClientes() {
		super();
		initialize();
		this.actual = ControladorCliente.getInstance().findPrimero();
		cargarActualEnPantalla();
	}

	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfNombre.setText("" + this.actual.getNombre());
			this.jtfApellidos.setText("" + this.actual.getApellidos());
			this.jtfLocalidad.setText("" + this.actual.getLocalidad());
			this.jtfDniNie.setText("" + this.actual.getDniNie());
			this.jtfFechaNac.setText("" + this.actual.getFechaNac());
			this.jtfActivo.setText("" + this.actual.getActivo());
		}
	}

	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setNombre(jtfNombre.getText());
		this.actual.setApellidos(jtfApellidos.getText());
		this.actual.setLocalidad(jtfLocalidad.getText());
		this.actual.setDniNie(jtfDniNie.getText());
		this.actual.setFechaNac(jtfFechaNac.getText());
		this.actual.setActivo(jtfActivo.getText());
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		this.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		this.add(jtfNombre, gbc_jtfId);
		jtfNombre.setColumns(10);

		lblNewLabel_2 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 1;
		gbc_jtfApellidos.gridy = 2;
		this.add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);

		lblNewLabel_3 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfLocalidad = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 3;
		this.add(jtfLocalidad, gbc_jtfLocalidad);
		jtfLocalidad.setColumns(10);

		lblNewLabel_4 = new JLabel("DniNie:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfDniNie = new JTextField();
		GridBagConstraints gbc_jtfDniNie = new GridBagConstraints();
		gbc_jtfDniNie.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDniNie.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDniNie.gridx = 1;
		gbc_jtfDniNie.gridy = 4;
		this.add(jtfDniNie, gbc_jtfDniNie);
		jtfDniNie.setColumns(10);

		lblNewLabel_5 = new JLabel("FechaNac:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfFechaNac = new JTextField();
		GridBagConstraints gbc_jtfFechaNac = new GridBagConstraints();
		gbc_jtfFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNac.gridx = 1;
		gbc_jtfFechaNac.gridy = 5;
		this.add(jtfFechaNac, gbc_jtfFechaNac);
		jtfFechaNac.setColumns(10);

		lblNewLabel_6 = new JLabel("Activo:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfActivo = new JTextField();
		GridBagConstraints gbc_jtfActivo = new GridBagConstraints();
		gbc_jtfActivo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfActivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfActivo.gridx = 1;
		gbc_jtfActivo.gridy = 6;
		this.add(jtfActivo, gbc_jtfActivo);
		jtfActivo.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		this.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorCliente.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		panel.add(btnBorrar);

	}

	/**
	 * 
	 */
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorCliente.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			this.jtfId.setText("" + this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}

	/**
	 * 
	 */
	private void vaciarCampos() {
		this.jtfId.setText("0");
		this.jtfActivo.setText("");
		this.jtfApellidos.setText("");
		this.jtfDniNie.setText("0");
		this.jtfFechaNac.setText("");
		this.jtfLocalidad.setText("");
		this.jtfNombre.setText("");
	}

	/**
	 * 
	 */
	private void borrar() {
		String posiblesRespuestas[] = { "Sí", "No" };
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión venta de coches",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas,
				posiblesRespuestas[1]);
		if (opcionElegida == 0) {
			ControladorCliente.getInstance().borrar(this.actual);
		}
	}
}
