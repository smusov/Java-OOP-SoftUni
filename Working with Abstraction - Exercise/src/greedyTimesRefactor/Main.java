
package greedyTimesRefactor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bagSize = Long.parseLong(scanner.nextLine());

        String[] safe = scanner.nextLine().split("\\s+");

        Bag bag = new Bag(bagSize);

        for (int i = 0; i < safe.length; i += 2) {

            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            if (bag.getSize() <= bag.getCapacity() + count) {
                continue;
            }

            if (name.length() == 3) {
                bag.addCash(name, count);
            } else if (name.toLowerCase().endsWith("gem")) {
                bag.addGem(name, count);
            } else if (name.toLowerCase().equals("gold")) {
                bag.addGold(count);
            }

        }
        System.out.println(bag.toString().trim());
    }
}