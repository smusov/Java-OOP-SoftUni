package interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Engine {
    public void run(String stopCommand, BufferedReader reader) throws IOException;
}
