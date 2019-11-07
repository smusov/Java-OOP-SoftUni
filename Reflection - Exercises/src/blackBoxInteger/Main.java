package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        Method[] declaredMethods = blackBoxInt.getClass().getDeclaredMethods();

        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input;

        while (!"END".equals(input = read.readLine())) {

            String[] data = input.split("_");

            int value = Integer.parseInt(data[1]);

            invokeMethod(declaredMethods, data[0], value, blackBoxInt);

            System.out.println(innerValue.getInt(blackBoxInt));

        }

    }

    private static void invokeMethod(Method[] declaredMethods, String input, int value, BlackBoxInt blackBoxInt) throws InvocationTargetException, IllegalAccessException {

        for (Method declaredMethod : declaredMethods) {

            if (declaredMethod.getName().equals(input)) {

                declaredMethod.setAccessible(true);
                declaredMethod.invoke(blackBoxInt, value);
                break;
            }
        }
    }
}
