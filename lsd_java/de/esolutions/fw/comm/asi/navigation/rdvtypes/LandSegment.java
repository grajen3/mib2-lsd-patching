/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.BlankZoneInfo;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RangeZoneInfo;
import java.util.Arrays;

public class LandSegment {
    public RangeZoneInfo[] rangePolygons;
    public BlankZoneInfo[] blankPolygons;

    public RangeZoneInfo[] getRangePolygons() {
        return this.rangePolygons;
    }

    public void setRangePolygons(RangeZoneInfo[] rangeZoneInfoArray) {
        this.rangePolygons = rangeZoneInfoArray;
    }

    public BlankZoneInfo[] getBlankPolygons() {
        return this.blankPolygons;
    }

    public void setBlankPolygons(BlankZoneInfo[] blankZoneInfoArray) {
        this.blankPolygons = blankZoneInfoArray;
    }

    public LandSegment() {
        this.rangePolygons = null;
        this.blankPolygons = null;
    }

    public LandSegment(RangeZoneInfo[] rangeZoneInfoArray, BlankZoneInfo[] blankZoneInfoArray) {
        this.rangePolygons = rangeZoneInfoArray;
        this.blankPolygons = blankZoneInfoArray;
    }

    public String toString() {
        return new StringBuffer("LandSegment{").append("rangePolygons=").append("[").append(this.rangePolygons == null ? "null" : Arrays.asList(this.rangePolygons).toString()).append("]").append(", blankPolygons=").append("[").append(this.blankPolygons == null ? "null" : Arrays.asList(this.blankPolygons).toString()).append("]").append("}").toString();
    }
}

