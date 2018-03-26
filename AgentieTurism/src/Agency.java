import java.io.*;
import java.util.*;

public class Agency {

	/*
	 * N is the number of countries
	 * each country will have N districts and
	 * each district will have N cities
	 */
	public int N = 3;
	private Hashtable<String, Place> hashPlace = new Hashtable<>();
	private Hashtable<String, City> hashCity = new Hashtable<>();
	private Hashtable<String, District> hashDistrict = new Hashtable<>();
	private Hashtable<String, Country> hashCountry = new Hashtable<>();
	private List<Country> countries = new Vector<>();
	
	/*
	 * get a place and print info about that place
	 */
	public void getPlace(String placeName) {
		try {
			Place place = hashPlace.get(placeName);
			place.printInfo();
		} catch (NullPointerException e) {
			System.out.println("This place doesn't exist !!!");
		}
	}
	
	public Place bestPriceCountry(String countryName) {
		Country country = hashCountry.get(countryName);
		Place place = null;
		if (country != null) {
			place = country.bestPrice();
		}
		return place;
	}
	
	public Place bestPriceDistrict(String districtName) {
		District district = hashDistrict.get(districtName);
		Place place = null;
		if (district != null) {
			place = district.bestPrice();
		}
		return place;
	}
	
	public Place bestPriceCity(String cityName) {
		City city = hashCity.get(cityName);
		Place place = null;
		if (city != null) {
			city.bestPrice();
		}
		return place;
	}
	
	@SuppressWarnings("finally")
	public List<Place> getTop5City(String cityName, String startDate, String endDate) {
		List<Place> top5 = null;
		try {
			City city = hashCity.get(cityName);
			top5 = city.getTop5(startDate, endDate);
		} catch (NullPointerException e) {
			System.out.println("This is not a city");
		} finally {
			return top5;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Place> getTop5District(String districtName, String startDate, String endDate) {
		List<Place> top5 = null;
		try {
			District district = hashDistrict.get(districtName);
			top5 = district.getTop5(startDate, endDate);
		} catch (NullPointerException e) {
			System.out.println("This is not a district");
		} finally {
			return top5;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Place> getTop5Country(String countryName, String startDate, String endDate) {
		List<Place> top5 = null;
		try {
			Country country = hashCountry.get(countryName);
			top5 = country.getTop5(startDate, endDate);
		} catch (NullPointerException e) {
			System.out.println("This is not a country");
		} finally {
			return top5;
		}
	}
	
	/*
	 * for testing read method
	 */
	public void printHashtables() {
		System.out.println(hashPlace);
		System.out.println(hashCity); 
		System.out.println(hashDistrict);
		System.out.println(hashCountry);
	}
	
	/*
	 * for testing the generation of data
	 */
	public void printHierarchy() {
		System.out.println("----- Next Country ------");
		for (int i = 0; i < N; i++) {
			System.out.println(" --- " + countries.get(i).getCountryName());
			List<District> districts = countries.get(i).getDistricts();
			for (int j = 0; j < N; j++) {
				System.out.println(" ------ " + districts.get(j).getDistrictName());
				for (int k = 0; k < N; k++) {
					City city = countries.get(i).getDistricts().get(j).getCities().get(k);
					System.out.println(" --------- " + city.getCityName());
					List<Place> places = city.getPlaces();
					for (Place p : places) {
						System.out.println(" ------------ " + p.getPlaceName());
					}
					System.out.printf("\n");
				}
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
			for (int j = 0; j < N; j++) {
				District district = new District("District" + (i * N + j), country);
				country.addDistrict(district);
				String districtName = district.getDistrictName();
				for (int k = 0; k < N; k++) {
					City city = new City("City" + ((i * N + j) * N + k), district, country);
					country.getDistrict(districtName).addCity(city);
				}
			}
		}
	}
	
	/*
	 * read data from file and store the connections between
	 * place-city, place-district, place-country in hashtables
	 */
	public void readData(String file) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				String[] tokens = line.split(";");
				String placeName = tokens[0];
				String cityName = tokens[1];
				String price = tokens[2];
				String[] activity = tokens[3].split(",");
				List<String> activities = new Vector<>();
				for (int i = 0; i < activity.length; i++) {
					activities.add(activity[i]);
				}
				String[] time = tokens[4].split("-");
				City city = findCity(cityName);
				Place place = new Place(placeName, city, Double.parseDouble(price), activities, time[0], time[1]);
				city.addPlace(place);
				hashPlace.put(placeName, place);
				hashCity.put(cityName, city);
				hashDistrict.put(city.getDistrict().getDistrictName(), city.getDistrict());
				hashCountry.put(city.getCountry().getCountryName(), city.getCountry());
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
	
	/*
	 * I use this when I read data because I need to 
	 * find the city for that place and I don't know
	 * in which country or district the city is
	 */
	public City findCity(String cityName) {
		for (Country country : countries) {
			for (District district : country.getDistricts()) {
				for (City city : district.getCities()) {
					if (city.getCityName().equals(cityName)) {
						return city;
					}
				}
			}
		}
		return null;
	}
	
}
