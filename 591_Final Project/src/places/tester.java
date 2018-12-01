package places;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;



public class tester {
	public static void main(String[] args) throws IOException, JSONException {
		System.out.println("please type address");
		Scanner scan=new Scanner(System.in);
		String address=scan.nextLine();
		System.out.println("what type");
		String type=scan.nextLine();
		System.out.println("radius in ft");
		double radius=scan.nextDouble();
		scan.close();
		URL url=PlacesURLBuilder.urlBuilder(address,type,radius);
		System.out.println(url);
		ArrayList<PlacesObject> pArray=PlacesParser.setPlaces(url);
		for (int i=0;i<pArray.size();i++) {
			System.out.println(pArray.get(i).getName());
			System.out.println(pArray.get(i).getAddress());
			System.out.println(pArray.get(i).getRating());


		}

	}
}
