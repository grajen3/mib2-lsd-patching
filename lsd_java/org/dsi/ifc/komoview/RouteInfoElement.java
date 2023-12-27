/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.komoview.TrafficInfo;

public class RouteInfoElement {
    public String distanceToElement;
    public String estimatedTimeToElement;
    public int routeInfoElementType;
    public int[] elementIconIDs;
    public String prio1EventText;
    public String streetIconText;
    public int streetIconID;
    public String exitNumber;
    public String turnToStreet;
    public String[] pOIElementNames;
    public ManeuverElement[] maneuverDescriptor;
    public TrafficInfo trafficInfo;
    public int destinationIndex;
    public String signPostInfo;
    public String distanceToManeuver;
    public String estimatedTimeToManeuver;
    public String streetCardinalDirection;
    public int exitIconId;

    public RouteInfoElement() {
        this.distanceToElement = null;
        this.estimatedTimeToElement = null;
        this.routeInfoElementType = 0;
        this.elementIconIDs = null;
        this.prio1EventText = null;
        this.streetIconText = null;
        this.streetIconID = 0;
        this.exitNumber = null;
        this.turnToStreet = null;
        this.pOIElementNames = null;
        this.maneuverDescriptor = null;
        this.trafficInfo = null;
        this.destinationIndex = 0;
        this.signPostInfo = null;
        this.distanceToManeuver = null;
        this.estimatedTimeToManeuver = null;
        this.streetCardinalDirection = null;
        this.exitIconId = 0;
    }

    public RouteInfoElement(String string, String string2, int n, int[] nArray, String string3, String string4, int n2, String string5, String string6, String[] stringArray, ManeuverElement[] maneuverElementArray, TrafficInfo trafficInfo, int n3, String string7, String string8, String string9, String string10, int n4) {
        this.distanceToElement = string;
        this.estimatedTimeToElement = string2;
        this.routeInfoElementType = n;
        this.elementIconIDs = nArray;
        this.prio1EventText = string3;
        this.streetIconText = string4;
        this.streetIconID = n2;
        this.exitNumber = string5;
        this.turnToStreet = string6;
        this.pOIElementNames = stringArray;
        this.maneuverDescriptor = maneuverElementArray;
        this.trafficInfo = trafficInfo;
        this.destinationIndex = n3;
        this.signPostInfo = string7;
        this.distanceToManeuver = string8;
        this.estimatedTimeToManeuver = string9;
        this.streetCardinalDirection = string10;
        this.exitIconId = n4;
    }

    public String getDistanceToElement() {
        return this.distanceToElement;
    }

    public String getEstimatedTimeToElement() {
        return this.estimatedTimeToElement;
    }

    public int getRouteInfoElementType() {
        return this.routeInfoElementType;
    }

    public int[] getElementIconIDs() {
        return this.elementIconIDs;
    }

    public String getPrio1EventText() {
        return this.prio1EventText;
    }

    public String getStreetIconText() {
        return this.streetIconText;
    }

    public int getStreetIconID() {
        return this.streetIconID;
    }

    public String getExitNumber() {
        return this.exitNumber;
    }

    public String getTurnToStreet() {
        return this.turnToStreet;
    }

    public String[] getPOIElementNames() {
        return this.pOIElementNames;
    }

    public ManeuverElement[] getManeuverDescriptor() {
        return this.maneuverDescriptor;
    }

    public TrafficInfo getTrafficInfo() {
        return this.trafficInfo;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public String getSignPostInfo() {
        return this.signPostInfo;
    }

    public String getDistanceToManeuver() {
        return this.distanceToManeuver;
    }

    public String getEstimatedTimeToManeuver() {
        return this.estimatedTimeToManeuver;
    }

    public int getExitIconId() {
        return this.exitIconId;
    }

    public String getStreetCardinalDirection() {
        return this.streetCardinalDirection;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(2400);
        stringBuffer.append("RouteInfoElement");
        stringBuffer.append('(');
        stringBuffer.append("distanceToElement");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.distanceToElement);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("estimatedTimeToElement");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.estimatedTimeToElement);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("routeInfoElementType");
        stringBuffer.append('=');
        stringBuffer.append(this.routeInfoElementType);
        stringBuffer.append(',');
        stringBuffer.append("elementIconIDs");
        stringBuffer.append('[');
        if (this.elementIconIDs != null) {
            stringBuffer.append(this.elementIconIDs.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.elementIconIDs != null) {
            n3 = this.elementIconIDs.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.elementIconIDs[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.elementIconIDs);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("prio1EventText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.prio1EventText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetIconText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconID");
        stringBuffer.append('=');
        stringBuffer.append(this.streetIconID);
        stringBuffer.append(',');
        stringBuffer.append("exitNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exitNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("turnToStreet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.turnToStreet);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("pOIElementNames");
        stringBuffer.append('[');
        if (this.pOIElementNames != null) {
            stringBuffer.append(this.pOIElementNames.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.pOIElementNames != null) {
            n3 = this.pOIElementNames.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.pOIElementNames[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.pOIElementNames);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("maneuverDescriptor");
        stringBuffer.append('[');
        if (this.maneuverDescriptor != null) {
            stringBuffer.append(this.maneuverDescriptor.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.maneuverDescriptor != null) {
            n3 = this.maneuverDescriptor.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.maneuverDescriptor[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.maneuverDescriptor);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("trafficInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficInfo);
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(',');
        stringBuffer.append("signPostInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.signPostInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("distanceToManeuver");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.distanceToManeuver);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("estimatedTimeToManeuver");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.estimatedTimeToManeuver);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetCardinalDirection");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetCardinalDirection);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exitIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.exitIconId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

