/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.motorwayinfo.transformer;

import de.vw.mib.util.StringBuilder;
import java.util.Arrays;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public class NavigationMotorwayInfoDataCollector
implements Comparable {
    public String name = "";
    public int dtm = 0;
    public int rtth = 0;
    public int rttm = 0;
    public ResourceLocator[] poiIcons = null;
    public String exitNumber = "";
    public ResourceLocator exitOrSAPAIcon;
    public NavLocation navLocation = null;
    public ResourceLocator[] tmcIcons = null;
    public int[] speedFlowSegments = new int[]{0, 0, 0, 0};
    public long distance;

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (this.name == null ? 0 : this.name.hashCode());
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
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)object;
        return !(this.name == null ? navigationMotorwayInfoDataCollector.name != null : !this.name.equals(navigationMotorwayInfoDataCollector.name));
    }

    @Override
    public int compareTo(Object object) {
        NavigationMotorwayInfoDataCollector navigationMotorwayInfoDataCollector = (NavigationMotorwayInfoDataCollector)object;
        if (this.dtm >= navigationMotorwayInfoDataCollector.dtm) {
            return -1;
        }
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("NavigationMotorwayInfoDataCollector [dtm=");
        stringBuilder.append(this.dtm);
        stringBuilder.append(", distance=");
        stringBuilder.append(this.distance);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", rtth=");
        stringBuilder.append(this.rtth);
        stringBuilder.append(", rttm=");
        stringBuilder.append(this.rttm);
        stringBuilder.append(", exitNumber=");
        stringBuilder.append(this.exitNumber);
        stringBuilder.append(", segments=[");
        stringBuilder.append(this.speedFlowSegments != null ? NavigationMotorwayInfoDataCollector.asString(this.speedFlowSegments) : null);
        stringBuilder.append("], poiIcons=");
        stringBuilder.append(this.poiIcons != null ? Arrays.asList(this.poiIcons) : null);
        stringBuilder.append(", tmcIcons=");
        stringBuilder.append(this.tmcIcons != null ? Arrays.asList(this.tmcIcons) : null);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String asString(int[] nArray) {
        if (nArray == null) {
            return "null";
        }
        int n = nArray.length - 1;
        if (n == -1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (true) {
            stringBuilder.append(nArray[n2]);
            if (n2 == n) {
                return stringBuilder.toString();
            }
            stringBuilder.append(", ");
            ++n2;
        }
    }
}

