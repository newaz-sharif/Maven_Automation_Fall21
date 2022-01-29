package Action_Items;

public class AI_2_Grades {
    public static void main(String[] args) {
        //enter the grade of the student
        int grade = 90;

        //decide the letter grade of the student based off of numerical value entered
        if (grade >= 90 && grade <= 100){
            System.out.println("The grade is A");
        } else if (grade >= 80 && grade <= 89){
            System.out.println("The grade is B");
        } else if (grade >= 70 && grade <= 79) {
            System.out.println("The grade is C");
        } else if (grade >= 60 && grade <= 69) {
            System.out.println("The grade is D");
        } else if (grade >= 0 && grade <= 59) {
            System.out.println("The grade is F");
        } else
            System.out.println("Invalid number. Please enter another value.");
    }//end of main method
}//end of public class
