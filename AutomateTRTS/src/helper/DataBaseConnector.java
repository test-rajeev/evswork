package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;


public class DataBaseConnector 
{

    private static String dbusername;
    private static String dbpassword;

    //Should be defined as jdbc:mysql://host:port/database name
    private static String databaseURLQA= "jdbc:sqlserver://172.16.5.117:1433;DatabaseName=Internaldb"; ///evs01tst06:1433
    
    // private static String databaseURLQA= "jdbc:sqlserver://evs01tst06:1433/internaldb;databaseName=IHRIS"; ///evs01tst06:1433
   // jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;

    public static String executeSQLQuery(String sqlQuery) 
    {
        String connectionUrl="";
        Connection connection;
        String resultValue = "";
        ResultSet rs;

      
            connectionUrl = databaseURLQA;
            dbusername = "evsdbuser";
            dbpassword = "evsdbuser";
       try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
            if(connection!=null) {
                System.out.println("Connected to the database...");
            }else {
                System.out.println("Database connection failed");
            }
            Statement stmt = connection.createStatement();
            rs=stmt.executeQuery(sqlQuery);

            try {
                while(rs.next()){
                    resultValue = rs.getString(1).toString();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch (NullPointerException err) {
                System.out.println("No Records obtained for this specific query");
                err.printStackTrace();
            }
            connection.close();

        }catch(SQLException sqlEx) {
            System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
        }
        return resultValue;
    }


    public static ArrayList<String> executeSQLQuery_List(String sqlQuery) 
    {
        String connectionUrl="";
        Connection connection;
        ArrayList<String> resultValue = new ArrayList<String>();
        ResultSet resultSet;

        	connectionUrl = databaseURLQA;
            dbusername = "evsdbuser";
            dbpassword = "evsdbuser";
 

     
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
            if(connection!=null) {
                System.out.println("Connected to the database");
            }else {
                System.out.println("Failed to connect database");
            }
            Statement statement = connection.createStatement();
            resultSet=statement.executeQuery(sqlQuery);

            try {
                while(resultSet.next()){
                    int columnCount = resultSet.getMetaData().getColumnCount();
                    StringBuilder stringBuilder = new StringBuilder();
                    for(int iCounter=1;iCounter<=columnCount; iCounter++){
                        stringBuilder.append(resultSet.getString(iCounter).trim()+" ");
                    }
                    String reqValue = stringBuilder.substring(0, stringBuilder.length()-1);
                    resultValue.add(reqValue);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch (NullPointerException ex) {
                System.out.println("No Records found for this specific query" +ex.getStackTrace());
            }
            finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        System.out.println( "SQL Exception:" +ex.getStackTrace());
                    }
                }
            }

        }catch(SQLException sqlEx) {
            System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
        }
        return resultValue;
    }
    
    public void testVerifySpecificRecord() 
    {
        String sqlQuery ="SELECT TOP 10 *  FROM [InternalApp_CommonDB].[dbo].[EmailQueue] order by MailQueueId DESC";
        String expectedEmpName = "Keshav";
        //Getting employee name by Id
        String actualEmpNameById = DataBaseConnector.executeSQLQuery(sqlQuery);
        System.out.println("Employee name retrieved from database :" + actualEmpNameById);
     //   Assert.assertEquals(expectedEmpName, actualEmpNameById);
      
    }
    
    public void tesVerifyListOfRecords() {
        boolean flag = false;
        List<String> listOfDBValues = new ArrayList<String>();
        String expEmployeeName = "Keshav";
        String sqlQuery = "select EMP_Manager from Common.Employee_Master where EMP_ID='6533'";
        //Getting list of employee names from employee table
        listOfDBValues = DataBaseConnector.executeSQLQuery_List(sqlQuery);
        for (String strName : listOfDBValues) {
            if (strName.equalsIgnoreCase(expEmployeeName)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag, "Retrieved values are not matching with Expected values");
    }
    
   
}
