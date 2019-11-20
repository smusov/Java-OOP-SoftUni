package core.engines;

import core.databases.DumpHardwareDatabaseImpl;
import core.databases.interfaces.DumpHardwareDatabase;
import io.ConsoleReader;
import io.ConsoleWriter;

public class Engine {
    
    private ConsoleReader consoleReader;
    private DumpHardwareDatabase database;

    public Engine() {
        
        this.consoleReader = new ConsoleReader();
        this.database = new DumpHardwareDatabaseImpl();
        
    }
    
    public void run(){

        Controller controller = new Controller(this.database);
        
        while(true){

            String input = consoleReader.readLine();

            String message = controller.executeCommand(input);

            if (!message.equals("")){
                ConsoleWriter.write(message);
            }
            if (input.equals("System Split")){
                break;
            }
        }
        
    }
}
