package me.isaacfleetwood.jchain;

/**
 * Helps with calling a callback function for a component in a panel , giving it the panel that it was run in.
 *
 * @author Isaac Fleetwood
 */

public interface PanelRunnable {

	public void run(Panel panel);
	
}
