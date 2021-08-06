package assigment.common;

public class OperationsOnFiles {

    public static int yearAddress = 5;
    public static int countryAddress = 0;
    public static int stateAddress = 1;
    public static int cityAddress = 2;
    public static int itemAddress = 4;
    public static int profitAddress = 3;
    public static double dollarPrice = 74.25;
    public static final String FILE_PATH="D:\\Result\\";
    public static final String LOG_PATH="C:\\Users\\Public\\MyLogFile\\";

    public static void main(String[] args) {
        ParseData.readTXTFile();

    }
}
