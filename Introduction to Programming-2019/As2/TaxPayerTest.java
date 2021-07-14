/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmnttwo;

import com.mycompany.assignmnttwo.TaxPayer;
import java.util.Scanner;


/**
 *
 * @author Bishal Budhathoki
 * Student ID:12116421
 */
public class TaxPayerTest {//TaxPayerTest class begins

    /**
     * @param args the command line arguments
     */
    static final int N = 6;//My student ID is 12116421 and the highest number of my student ID is 6.
    static final int taxGroup1 = 18200;//assigning value to taxGroup1
    static final int taxGroup2 = 37000;//assigning value to taxGroup2
    static final int taxGroup3 = 87000;//assigning value to taxGroup3
    static final int taxGroup4 = 180000;//assigning value to taxGroup4

    static TaxPayer[] Tx = new TaxPayer[N];//creating the object of an array of class TaxPayer to create 7 employee object 
    
    

    public static void main(String[] args) {
        final int lowestAgeLimit = 18;//assigning value to lowestAgeLimit
        final int highestAgeLimit = 64;//assigning value to highestAgeLimit
        final int lowestIncomeLimit = 1;//assisgning value to lowestIncomeLimit
        final int highestIncomeLimit = 999000;//assigning calue to the highestIncomeLimit
        int searchbyAge;
        int choice;//for storing choice of the user
        int counter = 0;//initializing the counter variable

        Scanner input = new Scanner(System.in);//use of scanner to take input from user
        try {//exception handling 
            while (true) {//while loop begins
                menuMethod();//calls the method which displays the menu
                choice = input.nextInt();//taking input from user
                if (choice == 1) {//the counter is 1 only if user selects 1 as to display first we need to input the name,age and taxableincome and then store them
                    counter = +1;//counter increases by 1 if user choose choice 1
                }//if case ends
                if (counter != 1) {//if user input choice from 2-6 counter is not increased
                    System.out.println("please choose option 1 for inserting the informtion");
                } else {
                    switch (choice) {
                        case 1://case 1 options begins for entering the employees information (name age and taxableincome)
                            for (int i = 0; i < N; i++) {//for loop begins
                                Tx[i] = new TaxPayer();//creating array object each time to hold data
                                System.out.print("Enter employee" + (i + 1) + "Name: ");
                                Tx[i].setEmplName(input.next());//store the name of employee

                                System.out.print("Enter employee" + (i + 1) + "Age: ");
                                Tx[i].setAge(input.nextInt());//store the age of employee
                                if (Tx[i].getAge() < lowestAgeLimit || Tx[i].getAge() > highestAgeLimit) {
                                    System.out.print("Please enter the age between 18 and 64:");
                                    Tx[i].setAge(input.nextInt());
                                }
                                System.out.print("Enter employee" + (i + 1) + "Taxable Income :$ ");
                                Tx[i].setTaxableIncome(input.nextDouble());//store the taxableincome 
                                if (Tx[i].getTaxableIncome() < lowestIncomeLimit || Tx[i].getTaxableIncome() > highestIncomeLimit) {
                                    System.out.print("Please enter the amount between 1 and 999000:");
                                    Tx[i].setTaxableIncome(input.nextDouble());
                                }
                            }//for loop ends
                            System.out.println("*************************************************");
                            System.out.println("Thank you for entering employee information");
                            System.out.println("----------------------------------------------------");
                            break;//case 1 ends
                        case 2://case 2 begins for calculating tax and finding the respective taxgroup
                            taxCalculator();//calling the method for calculating tax
                            System.out.println("*************************************************");
                            System.out.println("Calculation of the tax and taxgroup number ");
                            System.out.println("----------------------------------------------------");
                            break;//case 2 ends
                        case 3://case 3 begins for displaying all employee deatails 
                            System.out.println("*****************Employee Details*******************");
                            for (int i = 0; i < N; i++) {
                                System.out.printf("\nName:%s   Age:%d   Income:%.2f  TaxableAmount:%.2f  TaxGroup:%d", Tx[i].getEmplName(), Tx[i].getAge(), Tx[i].getTaxableIncome(), Tx[i].getTax(), Tx[i].getTaxGroup());
                            }
                            System.out.printf("\n----------------------------------------------------");
                            break;//case 3 ends
                        case 4://case 4 begins for displaying the employees from the group1
                            group1EmployeeList();//calls the  method group1EmployeeList
                            break;//case 4 ends
                        case 5://case 5  begins for the searching employee details by entering the age of employee
                            System.out.println("Enter the age of employee which you want to search by:");
                            searchbyAge = input.nextInt();//store the age input by user
                            searchByAge(Tx, searchbyAge);//calls seachByAge method
                            break;//case 5 ends
                        case 6://case 6 begins for sorting and displaying the employee details in descending order
                            sortByName(Tx);//calls sortByName method for sorting employees
                            System.out.printf("**********Employee details after sorting***********");
                            for (int i = 0; i < N; i++) {//for loop begins
                                System.out.printf("\nName: %s   Age: %d   Income: %.2f  TaxableAmount:%.2f   TaxGroup:%d", Tx[i].getEmplName(), Tx[i].getAge(), Tx[i].getTaxableIncome(), Tx[i].getTax(), Tx[i].getTaxGroup());

                            }//for loop ends
                            System.out.printf("\n----------------------------------------------------");
                            break;//case 6 ends
                        case 7://case 7 begins to exit from the application
                            System.exit(0);//exits from the application
                            break;//case 7 ends
                        default://defult begins
                            System.out.println("Please enter the choice again.The choice must be 1-7");//displaying the message
                            break;//default ends
                    }//end of switch case
                }//else statement ends
            }//while loop ends

        } catch (Exception e) {//catch exception begins
            System.out.println("Something went wrong");
            menuMethod();//calls the menuMethod method
        }//end of catch statement
    }//end of main

    public static void taxCalculator() {//taxCalculator method begins for calculating tax based on the taxableIncome input by employee
        //The method is called from the case2
        for (int i = 0; i < N; i++) {//for loop begins
            if (Tx[i].getTaxableIncome() < taxGroup1) {//if statement begins
                //The condition is true if the income is between $0-$18,200
                Tx[i].setTaxGroup(1);//set the TaxGroup1
                Tx[i].setTax(0);//set the tax 0 as no tax is applied for employee whose income lies in 0-18,200
            } else if (Tx[i].getTaxableIncome() < taxGroup2) {//The condition is true if the income is between $18,201-$37,000
                Tx[i].setTaxGroup(2);//set the TaxGroup to 2
                Tx[i].setTax((Tx[i].getTaxableIncome() - taxGroup1) * 0.19);//
            } else if (Tx[i].getTaxableIncome() < taxGroup3) {
                Tx[i].setTaxGroup(3);//set the taxGroup3
                Tx[i].setTax(3572 + (Tx[i].getTaxableIncome() - taxGroup2) * 0.325);
            } else if (Tx[i].getTaxableIncome() < taxGroup4) {
                Tx[i].setTaxGroup(4);//set the taxGropup4
                Tx[i].setTax(19822 + (Tx[i].getTaxableIncome() - taxGroup3) * 0.37);
            } else {
                Tx[i].setTaxGroup(5);//set the taxGroup5
                Tx[i].setTax(54097 + (Tx[i].getTaxableIncome() - taxGroup4) * 0.45);
            }//end of if ...else statement
        }//end of for loop
    }//end of taxCalculation Method

    public static void menuMethod() {//menuMethod method begins for displaying the menu options each time
        System.out.println("---------------------------------------------------------------");
        System.out.println("Myself Rabina Prajapati.My student Id is 12117176.ThankYou for using my application");
        System.out.println("----------------------------------------------------------------");
        
        System.out.println("Enter the options from 1 to 7");
        System.out.println(" 1. Read, validate and store data for N taxpayers ");
        System.out.println(" 2. Calculate and store tax and tax group for all taxpayers  ");
        System.out.println(" 3. Display all taxpayers");
        System.out.println(" 4. Display the name and age of all taxpayers from tax group 1");
        System.out.println(" 5. Search a taxpayer by age ");
        System.out.println(" 6. Sort and display taxpayers ");
        System.out.println(" 7. Exit from the application ");
    }//end of menuMethod

    public static void group1EmployeeList() {//group1EmployeeList method  begins
        int counter = 0;//setting counter to 0
        System.out.println("***************Group1 Employee List*******************\n");
        for (int i = 0; i < N; i++) {//forloop begins
            if (Tx[i].getTaxGroup() == 1) {//if condition to print the taxgroup 1 employees
                System.out.printf("\nName: %s  Age:%d\n", Tx[i].getEmplName(), Tx[i].getAge());
                counter = +1;//increase the value of counter if there is an employee in the taxgroup1
            }
        }//for loop ennds
        if (counter < 1) {//if the value of counter is less than 1 there is no ny employees in thhe taxGroup1
            System.out.println("There is no any employee in group1");
        }//if statement ends
        System.out.println("***********************************************");
    }//end of the methog group1EmployeeList

    public static void searchByAge(TaxPayer[] array, int a) {//method seachByAge begins
        int counter = 0;
        System.out.printf("********************Employees list of age " + a + " **************");
        for (int i = 0; i < N; i++) {//for loop begins to read all employee data of the particular age
            if (array[i].getAge() == a) {//checks if there is age matching or not
                System.out.printf("\nName: %s   Age: %d   Income: %.2f  TaxableAmount:%.2f   TaxGroup:%d\n", Tx[i].getEmplName(), Tx[i].getAge(), Tx[i].getTaxableIncome(), Tx[i].getTax(), Tx[i].getTaxGroup());
                counter = +1;//increase the counter value if there is any employee of the particular age
            }//end of if statement

        }//end of for loop
        if (counter == 0) {//if there is no employee from the prticular age group
            System.out.printf("\nTaxpayer with the given age is not found.ThankYou");
        }
        System.out.println("*********************************************");
    }//end of searchBAge method

    public static void sortByName(TaxPayer[] array) {//method sortByName begins
        //this method is called from case 6 for sorting the name in descending order and themn displaying the details
        for (int i = 0; i < array.length - 1; i++) {//for loop begins for sorting
            int temp = i;//initializing the temp for storing value and then sorting
            for (int j = i + 1; j < array.length; j++) {//start of next for loop 
                if (array[j].getEmplName().compareToIgnoreCase(array[temp].getEmplName()) > 0) {
                    temp = j;//assign largest value to temp
                }//end of if statement
            }//end of for loop
            TaxPayer largest = array[temp];//swapping the value in the temporary variable
            array[temp] = array[i];//storing largest value to the secondplace
            array[i] = largest;//storing largest value to firstplace
        }//end of for looop
    }//end of sortByName method
}//end of class TaxPayerTest
