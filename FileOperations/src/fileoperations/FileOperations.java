package fileoperations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperations {
	private static final String FILE_NAME = "myAdnaneExample.txt";
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean exist = false;
		
		while ( !exist) {
			System.out.println("Choose an option:");
			System.out.println("1. Create file");
			System.out.println("2. Write to file");
			System.out.println("3. Read from file");
			System.out.println("4. Update to file");
			System.out.println("5. Delete file");
			System.out.println("6. Exit");
			
			int option = scanner.nextInt();
			
			switch (option) {			
			case 1:
				createFile();
				break;			
			case 2:
				writeToFile();
				break;
			case 3:
				readFromFile();
				break;
			case 4:
				updateFile();
				break;
			case 5:
				deleteFile();
				break;
			case 6:
				exist = true;System.out.println("We hope to see you next time.");
				break;	
			default:
				System.out.println("Invalid option. Please try again");
			}//end of switch			
			
		}	// end of while				
		
		scanner.close();
		//System.out.println(Paths.get(FILE_NAME);
			
		} // end of main
		
	private static void deleteFile() {
		// TODO Auto-generated method stub
		try {
			Files.deleteIfExists(Paths.get(FILE_NAME));
			System.out.println("File successfully deleted.");
		} catch(IOException e) {
			System.out.println("Error in deleting the file.");
			e.printStackTrace();
		}
		
	}

	private static void updateFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true))) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the text you want to append to the file ");
			String content =  scanner.nextLine();
			writer.write("\n");
			writer.write(content);
			System.out.println("Successfully updated to  the file");

		} catch (IOException e) {
			System.out.println("Error: An error accured while writing to  the file");
			e.printStackTrace();
		}	
	}

	private static void readFromFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: An error occured while reading the file.");
			e.printStackTrace();
		}

	}

	private static void writeToFile() {
		// TODO Auto-generated method stub
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
			Scanner scanner = new Scanner (System.in);
			System.out.println("Enter your text");
			String content = scanner.nextLine();
			writer.write(content);
			System.out.println("Succesfully wrote to file.");
			//scanner.close();
						
		} catch (IOException e) {
			System.out.println("Error: An error occured while writing to the file.");
			e.printStackTrace();
		}
	}

//	private static void writeToFile() {
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Enter the text you want to write to the file ");
//			String content = scanner.nextLine();
//			writer.write(content);
//			System.out.println("Successfully wrote to  the file");
//		} catch (IOException e) {
//			System.out.println("Error: An error accured while writing to  the file");
//			e.printStackTrace();
//		}
//
//	}	
	

	private static void createFile() {
		try {
			
			File file = new File(FILE_NAME);
			if (file.createNewFile()) {
				System.out.println("File create: "+file.getName());
			} else {
				System.out.println("File already exists.");
			}
			
		} catch (IOException e) {
			System.out.println("Error: An error occured while creating the file.");
			e.printStackTrace();
		}
		
	}

}
