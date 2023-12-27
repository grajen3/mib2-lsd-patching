/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.navigation.AdditionalTurnListIcon;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.PriceInfo;

public class TurnListElement {
    public long distance;
    public long eta;
    public long etaWithTimeDelay;
    public ManeuverElement[] maneuver;
    public String street;
    public String turnToStreet;
    public String streetIconText;
    public int streetIconId;
    public String exitNumber;
    public String signPostInfo;
    public int exitIconId;
    public String countryAbbreviation;
    public int type;
    public AdditionalTurnListIcon[] additionalIcons;
    public NavLaneGuidanceData[] laneGuidance;
    public int destinationIndex;
    public PriceInfo tollcost;
    public long length;
    public String streetCardinalDirection;

    public TurnListElement() {
        this.distance = 0L;
        this.eta = 0L;
        this.etaWithTimeDelay = 0L;
        this.maneuver = null;
        this.street = null;
        this.turnToStreet = null;
        this.streetIconText = null;
        this.streetIconId = 0;
        this.exitNumber = null;
        this.signPostInfo = null;
        this.exitIconId = 0;
        this.countryAbbreviation = "";
        this.type = 0;
        this.additionalIcons = null;
        this.laneGuidance = null;
        this.destinationIndex = 0;
        this.tollcost = null;
        this.length = 0L;
        this.streetCardinalDirection = null;
    }

    public TurnListElement(long l, long l2, long l3, ManeuverElement[] maneuverElementArray, String string, String string2, String string3, int n, String string4, String string5, int n2, String string6, int n3, AdditionalTurnListIcon[] additionalTurnListIconArray, NavLaneGuidanceData[] navLaneGuidanceDataArray, int n4, PriceInfo priceInfo, long l4, String string7) {
        this.distance = l;
        this.eta = l2;
        this.etaWithTimeDelay = l3;
        this.maneuver = maneuverElementArray;
        this.street = string;
        this.turnToStreet = string2;
        this.streetIconText = string3;
        this.streetIconId = n;
        this.exitNumber = string4;
        this.signPostInfo = string5;
        this.exitIconId = n2;
        this.countryAbbreviation = string6;
        this.type = n3;
        this.additionalIcons = additionalTurnListIconArray;
        this.laneGuidance = navLaneGuidanceDataArray;
        this.destinationIndex = n4;
        this.tollcost = priceInfo;
        this.length = l4;
        this.streetCardinalDirection = string7;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getEta() {
        return this.eta;
    }

    public long getEtaWithTimeDelay() {
        return this.etaWithTimeDelay;
    }

    public ManeuverElement[] getManeuver() {
        return this.maneuver;
    }

    public String getStreet() {
        return this.street;
    }

    public String getTurnToStreet() {
        return this.turnToStreet;
    }

    public String getStreetIconText() {
        return this.streetIconText;
    }

    public int getStreetIconId() {
        return this.streetIconId;
    }

    public String getExitNumber() {
        return this.exitNumber;
    }

    public String getSignPostInfo() {
        return this.signPostInfo;
    }

    public int getExitIconId() {
        return this.exitIconId;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public int getType() {
        return this.type;
    }

    public AdditionalTurnListIcon[] getAdditionalIcons() {
        return this.additionalIcons;
    }

    public NavLaneGuidanceData[] getLaneGuidance() {
        return this.laneGuidance;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public PriceInfo getTollcost() {
        return this.tollcost;
    }

    public long getLength() {
        return this.length;
    }

    public String getStreetCardinalDirection() {
        return this.streetCardinalDirection;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(2300);
        stringBuffer.append("TurnListElement");
        stringBuffer.append('(');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("eta");
        stringBuffer.append('=');
        stringBuffer.append(this.eta);
        stringBuffer.append(',');
        stringBuffer.append("etaWithTimeDelay");
        stringBuffer.append('=');
        stringBuffer.append(this.etaWithTimeDelay);
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
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("turnToStreet");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.turnToStreet);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconText");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetIconText);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("streetIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.streetIconId);
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
        stringBuffer.append("exitIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.exitIconId);
        stringBuffer.append(',');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("additionalIcons");
        stringBuffer.append('[');
        if (this.additionalIcons != null) {
            stringBuffer.append(this.additionalIcons.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.additionalIcons != null) {
            n3 = this.additionalIcons.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.additionalIcons[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.additionalIcons);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("laneGuidance");
        stringBuffer.append('[');
        if (this.laneGuidance != null) {
            stringBuffer.append(this.laneGuidance.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.laneGuidance != null) {
            n3 = this.laneGuidance.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.laneGuidance[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.laneGuidance);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(',');
        stringBuffer.append("tollcost");
        stringBuffer.append('=');
        stringBuffer.append(this.tollcost);
        stringBuffer.append(',');
        stringBuffer.append("length");
        stringBuffer.append('=');
        stringBuffer.append(this.length);
        stringBuffer.append(',');
        stringBuffer.append("streetCardinalDirection");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetCardinalDirection);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

