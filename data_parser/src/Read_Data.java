package Research_Project;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data {
	private static int inputSheetNum = 0;
	private static int outputSheetNum = 0;

	public static void main(String[] args) {
		int dataIndex = 0;
		int numOfNodes = 0;
		// Opens the excel sheet
		try {
			// Opens the input stream for reading
			FileInputStream fopen = new FileInputStream("C:\\Research\\Research_Data.xlsx");
			FileInputStream fwrite = new FileInputStream("C:\\Research\\Output_Data.xlsx");
			// Loads workbook for reading
			XSSFWorkbook inputWorkbook = new XSSFWorkbook(fopen);
			// loads workbook for writing
			XSSFWorkbook outputWorkbook = new XSSFWorkbook(fwrite);
			// Opens input sheet for reading
			XSSFSheet inputSheet = inputWorkbook.getSheetAt(inputSheetNum);
			// Opens outputSheet for writing
			XSSFSheet outputSheet = outputWorkbook.createSheet("Sheet2");
			// finds the last value of the excel sheet
			int lastValue = inputSheet.getLastRowNum();
			// initializes the LinkedList with Volume_Data
			LinkedList<Volume_Data> filtered_Data = new LinkedList<>();
			// for loop to read into the data and write as well
			for (int i = 0; i < lastValue; i++) {
				// casts the date into an int and subtracts the 2018 year measurement
				int date = (int) inputSheet.getRow(i).getCell(0).getNumericCellValue() - 20180000;
				// finds the seconds of the data and rounds the value
				// =HOUR(A1) + MINUTE(A1)/60, converts the time to a decimal in Excel
				// locates the trade volume executed at the specific millisecond interval
				double volume = inputSheet.getRow(i).getCell(1).getNumericCellValue();
				// locates the trade volume executed at the specific millisecond interval
				// Creates a class which includes all the specific trade data
				Volume_Data trade = new Volume_Data(date, volume);
				// adds if the linkedlist is empty
				if (filtered_Data.size() == 0) {
					filtered_Data.add(trade);
				} else {
					// temporary variable for the current trade
					Volume_Data temp = filtered_Data.get(numOfNodes);
					// Checks if the dates's of the trade matches
					if (temp.getDate() == trade.getDate()) {
						// retrieves the current total
						double newTotal = temp.getVolume();
						// adds the new trade volume
						newTotal += trade.getVolume();
						// updates the trade volume
						filtered_Data.get(numOfNodes).setVolume(newTotal);
						// if the second of the trade is not the same, a new linkedlist node is added
						// if the date's don't match, a new linkedlist node is added
					} else {
						filtered_Data.add(trade);
						numOfNodes++;
					}
				}
			}
			numOfNodes = 0;
			for (Volume_Data dataPoint : filtered_Data) {
				// Creates the row for writing
				Row rows = outputSheet.createRow(numOfNodes);
				// Creates the cell for the date
				Cell dateCell = rows.createCell(0);
				// Writes the date cell value
				dateCell.setCellValue(dataPoint.getDate());
				// Creates the cell for wring the volume
				Cell volumeCell = rows.createCell(1);
				// Writes the volume cell value
				volumeCell.setCellValue(dataPoint.getVolume());
				numOfNodes++;
			}
			// /24 -> Format Cells -> General -> h:mm converts from decimal to time
			FileOutputStream write = new FileOutputStream("C:\\Research\\Output_Data.xlsx");
			outputWorkbook.write(write);
			inputWorkbook.close();
			outputWorkbook.close();
			System.out.println(numOfNodes);
			System.out.println("Data Done");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
