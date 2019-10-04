package hero;

public class Main {
    public static void main(String[] args) {
        BladeKnight bladeKnight = new BladeKnight("New Hero",25);

        String print = bladeKnight.toString();

        System.out.println(print);
    }
}
