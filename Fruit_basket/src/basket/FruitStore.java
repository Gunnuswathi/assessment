package basket;

import java.io.*;

//
public class FruitStore {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the file path for csv file");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//"C:\\Users\\gudur\\Downloads\\basket.csv"; // 
		String basketFilePath = bufferedReader.readLine();
		
		FruitBasket basket = new FruitBasket(basketFilePath);
		basket.Process();
	}
}


