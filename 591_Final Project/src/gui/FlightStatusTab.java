package gui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;

import directions.DirectionsObject;
import directions.DirectionsParser;
import directions.DirectionsURLBuilder;
import flightAPI.AirportPreCheck;
import flightAPI.FlightStatusAPI;

/**
 * tab to retrieve flight status info
 * @author shengfeng
 *
 */
public class FlightStatusTab {
	static String iata;
	static String icao;
	static String type;
	static JTextField text1;
	static JTextField text2;
	static JComboBox types;
	static JLabel info;

	public static void buildFlightStatusTab(JPanel panel) {
		JLabel label1=new JLabel();
		label1.setText("IATA airport code:");
		panel.add(label1);
		text1=new JTextField(10); 
		panel.add(text1);
		JLabel label2=new JLabel();
		label2.setText("Flight ICAO code:");
		panel.add(label2);
		text2=new JTextField(10); 
		panel.add(text2);
		types=new JComboBox();
		types.addItem("departure");
		types.addItem("arrival");
		info=new JLabel();

		panel.add(types);
		createButtonAndListener(panel);
		panel.add(info);
		
	}
	public static void createButtonAndListener(JPanel panel) {
		Button button=new Button("Get flight status");
		button.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				iata=text1.getText();
				icao=text2.getText();
				type=types.getSelectedItem().toString();
				String result="<html>";
				try {
					result=result+FlightStatusAPI.makeAPICall(iata, type, icao);
				} catch (IOException | JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				String preCheckURL = "https://www.tsa.gov/data/apcp.xml";

				try {
					result=result+AirportPreCheck.makeAPICall(iata, preCheckURL);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				result=result+"<html>";
				info.setText(result);

			
			}
		});
		panel.add(button);
	
	}
}
