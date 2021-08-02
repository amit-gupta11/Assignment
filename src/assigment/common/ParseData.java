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
    BufferedReader br = null;
    try {
      String record;
          br = new BufferedReader(new FileReader(Assignment.FILE_PATH+"data.txt"));
      while ((record = br.readLine()) != null) {
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
        if (br != null) {
          br.close();
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
    System.out.println("Year - " + recordData[Assignment.yearAddress] + " Country - " + (String)recordData[Assignment.countryAddress].toUpperCase()+ " State - " + recordData[Assignment.stateAddress] + " City - " + recordData[Assignment.cityAddress] + " Item - " + recordData[Assignment.itemAddress] + " Profit - " + "$" + String.format("%.4f",ConversionUtils.rupeesToUSDConversion(recordData[Assignment.profitAddress])));
  }
  
  public static void printDataMethod(String[]args){
     
  }
}