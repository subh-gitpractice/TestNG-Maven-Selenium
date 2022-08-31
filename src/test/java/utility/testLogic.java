package utility;

public class testLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
			String excelpath = "/testData/testdata.xlsx";
			String sheetName = "Sheet1";
			String datakey = "mytestdata1";
			excelUtil excel = new excelUtil(excelpath,sheetName);
			int [] data = excel.getDatakeyRow(datakey);
			System.out.println("Starting row "+ data[0]+" Ending row "+data[1]);
	
	
		

	}

}
