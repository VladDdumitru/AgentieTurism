import java.io.*;
import java.util.*;


public class Agency {

	/*
	 * N is the number of countries
	 * each country will have N districts and
	 * each district will have N cities
	 */
	public int N = 3;
	private Hashtable<Place, Country> hashPlaceCountry = new Hashtable<>();
	private Hashtable<Place, District> hashPlaceDistrict = new Hashtable<>();
	private Hashtable<Place, City> hashPlaceCity = new Hashtable<>();
	private List<Country> countries = new Vector<>();
	
	/*
	 * for testing the generation of data
	 */
	public void printHierarchy() {
		System.out.println("----- Next Country ------");
		for (int i = 0; i < N; i++) {
			System.out.println(countries.get(i).getcountryName());
			for (int j = 0; j < N; j++) {
				System.out.println(countries.get(i).getDistricts().get(j).getDistrictName());
				for (int k = 0; k < N; k++) {
					System.out.printf("%s ", countries.get(i).getDistricts().get(j).getCities().get(k).getCityName());
				}
				System.out.printf("\n");
			}
			System.out.println("----- Next Country ------");
		}
	}
	
	/*
	 * generate countries, districts and cities
	 */
	public void generateData() {
		for (int i = 0; i < N; i++) {
			Country country = new Country("Country" + i);
			countries.add(country);
			String countryName = country.getcountryName();
			for (int j = 0; j < N; j++) {
				District district = new District("District" + (i * N + j), countryName);
				country.addDistrict(district);
				String districtName = district.getDistrictName();
				for (int k = 0; k < N; k++) {
					City city = new City("City" + ((i * N + j) * N + k), districtName);
					country.getDistrict(districtName).addCity(city);
				}
			}
		}
	}
	
	/*
	 * read data from file
	 */
	public void readData(String file) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				line = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
