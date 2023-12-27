/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes;

import java.util.Arrays;
import org.dsi.ifc.global.NavLocationWgs84;

public class RdvPointList {
    public NavLocationWgs84[] points;

    public NavLocationWgs84[] getPoints() {
        return this.points;
    }

    public void setPoints(NavLocationWgs84[] navLocationWgs84Array) {
        this.points = navLocationWgs84Array;
    }

    public RdvPointList() {
        this.points = null;
    }

    public RdvPointList(NavLocationWgs84[] navLocationWgs84Array) {
        this.points = navLocationWgs84Array;
    }

    public String toString() {
        return new StringBuffer("RdvPointList{").append("points=").append("[").append(this.points == null ? "null" : Arrays.asList(this.points).toString()).append("]").append("}").toString();
    }
}

