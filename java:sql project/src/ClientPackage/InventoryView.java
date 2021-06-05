package ClientPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ServerPackage.Item;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 * 
 * Inventory View class for managing the inventory GUI.
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class InventoryView {

	public JFrame frame;
	JList list;
	private JTextField searchToolName; // Tool Name Search
	private JTextField searchToolId; // ToolID search
	private JTextField quantityResults; // Quantity results
	private JScrollPane scrollPane;
	
	private JButton btnListTools; //button to list tools
	private JButton btnSearchToolName; //button to search tool by name
	private JButton btnSearchToolId; //button to search id name
	private JButton btnCheckQuantity; //button to find quantity
	private JButton btnDecreaseQuantity; //button to decrease quantity

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryView window = new InventoryView();
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
	public InventoryView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(450, 300); 
		
		frame.setTitle("Inventory Management"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 6, 229, 260);
		frame.getContentPane().add(scrollPane);
		
		btnSearchToolName = new JButton("Search Tool Name:");
		btnSearchToolName.setBounds(14, 58, 96, 29);
		btnSearchToolName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearchToolName.setFont(new Font("Dialog", Font.PLAIN, 8));
		frame.getContentPane().add(btnSearchToolName);
		
		searchToolName = new JTextField();
		searchToolName.setBounds(113, 56, 88, 26);
		frame.getContentPane().add(searchToolName);
		searchToolName.setColumns(10);
		
		btnSearchToolId = new JButton("Search Tool ID: ");
		btnSearchToolId.setBounds(15, 99, 96, 29);
		btnSearchToolId.setFont(new Font("Dialog", Font.PLAIN, 8));
		frame.getContentPane().add(btnSearchToolId);
		
		searchToolId = new JTextField();
		searchToolId.setBounds(113, 99, 88, 26);
		searchToolId.setColumns(10);
		frame.getContentPane().add(searchToolId);
		
		btnCheckQuantity = new JButton("Check Quantity");
		btnCheckQuantity.setBounds(20, 157, 96, 29);
		btnCheckQuantity.setFont(new Font("Dialog", Font.PLAIN, 8));
		frame.getContentPane().add(btnCheckQuantity);
		
		btnDecreaseQuantity = new JButton("Decrease Quantity");
		btnDecreaseQuantity.setBounds(113, 157, 96, 29);
		btnDecreaseQuantity.setFont(new Font("Dialog", Font.PLAIN, 8));
		frame.getContentPane().add(btnDecreaseQuantity);
		
		btnListTools = new JButton("List All Tools");
		btnListTools.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnListTools.setBounds(57, 10, 96, 29);
		frame.getContentPane().add(btnListTools);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setFont(new Font("Dialog", Font.PLAIN, 8));
		btnQuit.setBounds(57, 233, 96, 29);
		
		btnQuit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { }
		});
		
		
		frame.getContentPane().add(btnQuit);
		
		quantityResults = new JTextField();
		quantityResults.setEditable(false);
		quantityResults.setColumns(10);
		quantityResults.setBounds(94, 192, 107, 26);
		frame.getContentPane().add(quantityResults);
		
		JLabel lblNewLabel = new JLabel("Quantity:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblNewLabel.setBounds(47, 198, 49, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSearch = new JLabel("Tool Searcher");
		lblSearch.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblSearch.setBounds(6, 41, 82, 16);
		frame.getContentPane().add(lblSearch);
		
		JLabel lblQuantityChecker = new JLabel("Quantity checker");
		lblQuantityChecker.setFont(new Font("Dialog", Font.PLAIN, 9));
		lblQuantityChecker.setBounds(11, 140, 82, 16);
		frame.getContentPane().add(lblQuantityChecker);
	}
	
	/**
	 * Scroll pane method to display an array list of strings.
	 * 
	 * @param arrayList
	 */
	public void setscrollpane(ArrayList<String> arrayList) {

		list = new JList(arrayList.toArray());

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
					if (!e.getValueIsAdjusting()) {
						JList source = (JList) e.getSource();
						String selected = source.getSelectedValue().toString();
						String[] selected_arr = selected.split(" ");
						
						searchToolId.setText(selected_arr[0]);
						
						
						 
					}
				}});
		
		list.setSelectedIndex(0);
		list.setVisibleRowCount(10);

		frame.remove(scrollPane);
		scrollPane = new JScrollPane(list);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(215, 6, 229, 260);

		frame.add(scrollPane);

		frame.invalidate();
		frame.validate();
		frame.repaint();
		
	}
	
	/**
	 * Scroll pane method to display an array list of items.
	 * 
	 * @param arrayList
	 */
	public void setscrollpane2(ArrayList<Item> arrayList) {

		list = new JList(arrayList.toArray());

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
					if (!e.getValueIsAdjusting()) {
						JList source = (JList) e.getSource();
						String selected = source.getSelectedValue().toString();
						String[] selected_arr = selected.split(" ");
						
						searchToolId.setText(selected_arr[0]);
						 
					}
				}});
		
		list.setSelectedIndex(0);
		list.setVisibleRowCount(10);

		frame.remove(scrollPane);
		scrollPane = new JScrollPane(list);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(215, 6, 229, 260);

		frame.add(scrollPane);

		frame.invalidate();
		frame.validate();
		frame.repaint();
		
	}
	
	/**
	 * method to set the quantity text field
	 * 
	 * @param quantity
	 */
	public void setQuantityResults(int quantity) {

		quantityResults.setText(quantity + "");
	}
	

	/**
	 * method to get the tool name text field
	 * @return tool name text field
	 */
	public String getToolName() {
		return searchToolName.getText();
	}

	/**
	 * method to get tool id text field
	 * @return tool id text field
	 */
	public int getToolID() {
		return Integer.parseInt(searchToolId.getText());
	}

	/**
	 * method to get the tool quantity text field
	 * @return tool quantity text field
	 */
	public int getToolQuantity() {
		return Integer.parseInt(quantityResults.getText());
	}
	
	/**
	 * Action Listener method for listing the items button
	 * 
	 * @param listenForListItemsButton
	 */
	public void ListToolsListener(ActionListener listenForListItemsButton) {
		
		btnListTools.addActionListener(listenForListItemsButton);
		
	}
	
	/**
	 * Action Listener method for searching tool name button
	 * 
	 * @param ListenForNameButton
	 */
	public void SearchToolNameListener(ActionListener ListenForNameButton) {
		
		btnSearchToolName.addActionListener(ListenForNameButton);
		
	}
	
	/** 
	 * Action Listener method for searching tool ID button
	 * @param ListenForIDButton
	 */
	public void SearchToolIDListener(ActionListener ListenForIDButton) {
		
		btnSearchToolId.addActionListener(ListenForIDButton);
		
	}
	
	/**
	 * Action Listener method for quantity button
	 * @param ListenForQuantityButton
	 */
	public void CheckQuantityListener(ActionListener ListenForQuantityButton) {
		
		btnCheckQuantity.addActionListener(ListenForQuantityButton);
		
	}
	
	/**
	 * Action Listener method for decrease quantity button
	 * @param ListenForDecreaseQuantityButton
	 */
	public void decreaseQuantityListener(ActionListener ListenForDecreaseQuantityButton) {
		
		btnDecreaseQuantity.addActionListener(ListenForDecreaseQuantityButton);
	}
	
}
