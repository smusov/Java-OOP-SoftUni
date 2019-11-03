package factories;

import interfaces.Factory;
import interfaces.Layout;
import layouts.SimpleLayouts;
import layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String produceData) {

        Layout layout;

        if (produceData.equals("SimpleLayout")) {
            layout = new SimpleLayouts();
        } else {
            layout = new XmlLayout();
        }
        return layout;
    }
}
