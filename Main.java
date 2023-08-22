import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{  
private static String program;

public static void main(String args[]) throws IOException  
{  
    //obtaining input bytes from a file  
FileInputStream fis=new FileInputStream(new File("C:\\Users\\mashu\\Documents\\Code\\food-footprints.xls"));  
//creating workbook instance that refers to .xls file  
HSSFWorkbook wb=new HSSFWorkbook(fis);   
//creating a Sheet object to retrieve the object  
HSSFSheet sheet=wb.getSheetAt(0);  
//evaluating cell type   
FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
Scanner myObj = new Scanner(System.in);  // Create a Scanner object



 

 /*
    for(Row row : sheet)
    {
        for(Cell cell : row)
        {
            
            switch(formulaEvaluator.evaluateInCell(cell).getCellTypeEnum())
            {

            
            case NUMERIC:
            if(cell.getNumericCellValue() == 0.43){
                System.out.print(cell.getStringCellValue() + "\t");
                 System.out.print("IU" + "\t");
            System.out.print(cell.getNumericCellValue() + "\t");
            }
                break;

          case STRING:
               if(cell.getStringCellValue() == "Apples"){
                System.out.print(cell.getStringCellValue() + "\t");
                    System.out.print("IU" + "\t");
                }
               break;
            default:

                break;
   

            }
        }
        */
      //  System.out.println();  

    for(Row row : sheet)
    {
        for(Cell cell : row)
        {
            switch(formulaEvaluator.evaluateInCell(cell).getCellTypeEnum())
            {
            /*
            case NUMERIC:
                System.out.print(cell.getNumericCellValue() + "\t");
                break;
            */
            case STRING:
                System.out.print(cell.getStringCellValue() + "\t");
                break;
            default:
                break;

            }
        }
        System.out.println();
    }
    double addGHG =0;
    addGHG = addGHG + Program(addGHG);
    System.out.println("How was your experience? Submit any feedback you have below (Write none if you don't have any):");
    String feedback = myObj.nextLine();  // Read user input
    ArrayList<String> FeedbackArray = new ArrayList<String>();
    FeedbackArray.add(feedback);
    System.out.println("All feedback:" + FeedbackArray);
    System.out.println("Write STOP to stop and CONTINUE to continue");
    String stopProgram = myObj.nextLine();
    if (stopProgram.equals("CONTINUE")){
        Program(addGHG);
        System.out.println("How was your experience? Submit any feedback you have below (Write none if you don't have any):");
        String feedback2 = myObj.nextLine();  // Read user input
        FeedbackArray.add(feedback2);
        System.out.println("All feedback:" + FeedbackArray);
        System.out.println("Write STOP to stop and CONTINUE to continue");
        stopProgram = myObj.nextLine();
    }
    
}

public static double Program(double addGHG) {
    String[] foods = {"Apples", "Bananas", "Barley", "Beef (beef herd)", "Beef (dairy herd)", "Beet Sugar", "Berries & Grapes", "Brassicas", "Cane Sugar", "Cassava", "Cheese", "Citrus Fruit", "Coffee", "Dark Chocolate", "Eggs", "Fish (farmed)", "Groundnuts", "Lamb & Mutton", "Maize", "Milk", "Nuts", "Oatmeal", "Onions & Leeks", "Other Fruit", "Other Pulses", "Other Vegetables", "Peas", "Pig Meat", "Potatoes", "Poultry Meat", "Prawns (farmed)", "Rice", "Root Vegetables", "Soymilk", "Tofu (soybeans)", "Tomatoes", "Wheat & Rye", "Wine"};
    double[] GHG = {0.43, 0.86, 1.18, 99.48, 33.3, 1.81, 1.53, 0.51, 3.2, 1.32, 23.88, 0.39, 28.53, 46.65, 4.67, 13.63, 3.23, 39.72, 1.7, 3.15, 0.43, 2.48, 0.5, 1.05, 1.79, 0.53, 0.98, 12.31, 0.46, 9.87, 26.87, 4.45, 0.43, 0.98, 3.16, 2.09, 1.57, 1.79};
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object

    System.out.println("Enter food from the list printed above");
     
    String foodInput = myObj.nextLine();  // Read user input
    for(int i = 0; i<foods.length; i++){
        if(foodInput.toLowerCase().trim().equals(foods[i].toLowerCase().trim())){
            
           System.out.println("Greenhouse Gas emissions per kilorgram is: " + GHG[i]);
           addGHG += GHG[i];

        }
    }
    System.out.println("Your total carbon footprint from today's diet is: " + addGHG + " greenhouse gas emissions per kilogram");
    return addGHG;
}
}