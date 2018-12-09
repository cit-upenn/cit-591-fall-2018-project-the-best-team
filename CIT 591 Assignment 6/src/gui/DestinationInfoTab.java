package gui;

import java.awt.Button;
import java.awt.Dimension;
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
import timeZone.TimeZoneObject;
import timeZone.TimeZoneParser;
import timeZone.TimeZoneURLBuilder;
import weather.WeatherAPI;

public class DestinationInfoTab {
	static String destination;

	static JTextField text1;

	static JLabel info;

	public static void buildDestinationInfoTab(JPanel panel) {
		JLabel label1=new JLabel();
		label1.setText("Destination City:");
		panel.add(label1);
		text1=new JTextField(10); 
		panel.add(text1);
		
		info=new JLabel();
		info.setPreferredSize(new Dimension(500,300));

		createButtonAndListener(panel);
		panel.add(info);



		
	}
	public static void createButtonAndListener(JPanel panel) {
		Button button=new Button("Get destination info");
		button.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				destination=text1.getText();
				
				String result="<html>";
				URL timeZoneURL = null;
				try {
					timeZoneURL=TimeZoneURLBuilder.urlBuilder(destination);
				} catch (IOException | JSONException e1) {
					result="No result found.";
					info.setText(result);
					return;
				}
				TimeZoneObject t=new TimeZoneObject();
				try {
					t=TimeZoneParser.setTimeZone(timeZoneURL);
				} catch (IOException | JSONException e1) {
					result="No result found.";
					info.setText(result);
					return;
				}
				result=result+"Local time: "+t.getLocalTime()+"<br/>";
				result=result+"Time Zone: "+t.getTimeZoneName()+"<br/>";
				
				String keyWeather = "b19e295b4bbeda7931adb202d826296d";
				try {
					result=result+WeatherAPI.makeAPICallCurrentWeather(destination,keyWeather)+"<html>";
				} catch (IOException | JSONException e1) {
					result="No result found.";
					info.setText(result);
					return;
				}
				

				info.setText(result);

			
			}
		});
		panel.add(button);
	
	}
}
