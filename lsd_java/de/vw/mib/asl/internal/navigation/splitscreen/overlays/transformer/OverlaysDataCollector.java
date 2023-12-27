/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays.transformer;

import generated.de.vw.mib.asl.internal.navigation.maneuverviewtenitems.ASLNavigationManeuverViewTenItemsPropertyManager;
import org.dsi.ifc.global.ResourceLocator;

public class OverlaysDataCollector
implements Comparable {
    public int type;
    public String name;
    public long distanceToNextDestination;
    public long rtt;
    public int dtm;
    public int rtth;
    public int rttm;
    public ResourceLocator colorIndicatorIcon;
    public boolean trafficLightIconVisibility;
    public int mainElement;
    public int direction;
    public String signPost;
    public String exitNumber;
    public int[] laneDirections;
    public int[] laneInfos;
    public int[] laneMarkingsLeft;
    public int[] laneMarkingsRight;
    public int numberOfLanes;
    public boolean laneGuidanceAvailableOverlays = false;
    public ResourceLocator headlineIcon;
    private static OverlaysDataCollector instance = new OverlaysDataCollector();

    public static OverlaysDataCollector getInstance() {
        return instance;
    }

    public void resetOverlaysDataCollector() {
        this.type = 0;
        this.name = "";
        this.dtm = 0;
        this.rtth = 0;
        this.rttm = 0;
        this.distanceToNextDestination = 0L;
        this.rtt = 0L;
        this.colorIndicatorIcon = ASLNavigationManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_COLOR_INDICATOR_ICON__DEFAULT_VALUE;
        this.trafficLightIconVisibility = false;
        this.mainElement = 0;
        this.direction = 0;
        this.signPost = "";
        this.exitNumber = "";
        this.laneDirections = new int[0];
        this.laneInfos = new int[0];
        this.laneMarkingsLeft = new int[0];
        this.laneMarkingsRight = new int[0];
        this.numberOfLanes = 0;
        this.laneGuidanceAvailableOverlays = false;
        this.headlineIcon = ASLNavigationManeuverViewTenItemsPropertyManager.MANEUVER_VIEW_DATA__MANEUVER_VIEW_DATA_TRAFFIC_LIGHT_ICON__DEFAULT_VALUE;
    }

    @Override
    public int compareTo(Object object) {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("OverlaysDataCollector [type: ");
        stringBuffer.append(this.type);
        stringBuffer.append(", name: ");
        stringBuffer.append(this.name);
        stringBuffer.append(", distanceToNextDestination: ");
        stringBuffer.append(this.distanceToNextDestination);
        stringBuffer.append(", rtt: ");
        stringBuffer.append(this.rtt);
        stringBuffer.append(", dtm: ");
        stringBuffer.append(this.dtm);
        stringBuffer.append(", rtth: ");
        stringBuffer.append(this.rtth);
        stringBuffer.append(", rttm: ");
        stringBuffer.append(this.rttm);
        stringBuffer.append(", colorIndicatorIcon: ");
        stringBuffer.append(this.colorIndicatorIcon);
        stringBuffer.append(", trafficLightIconVisibility: ");
        stringBuffer.append(this.trafficLightIconVisibility);
        stringBuffer.append(", headlineIcon: ");
        stringBuffer.append(this.headlineIcon);
        stringBuffer.append(", mainElement: ");
        stringBuffer.append(this.mainElement);
        stringBuffer.append(", direction: ");
        stringBuffer.append(this.direction);
        stringBuffer.append(", signPost: ");
        stringBuffer.append(this.signPost);
        stringBuffer.append(", exitNumber: ");
        stringBuffer.append(this.exitNumber);
        stringBuffer.append(", laneDirections: ");
        stringBuffer.append(this.laneDirections);
        stringBuffer.append(", laneInfos: ");
        stringBuffer.append(this.laneInfos);
        stringBuffer.append(", laneMarkingsLeft: ");
        stringBuffer.append(this.laneMarkingsLeft);
        stringBuffer.append(", laneMarkingsRight");
        stringBuffer.append(this.laneMarkingsRight);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

