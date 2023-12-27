/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.car.generic;

import de.vw.mib.graphics.Point;

final class GenericCarAdjusterConfigData$ButtonDefinition {
    private short id;
    private short aspectId;
    private Point imagePosition;
    private Point[] vertices;

    public GenericCarAdjusterConfigData$ButtonDefinition(short[] sArray) {
        this.setId(sArray);
        this.setAspectId(sArray);
        this.setImagePosition(sArray);
        this.setVertices(sArray);
    }

    public void setId(short[] sArray) {
        this.id = sArray[0];
    }

    public int getId() {
        return this.id;
    }

    private void setAspectId(short[] sArray) {
        if (20 < sArray.length) {
            this.aspectId = sArray[20];
        }
    }

    public short getAspectId() {
        return this.aspectId;
    }

    private void setImagePosition(short[] sArray) {
        this.imagePosition = new Point(sArray[1], sArray[2]);
    }

    public Point getImagePosition() {
        return this.imagePosition;
    }

    public void setVertices(short[] sArray) {
        short s = sArray[3];
        this.setVertices(sArray, s, 4);
    }

    public void setVertices(short[] sArray, int n, int n2) {
        this.vertices = new Point[n];
        for (int i2 = this.vertices.length - 1; i2 >= 0; --i2) {
            this.vertices[i2] = new Point(sArray[2 * i2 + n2], sArray[2 * i2 + 1 + n2]);
        }
    }

    public Point[] getVertices() {
        return this.vertices;
    }
}

