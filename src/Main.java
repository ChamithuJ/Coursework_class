
import java.util.*; // Importing the library functions.
import java.io.File;// Importing the library functions.
import java.io.FileWriter; // Importing the library functions.
import java.io.IOException; // Importing the library functions.




public class Main {
    private static int[] pay = new int[3];
    public static void main(String[] args) throws IOException { //The main function
        Scanner inputs = new Scanner(System.in);

        foodque queueONE = new foodque(2);
        foodque queueTWO = new foodque(3);
        foodque queueTHREE = new foodque(5);
        foodque WaitingList = new foodque(10);



        int burgertot = 50; // Initial burger count assigned to a variable called burgertot.
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" Welcome to Foodies FAV Food Center !!! ");

        while (true) { // looping everything in an infinite loop so as to run it infinitely unless exited.
            mainmenue(); // calling the function called mainmenue.
            if (burgertot <= 10) {  //checking if the total amount of burgers is less than 10 to display a warning.
                System.out.println();
                System.out.println("The number of burgers is low please refill");
                System.out.println();
            }
            System.out.print("Enter your option : ");
            String option = inputs.next(); // use of the scanner called inputs
            if (option.equals("999") || option.equals("EXT")) {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Thank you for using the que management system");
                break; // Exiting the loop
            }

            switch (option) { // use fo switch case to call the functions
                case "100":
                case "VFQ":
                    viewallques(queueONE, queueTWO, queueTHREE);
                    break;
                case "101":
                case "VEQ":
                    viewallemptyques(queueONE, queueTWO, queueTHREE);
                    break;
                case "102":
                case "ACQ":
                    addcustomer(queueONE, queueTWO, queueTHREE,WaitingList);
                    break;
                case "103":
                case " RCQ":
                    removecustomer(queueONE, queueTWO, queueTHREE);
                    break;
                case "104":
                case "PCQ":
                    int Sburgers = removeservedcustomer(queueONE, queueTWO, queueTHREE, burgertot,WaitingList);
                    burgertot -= Sburgers;
                    break;
                case "105":
                case "VCS":
                    customerssorted(queueONE, queueTWO, queueTHREE);
                    break;
                  case "106":
                case "SPD":
                    storeprogramdata(queueONE, queueTWO, queueTHREE,burgertot);
                    break;
                case "107":
                case "LPD ":
                    burgertot=loadprogramdata(queueONE, queueTWO, queueTHREE,burgertot);
                    break;
                case "108":
                case "STK":
                    remaningburgerstock(burgertot);
                    break;
                case "109":
                case "AFS":
                  int added = Addburgerstock(burgertot);
                    burgertot += added;

                    break;
                case "110":
                case "IFQ":
                    incomeofeachqueu();
                    break;
                case "check":
                    check(WaitingList);
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Invalid option try again ");
                    System.out.println(" ");
                    break;


            }

        }
    }

    public static void check(foodque queueONE ) {
        Customer[] cashierONE = queueONE.getQueue();
        for(Customer element:cashierONE){
            System.out.println(element.getname());
        }

   }


    public static void mainmenue() { //using a function called mainmenue that has a multiline string
        System.out.println(""" 
                             
                                
                Available options :
                100 or VFQ: View all Queues
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue. (From a specific location)
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine)
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining burgers Stock.
                109 or AFS: Add burgers to Stock.
                110 or IFQ: Income of each queue.
                999 or EXT: Exit the Program
                                
                                
                """);
    }

    public static void viewallques(foodque queueONE, foodque queueTWO, foodque queueTHREE) { // a new function for viewing all the ques.
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();
        System.out.println(" ");

        System.out.println("""
                *****************
                *    Cashiers   *
                *****************"""); // multiline string


        for (int i = 0; i < 5; i++) { //using a for loop
            // use of a string variable called one
            String one = " ";
            String two = " ";
            String three = " ";
            if (i < cashierONE.length) {
                if (i < 2) {
                    if (cashierONE[i] != null) { // checking weather the i'th  position of the string cashier one is an "X"
                        one = "O";
                    } else {
                        one = "X";
                    }
                }
            }
            // use of string variable called two

            if (i < cashierTWO.length) {
                if (i < 3) {
                    if (cashierTWO[i] != null) { // checking weather the i'th  position of the string cashier two is an "X"
                        two = " O";
                    } else {
                        two = "X";
                    }
                }
            }
            // use of string variable called three

            if (i < cashierTHREE.length) {
                if (i < 5) {
                    if (cashierTHREE[i] != null) { //checking weather the i'th  position of the string cashier three is an "X"
                        three = "O";
                    } else {
                        three = "X";
                    }
                }
            }
            // printing one, two and three the values denoted within " " are the spaces in between each
            System.out.printf("%1s %5s %6s%n", one, two, three);
        }

        System.out.println("");
        System.out.println(" X - Not occupied   O - Not occupied   ");
    }

    public static void viewallemptyques(foodque queueONE, foodque queueTWO, foodque queueTHREE) {
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();

        System.out.println("");
        boolean temp1 = true;
        int var = 0;

        for (Customer element : cashierONE) {
            if (element != null) {
                var = 1;
                break;
            }
        }
        if (var == 0) {
            System.out.println("Cashier one is empty");
            temp1 = false;
        }

        var = 0; // Reset var to 0 before checking the next queue

        for (Customer element : cashierTWO) {
            if (element != null) {
                var = 1;
                break;
            }
        }
        if (var == 0) {
            System.out.println("Cashier two is empty");
            temp1 = false;
        }

        var = 0; // Reset var to 0 before checking the next queue

        for (Customer element : cashierTHREE) {
            if (element != null) {
                var = 1;
                break;
            }
        }
        if (var == 0) {
            System.out.println("Cashier three is empty");
            temp1 = false;
        }

        if (temp1) {
            System.out.println("None of the cashiers are empty");
        }
        System.out.println();
    }


    public static int checkslots(Customer[] queue) {
        int count = 0;
        for (Customer elements : queue) {
            if (elements != null) {
                count++;
            }
        }
        return count;
    }


    public static void addcustomer(foodque queueONE, foodque queueTWO, foodque queueTHREE,foodque WaitingList ) { // a new function for adding a new customer to ques.
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();
        Customer[] WAitingList = WaitingList.getQueue();
        

        int FillSlots1 = checkslots(cashierONE);
        int FillSlots2 = checkslots(cashierTWO);
        int FillSlots3 = checkslots(cashierTHREE);


        System.out.print("");
        Scanner inputs = new Scanner(System.in); // use of a sanner called inputs to store the inputed variables.
        System.out.print("Enter the customer first name : ");
        String Firstname = inputs.next();
        System.out.print("Enter the customer second name : ");
        String Lastname = inputs.next();
        System.out.print("Enter the number of burgers : ");
        int requiredburgers = inputs.nextInt();
        Customer newCustomer = new Customer(Firstname, Lastname, requiredburgers);

        if (FillSlots1 + FillSlots2 + FillSlots3 == 10) {
            System.out.println("All the queues are full");
            WaitingList.WAITinglist(newCustomer);
            System.out.println("The customer was added to waiting list.");
            return;
        }

        int cashier = 1;
        if (FillSlots2 < FillSlots1) {
            cashier = 2;
        }
        if (FillSlots1 == 2) {
            cashier = 2;
        }
        if (FillSlots3 < FillSlots2) {
            cashier = 3;
        }
        if (FillSlots2 == 3) {
            cashier = 3;
        }

        if (cashier == 1) {
            queueONE.setcustomer(newCustomer);

        }
        if (cashier == 2) {
            queueTWO.setcustomer(newCustomer);
        }
        if (cashier == 3) {
            queueTHREE.setcustomer(newCustomer);
        }
        System.out.println();


    }

    public static void removecustomer(foodque queueONE, foodque queueTWO, foodque queueTHREE) { // a new function for removing a customer form the queu

        while (true) {
            System.out.println("");
            Scanner inputs = new Scanner(System.in);
            int Cashier;
            int CashierSlot;
            try {
                System.out.print("Enter the cashier number :  ");
                Cashier = inputs.nextInt();
                if (Cashier == 999) {
                    System.out.println("Exiting the process ");
                    break;
                }
                if (Cashier == 1) {
                    System.out.print("Enter the slot( Max 2) :");
                }
                if (Cashier == 2) {
                    System.out.print("Enter the slot( Max 3) :");
                }
                if (Cashier == 3) {
                    System.out.print("Enter the slot( Max 5) :");
                }
                CashierSlot = inputs.nextInt();

            } catch (Exception e) {
                System.out.println("Enter an inteager .");
                continue;
            }
            if (CashierSlot == 999) {
                System.out.println("Exiting the process ");
                break;
            }
            if (Cashier == 1) {
                queueONE.Removecustomer(Cashier, CashierSlot);
                break;
            } else if (Cashier == 2) {
                queueTWO.Removecustomer(Cashier, CashierSlot);
                break;

            } else if (Cashier == 3) {
                queueTHREE.Removecustomer(Cashier, CashierSlot);
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        System.out.println();

    }

    public static int removeservedcustomer(foodque queueONE, foodque queueTWO, foodque queueTHREE, int burgers,foodque WaitingList ) { // a new function for removing a served customer.
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();
        Customer[] WAitingList = WaitingList.getQueue();

        int cashiernum = 0;
        int servedburgers = 0;
        while (true) {
            System.out.println("");
            Scanner inputs = new Scanner(System.in);
            try {
                // getting a scanner called inputs to store the values that the user inputs
                System.out.print("Enter cashier number : ");
                cashiernum = inputs.nextInt();
            } catch (Exception e) {
                System.out.println("Enter a valid input");
            }
            if (cashiernum == 1) {
                servedburgers = queueONE.servecustomer(burgers);
                pay[0] += servedburgers;
                if(WAitingList[0]!=null){
                    for(int  i=0; i< cashierONE.length;i++) {
                        if(cashierONE[i]==null) {
                            cashierONE[i] = WAitingList[0];
                            System.out.println("Customer added from waiting list to cashier one");
                            break;
                        }
                    }
                }
                return servedburgers;
            } else if (cashiernum == 2) {
                servedburgers = queueTWO.servecustomer(burgers);
                pay[1] += servedburgers;
                if(WAitingList[0]!=null){
                    for(int  i=0; i< cashierTWO.length;i++) {
                        if(cashierTWO[i]==null) {
                            cashierTWO[i] = WAitingList[0];
                            System.out.println("Customer added from waiting list to cashier two");
                        }
                    }
                }

                return servedburgers;
            } else if (cashiernum == 3) {
                servedburgers = queueTHREE.servecustomer(burgers);
                pay[2] += servedburgers;
                if(WAitingList[0]!=null){
                    for(int  i=0; i< cashierTHREE.length;i++) {
                        if(cashierTHREE[i]==null) {
                            cashierTHREE[i] = WAitingList[0];
                            System.out.println("Customer added from waiting list to cashier three");
                        }
                    }
                }
                return servedburgers;
            } else {
                System.out.println("Invalid number .");
                return servedburgers;
            }

        }
    }

    public static void remaningburgerstock(int burgertot) {
        System.out.println(" ");
        System.out.println("Remaning burgers " + burgertot); // displaying the remaning burgers in stock

    }

    public static int Addburgerstock(int burgertot) { // a new function to add burgers to the stock
        System.out.println("");
        System.out.println("Current Amount of Burgers are " + burgertot); //displaying the current amount of burgers
            while (true) {
                try {
                    Scanner inputs = new Scanner(System.in);
                    System.out.print("Enter the amount of burgers to be added (enter 999 to exit) : ");
                    int amount = inputs.nextInt();
                    if (amount == 999) { // to exit without restocking
                        break;

                    } else {
                        System.out.println("The amount of burgers has been added.");
                        return amount;
                    }
                } catch (Exception e) { // use of try catch to avoid the error of not entering an inteager value.
                    System.out.println("Enter an Integer value");
                    return 0;

                }
            }
         return 0;
        }
    public static void customerssorted(foodque queueONE, foodque queueTWO, foodque queueTHREE ){ // a new function for sorting .
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();
        String[] name = new String[10];

        int count =0;
        for(Customer element : cashierONE){ // checking weather the element is present within  cashierone.
            if(element != null ){
                name[count]= element.getname();
            }else{
                name[count]="X";
            }
            count++;

        }
        for(Customer element : cashierTWO){// checking weather the element is present within  cashierone.
            if (element != null){
                name[count]= element.getname();
            }else{
                name[count]="X";
            }
            count++;

        }
        for (Customer element : cashierTHREE){// checking weather the element is present within  cashierone.
          if(element != null){
              name[count]=element.getname();
          } else {
              name[count]="X";
          }
            count++;
        }

        for(String element:name){
            System.out.println(element);
        }
        for(int i =0;i< name.length -1;i++){ // sorting the array alphabetical order.
            for(int j=0;j< name.length-i-1;j++){
                if(compareStrings(name[j].toUpperCase(),name[j+1].toUpperCase())>0){ // comparing the strings and swapping when necessary.
                    String temp = name[j];
                    name[j]= name[j+1];
                    name[j+1]=temp;

                }
            }
        }
        for( String element: name ){
            if(!element.equals("X")){ // as we only want the names that were entered before to be compared eleminating the "X" values
                System.out.print(element +",");
            }
        }
        System.out.println();
    }
    public static int compareStrings(String s1,String s2){ // comparing the two strings to one another.
        int minLength=Math.min(s1.length(),s2.length());
        for (int i=0;i<minLength;i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2){
                return c1 -c2;
            }
        }
        return s1.length() - s2.length();
    }
    public static void storeprogramdata( foodque queueONE, foodque queueTWO, foodque queueTHREE,int burgertot ) throws IOException{
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();
        FileWriter exitfile = new FileWriter("ClassData.txt"); // creating a file writer object to write data to a file named "Stored data.txt"
        // writing the contents of cashierone array to the file
        for ( int i=0;i<cashierONE.length;i++) {
            if (cashierONE[i] != null) {
                exitfile.write(cashierONE[i].getname() + " Burgers : " + cashierONE[i].getRequiredburgers() + ",");
            }
        }
        exitfile.write("\n");
        // writing the contents of cashiertwo array to the file
        for(int i =0;i<cashierTWO.length;i++) {
            if (cashierTWO[i] != null) {
                exitfile.write(cashierTWO[i].getname()+" Burgers : " + cashierTWO[i].getRequiredburgers() + ",");
            }
        }

        exitfile.write("\n");
        // writing the contents of cashierthree array to the file
        for(int i =0;i<cashierTHREE.length;i++) {
            if (cashierTHREE[i] != null) {
                exitfile.write(cashierTHREE[i].getname()+" Burgers : " + cashierTHREE[i].getRequiredburgers() + ",");
            }
        }
        // writing the contents of burgertot array to the file
        exitfile.write("\n"+burgertot);
        exitfile.close(); // closing file writer
        System.out.println();
        System.out.println("Data has been Sucessfully Stored in the file.");
        System.out.println();
    }
    public static int loadprogramdata(foodque queueONE, foodque queueTWO, foodque queueTHREE ,int burgertot ){
        Customer[] cashierONE = queueONE.getQueue();
        Customer[] cashierTWO = queueTWO.getQueue();
        Customer[] cashierTHREE = queueTHREE.getQueue();
        try{
            File file = new File("ClassData.txt");
            Scanner file_reader = new Scanner(file);
            String line1 = file_reader.nextLine();
            String line2 = file_reader.nextLine();
            String line3 = file_reader.nextLine();
            
            String burgers = file_reader.nextLine();
            int burger = Integer.parseInt(burgers);
            // splitting each line using a comma and storing the elements in seperate arrays
            String[] array1 = line1.split(",",0);
            String[] array2 = line2.split(",",0);
            String[] array3 = line3.split(",",0);
            // Assign the elemnts of array1 to cashierone
            for(int i=0;i<cashierONE.length && i<array1.length;i++){
                String[] customerData = array1[i].split("Burgers : ");
                if (customerData.length ==2){
                    String name = customerData[0];
                    String[] Name = name.split(" ");
                    int Burgers = Integer.parseInt(customerData[1]);
                    Customer newCustomer = new Customer(Name[0], Name[1], Burgers);
                    cashierONE[i] = newCustomer;
                }
            }
            // Assign the elemnts of array2 to cashiertwo
            for(int i=0;i<cashierTWO.length && i<array2.length;i++){
                String[] customerData = array2[i].split("Burgers : ");
                if (customerData.length ==2){
                    String name = customerData[0];
                    String[] Name = name.split(" ");
                    int Burgers = Integer.parseInt(customerData[1]);
                    Customer newCustomer = new Customer(Name[0], Name[1], Burgers);
                    cashierTWO[i] = newCustomer;
                }
            }
            // Assign the elemnts of array3 to cashierthree
            for(int i=0;i<cashierTHREE.length && i<array3.length;i++){
                String[] customerData = array3[i].split("Burgers : ");
                if (customerData.length ==2){
                    String name = customerData[0];
                    String[] Name = name.split(" ");
                    int Burgers = Integer.parseInt(customerData[1]);
                    Customer newCustomer = new Customer(Name[0], Name[1], Burgers);
                    cashierTHREE[i] = newCustomer;
                }
            }
            file_reader.close(); // closing file reader
            System.out.println("Data has been loaded sucessfully!");
            return burger;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error has occured while reading the file. ");

            return burgertot;
        }
    }
    public static void incomeofeachqueu(){
    int FirstQUEU = pay[0]*650;
    int SECONDQUEU =pay[1]*650;
    int THIRDQUEU = pay[2]*650;
        System.out.println("The amount earned by the first queue in total is : "+ FirstQUEU);
        System.out.println("The amount earned by the second queue in total is : "+ SECONDQUEU);
        System.out.println("The amount earned by the third queue in total is : "+ THIRDQUEU);
    }
    }








