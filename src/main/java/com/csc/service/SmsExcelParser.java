package com.csc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.csc.data.domain.SmsMessage;
import com.csc.data.repository.SmsMessageRepository;

@Component
public class SmsExcelParser {

	@Autowired
	SmsMessageRepository smsMessageRepository;
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEE HH:mm:ss");
	
	
	/*public static void main(String[] args){
		Date date = new Date();
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
	}*/
	public Workbook openFile(String filename){
		Workbook wb=null;
		File file = new File(filename);
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new HSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wb;
	}
	
	/***
	 * Parses the file and load contents in database
	 * @param filename
	 */
	@Transactional()
	public void parseFile(String filename){
		Workbook wb = openFile(filename);
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> rowItr = sheet.iterator();

		int rowCounter=0;
		try{
			for(; rowItr.hasNext(); ){

				Row row = rowItr.next();
				rowCounter++;

				//Skip header row
				if(rowCounter==1)
					continue;

				
				//Iterator<Cell> cellItr = row.cellIterator();
				//int cellCount=0;
				SmsMessage message = new SmsMessage();
				
				for(int cellCount=0; cellCount<row.getPhysicalNumberOfCells(); cellCount++){
					//Cell cell = cellItr.next();
					Cell cell = row.getCell(cellCount);
					String strValue = null;
					Date dateValue = null;
					Double doubleValue = null;

					if(cell==null){
						
					}else{
						switch(cell.getCellTypeEnum()){
						case STRING:
							strValue =cell.getStringCellValue();
							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								dateValue = cell.getDateCellValue();
							} else {
								doubleValue = cell.getNumericCellValue();
							}
							break;
						default:
							System.out.println("Do not know how to read this cell");
						}

					}
					populateMessage(message, cellCount, strValue, dateValue);
					//cellCount++;
				}

				saveMessage(message);
				
			}// all rows
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(wb!=null)
				try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
	
	public void populateMessage(SmsMessage message, int cellCount, String strValue, Date dateValue){
		
		message.setContactId(1);
		switch(cellCount){
		case 0:
			message.setPhoneNumber(strValue);
			break;
		case 1:
			message.setSenderName(strValue);
			break;
		case 2:
			
			try {
				Date date = sdf.parse(strValue);
				message.setDateSent(new Timestamp(date.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			message.setFolder(strValue);
			break;
		case 4:
			message.setContent(strValue);
			break;
		}
		
	}
	
	public void saveMessage(SmsMessage message){
		smsMessageRepository.save(message);	
	}
}
