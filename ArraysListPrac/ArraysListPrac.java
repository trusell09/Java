import java.util.ArrayList;
import java.util.Arrays;

public class ArraysListPrac {
    public static void main(String[] args){
        
        System.out.println("Hello, Arrays Lists!");

        // initialize an arraylist with values
        //ArrayList <String> names = new ArrayList<String>(Arrays.asList("Mark", "Willie"));
        
        
        // initialize an empty arraylist with no values BELOW
        ArrayList <String> names = new ArrayList<String>();
        names.add("Murph");
        names.add("Henryson");
        // names.remove(0);  would remove Murph from the list of names when printed 
        // names.set(0, "New Name");  Sets the new value as "New Name" or whatever value given


        System.out.println(names);
        System.out.println(names.get(0));
        
        
        // looping through the length of Arraylist 
        // below will Loop through Murph and Henryson names
        for (int i = 0; i<names.size(); i++){
            System.out.println("Looping . I is -->" + i);
            System.out.println(names.get(i)); //same saying [i] in JavaScript or Python
        }
    
        //enhanced for loop is when we dont need the index numbers, just the values at the index numbers
        //dont use enhanced for loop when you need to know the index numbers
        for(String name : names){
            System.out.println(name);
        }



    }
}
