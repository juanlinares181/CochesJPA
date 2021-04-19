package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.Cliente;
import model.Coche;
import model.Concesionario;
import model.Fabricante;
import model.Venta;
import model.controllers.ControladorCliente;
import model.controllers.ControladorCoche;
import model.controllers.ControladorConcesionario;
import model.controllers.ControladorFabricante;
import model.controllers.ControladorVenta;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelVentas extends JPanel {

	Venta actual = new Venta();

	private JTextField jtfId;
	private JTextField jtfFecha;
	private JTextField jtfPrecioVenta;
	private JTextField jtfCliente;
	private JTextField jtfCoche;
	private JTextField jtfConcesionario;
	private JComboBox<Concesionario> jcbConcesionario;
	private JComboBox<Cliente> jcbCliente;

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

		JLabel lblNewLabel_1 = new JLabel("Concesionario:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbConcesionario = new JComboBox();
		GridBagConstraints gbc_jcbConcesionario = new GridBagConstraints();
		gbc_jcbConcesionario.insets = new Insets(0, 0, 5, 0);
		gbc_jcbConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbConcesionario.gridx = 1;
		gbc_jcbConcesionario.gridy = 1;
		add(jcbConcesionario, gbc_jcbConcesionario);

		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbCliente = new JComboBox();
		GridBagConstraints gbc_jcbCliente = new GridBagConstraints();
		gbc_jcbCliente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCliente.gridx = 1;
		gbc_jcbCliente.gridy = 2;
		add(jcbCliente, gbc_jcbCliente);

		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 3;
		this.add(jtfFecha, gbc_jtfId);
		jtfFecha.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("PrecioVenta:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		this.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfPrecioVenta = new JTextField();
		GridBagConstraints gbc_jtfPrecioVenta = new GridBagConstraints();
		gbc_jtfPrecioVenta.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrecioVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecioVenta.gridx = 1;
		gbc_jtfPrecioVenta.gridy = 4;
		this.add(jtfPrecioVenta, gbc_jtfPrecioVenta);
		jtfPrecioVenta.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("IdCliente:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfCliente = new JTextField();
		GridBagConstraints gbc_jtfCliente = new GridBagConstraints();
		gbc_jtfCliente.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCliente.gridx = 1;
		gbc_jtfCliente.gridy = 5;
		this.add(jtfCliente, gbc_jtfCliente);
		jtfCliente.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Coche:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfCoche = new JTextField();
		GridBagConstraints gbc_jtfCoche = new GridBagConstraints();
		gbc_jtfCoche.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCoche.gridx = 1;
		gbc_jtfCoche.gridy = 6;
		this.add(jtfCoche, gbc_jtfCoche);
		jtfCoche.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Concesionario:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		this.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfConcesionario = new JTextField();
		GridBagConstraints gbc_jtfConcesionario = new GridBagConstraints();
		gbc_jtfConcesionario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfConcesionario.gridx = 1;
		gbc_jtfConcesionario.gridy = 7;
		this.add(jtfConcesionario, gbc_jtfConcesionario);
		jtfConcesionario.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);

		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);

		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);

		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);

		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);

		cargarDatosCliente();
		this.actual = ControladorVenta.getInstance().findPrimero();
		cargarActualEnPantalla();

		cargarDatosConcesionario();
		this.actual = ControladorVenta.getInstance().findPrimero();
		cargarActualEnPantalla();

	}

	/**
	 * 
	 */
	private void cargarDatosConcesionario() {
		List<Concesionario> concesionario = ControladorConcesionario.getInstance().findAll();

		for (Concesionario co : concesionario) {
			this.jcbConcesionario.addItem(co);
		}
	}

	/**
	 * 
	 */
	private void cargarDatosCliente() {
		List<Cliente> clientes = ControladorCliente.getInstance().findAll();

		for (Cliente cl : clientes) {
			this.jcbCliente.addItem(cl);
		}
	}

	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfFecha.setText("" + this.actual.getId());
			this.jtfPrecioVenta.setText("" + this.actual.getPrecioVenta());
			this.jtfCliente.setText("" + this.actual.getCliente());
			this.jtfCoche.setText("" + this.actual.getCoche());
			this.jtfConcesionario.setText("" + this.actual.getConcesionario());

			for (int i = 0; i < this.jcbCliente.getItemCount(); i++) {
				if (this.actual.getCliente().getId() == this.jcbCliente.getItemAt(i).getId()) {
					this.jcbCliente.setSelectedIndex(i);
				}
			}

			for (int i = 0; i < this.jcbConcesionario.getItemCount(); i++) {
				if (this.actual.getConcesionario().getId() == this.jcbConcesionario.getItemAt(i).getId()) {
					this.jcbConcesionario.setSelectedIndex(i);
				}
			}
		}
	}

	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		this.actual.setFecha(jtfFecha.getText());
		this.actual.setPrecioVenta(Integer.parseInt(jtfPrecioVenta.getText()));
		this.actual.setCliente(Integer.parseInt(jtfCliente.getText()));
		this.actual.setConcesionario(Integer.parseInt(jtfConcesionario.getText()));
		this.actual.setCoche(Integer.parseInt(jtfCoche.getText()));
		Cliente cl = (Cliente) jcbCliente.getSelectedItem();
		this.actual.setCliente(cl);
		Concesionario co = (Concesionario) jcbConcesionario.getSelectedItem();
		this.actual.setConcesionario(co);
	}

	/**
	 * 
	 */
	private void vaciarCampos() {
		this.jtfId.setText("0");
		this.jtfFecha.setText("");
		this.jtfPrecioVenta.setText("");
		this.jtfCliente.setText("");
		this.jtfCoche.setText("");
		this.jtfConcesionario.setText("");
		this.jcbCliente.setSelectedIndex(0);
		this.jcbConcesionario.setSelectedIndex(0);
	}

	/**
	 * 
	 */
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorVenta.getInstance().guardar(this.actual);
		if (resultado == true && this.actual != null && this.actual.getId() > 0) {
			this.jtfId.setText("" + this.actual.getId());
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Error al guardar");
		}
	}

}
