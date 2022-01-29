package Action_Items;

public class AI_1_for_loop {
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

        for (int i = 0; i <= 3; i++){
            for (int j = 0; j <= 3; j++){
                System.out.println("My zipcode is " + zipCode[i] + " and my street number is " + streetNumber[j] );

            }//end of inner for loop
        }//end of outer for loop
    }//end of psvm
}//end of class
