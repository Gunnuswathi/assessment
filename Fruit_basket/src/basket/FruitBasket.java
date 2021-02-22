package basket;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FruitBasket {

	private String basketPath;
// defining the constructor
	public FruitBasket(String basketPath) {
		this.basketPath = basketPath;
		fruits = new ArrayList<Fruit>();
		ReadBasketItems();
	}

	// Collection to hold the fruits read from the csv file
	private List<Fruit> fruits;

	private void ReadBasketItems() {
		// read the data from csv file and add it to the list
		// leave out the first line for header
		// read each line into an object of fruit - add to the list
		try {
			InputStream inputStream = new FileInputStream(basketPath);
			Reader inputStreamReader = new InputStreamReader(inputStream);
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
				reader.readLine();
				while (reader.ready()) {
					String line = reader.readLine();
					// split on comma
					// create a fruit object and add to list - fruits
					String[] itemProperties = line.split(",");
					Fruit fruit = new Fruit(itemProperties[0], Integer.parseInt(itemProperties[1]), itemProperties[2],
							itemProperties[3], Integer.parseInt(itemProperties[4]));
					fruits.add(fruit);

					System.out.println(line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			inputStreamReader.close();
		} catch (Exception ex) {

		}

	}
//started creating the process for the given questions.
	@SuppressWarnings("unchecked")
	public void Process() {
		System.out.println(fruits.size());
		//1.Total number of fruits 

		System.out.println("Total number of fruits : " + fruits.stream().mapToInt(Fruit::getSize).sum());
	
//2.Types of fruits
		System.out.println("Types of fruit : " + fruits.stream().map(Fruit::getName).distinct().count());
	//3. The number of each type of fruit in descending order

		System.out.println("\nThe number of each type of fruit in descending order");

		// get the fruits by descending order
		Object[] fruitByDescendingOrder = fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getName, Collectors.summingInt(Fruit::getSize))).entrySet()
				.stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).toArray();

		// loop through the ordered list and print the data
		for (Object f : fruitByDescendingOrder) {
			Entry<String, Integer> e = (Entry<String, Integer>) f;
			System.out.println(e.getKey() + " : " + e.getValue());
		}
//4.The characteristics (size, color, shape, etc.) of each fruits by type
		System.out.println("\nThe characteristics (size, color, shape, etc.) of each fruits by type");

		
		// get the fruits by descending order
		Object[] fruitsGroupedByCharactreristics = fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getName)).entrySet()
				.stream().toArray();
		
		for (Object c : fruitsGroupedByCharactreristics) {
			Entry<String, ArrayList<Fruit>> e = (Entry<String, ArrayList<Fruit>>) c;
			
			int fruitsTotal = e.getValue().stream().mapToInt(v -> v.getSize()).sum();
			Fruit item = e.getValue().stream().findFirst().get();
			System.out.println(fruitsTotal + " " + e.getKey() + ", " + item.getShape()+ ","+ item.getColor());
			
					
		}
	//5.	Have any fruit been in the basket for over 3 days
		System.out.println("\nHave any fruit been in the basket for over 3 days");
		// get the fruits by descending order
		Object[] fruitsOver3Days = fruits.stream().filter(f -> f.getDays() > 3)
				.collect(Collectors.groupingBy(Fruit::getName, Collectors.summingInt(Fruit::getSize))).entrySet()
				.stream().toArray();

		// loop through the ordered list and print the data
		int loopCount = 0;
		for (Object f : fruitsOver3Days) {
			Entry<String, Integer> e = (Entry<String, Integer>) f;
			if (loopCount != 0) {
				if (loopCount == fruitsOver3Days.length - 1) {
					System.out.print(" and ");
				} else {
					System.out.print(", ");
				}
			}
			System.out.print(e.getValue() + " " + e.getKey());
			loopCount++;
			// System.out.println(String.format("%-20s", e.getKey()) + " : " +
			// e.getValue());
		}
		System.out.print(" are over 3 days old\n");

	}

}
