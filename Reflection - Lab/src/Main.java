import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

        Class ref = Reflection.class;

        System.out.println(ref);

        Class superClass = Reflection.class.getSuperclass();

        System.out.println(superClass);

        Class[] interfaces = ref.getInterfaces();

        Arrays.stream(interfaces).forEach(System.out::println);

        Object reflection = ref.getDeclaredConstructor().newInstance();

        System.out.println(reflection);

    }
}
