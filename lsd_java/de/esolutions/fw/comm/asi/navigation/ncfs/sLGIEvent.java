/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLocationContainer;

public class sLGIEvent {
    public long id;
    public short version;
    public sBoundingBox boundaries;
    public sLocationContainer location;
    public int startAt;
    public int endAt;
    public int eventType;
    public int eventQuality;
    public int[] tileIds;
    public byte minRoadclass;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public short getVersion() {
        return this.version;
    }

    public void setVersion(short s) {
        this.version = s;
    }

    public sBoundingBox getBoundaries() {
        return this.boundaries;
    }

    public void setBoundaries(sBoundingBox sBoundingBox2) {
        this.boundaries = sBoundingBox2;
    }

    public sLocationContainer getLocation() {
        return this.location;
    }

    public void setLocation(sLocationContainer sLocationContainer2) {
        this.location = sLocationContainer2;
    }

    public int getStartAt() {
        return this.startAt;
    }

    public void setStartAt(int n) {
        this.startAt = n;
    }

    public int getEndAt() {
        return this.endAt;
    }

    public void setEndAt(int n) {
        this.endAt = n;
    }

    public int getEventType() {
        return this.eventType;
    }

    public void setEventType(int n) {
        this.eventType = n;
    }

    public int getEventQuality() {
        return this.eventQuality;
    }

    public void setEventQuality(int n) {
        this.eventQuality = n;
    }

    public int[] getTileIds() {
        return this.tileIds;
    }

    public void setTileIds(int[] nArray) {
        this.tileIds = nArray;
    }

    public byte getMinRoadclass() {
        return this.minRoadclass;
    }

    public void setMinRoadclass(byte by) {
        this.minRoadclass = by;
    }

    public sLGIEvent() {
        this.boundaries = null;
        this.location = null;
    }

    public sLGIEvent(long l, short s, sBoundingBox sBoundingBox2, sLocationContainer sLocationContainer2, int n, int n2, int n3, int n4, int[] nArray, byte by) {
        this.id = l;
        this.version = s;
        this.boundaries = sBoundingBox2;
        this.location = sLocationContainer2;
        this.startAt = n;
        this.endAt = n2;
        this.eventType = n3;
        this.eventQuality = n4;
        this.tileIds = nArray;
        this.minRoadclass = by;
    }

    public String toString() {
        return new StringBuffer("sLGIEvent{").append("id=").append(this.id).append(", version=").append(this.version).append(", boundaries=").append(this.boundaries).append(", location=").append(this.location).append(", startAt=").append(this.startAt).append(", endAt=").append(this.endAt).append(", eventType=").append(this.eventType).append(", eventQuality=").append(this.eventQuality).append(", tileIds=").append("[").append(this.tileIds == null ? "null" : new StringBuffer().append("size=").append(this.tileIds.length).toString()).append("]").append(", minRoadclass=").append(this.minRoadclass).append("}").toString();
    }
}

