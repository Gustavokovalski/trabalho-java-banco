

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ClientesFrame extends JFrame {
	private ModeloCliente modelo = new ModeloCliente();
	private Cliente selecionado = null;

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtRG;
	private JTextField txtCPF;
	private JTextField txtId;
	private JTable table;
	private JTextField txtEndereco;
	private JTextField txtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesFrame frame = new ClientesFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 558);
		contentPane = new JPanel();
		contentPane.setToolTipText("M");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(166, 59, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(222, 57, 198, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSobrenome.setBounds(430, 59, 64, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(504, 57, 198, 20);
		contentPane.add(txtSobrenome);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRg.setBounds(430, 88, 64, 14);
		contentPane.add(lblRg);
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		txtRG.setBounds(504, 86, 198, 20);
		contentPane.add(txtRG);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCpf.setBounds(166, 88, 64, 14);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(222, 86, 198, 20);
		contentPane.add(txtCPF);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblId.setBounds(22, 59, 46, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(78, 57, 46, 20);
		contentPane.add(txtId);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEndereco.setBounds(430, 119, 64, 14);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(504, 117, 198, 20);
		contentPane.add(txtEndereco);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 214, 680, 297);
		contentPane.add(scrollPane);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSexo.setBounds(22, 88, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboSexo = new JComboBox();
		comboSexo.setToolTipText("M");
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboSexo.setBounds(77, 85, 53, 22);
		contentPane.add(comboSexo);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(22, 120, 46, 14);
		contentPane.add(lblEstado);
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"PR", "SP"}));
		comboEstado.setToolTipText("M");
		comboEstado.setBounds(78, 116, 53, 22);
		contentPane.add(comboEstado);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCidade.setBounds(166, 119, 64, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(222, 117, 198, 20);
		contentPane.add(txtCidade);
		
		JLabel lblManterCliente = new JLabel("Manter Cliente");
		lblManterCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblManterCliente.setFont(new Font("Arial", Font.BOLD, 20));
		lblManterCliente.setBounds(22, 12, 680, 20);
		contentPane.add(lblManterCliente);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(txtId.getText());
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				char sexo = comboSexo.getSelectedItem().toString().charAt(0);
				String CPF = txtCPF.getText();
				String RG = txtRG.getText();
				String estado = comboEstado.getSelectedItem().toString();
				String cidade = txtCidade.getText();
				String endereco = txtEndereco.getText();
				Cliente c = new Cliente(nome, sobrenome, sexo, CPF, RG, estado, cidade, endereco);
				modelo.adicionar(c);
				limparCampos();
			}
		});
		btnAdicionar.setBounds(22, 169, 91, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.remover(selecionado);
				limparCampos();
			}
		});
		btnRemover.setBounds(238, 169, 91, 23);
		contentPane.add(btnRemover);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(txtId.getText());
				String nome = txtNome.getText();
				String sobrenome = txtSobrenome.getText();
				char sexo = comboSexo.getSelectedItem().toString().charAt(0);
				String CPF = txtCPF.getText();
				String RG = txtRG.getText();
				String estado = comboEstado.getSelectedItem().toString();
				String cidade = txtCidade.getText();
				String endereco = txtEndereco.getText();
				Cliente c = new Cliente(nome, sobrenome, sexo, CPF, RG, estado, cidade, endereco);
				int index = table.getSelectedRow();
				modelo.atualizar(index, c);
				limparCampos();
			}
		});
		btnSalvar.setBounds(130, 169, 91, 23);
		contentPane.add(btnSalvar);
		

		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Cliente c = modelo.getCliente(table.getSelectedRow());
				txtId.setText(Integer.toString(c.getId()));
				txtNome.setText(c.getNome());
				txtSobrenome.setText(c.getSobrenome());
				txtCPF.setText(c.getCpf());
				txtRG.setText(c.getRg());
				txtEndereco.setText(c.getEndereco());
				selecionado = c;
			}
		});
		table.setModel(modelo);
		table.setBorder(new CompoundBorder());
		

	}
	
	public void limparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtSobrenome.setText("");
		txtCPF.setText("");
		txtRG.setText("");
		txtEndereco.setText("");
	}
}
