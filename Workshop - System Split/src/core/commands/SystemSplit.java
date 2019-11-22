package core.commands;

import java.util.List;

public class SystemSplit extends CommandImpl {
    @Override
    public String execute(List<String> args) {
        return getSystemSplit();
    }

    private String getSystemSplit(){
        StringBuilder sb = new StringBuilder();
        super.database.getHardwares().values().forEach(e->sb.append(e.toString()));
        return sb.toString();
    }

}
