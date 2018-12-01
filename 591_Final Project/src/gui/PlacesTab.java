package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;

import directions.DirectionsObject;
import directions.DirectionsParser;
import directions.DirectionsURLBuilder;
import places.PlacesObject;
import places.PlacesParser;
import places.PlacesURLBuilder;
/**
 * create the tab for searching surrouding places
 * @author shengfeng
 *
 */
public class PlacesTab {
	static String currentLocation;
	static String radius;
	static String type;
	static JTextField text1;
	static JTextField text2;
	static JComboBox types;
	static JLabel info;

	public static void buildPlacesTab(JPanel panel) {
		JLabel label1=new JLabel();
		label1.setText("Current location:");
		panel.add(label1);
		text1=new JTextField(10); 
		panel.add(text1);
		JLabel label2=new JLabel();
		label2.setText("Radius in ft:");
		panel.add(label2);
		text2=new JTextField(10); 
		panel.add(text2);
		types=new JComboBox();
		types.addItem("airport");
		types.addItem("atm");
		types.addItem("cafe");
		types.addItem("car_rental");
		types.addItem("convenience_store");
		types.addItem("lodging");
		types.addItem("restaurant");
		types.addItem("bar");
		types.addItem("transit_station");
		info=new JLabel();

		panel.add(types);
		createButtonAndListener(panel);
		panel.add(info);



		
	}
	public static void createButtonAndListener(JPanel panel) {
		Button button=new Button("Get places info");
		button.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				currentLocation=text1.getText();
				radius=text2.getText();
				type=types.getSelectedItem().toString();
				String result="<html>";
				URL url = null;
				
				try {
					url = PlacesURLBuilder.urlBuilder(currentLocation, type, Double.parseDouble(radius));
				} catch (NumberFormatException | IOException | JSONException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				ArrayList<PlacesObject> pArray=new ArrayList<>();;
				try {
					pArray = PlacesParser.setPlaces(url);
				} catch (IOException | JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i=0;i<pArray.size();i++) {
					result=result+"Name: "+pArray.get(i).getName()+"<br/>";
					result=result+"Address: "+pArray.get(i).getAddress()+"<br/>";
					result=result+"Rating: "+pArray.get(i).getRating()+"<br/>";

				}
				result=result+"<html>";

				info.setText(result);
			
			}
		});
		panel.add(button);
	
	}
}
