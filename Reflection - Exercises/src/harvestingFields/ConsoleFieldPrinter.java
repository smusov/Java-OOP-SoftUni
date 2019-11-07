package harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ConsoleFieldPrinter {

    public static void printFieldsByGivenModifier(String accessModifier, Class clazz) {
        Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> Modifier.toString(field.getModifiers()).equals(accessModifier))
                .forEach(field ->
                        System.out.println(Modifier.toString(
                                field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName()));
    }

    public static void printAllFields(Class clazz) {
        Arrays.stream(clazz.getDeclaredFields()).forEach(field ->
                System.out.println(Modifier.toString(
                        field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName()));
    }
}
