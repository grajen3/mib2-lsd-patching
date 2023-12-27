/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRectangleSetReference;

public class sLocationContainer {
    public int validLocationType;
    public sEdge edgeLocation;
    public sRectangleSetReference rectangleSetLocation;

    public int getValidLocationType() {
        return this.validLocationType;
    }

    public void setValidLocationType(int n) {
        this.validLocationType = n;
    }

    public sEdge getEdgeLocation() {
        return this.edgeLocation;
    }

    public void setEdgeLocation(sEdge sEdge2) {
        this.edgeLocation = sEdge2;
    }

    public sRectangleSetReference getRectangleSetLocation() {
        return this.rectangleSetLocation;
    }

    public void setRectangleSetLocation(sRectangleSetReference sRectangleSetReference2) {
        this.rectangleSetLocation = sRectangleSetReference2;
    }

    public sLocationContainer() {
        this.edgeLocation = null;
        this.rectangleSetLocation = null;
    }

    public sLocationContainer(int n, sEdge sEdge2, sRectangleSetReference sRectangleSetReference2) {
        this.validLocationType = n;
        this.edgeLocation = sEdge2;
        this.rectangleSetLocation = sRectangleSetReference2;
    }

    public String toString() {
        return new StringBuffer("sLocationContainer{").append("validLocationType=").append(this.validLocationType).append(", edgeLocation=").append(this.edgeLocation).append(", rectangleSetLocation=").append(this.rectangleSetLocation).append("}").toString();
    }
}

