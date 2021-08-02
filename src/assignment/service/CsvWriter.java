/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.service;

import assigment.common.Logs;
import assigment.common.Assignment;
import assignment.interfaces.Writable;
import assignment.utils.ConversionUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */

public class CsvWriter implements Writable {

    private final String HEADERS="Year,Country,State,City,Items,Profit(USD)\n";
    @Override
    public void writeCSV(ArrayList al)
    {
    try
    {
        BufferedWriter br= new BufferedWriter(new FileWriter(Assignment.FILE_PATH+"RESULT.csv"));
        br.write(HEADERS);
        for(int i=0;i<al.size();i++)
        {
            String cells[]=(String [])al.get(i);
            String csvRecord=cells[Assignment.yearAddress]+","+cells[Assignment.countryAddress].toUpperCase()+","+cells[Assignment.stateAddress]+","+cells[Assignment.cityAddress]+","+cells[Assignment.itemAddress]+","+String.format("%.4f",ConversionUtils.rupeesToUSDConversion(cells[Assignment.profitAddress]))+"\n";
            br.write(csvRecord);
        }
        br.flush();
        br.close();
    }catch(Exception e)
    {
       Logs.printLogs("Error in writeCSV function Error"+e.toString());
    }
    }
  
}