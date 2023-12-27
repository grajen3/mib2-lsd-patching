/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavRouteListDataIcon;

public class CombinedRouteListElement {
    public long uid;
    public long parent;
    public int[] type;
    public long startDistance;
    public long endDistance;
    public long startTime;
    public long endTime;
    public String description;
    public String roadNumber;
    public String streetIconText;
    public String exitNumber;
    public String signPostInfo;
    public NavRouteListDataIcon[] icons;
    public long startDistanceTraffic;
    public long endDistanceTraffic;
    public ManeuverElement[] maneuver;
    public boolean blocked;
    public int destinationIndex;
    public boolean hasChildren;
    public String countryAbbreviation;

    public CombinedRouteListElement() {
        this.uid = 0L;
        this.parent = -1L;
        this.type = null;
        this.startDistance = 0L;
        this.endDistance = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.description = null;
        this.roadNumber = null;
        this.streetIconText = null;
        this.exitNumber = null;
        this.signPostInfo = null;
        this.icons = null;
        this.startDistanceTraffic = 0L;
        this.endDistanceTraffic = 0L;
        this.maneuver = null;
        this.blocked = false;
        this.destinationIndex = -1;
        this.hasChildren = false;
        this.countryAbbreviation = null;
    }

    public CombinedRouteListElement(long l, long l2, int[] nArray, long l3, long l4, long l5, long l6, String string, String string2, String string3, String string4, String string5, NavRouteListDataIcon[] navRouteListDataIconArray, long l7, long l8, ManeuverElement[] maneuverElementArray, boolean bl, int n, boolean bl2, String string6) {
        this.uid = l;
        this.parent = l2;
        this.type = nArray;
        this.startDistance = l3;
        this.endDistance = l4;
        this.startTime = l5;
        this.endTime = l6;
        this.description = string;
        this.roadNumber = string2;
        this.streetIconText = string3;
        this.exitNumber = string4;
        this.signPostInfo = string5;
        this.icons = navRouteListDataIconArray;
        this.startDistanceTraffic = l7;
        this.endDistanceTraffic = l8;
        this.maneuver = maneuverElementArray;
        this.blocked = bl;
        this.destinationIndex = n;
        this.hasChildren = bl2;
        this.countryAbbreviation = string6;
    }

    public long getUid() {
        return this.uid;
    }

    public long getParent() {
        return this.parent;
    }

    public int[] getType() {
        return this.type;
    }

    public long getStartDistance() {
        return this.startDistance;
    }

    public long getEndDistance() {
        return this.endDistance;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getDescription() {
        return this.description;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public String getStreetIconText() {
        return this.streetIconText;
    }

    public String getExitNumber() {
        return this.exitNumber;
    }

    public String getSignPostInfo() {
        return this.signPostInfo;
    }

    public NavRouteListDataIcon[] getIcons() {
        return this.icons;
    }

    public long getStartDistanceTraffic() {
        return this.startDistanceTraffic;
    }

    public long getEndDistanceTraffic() {
        return this.endDistanceTraffic;
    }

    public ManeuverElement[] getManeuver() {
        return this.maneuver;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public boolean isHasChildren() {
        return this.hasChildren;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public void setUid(long l) {
        this.uid = l;
    }

    public void setParent(long l) {
        this.parent = l;
    }

    public void setType(int[] nArray) {
        this.type = nArray;
    }

    public void setStartDistance(long l) {
        this.startDistance = l;
    }

    public void setEndDistance(long l) {
        this.endDistance = l;
    }

    public void setStartTime(long l) {
        this.startTime = l;
    }

    public void setEndTime(long l) {
        this.endTime = l;
    }

    public void setDescription(String string) {
        this.description = string;
    }

    public void setRoadNumber(String string) {
        this.roadNumber = string;
    }

    public void setStreetIconText(String string) {
        this.streetIconText = string;
    }

    public void setExitNumber(String string) {
        this.exitNumber = string;
    }

    public void setIcons(NavRouteListDataIcon[] navRouteListDataIconArray) {
        this.icons = navRouteListDataIconArray;
    }

    public void setStartDistanceTraffic(long l) {
        this.startDistanceTraffic = l;
    }

    public void setEndDistanceTraffic(long l) {
        this.endDistanceTraffic = l;
    }

    public void setManeuver(ManeuverElement[] maneuverElementArray) {
        this.maneuver = maneuverElementArray;
    }

    public void setBlocked(boolean bl) {
        this.blocked = bl;
    }

    public void setDestinationIndex(int n) {
        this.destinationIndex = n;
    }

    public void setHasChildren(boolean bl) {
        this.hasChildren = bl;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("CombinedRouteListElement");
        stringBuffer.append('(');
        stringBuffer.append("uid");
        stringBuffer.append('=');
        stringBuffer.append(this.uid);
        stringBuffer.append(',');
        stringBuffer.append("parent");
        stringBuffer.append('=');
        stringBuffer.append(this.parent);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('[');
        if (this.type != null) {
            stringBuffer.append(this.type.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.type != null) {
            n3 = this.type.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.type[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.type);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("startDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.startDistance);
        stringBuffer.append(',');
        stringBuffer.append("endDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.endDistance);
        stringBuffer.append(',');
        stringBuffer.append("startTime");
        stringBuffer.append('=');
        stringBuffer.append(this.startTime);
        stringBuffer.append(',');
        stringBuffer.append("endTime");
        stringBuffer.append('=');
        stringBuffer.append(this.endTime);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetIconText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exitNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exitNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("signPostInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.signPostInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("icons");
        stringBuffer.append('[');
        if (this.icons != null) {
            stringBuffer.append(this.icons.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.icons != null) {
            n3 = this.icons.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.icons[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.icons);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("startDistanceTraffic");
        stringBuffer.append('=');
        stringBuffer.append(this.startDistanceTraffic);
        stringBuffer.append(',');
        stringBuffer.append("endDistanceTraffic");
        stringBuffer.append('=');
        stringBuffer.append(this.endDistanceTraffic);
        stringBuffer.append(',');
        stringBuffer.append("maneuver");
        stringBuffer.append('[');
        if (this.maneuver != null) {
            stringBuffer.append(this.maneuver.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.maneuver != null) {
            n3 = this.maneuver.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.maneuver[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.maneuver);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("blocked");
        stringBuffer.append('=');
        stringBuffer.append(this.blocked);
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(',');
        stringBuffer.append("hasChildren");
        stringBuffer.append('=');
        stringBuffer.append(this.hasChildren);
        stringBuffer.append(',');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

