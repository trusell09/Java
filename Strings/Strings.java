public class Strings {
    public static void main(String[] args){
        System.out.println("Hello Strings!");
        
        String coolQuote = "It is not the Mountains ahead the will wear you out, it is the pebble in your shoe - ";

        String author = "Muhammad Ali";

        String result = coolQuote.concat(author);

        System.out.println(result);
    
        Integer wherePebbleAt = coolQuote.indexOf("pebble");
        System.out.println(wherePebbleAt);
    
    
        String a = new String("same letters");
        String b = new String("same letters");

        System.out.println(a.equals(b)); //  prints true. same exact charcters

        generateFullName("Trey", "Russell");
        generateFullName("Joe", "Johnson", "Jackson");

    }

    // creating a method
    // String.indexOf(String str) : int
    
    // Python Syntax for methods:
    // def generatefullName(strInput):
    //      pass
    // translation of Python to Java below


    // method overlaoding is when there are multiple methods that are the same in their return tupe and name but dffer in their parameters
    // method signature for this generateFullname is: public static void generateFullName(String firstName, String lastName)
    public static void generateFullName(String firstName, String lastName){
        System.out.println(firstName + " " + lastName);
        System.out.println(String.format("Hello, %s %s", firstName, lastName));
        // generateFullName above in main 
    }
    
        // method signature for this generateFullname is: public static void generateFullName(String firstName, String middleName, String lastName)

    public static void generateFullName(String firstName, String middleName, String lastName){
        System.out.println(firstName + " " + middleName + " " + lastName);
        System.out.println(String.format("Hello, %s %s %s", firstName, middleName, lastName));
        // generateFullName above in main 
    }

}