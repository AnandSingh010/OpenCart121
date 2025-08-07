package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\opencartLogin.xlsx";
		ExcelUtils xutil = new ExcelUtils(path);
		
		int totalrows = xutil.getRowCount("Sheet1");
		int totalcols = xutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				logindata[i-1][j] = xutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
		
		
	}
	
	
	
}
