package Utilities;

public class DataProvider 
{

	//Data Provider =1 
	@org.testng.annotations.DataProvider(name="LoginData")
	public String [][] getData() throws Exception
	{
		//String ppath="C:\\Users\\arun.maltumkar\\eclipse-workspace\\Echo_V2.0\\testData\\Echo_Provider_Test.xlsx";
		String ppath= System.getProperty("user.dir")+"\\testData\\Echo_Provider_Test.xlsx";
		ExcelUtility exut= new ExcelUtility(ppath);
		int  totalrows=exut.getRowcount("Logins");
		int totaldatarows= totalrows+1;
		int totalcellcount=exut.getCellcount("Logins",1);
		
		String exceldata [][] = new String[totalrows][totalcellcount];  //created 2 dim array
		
		for(int i=1;i<totaldatarows;i++)
		{
			for(int j=0;j<totalcellcount;j++)
			{
				exceldata[i-1][j]=exut.getCellData("Logins", i, j);

			}
		}
		return exceldata;
		
	}
	
	
	
	
}
