import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(read.readLine());

        try {

            if (number<0){
                throw new IllegalArgumentException("Invalid number");
            }

            System.out.println(Math.sqrt(number));

        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("Good bye");
        }

    }
}
