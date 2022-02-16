import java.util.ArrayList;
import java.util.Arrays;

public class ArraysListPrac {
    public static void main(String[] args){
        
        System.out.println("Hello, Arrays Lists!");

        // initialize an arraylist with values
        ArrayList <String> names = new ArrayList<String>(Arrays.asList("Mark", "Willie"));
        
        
        // initialize an empty arraylist with no values BELOW
        //ArrayList <String> names = new ArrayList<String>();
        //names.add("Murph");
        //names.add("Henryson");
        // names.remove(0);  would remove Murph from the list of names when printed 
        // names.set(0, "New Name");  Sets the new value as "New Name" or whatever value given
        
        System.out.println(names);
        System.out.println(names.get(0));
        
    
    
    }
}
