/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnttwo;

/**
 *
 * @author Bishal Budhathoki
 * Student ID:12116421
 */
public class TaxPayer {//TaxPayer class begins
    private String emplName;
    private int age;
    private int taxGroup;
    private double taxableIncome;
    private double tax;
    
    
    public TaxPayer(){//Default Constructor
        emplName="Null";
        age=0;
        taxGroup=0;
        taxableIncome=0;
        tax=0;
        
    }
    public String getEmplName(){//start of getRmplName Method
        return emplName;
    }//end of getEMplName Method
    public void setEmplName(String name){//start of setEmplName method
        emplName=name;
    }//end of setEmplName method
    
    public int getAge(){//start of getAge method
        return age;
    }//end of getAge method
    public void setAge(int Age){//start of setAge method
        age=Age;
    }//end of setAge method
    
    public int getTaxGroup(){//start of getTaxGroup method
        return taxGroup;
    } //end of getTaxGroup method
    public void setTaxGroup(int group){//start of setTaxGroup method
        taxGroup=group;
    }//end of setTaxGroup method
    public double getTaxableIncome(){//start of getTaxableIncome method
        return taxableIncome;
    } //end of getTaxableIncome method
    public void setTaxableIncome(double income){//start of setTaxableIncome method
        taxableIncome=income;
    }//end of setTaxableIncome method
    public double getTax(){//start of getTax method
        return tax;
    }//end of getTax method
    public void setTax(double emplTax){//start of SetTax method
        tax=emplTax;
    }//end of setTax method
}// TaxPayer class ends
