/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageCollector;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageFormatter;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.AbstractNavigationTrafficTMCOverviewSubListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public class NavigationTrafficTMCOverviewSubListTransformer
extends AbstractNavigationTrafficTMCOverviewSubListTransformer {
    @Override
    public int getInt(int n, Object object) {
        int n2 = 0;
        if (object == null) {
            return n2;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.tmcListElement == null) {
            return n2;
        }
        return n2;
    }

    @Override
    public LabeledIconValue getLabeledIconValue(int n, Object object) {
        LabeledIconValue labeledIconValue = new LabeledIconValue("", new ResourceLocator(), new TextRenderingInfo());
        if (object == null) {
            return labeledIconValue;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.tmcListElement == null || trafficMessageCollector.tmcListElement.message == null) {
            return labeledIconValue;
        }
        if (trafficMessageCollector.trafficMessageIcon == null || trafficMessageCollector.trafficMessageIcon.roadIconDescriptor == null) {
            return labeledIconValue;
        }
        switch (n) {
            case 6: {
                labeledIconValue.setText(trafficMessageCollector.tmcListElement.message.roadNumber);
                labeledIconValue.setResourceLocator(trafficMessageCollector.trafficMessageIcon.roadIconDescriptor.getResourceLocator());
                labeledIconValue.setTextRenderingInfo(trafficMessageCollector.trafficMessageIcon.roadIconDescriptor.getTextRenderingInfo());
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return labeledIconValue;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = new ResourceLocator();
        if (object == null) {
            return resourceLocator;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.trafficMessageIcon == null || trafficMessageCollector.trafficMessageIcon.iconDescriptor == null) {
            return resourceLocator;
        }
        switch (n) {
            case 5: {
                resourceLocator = trafficMessageCollector.trafficMessageIcon.iconDescriptor.getResourceLocator();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return resourceLocator;
    }

    @Override
    public String getString(int n, Object object) {
        String string = "";
        if (object == null) {
            return string;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.tmcListElement == null || trafficMessageCollector.tmcListElement.message == null) {
            return string;
        }
        switch (n) {
            case 0: {
                if (trafficMessageCollector.tmcListElement.message.getEventText() == null || trafficMessageCollector.tmcListElement.message.getEventText().length <= 0) break;
                string = trafficMessageCollector.tmcListElement.message.getEventText()[0];
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        if (string == null) {
            return "";
        }
        return string;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector == null || trafficMessageCollector.tmcListElement == null || trafficMessageCollector.tmcListElement.message == null) {
            return null;
        }
        FixFormatterFieldData fixFormatterFieldData = null;
        switch (n) {
            case 10: {
                fixFormatterFieldData = TrafficMessageFormatter.prepareFixFormatterListData(trafficMessageCollector.tmcListElement.message);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return fixFormatterFieldData;
    }
}

