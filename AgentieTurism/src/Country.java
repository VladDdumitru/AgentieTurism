import java.util.*;

public class Country {
	private String countryName;
	private List<District> districts;
	
	public Country(String countryName) {
		this.countryName = countryName;
		this.districts = new Vector<>();
	}
	
	public String getcountryName() {
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
	
	
	
}
