import java.util.*;

public class Place {
	private String placeName;
	private String cityName;
	private Double pricePerDay;
	private List<String> activities;
	private Date beginDate;
	private Date endDate;
	
	public Place(String placeName, String cityName, Double pricePerDay, List<String> activities, Date beginDate, Date endDate) {
		this.placeName = placeName;
		this.cityName = cityName;
		this.pricePerDay = pricePerDay;
		this.activities = activities;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
