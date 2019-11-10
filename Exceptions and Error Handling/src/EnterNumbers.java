import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        try {
            int start = Integer.parseInt(read.readLine());
            int end = Integer.parseInt(read.readLine());

            printNumbers(start,end);

        }catch (NumberFormatException ex){

            System.out.println(ex);

        }catch (IllegalArgumentException ex){

            System.out.println(ex.getMessage());
            System.out.println("Try again!");

            printNumbers(Integer.parseInt(read.readLine()),Integer.parseInt(read.readLine()));
        }

    }

    private static void printNumbers (int start,int end){
        if (start<1){
            throw new IllegalArgumentException(String.format("%d is not valid number of start!",start));
        }
        if (end>100){
            throw new IllegalArgumentException(String.format("%d is not valid number of end!",end));
        }
        for (int i = start; i <=end; i++) {
            System.out.println(i);
        }
    }
}
