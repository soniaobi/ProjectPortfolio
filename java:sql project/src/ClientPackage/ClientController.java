package ClientPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ServerPackage.Client;
import ServerPackage.ClientManager;

/**
 * Client controller class to manage the Client GUI.
 * 
 * @author SoniaObi
 */

public class ClientController {

	private ClientView view;
	private ClientManager model;

	/**
	 * Constructor for the class.
	 * 
	 * @param view
	 * @param model
	 */
	public ClientController(ClientView view, ClientManager model) {

		this.view = view;
		this.model = model;

		this.view.addNewClientListener(new NewClientListener());

		this.view.searchClientListener(new SearchClientListener());

		this.view.deleteClientListener(new DeleteClientListener());

		this.view.modifyClientListener(new ModifylientListener());

	}

	/**
	 * Action Listener class for adding a new client.
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 */
	class NewClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// int id;
			String lname, fname, type, phoneNum, address, postalCode;

			// id = view.getClientID();
			lname = view.getLastName();
			fname = view.getFirstName();
			type = view.getClientType();
			phoneNum = view.getClientPhoneNum();
			address = view.getClientAddress();
			postalCode = view.getClientPostalCode();

			// id set to 0 as sql is set to auto increment clientID
			Client c = new Client(0, lname, fname, type, phoneNum, address, postalCode);
			model.addClient(c);

		}
	}

	/**
	 * Action Listener class for searching for a client.
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class SearchClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (view.getRadioButton().equals("IDButton")) {

				String id;

				id = view.getClientSearch();

				view.setscrollpane(model.searchClientByID(id));
			}

			else if (view.getRadioButton().equals("NameButton")) {

				String name;

				name = view.getClientSearch();

				view.setscrollpane(model.searchClientByName(name));
			}

			else if (view.getRadioButton().equals("TypeButton")) {

				String type;

				type = view.getClientSearch();

				view.setscrollpane(model.searchClientByType(type));

			}
		}

	}

	/**
	 * Action Listener class for deleting a client.
	 * 
	 * @author Sonia Obi & Remy Onyegbutulem
	 *
	 */
	class DeleteClientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int id;

			id = view.getClientID();

			model.removeClient(id);

		}
	}

	/**
	 * Action Listener class for modifying a client.
	 * 
	 * @author Sonia Obi
	 *
	 */
	class ModifylientListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int id;
			String lname, fname, type, phoneNum, address, postalCode;

			id = view.getClientID();
			lname = view.getLastName();
			fname = view.getFirstName();
			type = view.getClientType();
			phoneNum = view.getClientPhoneNum();
			address = view.getClientAddress();
			postalCode = view.getClientPostalCode();

			model.modifyClient(id, fname, lname, type, phoneNum, address, postalCode);

		}
	}
}
