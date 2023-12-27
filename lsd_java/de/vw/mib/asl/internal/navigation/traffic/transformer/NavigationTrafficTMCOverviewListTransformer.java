/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic.transformer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageCollector;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageFormatter;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.AbstractNavigationTrafficTMCOverviewListTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.tmc.TmcListElement;

public class NavigationTrafficTMCOverviewListTransformer
extends AbstractNavigationTrafficTMCOverviewListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl = false;
        if (null == object) {
            return bl;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.tmcListElement == null) {
            return bl;
        }
        switch (n) {
            case 1: {
                bl = trafficMessageCollector.tmcListElement.isHasChild();
                break;
            }
            case 11: {
                bl = this.hasFolderOnRouteItems(trafficMessageCollector);
                break;
            }
            case 14: {
                bl = this.isTmcItemOnRoute(trafficMessageCollector.tmcListElement);
                break;
            }
            case 15: {
                bl = this.isTmcItemAreaMessage(trafficMessageCollector);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return bl;
    }

    private boolean isTmcItemAreaMessage(TrafficMessageCollector trafficMessageCollector) {
        return this.isCollectorOrListElementOrMessageNotNull(trafficMessageCollector) && trafficMessageCollector.tmcListElement.getMessage().isArea;
    }

    private boolean isCollectorOrListElementOrMessageNotNull(TrafficMessageCollector trafficMessageCollector) {
        return trafficMessageCollector != null && trafficMessageCollector.tmcListElement != null && trafficMessageCollector.tmcListElement.getMessage() != null;
    }

    private boolean isTmcItemOnRoute(TmcListElement tmcListElement) {
        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            return true;
        }
        if (tmcListElement.message == null) {
            return true;
        }
        return tmcListElement.message.routeRelevance == 0;
    }

    @Override
    public int getInt(int n, Object object) {
        int n2 = -1;
        if (object == null) {
            return n2;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.tmcListElement == null) {
            return n2;
        }
        switch (n) {
            case 0: {
                n2 = trafficMessageCollector.tmcListElement.getNumberOfMessagesInNode();
                break;
            }
            case 99: {
                n2 = (int)trafficMessageCollector.tmcListElement.getUID();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
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
        if (trafficMessageCollector.tmcListElement == null) {
            return labeledIconValue;
        }
        if (trafficMessageCollector.trafficMessageIcon == null) {
            return labeledIconValue;
        }
        switch (n) {
            case 8: {
                if (trafficMessageCollector.tmcListElement.hasChild) {
                    labeledIconValue.setText(trafficMessageCollector.tmcListElement.roadNumber);
                } else {
                    labeledIconValue.setText(trafficMessageCollector.tmcListElement.message.roadNumber);
                }
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
    public long getLong(int n, Object object) {
        long l = -1L;
        if (null == object) {
            return l;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.tmcListElement == null) {
            return l;
        }
        switch (n) {
            case 99: {
                l = trafficMessageCollector.tmcListElement.getUID();
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return l;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ResourceLocator resourceLocator = new ResourceLocator();
        if (null == object) {
            return resourceLocator;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector.trafficMessageIcon == null || trafficMessageCollector.trafficMessageIcon.iconDescriptor == null) {
            return resourceLocator;
        }
        switch (n) {
            case 7: {
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
        if (trafficMessageCollector.tmcListElement == null) {
            return string;
        }
        if (trafficMessageCollector.tmcListElement.hasChild) {
            switch (n) {
                case 4: {
                    string = trafficMessageCollector.tmcListElement.roadName;
                    break;
                }
            }
        }
        if (trafficMessageCollector.tmcListElement.message == null) {
            return string;
        }
        switch (n) {
            case 2: {
                if (trafficMessageCollector.tmcListElement.message.getEventText() == null || trafficMessageCollector.tmcListElement.message.getEventText().length <= 0) break;
                string = trafficMessageCollector.tmcListElement.message.getEventText()[0];
                break;
            }
            case 4: {
                string = trafficMessageCollector.tmcListElement.message.getRoadName();
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

    private boolean hasFolderOnRouteItems(TrafficMessageCollector trafficMessageCollector) {
        return !ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive();
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        FixFormatterFieldData fixFormatterFieldData;
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)object;
        if (trafficMessageCollector == null || trafficMessageCollector.tmcListElement == null || trafficMessageCollector.tmcListElement.message == null) {
            return null;
        }
        switch (n) {
            case 13: {
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

