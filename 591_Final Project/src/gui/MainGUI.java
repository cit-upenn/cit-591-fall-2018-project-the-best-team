package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.json.JSONException;

import flightAPI.FlightStatusAPI;

/**
 * the main gui menu
 * @author shengfeng
 *
 */
public class MainGUI extends JFrame {

	public static void buildMainMenu(JFrame frame) {
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	  JPanel panel1=new JPanel();
  	  panel1.setOpaque(false);
  	  ToAirportTab.buildToAirportTab(panel1);
  	  JPanel panel2=new JPanel();
  	  panel2.setOpaque(false);
  	  FlightStatusTab.buildFlightStatusTab(panel2);
  	  JPanel panel3=new JPanel();
  	  panel3.setOpaque(false);
  	  DestinationInfoTab.buildDestinationInfoTab(panel3);
  	  JPanel panel4=new JPanel();
  	  panel4.setOpaque(false);
  	  PlacesTab.buildPlacesTab(panel4);
  	  JTabbedPane tabs=new JTabbedPane();
  	  tabs.addTab("To Airport", panel1);
  	  tabs.addTab("Flight Status", panel2);
  	  tabs.addTab("Destination Info", panel3);
  	  tabs.addTab("Places", panel4);
  	  tabs.setVisible(true);

  	  frame.setContentPane(tabs);
  	  frame.setVisible(true);
  	  frame.setSize(800, 600);
	}
	public static void main(String[] args) {
		
		 SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	  JFrame frame = new JFrame();
		    	  buildMainMenu(frame);	    	 
		      }
		    });
	}
	
}
