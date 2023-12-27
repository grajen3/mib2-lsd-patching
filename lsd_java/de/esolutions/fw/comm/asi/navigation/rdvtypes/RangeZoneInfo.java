/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvPointList;
import java.util.Arrays;

public class RangeZoneInfo {
    public int zoneID;
    public RdvPointList[] safetyZones;

    public int getZoneID() {
        return this.zoneID;
    }

    public void setZoneID(int n) {
        this.zoneID = n;
    }

    public RdvPointList[] getSafetyZones() {
        return this.safetyZones;
    }

    public void setSafetyZones(RdvPointList[] rdvPointListArray) {
        this.safetyZones = rdvPointListArray;
    }

    public RangeZoneInfo() {
        this.safetyZones = null;
    }

    public RangeZoneInfo(int n, RdvPointList[] rdvPointListArray) {
        this.zoneID = n;
        this.safetyZones = rdvPointListArray;
    }

    public String toString() {
        return new StringBuffer("RangeZoneInfo{").append("zoneID=").append(this.zoneID).append(", safetyZones=").append("[").append(this.safetyZones == null ? "null" : Arrays.asList(this.safetyZones).toString()).append("]").append("}").toString();
    }
}

