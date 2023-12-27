/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvPointList;

public class BlankZoneInfo {
    public RdvPointList blankZone;

    public RdvPointList getBlankZone() {
        return this.blankZone;
    }

    public void setBlankZone(RdvPointList rdvPointList) {
        this.blankZone = rdvPointList;
    }

    public BlankZoneInfo() {
        this.blankZone = null;
    }

    public BlankZoneInfo(RdvPointList rdvPointList) {
        this.blankZone = rdvPointList;
    }

    public String toString() {
        return new StringBuffer("BlankZoneInfo{").append("blankZone=").append(this.blankZone).append("}").toString();
    }
}

