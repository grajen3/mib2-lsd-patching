/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLineLocationReferenceContainer;

public class sEdge {
    public long id;
    public sLineLocationReferenceContainer location;
    public sBoundingBox boundaries;
    public int[] tileIds;
    public int roadClass;

    public long getId() {
        return this.id;
    }

    public void setId(long l) {
        this.id = l;
    }

    public sLineLocationReferenceContainer getLocation() {
        return this.location;
    }

    public void setLocation(sLineLocationReferenceContainer sLineLocationReferenceContainer2) {
        this.location = sLineLocationReferenceContainer2;
    }

    public sBoundingBox getBoundaries() {
        return this.boundaries;
    }

    public void setBoundaries(sBoundingBox sBoundingBox2) {
        this.boundaries = sBoundingBox2;
    }

    public int[] getTileIds() {
        return this.tileIds;
    }

    public void setTileIds(int[] nArray) {
        this.tileIds = nArray;
    }

    public int getRoadClass() {
        return this.roadClass;
    }

    public void setRoadClass(int n) {
        this.roadClass = n;
    }

    public sEdge() {
        this.location = null;
        this.boundaries = null;
    }

    public sEdge(long l, sLineLocationReferenceContainer sLineLocationReferenceContainer2, sBoundingBox sBoundingBox2, int[] nArray, int n) {
        this.id = l;
        this.location = sLineLocationReferenceContainer2;
        this.boundaries = sBoundingBox2;
        this.tileIds = nArray;
        this.roadClass = n;
    }

    public String toString() {
        return new StringBuffer("sEdge{").append("id=").append(this.id).append(", location=").append(this.location).append(", boundaries=").append(this.boundaries).append(", tileIds=").append("[").append(this.tileIds == null ? "null" : new StringBuffer().append("size=").append(this.tileIds.length).toString()).append("]").append(", roadClass=").append(this.roadClass).append("}").toString();
    }
}

