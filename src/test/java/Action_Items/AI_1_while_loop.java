package Action_Items;

public class AI_1_while_loop {
    public static void main(String[] args) {

        //dynamic array with string data
        String[] zipCode = new String[4]; //defining and setting boundaries for string values

        zipCode[0] = "12345";
        zipCode[1] = "54321";
        zipCode[2] = "13524";
        zipCode[3] = "53142";

        String[] streetNumber = new String[4];

        streetNumber[0] = "1738";
        streetNumber[1] = "1652";
        streetNumber[2] = "2906";
        streetNumber[3] = "4211";

        //First initialize the starting point before while loop
        int i = 0;

        //define the while loop with your end point execution
        while(i < zipCode.length){
            int j = 0;
            while(j < streetNumber.length){

                System.out.println("My zipcode is " + zipCode[i] + " and my street number is " + streetNumber[j] );

                j = j+1;
            }//end of inner while loop

            i = i+1;
        }//end of outer while loop

    }//end of psvm
}//end of class
