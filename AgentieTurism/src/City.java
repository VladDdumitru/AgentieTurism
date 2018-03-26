import java.util.*;

public class City {
	private Country country;
	private District district;
	private String cityName;
	private List<Place> places;
	
	public City(String cityName, District district, Country country) {
		this.cityName = cityName;
		this.district = district;
		this.country = country;
		this.places = new Vector<>();
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + "]";
	}

	public String getCityName() {
		return cityName;
	}
	
	public District getDistrict() {
		return district;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public List<Place> getPlaces() {
		return places;
	}
	
	public void addPlace(Place place) {
		places.add(place);
	}
	
	public Place findPlace(String name) {
		for (Place p : places) {
			if(p.getPlaceName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	/*
	 * get top5 places from a city
	 */
	public List<Place> getTop5(String startDate, String endDate) {
		List<Place> top5 = new Vector<>();
		PriorityQueue<Place> pq = new PriorityQueue<>(new Comparator<Place>() {

			@Override
			public int compare(Place p1, Place p2) {
				return p1.getPricePerDay().compareTo(p2.getPricePerDay());
			}
			
		});
		for (Place place : places) {
			if (place.getStartDate().compareTo(startDate) >= 0 &&
					place.getEndDate().compareTo(endDate) <=0) {
				pq.add(place);
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
}
