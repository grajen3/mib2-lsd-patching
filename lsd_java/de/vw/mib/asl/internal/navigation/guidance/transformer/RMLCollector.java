/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.transformer;

import de.vw.mib.properties.values.LabeledIconValue;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class RMLCollector {
    public long myRouteListItemtId = 0L;
    public int myRouteListMnDTM = 0;
    public int myRouteListMnETAH = 0;
    public int myRouteListMnETAM = 0;
    public int myRouteListMnETAD = 0;
    public int routeListMnRttH = 0;
    public int routeListMnRttM = 0;
    public int myRouteListMnId = 0;
    public String myRouteListMnName = "";
    public boolean hasSubItems = false;
    public boolean isCongestionSelected = false;
    public boolean isBlockingSelected = false;
    public int myDistanceInMeterToDestination = 0;
    public int myTimeInMsToDestination = 0;
    public int myAbsIndex = 0;
    public int[] type = new int[]{0};
    public int typeForModel = 1;
    public int listMnStopoverNumber = 0;
    public ResourceLocator myIcon = new ResourceLocator();
    public String myTurnToStreet = "";
    public String myCurrentStreet = "";
    public long parent = -1L;
    public int iconType = -1;
    public int startDistance = 0;
    public int endDistance = 0;
    public String streetIconText = "";
    public LabeledIconValue labeledIconValue = new LabeledIconValue("", new ResourceLocator(), new TextRenderingInfo());

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("RMLCollector [isBlockingSelected=");
        stringBuffer.append(this.isBlockingSelected);
        stringBuffer.append(", isCongestionSelected=");
        stringBuffer.append(this.isCongestionSelected);
        stringBuffer.append(", hasSubItems=");
        stringBuffer.append(this.hasSubItems);
        stringBuffer.append(", myAbsIndex=");
        stringBuffer.append(this.myAbsIndex);
        stringBuffer.append(", myCurrentStreet=");
        stringBuffer.append(this.myCurrentStreet);
        stringBuffer.append(", myDistanceInMeterToDestination=");
        stringBuffer.append(this.myDistanceInMeterToDestination);
        stringBuffer.append(", myIcon=");
        stringBuffer.append(this.myIcon);
        stringBuffer.append(", myRouteLisItemtId=");
        stringBuffer.append(this.myRouteListItemtId);
        stringBuffer.append(", myRouteListMnDTM=");
        stringBuffer.append(this.myRouteListMnDTM);
        stringBuffer.append(", myRouteListMnETAD=");
        stringBuffer.append(this.myRouteListMnETAD);
        stringBuffer.append(", myRouteListMnETAH=");
        stringBuffer.append(this.myRouteListMnETAH);
        stringBuffer.append(", myRouteListMnETAM=");
        stringBuffer.append(this.myRouteListMnETAM);
        stringBuffer.append(", myRouteListMnRttH=");
        stringBuffer.append(this.routeListMnRttH);
        stringBuffer.append(", myRouteListMnRttM=");
        stringBuffer.append(this.routeListMnRttM);
        stringBuffer.append(", myRouteListMnId=");
        stringBuffer.append(this.myRouteListMnId);
        stringBuffer.append(", myRouteListMnName=");
        stringBuffer.append(this.myRouteListMnName);
        stringBuffer.append(", myTimeInMsToDestination=");
        stringBuffer.append(this.myTimeInMsToDestination);
        stringBuffer.append(", myTurnToStreet=");
        stringBuffer.append(this.myTurnToStreet);
        stringBuffer.append(", parent=");
        stringBuffer.append(this.parent);
        stringBuffer.append(", streetIconText=");
        stringBuffer.append(this.streetIconText);
        stringBuffer.append(", type=");
        stringBuffer.append(this.type != null ? this.arrayToString(this.type, this.type.length) : null);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (!(object instanceof int[])) continue;
            stringBuffer.append(((int[])object)[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public boolean hasParent() {
        return this.parent != -1L;
    }
}

