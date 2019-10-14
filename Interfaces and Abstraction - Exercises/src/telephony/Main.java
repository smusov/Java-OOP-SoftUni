package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));

        List<String> numbers = Arrays.stream(read.readLine().split("\\s+")).collect(Collectors.toList());
        List<String> urls = Arrays.stream(read.readLine().split("\\s+")).collect(Collectors.toList());

        Smartphone phone = new Smartphone(numbers,urls);

        System.out.println(phone.call());
        System.out.println(phone.browse());

    }
}
