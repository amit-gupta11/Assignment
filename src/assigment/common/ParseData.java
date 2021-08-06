package assigment.common;

import assignment.interfaces.Writable;
import assignment.service.CsvWriter;
import assignment.utils.ConversionUtils;
import assignment.utils.RecordValidations;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class ParseData {
  static   ArrayList<String[]> rows = new ArrayList<>();
  public static void readTXTFile() {
    BufferedReader readFile = null;
    try {
      String record;
          readFile = new BufferedReader(new FileReader(OperationsOnFiles.FILE_PATH+"data.txt"));
      while ((record = readFile.readLine()) != null) {
          if(RecordValidations.isValidRecord(record))
          {
          parseDataMethod(record);    
          }
          
       if(rows.size()>0)
       {
           Writable writer=new CsvWriter();
           writer.writeCSV(rows);
       }
          
        //
      }
//      
      }
    catch(Exception exp) {
        Logs.printLogs("Error is ParseData function Error:"+exp.toString());
    } finally {
      try {
        if (readFile != null) {
          readFile.close();
        }
      } catch(IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void parseDataMethod(String record) throws SecurityException, IOException 
  {	
    String recordData[]=record.split("\\|");
    rows.add(recordData);
    System.out.println("Year - " + recordData[OperationsOnFiles.yearAddress] + " Country - " + (String)recordData[OperationsOnFiles.countryAddress].toUpperCase()+ " State - " + recordData[OperationsOnFiles.stateAddress] + " City - " + recordData[OperationsOnFiles.cityAddress] + " Item - " + recordData[OperationsOnFiles.itemAddress] + " Profit - " + "$" + String.format("%.4f",ConversionUtils.rupeesToUSDConversion(recordData[OperationsOnFiles.profitAddress])));
  }
  

}