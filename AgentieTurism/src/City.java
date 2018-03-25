import java.util.*;

public class City {
	private String countryName;
	private String districtName;
	private String cityName;
	private List<Place> places;
	
	public City(String cityName, String districtName) {
		this.cityName = cityName;
		this.districtName = districtName;
		this.places = new Vector<>();
	}

	public String getCityName() {
		return cityName;
	}
	
	public String getDistrictName() {
		return districtName;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public List<Place> getPlaces() {
		return places;
	}
	
	public Place findPlace(String name) {
		for (Place p : places) {
			if(p.getPlaceName().equals(name)) {
				return p;
			}
		}
		return null;
	}
}
