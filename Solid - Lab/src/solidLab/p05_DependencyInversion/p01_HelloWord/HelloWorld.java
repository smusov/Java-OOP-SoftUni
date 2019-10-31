package solidLab.p05_DependencyInversion.p01_HelloWord;

public class HelloWorld {

    public String greeting(String name, int hours) {

        if (hours < 12) {
            return "Good morning, " + name;
        }

        if (hours < 18) {
            return "Good afternoon, " + name;
        }

        return "Good evening, " + name;

    }
}
