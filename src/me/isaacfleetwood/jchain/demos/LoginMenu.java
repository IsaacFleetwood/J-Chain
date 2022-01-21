package me.isaacfleetwood.jchain.demos;


import javax.swing.BoxLayout;

import me.isaacfleetwood.jchain.Button;
import me.isaacfleetwood.jchain.Label;
import me.isaacfleetwood.jchain.Panel;
import me.isaacfleetwood.jchain.TextField;

/**
 * 
 * Demonstration of the framework at work. 
 * Creates a login menu that opens a modal depending on success or fail.
 * 
 * @author Isaac Fleetwood
 *
 */
public class LoginMenu {

	public static void main(String[] args) {
		Panel panel = new Panel();
		panel
			.boxLayout(BoxLayout.Y_AXIS)
			.setPanelSize(400, 300)
			.setMargin(0, 50)
			.add(new TextField("Username"))
		    	.compSetSize(280, 70)
			.add(new TextField("Password"))
		    	.compSetSize(280, 70)
			.add(new Button("Login")
				.onClick((Panel p) -> {
					String username = p.getInput("Username");
					String password = p.getInput("Password");
					if(username.equals("user") && password.equals("pass")) {
						p.openModal("success");
						return;
					}
					p.openModal("fail");
				})
			)
			.addModal("success", new Panel()
				.setPanelSize(300, 200)
				.add(new Label("Successfully logged in!"))
				.add(new Button("Close")
					.onClick((Panel __) -> {
						panel.closeModal();
					})
				)
			)
			.addModal("fail", new Panel()
				.setPanelSize(300, 200)
				.add(new Label("Unable to login!"))
				.add(new Button("Close")
					.onClick((Panel __) -> {
						panel.closeModal();
					})
				)
			)
			.setFrameName("Login");
		panel.open();
	}

}
