/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.ss.transformer;

import generated.de.vw.mib.asl.internal.navigation.map.ss.ASLNavigationMapSSPropertyManager;
import java.util.Arrays;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class ManeuverViewDataCollector
implements Comparable {
    public int type = 0;
    public String name = "";
    public int dtm = 0;
    public int rtth = 0;
    public int rttm = 0;
    public int symbolId = 0;
    public int numberOfPoiIcons = 0;
    public ResourceLocator[] poiIcons = null;
    public String tmcRoadName = "";
    public String tmcStartLocation = "";
    public String tmcEndLocation = "";
    public String tmcMessageText = "";
    public ResourceLocator tmcListIcon = ASLNavigationMapSSPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TMC_LIST_ICON__DEFAULT_VALUE;
    public long distanceToNextDestination = 0L;
    public long rtt;
    public int mainElement = 0;
    public int direction = 0;
    public String signPost = "";
    public int destinationIndex;
    public long tmcMessageID = 0L;
    public NavLocation poiNavLocation = null;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ManeuverViewDataCollector [distanceToNextDestination=");
        stringBuffer.append(this.distanceToNextDestination);
        stringBuffer.append(", dtm=");
        stringBuffer.append(this.dtm);
        stringBuffer.append(", name=");
        stringBuffer.append(this.name);
        stringBuffer.append(", numberOfPoiIcons=");
        stringBuffer.append(this.numberOfPoiIcons);
        stringBuffer.append(", poiIcons=");
        stringBuffer.append(this.poiIcons != null ? Arrays.asList(this.poiIcons) : null);
        stringBuffer.append(", rtt=");
        stringBuffer.append(this.rtt);
        stringBuffer.append(", rtth=");
        stringBuffer.append(this.rtth);
        stringBuffer.append(", rttm=");
        stringBuffer.append(this.rttm);
        stringBuffer.append(", symbolId=");
        stringBuffer.append(this.symbolId);
        stringBuffer.append(", tmcEndLocation=");
        stringBuffer.append(this.tmcEndLocation);
        stringBuffer.append(", tmcListIcon=");
        stringBuffer.append(this.tmcListIcon);
        stringBuffer.append(", tmcMessageText=");
        stringBuffer.append(this.tmcMessageText);
        stringBuffer.append(", tmcRoadName=");
        stringBuffer.append(this.tmcRoadName);
        stringBuffer.append(", tmcStartLocation=");
        stringBuffer.append(this.tmcStartLocation);
        stringBuffer.append(", type=");
        stringBuffer.append(this.type);
        stringBuffer.append(", messageID=");
        stringBuffer.append(this.tmcMessageID);
        stringBuffer.append(", poiNavLocation=");
        stringBuffer.append(this.poiNavLocation);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.name == null ? 0 : this.name.hashCode());
        n2 = 31 * n2 + (int)this.rtt;
        n2 = 31 * n2 + this.type;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)object;
        if (this.type != maneuverViewDataCollector.type) {
            return false;
        }
        return this.type == 1 && this.name.equals(maneuverViewDataCollector.name) && this.rtt == maneuverViewDataCollector.rtt;
    }

    @Override
    public int compareTo(Object object) {
        ManeuverViewDataCollector maneuverViewDataCollector = (ManeuverViewDataCollector)object;
        if (this.dtm < maneuverViewDataCollector.dtm) {
            return -1;
        }
        if (this.dtm == maneuverViewDataCollector.dtm) {
            if (this.name == null) {
                return -1;
            }
            if (maneuverViewDataCollector.name == null) {
                return 1;
            }
            if (this.name.compareTo(maneuverViewDataCollector.name) < 0) {
                return -1;
            }
            return 1;
        }
        return 1;
    }
}

