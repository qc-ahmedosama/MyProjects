package roundTest;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileDataReader {

    private XSSFWorkbook wb;

    public String read(String fileName, int x, int y) {

	String f = "src/main/resources/TestData/" + fileName;
	String testdata = "";
	try {
	    FileInputStream fis = new FileInputStream(f);
	    wb = new XSSFWorkbook(fis);
	    XSSFSheet sht = wb.getSheet("Sheet1");

	    DataFormatter df = new DataFormatter();
	    testdata = df.formatCellValue(sht.getRow(x - 1).getCell(y - 1));

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}

	return testdata;

    }

}
