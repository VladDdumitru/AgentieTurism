import java.util.*;

public class District {
	private Country country;
	private String districtName;
	private List<City> cities;	
	
	public District(String districtName, Country country) {
		this.districtName = districtName;
		this.country = country;
		this.cities = new Vector<>();
	}

	public String getDistrictName() {
		return districtName;
	}
	
	public Country getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		return "District [districtName=" + districtName + "]";
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
	
	/*
	 * get top5 places from a district
	 */
	public List<Place> getTop5(String startDate, String endDate) {
		List<Place> top5 = new Vector<>();
		PriorityQueue<Place> pq = new PriorityQueue<>(new Comparator<Place>() {

			@Override
			public int compare(Place p1, Place p2) {
				return p1.getPricePerDay().compareTo(p2.getPricePerDay());
			}
			
		});
		for (City city : cities) {
			for (Place place : city.getPlaces()) {
				if (place.getStartDate().compareTo(startDate) >= 0 &&
						place.getEndDate().compareTo(endDate) <= 0) {
					pq.add(place);
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			Place place = pq.poll();
			if (place != null) {
				top5.add(place);
			}
		}
		return top5;
	}
	
	/*
	 * get best price from a district
	 */
	public Place bestPrice() {
		double bestPrice = Double.MAX_VALUE;
		Place best = null;
		for (City city : cities) {
			Place place = city.bestPrice();
			if(place != null) {
				if (place.getPricePerDay() < bestPrice) {
					best = place;
					bestPrice = place.getPricePerDay();
				}
			}
		}
		return best;
	}
}
