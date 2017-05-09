package helper;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public static XSSFWorkbook work;
    public static XSSFSheet sheet;
    public static XSSFCell cell;
    public static FileInputStream fs;
    
public static void setexcel(String path,String sheetname) throws IOException {
      try{
      fs= new FileInputStream(path);
    work=new XSSFWorkbook(fs);
      sheet= work.getSheet(sheetname); 
}
      catch(Exception e)
      {
       throw(e);}
 }
public static String getCellData(int RowNum, int ColNum)
{
      try{
             
      cell=sheet.getRow(RowNum).getCell(ColNum);
      String cellvalue;
      cellvalue=cell.getStringCellValue();
    return cellvalue;
      
         }
      catch(Exception e)
           {
                  throw(e);
           }    
      }
}





