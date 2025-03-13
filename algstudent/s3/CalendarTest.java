package algstudent.s3.championship;

import static org.junit.Assert.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class CalendarTest {
	@Test
	public void test1() {
		var names = loadNamesFromFile("src/algstudent/s3/championship/game01.txt");
		var n = names.length; //number of players
		Calendar calendar = new Calendar(n); //to create the table with n players
		calendar.schedule(0, n-1); //first and last player (we work from 0 to n-1)
//		calendar.printBoard(); //to print the table
		//calendar.printBoardWithNames(names); //to print the table with the names
		int[][] table = (int[][])calendar.getTable();
		assertArrayEquals(table, new int[][] {
				{0, 1, 2, 3},
				{1, 0, 3, 2},
				{2, 3, 0, 1},
				{3, 2, 1, 0}});
		calendar.printBoardWithNames(names);
	}
	
	@Test
	public void test2() {
		var names = loadNamesFromFile("src/algstudent/s3/championship/game02.txt");
		var n = names.length; //number of players
		Calendar calendar = new Calendar(n); //to create the table with n players
		calendar.schedule(0, n-1); //first and last player (we work from 0 to n-1)
//		calendar.printBoard(); //to print the table
		//calendar.printBoardWithNames(names); //to print the table with the names
		var table = calendar.getTable();
		assertArrayEquals(table, new int[][] {
				{0, 1, 2, 3, 4, 5, 6, 7},
				{1, 0, 3, 2, 5, 4, 7, 6},
				{2, 3, 0, 1, 6, 7, 4, 5},
				{3, 2, 1, 0, 7, 6, 5, 4},
				{4, 5, 6, 7, 0, 1, 2, 3},
				{5, 4, 7, 6, 1, 0, 3, 2},
				{6, 7, 4, 5, 2, 3, 0, 1},
				{7, 6, 5, 4, 3, 2, 1, 0}});
		calendar.printBoardWithNames(names);
	}
	
	private String[] loadNamesFromFile(String fileName) {
		String[] names = null; //to store the real names of players
		BufferedReader reader = null; //to read the file
		
		try {
			reader = new BufferedReader(new FileReader(fileName)); //open the file to be read
			names = new String[Integer.parseInt(reader.readLine())]; //get the number of players (first line)
			int i = 0;
			while (reader.ready()) 
				names[i++] = reader.readLine(); //keep names of players
			
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return names;
	}
}
