import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.*;

public class Main {

	/*
	 * Number of places
	 * Number of cities
	 * filename to read places
	 * (for testing)
	 */
	private static final int N = 20;
	private static int noCities;
	private static String filename = "nume.txt";
	
	/*
	 * use generateFilesWithPlaces method to generate a file with new places
	 * N is the number of places
	 * make some tests
	 */
	@SuppressWarnings("deprecation")
	public static void main(String []args) {
		Agency agency = new Agency();
		noCities = (int)Math.pow(agency.N, 3) - 1;
		generateFilesWithPlaces();
		agency.generateData();
		agency.readData(filename);
		agency.printHierarchy();
		agency.printHashtables();
		
		/* get info about a place */
		agency.getPlace("Place17");
		
		/* get top5 and best price from a country, from a district and from a city */
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String startDate = "" + format.format(new Date(2018 - 1900, 0, 1));
		String endDate = "" + format.format(new Date(2018 - 1900, 11, 1));
		List<Place> top5 = agency.getTop5Country("Country0", startDate, endDate);
		System.out.println(" --- Top5 Country0 --- ");
		if (top5 != null) {
			for (Place place : top5) {
				System.out.println(place.getPlaceName() + " - " + place.getPricePerDay());
			}
		}
		Place best = agency.bestPriceCountry("Country0");
		if (best != null) {
			System.out.println("Country0 - Best Price");
			System.out.println(best.getPlaceName() + " - " + best.getPricePerDay());
		}
		top5 = agency.getTop5District("District5", startDate, endDate);
		System.out.println(" --- Top5 District5 --- ");
		if (top5 != null) {
			for (Place place : top5) {
				System.out.println(place.getPlaceName() + " - " + place.getPricePerDay());
			}
		}
		best = agency.bestPriceDistrict("District5");
		if (best != null) {
			System.out.println("District5 - Best Price");
			System.out.println(best.getPlaceName() + " - " + best.getPricePerDay());
		}
		top5 = agency.getTop5City("City20", startDate, endDate);
		System.out.println(" --- Top5 City20 --- ");
		if (top5 != null) {
			for (Place place : top5) {
				System.out.println(place.getPlaceName() + " - " + place.getPricePerDay());
			}
		}
		best = agency.bestPriceCity("City20");
		if (best != null) {
			System.out.println("City20 - Best Price");
			System.out.println(best.getPlaceName() + " - " + best.getPricePerDay());
		}
	}
	
	/* 
	 * Generate files to test the application
	 * the columns will be separated by ;
	 */
	@SuppressWarnings("deprecation")
	public static void generateFilesWithPlaces() {
		String outFile = filename;
		List<String> activities = new Vector<>();
		activities.add("surfing");
		activities.add("trasee montane");
		activities.add("inot");
		activities.add("volei");
		activities.add("mers cu bicicleta");
		activities.add("muzee");
		activities.add("plaja");
		FileWriter fw = null;
		Random rand = new Random();
		try {
			fw = new FileWriter(outFile);
			for (int i = 0; i < N; i++) {
				fw.write("Place" + i + ";" + "City" + rand.nextInt(noCities) + ";");
				Double nr = rand.nextDouble() * 150;
				int aux = (int)(nr * 100);
				Double result = aux/100d;
				String price = "" + result;
				int index1 = rand.nextInt(activities.size());
				fw.write(price + ";" + activities.get(index1) + ",");
				int index2 = rand.nextInt(activities.size());
				while (index2 == index1) {
					index2 = rand.nextInt(activities.size());
				}
				fw.write(activities.get(index2) + ",");
				int index3 = rand.nextInt(activities.size());
				while (index3 == index1 || index3 == index2) {
					index3 = rand.nextInt(activities.size());
				}
				fw.write(activities.get(index3) + ";");
				int month = rand.nextInt(12);
				int day = rand.nextInt(20);
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				String dateBegin = "" + format.format(new Date(2018 - 1900, month, day));
				String dateEnd = "" + format.format(new Date(2018 - 1900, month, day + 6));
				fw.write(dateBegin + "-" + dateEnd);
				fw.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
