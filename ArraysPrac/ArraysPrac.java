import java.util.Arrays;

public class ArraysPrac {
    public static void main(String[] args){
        System.out.println("Hello Arrays!");

        // initialize an array for storing primitive ints only
        //int[] nums = {11,4,9,151};

        int[] nums = new int[5]; // this is saying "create an integer array called nums which will have 5 values it can fill"
        // [0,0,0,0,0] is the default value for above int[]
        nums [3] = 780;
        System.out.println(Arrays.toString(nums));


    }
}
