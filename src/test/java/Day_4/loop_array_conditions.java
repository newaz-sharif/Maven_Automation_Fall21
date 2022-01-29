package Day_4;

public class loop_array_conditions {
    public static void main(String[] args) {

        //dynamic array for list of cities
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";

        int i = 0;
        while(i <cities.length) {
            //two if conditions
            //when you are not sure if the value is in upper case , lower case or mixed case
            if (cities[i] == "Brooklyn") {
                System.out.println("City is " + cities[i]);
            } else if (cities[i] == "Queens") {
                System.out.println("City is " + cities[i]);
            }//end of conditions
            i++;
        }//end of while loop

        /*
        //this example provides the option to change the values from cities to either uppercase or lowercase to match the "equals"
        int i = 0;
        while(i <cities.length) {
            //two if conditions
            //when you are not sure if the value is in upper case , lower case or mixed case
            if (cities[i].toLowerCase().equals("brooklyn")) {
                System.out.println("City is " + cities[i]);
            } else if (cities[i].toUpperCase().equals("QUEENS")) {
                System.out.println("City is " + cities[i]);
            }//end of conditions
            i++;
        }//end of while loop
         */



    }//end of main method
}//end of class
