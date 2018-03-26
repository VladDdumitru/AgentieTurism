import java.util.*;

public class Country {
	@Override
	public String toString() {
		return "Country [countryName=" + countryName + "]";
	}

	private String countryName;
	private List<District> districts;
	
	public Country(String countryName) {
		this.countryName = countryName;
		this.districts = new Vector<>();
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	//add a new district to the list
	public void addDistrict(District district) {
		districts.add(district);
	}
	
	public List<District> getDistricts() {
		return districts;
	}
	
	//find district in the list by name
	public District getDistrict(String district) {
		for (District d : this.districts) {
			if (d.getDistrictName().equals(district)) {
				return d;
			}
		}
		return null;
	}
	
	/*
	 * get top5 places from a country
	 */
	public List<Place> getTop5(String startDate, String endDate) {
		List<Place> top5 = new Vector<>();
		PriorityQueue<Place> pq = new PriorityQueue<>(new Comparator<Place>() {

			@Override
			public int compare(Place p1, Place p2) {
				return p1.getPricePerDay().compareTo(p2.getPricePerDay());
			}
			
		});
		for (District district : districts) {
			List<City> list = district.getCities();
			for (City city : list)
				pq.addAll(city.getPlaces());
		}
		for (int i = 0; i < 5; i++) {
			Place place = pq.poll();
			if (place != null) {
				top5.add(place);
			}
		}
		return top5;
	}
}
