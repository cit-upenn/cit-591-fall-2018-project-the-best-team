package gui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;

import directions.DirectionsObject;
import directions.DirectionsParser;
import directions.DirectionsURLBuilder;
/**
 * create the tab for calculating trip distance and duration
 * @author shengfeng
 *
 */
public class ToAirportTab {
	static String currentLocation;
	static String airport;
	static String mode;
	static JTextField text1;
	static JTextField text2;
	static JComboBox modes;
	static JLabel info;

	public static void buildToAirportTab(JPanel panel) {
		JLabel label1=new JLabel();
		label1.setText("Current location:");
		panel.add(label1);
		text1=new JTextField(10); 
		panel.add(text1);
		JLabel label2=new JLabel();
		label2.setText("Airport name:");
		panel.add(label2);
		text2=new JTextField(10); 
		panel.add(text2);
		modes=new JComboBox();
		modes.addItem("driving");
		modes.addItem("walking");
		modes.addItem("bicycling");
		info=new JLabel();

		panel.add(modes);
		createButtonAndListener(panel);
		panel.add(info);



		
	}
	public static void createButtonAndListener(JPanel panel) {
		Button button=new Button("Get trip info");
		button.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				currentLocation=text1.getText();
				airport=text2.getText();
				mode=modes.getSelectedItem().toString();
				String result="";
				URL url = null;
				try {
					url = DirectionsURLBuilder.urlBuilder(currentLocation,airport,mode);
				} catch (MalformedURLException e1) {
					result="No result found.";
					info.setText(result);
					return;
				}
				DirectionsObject d=new DirectionsObject();
				try {
					d=DirectionsParser.setJsonDirections(url);
				} catch (IOException | JSONException e1) {
					result="No result found.";
					info.setText(result);
					return;
				}
				info.setText("<html>"+"Origin: "+d.getOrigin()
				+"<br/>"+"Destination: "+d.getDestination()+
				"<br/>"+"Duration: "+d.getDuration()+
				"<br/>"+"Distance: "+d.getDistance()+"</html>");

			
			}
		});
		panel.add(button);
	
	}
}
