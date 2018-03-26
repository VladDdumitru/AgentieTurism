import java.util.*;

public class Place {
	private String placeName;
	private City city;
	private Double pricePerDay;
	private List<String> activities;
	private String startDate;
	private String endDate;
	
	public Place(String placeName, City city, Double pricePerDay,
			List<String> activities, String startDate, String endDate) {
		this.placeName = placeName;
		this.city = city;
		this.pricePerDay = pricePerDay;
		this.activities = activities;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/*
	 * print infos
	 */
	public void printInfo() {
		System.out.println("---- " + placeName + " ----");
		System.out.println("Country, District, City: " + city.getCountry().getCountryName() + ", " +
				city.getDistrict().getDistrictName() + ", " + city.getCityName());
		System.out.println("Price per day: " + pricePerDay);
		System.out.println("Activities: " + activities);
		System.out.println("Period: " + startDate + "-" + endDate);
	}
	
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public City getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Place [placeName=" + placeName + "]";
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}	
}
