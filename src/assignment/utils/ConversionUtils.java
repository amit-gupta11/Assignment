/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.utils;

import assigment.common.OperationsOnFiles;

/**
 *
 * @author LENOVO
 */
public class ConversionUtils {
    
  public static double rupeesToUSDConversion(String price)
  {
      double convertedPrice = Integer.valueOf(price)/OperationsOnFiles.dollarPrice;
      return convertedPrice;
  }
    
  
    
}
