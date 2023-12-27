/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.maneuverviewtenitems.transformer;

import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.LabeledIconValue;
import generated.de.vw.mib.asl.internal.navigation.maneuverviewtenitems.ASLNavigationManeuverViewTenItemsPropertyManager;
import java.util.Arrays;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationManeuverViewDataTenItemsCollector
implements Comparable {
    public int type = 0;
    public String name = "";
    public int dtm = 0;
    public int rtth = 0;
    public int rttm = 0;
    public int numberOfPoiIcons = 0;
    public ResourceLocator[] poiIcons = null;
    public String tmcRoadName = "";
    public String tmcRoadNumber;
    public String tmcStartLocation = "";
    public String tmcEndLocation = "";
    public String tmcMessageText = "";
    public ResourceLocator tmcListIcon = ASLNavigationManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TMC_LIST_ICON__DEFAULT_VALUE;
    public long distanceToNextDestination = 0L;
    public long rtt;
    public int mainElement = 0;
    public int direction = 0;
    public String signPost = "";
    public String exitNumber = "";
    public String address = "";
    public int tmcDelay = 0;
    public int[] tollGateDirections = null;
    public int[] tollGateInfos = null;
    public int[] tollGateMarkingsLeft = null;
    public int[] tollGateMarkingsRight = null;
    public ResourceLocator colorIndicatorIcon = null;
    public ResourceLocator trafficLightIcon = null;
    public boolean trafficLightIconVisibility = false;
    public int[] laneDirections = null;
    public int[] laneInfos = null;
    public int[] laneMarkingsLeft = null;
    public int[] laneMarkingsRight = null;
    public LabeledIconValue roadSignLabeledIcon = null;
    public int tollGateCost = -1;
    public int tollGateCostCurrency = 0;
    public int length = 0;
    public ResourceLocator stopoverFlagIcon = null;
    public int destinationIndex = 0;
    public FixFormatterFieldData fixFormatterFieldForAddressData = null;
    public long messageID = 0L;
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
        stringBuffer.append(", tmcEndLocation=");
        stringBuffer.append(this.tmcEndLocation);
        stringBuffer.append(", tmcListIcon=");
        stringBuffer.append(this.tmcListIcon);
        stringBuffer.append(", tmcMessageText=");
        stringBuffer.append(this.tmcMessageText);
        stringBuffer.append(", tmcRoadName=");
        stringBuffer.append(this.tmcRoadName);
        stringBuffer.append(", tmcRoadNumber=");
        stringBuffer.append(this.tmcRoadNumber);
        stringBuffer.append(", tmcStartLocation=");
        stringBuffer.append(this.tmcStartLocation);
        stringBuffer.append(", type=");
        stringBuffer.append(this.type);
        stringBuffer.append(", exitNumber=");
        stringBuffer.append(this.exitNumber);
        stringBuffer.append(", address=");
        stringBuffer.append(this.address);
        stringBuffer.append(", tmcDelay=");
        stringBuffer.append(this.tmcDelay);
        stringBuffer.append(", trafficLightIconVisibility=");
        stringBuffer.append(this.trafficLightIconVisibility);
        stringBuffer.append(", tollGateCost=");
        stringBuffer.append(this.tollGateCost);
        stringBuffer.append(", tollGateCostCurrency=");
        stringBuffer.append(this.tollGateCostCurrency);
        stringBuffer.append(", length=");
        stringBuffer.append(this.length);
        stringBuffer.append(", destinationIndex=");
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(", messageID=");
        stringBuffer.append(this.messageID);
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
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        if (this.name == null ? navigationManeuverViewDataTenItemsCollector.name != null : !this.name.equals(navigationManeuverViewDataTenItemsCollector.name)) {
            return false;
        }
        if ((long)this.rtth != navigationManeuverViewDataTenItemsCollector.rtt) {
            return false;
        }
        return this.type == navigationManeuverViewDataTenItemsCollector.type;
    }

    @Override
    public int compareTo(Object object) {
        NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = (NavigationManeuverViewDataTenItemsCollector)object;
        if (this.dtm >= navigationManeuverViewDataTenItemsCollector.dtm) {
            return -1;
        }
        return 1;
    }
}

