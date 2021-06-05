package ClientPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ServerPackage.InventoryManagementSystem;

/**
 * Inventory controller class to control the Inventory GUI
 * 
 * @author Sonia Obi & Remy Onyegbutulem
 *
 */
public class InventoryController {

	private InventoryView view;
	private InventoryManagementSystem model;

	/**
	 * Contructor for the class.
	 * 
	 * @param view
	 * @param model
	 */
	public InventoryController(InventoryView view, InventoryManagementSystem model) {

		this.view = view;
		this.model = model;

		this.view.ListToolsListener(new ListToolsListener());
		this.view.SearchToolNameListener(new SearchToolNameListener());
		this.view.SearchToolIDListener(new SearchToolIDListener());
		this.view.CheckQuantityListener(new CheckQuantityListener());
		this.view.decreaseQuantityListener(new decreaseQuantityListener());

	}

	/**
	 * Action Listener class for listing all the tools.
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class ListToolsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			view.setscrollpane(model.listItems());

		}
	}

	/**
	 * Action Listener class for search tool by tool name
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class SearchToolNameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String name = view.getToolName();
			view.setscrollpane2(model.searchToolByName(name));

		}
	}

	/**
	 * Action Listener class for search tool by ID
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class SearchToolIDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int id = view.getToolID();

			view.setscrollpane2(model.searchToolByID(id));

		}

	}

	/**
	 * Action Listener class for searching tool quantity 
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class CheckQuantityListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int id = view.getToolID();

			view.setQuantityResults(model.checkItemQuantity(id));

		}

	}

	/**
	 * Action Listener class for decreasing tool quantity 
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class decreaseQuantityListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int id = view.getToolID();
			model.decreaseItemQuantity(id);

		}

	}
}
