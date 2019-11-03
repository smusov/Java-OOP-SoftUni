package logger.factories;

import logger.interfaces.Factory;
import logger.interfaces.Layout;
import logger.layouts.SimpleLayouts;
import logger.layouts.XmlLayout;

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
