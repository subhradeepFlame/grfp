package com.green.rfp.qa.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class csvHelper {
	private static String filepath = "C:\\Users\\CISPL-SUBHASISH DEB\\Downloads\\vendor-import-bid1-37.csv";

	public static void main(String[] args) throws Exception {
		updateCSV(filepath, "new text", 2, 3);

		CSVReader reader = new CSVReader(new FileReader(filepath), ',', '"', 1);
		List<String[]> allRows = reader.readAll();
		for (String[] row : allRows) {
			System.out.println(Arrays.toString(row));
		}

		CSVWriter writer = new CSVWriter(new FileWriter(filepath, true));

		String[] record = "3,David,Feezor,USA,40".split(",");

		writer.writeNext(record);

		writer.close();
		apendNewRow(filepath, "a,b,c", ",");
		reader.close();
	}

	public static void apendNewRow(String fileToUpdate, String data, String separator) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(fileToUpdate), ',', '"', 1);
		CSVWriter writer = new CSVWriter(new FileWriter(fileToUpdate, true));
		String[] record = data.split(separator);
		writer.writeNext(record);
		writer.close();
		reader.close();
	}

	public static void updateCSV(String fileToUpdate, String replace, int row, int col) throws IOException {
		File inputFile = new File(fileToUpdate);
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		csvBody.get(row)[col] = replace;
		reader.close();
		CSVWriter writer = 
			    new CSVWriter(new FileWriter(inputFile), ',', CSVWriter.NO_QUOTE_CHARACTER);
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
	}

	public static String readCSV(String filepath, int row,int col) {
		String delimiter = ",";
		String line;
		List<List<String>> lines = new ArrayList<List<String>>();
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			while ((line = br.readLine()) != null) {
				List<String> values = Arrays.asList(line.split(delimiter));
				lines.add(values);
			}
			String csvValue= lines.get(row).get(col);
			System.out.println("value: "+csvValue);
			return csvValue;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void deleteDownloadedFiles() {
		String directory = "downloads"; // If download is in IDE project folder
		File file = new File(directory);
		String[] currentFiles;
		if (file.isDirectory()) {
			currentFiles = file.list();
			for (int i = 0; i < currentFiles.length; i++) {
				File myFile = new File(file, currentFiles[i]);
				myFile.delete();
			}
		}
	}

}
