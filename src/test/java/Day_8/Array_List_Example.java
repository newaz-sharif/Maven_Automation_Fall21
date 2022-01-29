package Day_8;

import java.util.ArrayList;

public class Array_List_Example {
    public static void main(String[] args) {

        //Arraylist is a resizable array which means you don't need to add the length to add more array values
        //ArrayList example with string
        ArrayList<String> Countries = new ArrayList<>();

        Countries.add("USA");
        Countries.add("China");
        Countries.add("Canada");
        Countries.add("Mexico");

        //shortcut for System.out.println is sout
        System.out.println("My country is " + Countries.get(2));

        //ArrayList example with int
        ArrayList<Integer> HouseNumber = new ArrayList<>();

        HouseNumber.add(111);
        HouseNumber.add(222);
        HouseNumber.add(333);
        HouseNumber.add(444);

        System.out.println("My house number is " + HouseNumber.get(3));

    }//end of main method
}//end of class
