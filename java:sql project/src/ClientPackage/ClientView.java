package ClientPackage;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ServerPackage.Client;

/**
 * Class for constructing the GUI for the Client
 * 
 * @author SoniaObi
 *
 */

public class ClientView {

	public JFrame frame;
	private JButton btnSearch;
	private JTextField textField; // clientSearchBox
	private JTextField clientID; // clientID
	private JTextField clientFirstName; // clientFirstName
	private JTextField clientLastName; // clientLastName
	private JTextField clientAddress; // clientAddress
	private JTextField clientPostalCode; // clientPostalCode
	private JTextField clientPhoneNum; // clientPhoneNum
	private JButton btnNewButton; // save button
	private JButton btnDelete; // delete button
	private JButton btnModify; // modify button

	private JComboBox comboBox;

	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnClientType;
	private JRadioButton rdbtnLastName;
	JScrollPane scrollPane_1;

	private ButtonGroup group;
	private JList<Client> list;

	/**
	 * Create the application.
	 */
	public ClientView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setSize(450, 300);

		frame.setTitle("Client Management Screen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("");
		label.setBounds(-1400, -856, 450, 272);
		frame.getContentPane().add(label);

		JPanel panel = new JPanel();
		panel.setBounds(253, 6, 191, 260);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		btnNewButton = new JButton("Save");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnNewButton.setBounds(0, 231, 53, 29);
		panel.add(btnNewButton);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnDelete.setBounds(95, 231, 53, 29);
		panel.add(btnDelete);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				resetClientInformation();
			}
		});

		btnClear.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnClear.setBounds(138, 231, 53, 29);
		panel.add(btnClear);

		JLabel lblNewLabel_1 = new JLabel("Client ID:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblNewLabel_1.setBounds(24, 29, 53, 16);
		panel.add(lblNewLabel_1);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.DARK_GRAY);
		lblFirstName.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblFirstName.setBounds(24, 57, 53, 16);
		panel.add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblLastName.setBounds(24, 85, 53, 16);
		panel.add(lblLastName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblAddress.setBounds(24, 113, 34, 16);
		panel.add(lblAddress);

		JLabel lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setForeground(Color.DARK_GRAY);
		lblPostalCode.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblPostalCode.setBounds(24, 141, 53, 16);
		panel.add(lblPostalCode);

		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setForeground(Color.DARK_GRAY);
		lblPhone.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblPhone.setBounds(24, 169, 60, 16);
		panel.add(lblPhone);

		JLabel lblClientType = new JLabel("Client Type:");
		lblClientType.setForeground(Color.DARK_GRAY);
		lblClientType.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblClientType.setBounds(24, 197, 53, 16);
		panel.add(lblClientType);

		clientID = new JTextField();
		clientID.setEnabled(false);
		clientID.setColumns(10);
		clientID.setBounds(84, 27, 104, 16);
		panel.add(clientID);

		clientFirstName = new JTextField();
		clientFirstName.setColumns(10);
		clientFirstName.setBounds(83, 57, 104, 16);
		panel.add(clientFirstName);

		clientLastName = new JTextField();
		clientLastName.setColumns(10);
		clientLastName.setBounds(83, 85, 104, 16);
		panel.add(clientLastName);

		clientAddress = new JTextField();
		clientAddress.setColumns(10);
		clientAddress.setBounds(83, 113, 104, 16);
		panel.add(clientAddress);

		clientPostalCode = new JTextField();
		clientPostalCode.setColumns(10);
		clientPostalCode.setBounds(82, 142, 104, 16);
		panel.add(clientPostalCode);

		clientPhoneNum = new JTextField();
		clientPhoneNum.setColumns(10);
		clientPhoneNum.setBounds(83, 170, 104, 16);
		panel.add(clientPhoneNum);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "...", "R", "C" }));
		comboBox.setBounds(76, 197, 53, 25);
		panel.add(comboBox);

		JLabel lblClientInformation_1 = new JLabel("Client Information");
		lblClientInformation_1.setForeground(Color.BLACK);
		lblClientInformation_1.setFont(new Font("Dialog", Font.BOLD, 9));
		lblClientInformation_1.setBounds(62, 0, 86, 16);
		panel.add(lblClientInformation_1);

		btnModify = new JButton("Modify");
		btnModify.setFont(new Font("Dialog", Font.PLAIN, 9));
		btnModify.setBounds(44, 231, 60, 29);
		panel.add(btnModify);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 235, 118);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(110, 81, 57, 29);

		panel_1.add(btnSearch);
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 7));

		JButton btnClearSearch = new JButton("Clear Search");
		btnClearSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				resetClientSearchBox();

			}
		});

		btnClearSearch.setFont(new Font("Dialog", Font.PLAIN, 7));
		btnClearSearch.setBounds(161, 82, 74, 27);
		panel_1.add(btnClearSearch);

		textField = new JTextField();
		textField.setBounds(7, 88, 104, 16);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Enter the search parameter below: ");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblNewLabel.setBounds(0, 69, 133, 16);
		panel_1.add(lblNewLabel);

		JLabel lblSelectTypeOf = new JLabel("Select type of search to perform: ");
		lblSelectTypeOf.setForeground(Color.DARK_GRAY);
		lblSelectTypeOf.setFont(new Font("Dialog", Font.PLAIN, 8));
		lblSelectTypeOf.setBounds(0, 0, 133, 16);
		panel_1.add(lblSelectTypeOf);

		rdbtnNewRadioButton = new JRadioButton("Client ID");
		rdbtnNewRadioButton.setForeground(Color.DARK_GRAY);
		rdbtnNewRadioButton.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		rdbtnNewRadioButton.setBounds(7, 13, 141, 16);
		panel_1.add(rdbtnNewRadioButton);

		rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setForeground(Color.DARK_GRAY);
		rdbtnLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		rdbtnLastName.setBounds(7, 33, 141, 16);
		panel_1.add(rdbtnLastName);

		rdbtnClientType = new JRadioButton("Client Type");
		rdbtnClientType.setForeground(Color.DARK_GRAY);
		rdbtnClientType.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		rdbtnClientType.setBounds(7, 53, 141, 16);
		panel_1.add(rdbtnClientType);

		group = new ButtonGroup();
		group.add(rdbtnClientType);
		group.add(rdbtnLastName);
		group.add(rdbtnNewRadioButton);

		JLabel lblSearchClients = new JLabel("Search Clients");
		lblSearchClients.setForeground(Color.BLACK);
		lblSearchClients.setFont(new Font("Dialog", Font.BOLD, 9));
		lblSearchClients.setBounds(160, 0, 75, 16);
		panel_1.add(lblSearchClients);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setBounds(6, 127, 235, 139);
		frame.getContentPane().add(scrollPane_1);

		JLabel lblClientInformation = new JLabel("Client Information");
		lblClientInformation.setBounds(315, 6, 71, 16);
		frame.getContentPane().add(lblClientInformation);
		lblClientInformation.setForeground(Color.BLACK);
		lblClientInformation.setFont(new Font("Dialog", Font.PLAIN, 7));

		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {

				Client valueObj = list.getSelectedValue();

				// Set for the objects

				System.out.println(valueObj);

			}
		};
	}

	/**
	 * function to retrieve the text field for client ID
	 * 
	 * @return client ID field
	 */
	public int getClientID() {
		return Integer.parseInt(clientID.getText());
	}

	/**
	 * function to retrieve text field for first name
	 * 
	 * @return first name field
	 */

	public String getFirstName() {
		return clientFirstName.getText();
	}

	/**
	 * function to retrieve the text field for last name
	 * 
	 * @return last name field
	 */
	public String getLastName() {
		return clientLastName.getText();
	}

	/**
	 * function to retreive text field for client address
	 * 
	 * @return address field
	 */
	public String getClientAddress() {
		return clientAddress.getText();
	}

	/**
	 * function to retrieve text field for postal code
	 * 
	 * @return postal code field
	 */
	public String getClientPostalCode() {
		return clientPostalCode.getText();
	}

	/**
	 * function to retrieve text field for phone number
	 * 
	 * @return phone number field
	 */
	public String getClientPhoneNum() {
		return clientPhoneNum.getText();
	}

	/**
	 * function to retrieve client search text field
	 * 
	 * @return client search field
	 */
	public String getClientSearch() {
		return textField.getText();
	}

	/**
	 * function to get which radio button was selected
	 * 
	 * @return the string linked to whichever radio button is selected
	 */
	public String getRadioButton() {

		if (rdbtnNewRadioButton.isSelected())
			return "IDButton";

		else if (rdbtnClientType.isSelected())
			return "TypeButton";

		else if (rdbtnLastName.isSelected())
			return "NameButton";

		return null;

	}

	/**
	 * function to reset the client information
	 */
	public void resetClientInformation() {
		clientID.setText("");
		clientFirstName.setText("");
		clientLastName.setText("");
		clientAddress.setText("");
		clientPostalCode.setText("");
		clientPhoneNum.setText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "...", "R", "C" }));
		return;
	}

	/**
	 * function to reset the client search box
	 */
	public void resetClientSearchBox() {
		textField.setText("");
		rdbtnNewRadioButton.setSelected(false);
		rdbtnLastName.setSelected(false);
		rdbtnClientType.setSelected(false);

		return;
	}

	/**
	 * function to set scroll pane to the client list results
	 * 
	 * @param Clist
	 */
	public void setscrollpane(ArrayList<Client> Clist) {

		list = new JList(Clist.toArray());

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (!e.getValueIsAdjusting()) {
					JList source = (JList) e.getSource();
					String selected = source.getSelectedValue().toString();
					String[] selected_arr = selected.split(" ");

					String s = "";

					for (int i = 5; i <= selected_arr.length - 3; i++)
						s += (selected_arr[i] + " ");

					int len = selected_arr.length;
					String postalCode = (selected_arr[len - 2]) + " " + (selected_arr[len - 1]);

					clientID.setText(selected_arr[0]);
					clientFirstName.setText(selected_arr[1]);
					clientLastName.setText(selected_arr[2]);
					comboBox.setSelectedItem(selected_arr[3]);
					clientPhoneNum.setText(selected_arr[4]);
					clientAddress.setText(s.trim());
					clientPostalCode.setText(postalCode);

				}
			}
		});

		list.setSelectedIndex(0);
		list.setVisibleRowCount(10);

		frame.remove(scrollPane_1);
		scrollPane_1 = new JScrollPane(list);
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setBounds(6, 127, 235, 139);

		frame.getContentPane().add(scrollPane_1);

		frame.invalidate();
		frame.validate();
		frame.repaint();

	}

	/**
	 * function to get the client type from the combo box
	 * 
	 * @return the client type in the combo box
	 */
	public String getClientType() {
		return comboBox.getSelectedItem().toString();
	}

	/**
	 * client listener method for adding new client
	 * 
	 * @param listenForSaveButton
	 */
	public void addNewClientListener(ActionListener listenForSaveButton) {
		btnNewButton.addActionListener(listenForSaveButton);
	}

	/**
	 * client listener method for deleting client
	 * 
	 * @param listenForDeleteButton
	 */
	public void deleteClientListener(ActionListener listenForDeleteButton) {
		btnDelete.addActionListener(listenForDeleteButton);
	}

	/**
	 * client listener method for modifying client
	 * 
	 * @param listenforModifyButton
	 */
	public void modifyClientListener(ActionListener listenforModifyButton) {
		btnModify.addActionListener(listenforModifyButton);
	}

	/**
	 * client listener method for searching client
	 * 
	 * @param listenforSearchButton
	 */
	public void searchClientListener(ActionListener listenforSearchButton) {

		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnNewRadioButton) {
					btnSearch.addActionListener(listenforSearchButton);
				}
			}
		});

		rdbtnLastName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnLastName) {
					btnSearch.addActionListener(listenforSearchButton);
				}
			}
		});

		rdbtnClientType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == rdbtnClientType) {
					btnSearch.addActionListener(listenforSearchButton);
				}
			}
		});

	}

}
