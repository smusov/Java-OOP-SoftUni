import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        for (int i = 1; i <=n; i++) {
            StringBuilder builder = new StringBuilder();

            appendSpaces(n, i, builder);
            appendStars(i, builder);

            System.out.println(builder.toString());
        }

        for (int i = n-1; i >=1; i--) {
            StringBuilder builder = new StringBuilder();

            appendSpaces(n,i,builder);
            appendStars(i, builder);

            System.out.println(builder.toString());
        }
    }

    private static void appendStars(int i, StringBuilder builder) {
        for (int j = 1; j <= i; j++) {
            builder.append("* ");
        }
    }

    private static void appendSpaces(int n, int i, StringBuilder builder) {
        for (int j = n - i; j > 0; j--) {
            builder.append(" ");
        }
    }
}
