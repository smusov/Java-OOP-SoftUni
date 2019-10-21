package word;

import java.util.List;

public class MoreCommands extends CommandImpl {
    public MoreCommands(StringBuilder text) {
        super(text);
        super.initCommands();
    }

    @Override
    protected List<Command> initCommands() {

        List<Command> commands = super.initCommands();

        CutTransform cutTransform = new CutTransform();

        commands.add(new Command("cut", cutTransform));
        commands.add(new Command("paste", new PasteTransform(cutTransform)));
        return commands;
    }
}
