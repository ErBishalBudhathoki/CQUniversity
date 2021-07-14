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
public class Tax {
    
    //variables and constant declaration
    double MaxIncome, Income_Tax;
    
    //calling Taxtest object of TaxTest.java
    TaxTest TT = null;
    
    public Tax() {
        // constructor (constructor with no argument should pass here)
        if(MaxIncome > 0) {
            this.MaxIncome = 0;
        }
    } //end of constructor Tax()

    //calaculating tax for given number of emplyees
    public double calculateTax(double taxableIncome) {
        double excessDollar; //for amount eligible of tax
        this.MaxIncome = taxableIncome;
        
        // code to calculate tax based on tax range shown in Table 1
        if (taxableIncome < 0) {
            System.out.println("*****Salary can not be in negative.*****");
        } else if (taxableIncome == 0 || taxableIncome <= 18200) {
            MaxIncome = 0.0;
            Income_Tax = MaxIncome;
           
        } else if (taxableIncome >= 18201 && taxableIncome <= 37000) {
            excessDollar = (taxableIncome - 18200);
            MaxIncome = 0.0 + excessDollar * 0.19;
            Income_Tax = MaxIncome;
            
        } else if (taxableIncome >= 37001 && taxableIncome <= 87000) {
            excessDollar = (taxableIncome - 37000);
            MaxIncome = 3572 + excessDollar * 0.325;
            Income_Tax = MaxIncome;
            
        } else if (taxableIncome >= 87001 && taxableIncome <= 180000) {
            excessDollar = (taxableIncome - 87000);
            MaxIncome = 19822 + excessDollar * 0.37;
            Income_Tax = MaxIncome;
           
        } else if (taxableIncome >= 180001) {
            excessDollar = (taxableIncome - 180000);
            MaxIncome = 54097 + excessDollar * 0.45;
            Income_Tax = MaxIncome;
           
        }

        return Income_Tax;

    } //End of CalculateTax()

    // code to determine and return tax group number with highest number of employees
    public int highestTaxGroup(int group1, int group2, int group3, int group4, int group5) {
                
        if (group1 > group2 && group1 > group3 && group1 > group4 && group1 > group5) {
            return 1;
        } 
        else if (group2 > group1 && group2 > group3 && group2 > group4 && group2 > group5) {
            return 2;
        } 
        else if (group3 > group1 && group3 > group2 && group3 > group4 && group3 > group5) {
            return 3;
        } 
        else if (group4 > group1 && group4 > group2 && group2 > group3 && group4 > group5) {
            return 4;
        } 
        else
            return 5;
    } //end of HighestTaxGroup
    
} //end of class Tax
