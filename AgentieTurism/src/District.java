import java.util.*;

public class District {
	private String countryName;
	private String districtName;
	private List<City> cities;	
	
	public District(String districtName, String countryName) {
		this.districtName = districtName;
		this.countryName = countryName;
		this.cities = new Vector<>();
	}

	public String getDistrictName() {
		return districtName;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void addCity(City city) {
		cities.add(city);
	}
	
	public List<City> getCities() {
		return cities;
	}
	
	public City findCity(String name) {
		for (City c : cities) {
			if (c.getCityName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}
