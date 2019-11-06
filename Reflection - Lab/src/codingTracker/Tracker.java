package codingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    private static void printMethodsByAuthor(Class cl) {
        Method[] declaredMethods = cl.getDeclaredMethods();

        Map<String, List<String>> methodsByAuthor = new HashMap<>();

        for (Method method : declaredMethods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {

                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");

            }
        }
        methodsByAuthor.forEach((key, value) ->
                System.out.println(String.format("%s: %s",key,value.toString().replaceAll("[\\[\\],]",""))));
    }
}
