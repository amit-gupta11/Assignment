/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.utils;

import assigment.common.Logs;
import assigment.common.OperationsOnFiles;

/**
 *
 * @author Lenovo
 */
public class RecordValidations {

    private static String LINE_REGEX = "^[0-9a-zA-Z|]+$";
    private final static String YEAR_REGEX = "\\d{4}";

    public final static boolean isValidRecord(String record) {
        String[] recordData = record.split("\\|");
        if (record.matches(LINE_REGEX)) {

            if (recordData.length != 6) {
                Logs.printLogs("Invalid Record Record: " + record);
                return false;
            } else if (!recordData[5].trim().matches(YEAR_REGEX)) {
                Logs.printLogs("Invalid Year Record:" + record);
                return false;
            }
        } else {
            Logs.printLogs("Invalid Delimiter Record:" + record);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String r = "2020";
        System.out.println(r.matches("\\d{4}"));
    }
}
