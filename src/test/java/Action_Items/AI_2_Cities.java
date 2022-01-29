package Action_Items;

public class AI_2_Cities {
    public static void main(String[] args) {

        //dynamic array for list of cities
        String [] cities = new String[5];

        cities[0] = "New York";
        cities[1] = "California";
        cities[2] = "Ohio";
        cities[3] = "New Jersey";
        cities[4] = "Florida";

        int i = 0;
        while (i < cities.length){
            if (cities[i] == "New York"){
                System.out.println("The city is " + cities[i]);
            } else if (cities[i] == "California"){
                System.out.println("The city is " + cities[i]);
            }
            //iterate through the array list
            i++;
        }//end of while loop


    }//end of main method
}//end of public class
