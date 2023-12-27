/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.map;

import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import org.dsi.ifc.global.NavLocation;

public class MapConfiguration {
    public static final int ENUM_HMI_GOTO_TYPE_GO_TO_TMC_MESSAGE;
    public static final int ENUM_HMI_GOTO_TYPE_SET_LOCATION;
    public static final int ENUM_HMI_GOTO_TYPE_SET_LOCATION_BY_LOCATION;
    public static final int ENUM_HMI_MAP_CATEGORY_DETAIL;
    public static final int ENUM_HMI_MAP_CATEGORY_MAIN;
    private final int flagType;
    private final int hmiGotoType;
    private final int hmiMapCategory;
    private final int locationType;
    private final NavLocation navLocation;
    private boolean poiShowCategoryIcon;
    private final short stopOverNumber;
    private final TrafficMessageDetails trafficMessageDesc;

    private MapConfiguration(int n, NavLocation navLocation, int n2, int n3, TrafficMessageDetails trafficMessageDetails, int n4, short s) {
        this.navLocation = navLocation;
        this.flagType = n2;
        this.hmiMapCategory = n3;
        this.trafficMessageDesc = trafficMessageDetails;
        this.hmiGotoType = n;
        this.locationType = n4;
        this.stopOverNumber = s;
    }

    public MapConfiguration(NavLocation navLocation, int n, int n2) {
        this(0, navLocation, n, n2, null, -1, -1);
    }

    public MapConfiguration(TrafficMessageDetails trafficMessageDetails) {
        this(2, null, 29, 0, trafficMessageDetails, -1, -1);
    }

    public int getFlagType() {
        return this.flagType;
    }

    public int getHmiGotoType() {
        return this.hmiGotoType;
    }

    public int getHmiMapCategory() {
        return this.hmiMapCategory;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public NavLocation getNavLocation() {
        return this.navLocation;
    }

    public short getStopOverNumber() {
        return this.stopOverNumber;
    }

    public TrafficMessageDetails getTmcMessage() {
        return this.trafficMessageDesc;
    }

    public boolean isPoiShowCategoryIcon() {
        return this.poiShowCategoryIcon;
    }

    public void setPoiShowCategoryIcon(boolean bl) {
        this.poiShowCategoryIcon = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MapConfiguration={").append("flagType=").append(this.flagType).append(", hmiGoToType=").append(this.hmiGotoType).append(", hmiMapCategory=").append(this.hmiMapCategory).append(", navLocation=").append(this.navLocation == null ? "null" : this.navLocation.toString()).append(", setLocationType=").append(this.locationType).append(", stopOverNumber=").append(this.stopOverNumber).append(", trafficMessageDesc=").append(this.trafficMessageDesc == null ? "null" : this.trafficMessageDesc.toString()).append("}");
        return stringBuffer.toString();
    }
}

