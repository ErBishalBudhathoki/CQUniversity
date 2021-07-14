
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bishal Budhathoki
 * 12116421
 */
public class TaxTest   {
    
    public static void main(String[] args) {
        // declare variables/constants
        final int N = 6;
        int group_1 = 0, group_2 = 0, group_3 = 0, group_4 = 0, group_5 = 0;
        double highestTax = 0.00; //To store highest tax value  
        double lowestTax = 0.00; //To store lowest tax value
        
        //to read user input for salary income
        Scanner input = new Scanner(System.in); 
        // display welcome message
        System.out.println("****************************************************************");
        System.out.println("**********Hello, Welcome to Tax Return Info Calculator**********");
        System.out.println("****************************************************************\n");
        System.out.println("Total number of employee(N): 6 (12116421)\n");
        
        // loop to input taxable income, calculate and display tax
        Tax tax = null; //declaring Tax object of Tax.java and assigning null initially
        
        // taking income salary input of N employee and displaying there income tax
        for (int i = 0; i < N; i++) {
            
            System.out.printf("Enter the taxable income for employee %d: ", i+1);
            double taxable = input.nextDouble(); //accepting user input
            tax = new Tax(); ///declaring Tax object of Tax.java
            
            //calling calculateTax object of Tax class
            double IncomeTax = tax.calculateTax(taxable);
            
            if (taxable >= 0 && taxable <= 18200) { //Group1
                group_1++;
                System.out.printf("The income tax for employee %d is $%.2f\n", i+1, IncomeTax);
            } else if (taxable >= 18201 && taxable <= 37000) { //Group2
                group_2++;
                System.out.printf("The income tax for employee %d is $%.2f\n", i+1, IncomeTax);
            } else if (taxable >= 37001 && taxable <= 87000) { ////Group3
                group_3++;
                System.out.printf("The income tax for employee %d is $%.2f\n", i+1, IncomeTax);
            } else if (taxable >= 87001 && taxable <= 180000) { ////Group4
                group_4++;
                System.out.printf("The income tax for employee %d is $%.2f\n", i+1, IncomeTax);
            } else if (taxable >= 180001) { //Group5
                group_5++;
                System.out.printf("The income tax for employee %d is $%.2f\n", i+1, IncomeTax);
            }
            
            //comparing for highest and lowest taxable income
            if (highestTax < IncomeTax ) {
                highestTax = IncomeTax;
            } else {
                lowestTax = IncomeTax;
            }   
        }//end of taking income salary input and displaying incometax
        
        //Generating Report of the application
        System.out.println("\n-----------------Report-------------------");
        System.out.printf("Highest tax is $%.2f\n", highestTax); //displaying highest tax
        System.out.printf("Lowest tax is $%.2f\n", lowestTax); //displaying lowest tax
        // generated and display report

        //find out highest employees in group
        if (group_1 >= 0) {
            System.out.println("Total number of employees in group1: " + group_1);
        }

        if (group_2 >= 0) {
            System.out.println("Total number of employees in group2: " + group_2);
        }

        if (group_3 >= 0) {
            System.out.println("Total number of employees in group3: " + group_3);
        }

        if (group_4 >= 0) {
            System.out.println("Total number of employees in group4: " + group_4);
        }

        if (group_5 >= 0) {
            System.out.println("Total number of employees in group5: " + group_5);
        }

        int HighestGroupNum = tax.highestTaxGroup(group_1, group_2, group_3, group_4, group_5); //finding highest group of 5 by calling highestTaxGroup object
              
        System.out.println("Tax group number with highest number of employees: Group" +HighestGroupNum);
        System.out.println("------------------------------------------");
        
        // display exit message
        System.out.println("*****************************************************************************");
        System.out.println("Thank-you for using this application, Come back again to use this application");
        System.out.println("******************************************************************************\n");

    } //End of main class object
} //end of TaxTest class
