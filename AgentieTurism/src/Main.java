import java.io.FileWriter;
import java.util.Random;
import java.util.*;

public class Main {

	/*
	 * Number of places and cities
	 * (for testing)
	 */
	private static final int N = 20;
	private static int noCities;
	
	public static void main(String []args) {
		Agency agency = new Agency();
		noCities = (int)Math.pow(agency.N, 3) - 1;
		agency.generateData();
		agency.printHierarchy();
		
		generateFilesWithPlaces();
	}
	
	/* 
	 * Generate files to test the application
	 * the columns will be separated by ;
	 */
	@SuppressWarnings("deprecation")
	public static void generateFilesWithPlaces() {
		String outFile = "nume.txt";
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
				int month = rand.nextInt(12) + 1;
				int day = rand.nextInt(20) + 1;
				String dateBegin = "" + new Date(2018, month, day);
				String dateEnd = "" + new Date(2018, month, day + 7);
				fw.write(dateBegin + " - " + dateEnd);
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
