package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic Methods related files
 * @author Lohitha
 * 
 */

public class FileUtility {
	
	/**
	 * This method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}
	
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws IOException
	 */
	
	
	public String readDataFromExcel(String sheetname,int rowNo,int celNo) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);//document
		Sheet sh = wb.getSheet(sheetname);//sheet
		Row rw = sh.getRow(rowNo);//row
		Cell cl = rw.getCell(celNo);//cell
		String value = cl.getStringCellValue();
		return value;
		
		
		          
		
	}

}
