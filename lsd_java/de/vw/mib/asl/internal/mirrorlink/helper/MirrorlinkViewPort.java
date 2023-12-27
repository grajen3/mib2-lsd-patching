/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.helper;

public class MirrorlinkViewPort {
    private int width = 0;
    private int height = 0;
    private int x = 0;
    private int y = 0;
    private boolean position = false;
    private boolean dimension = false;

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setDimension(int n, int n2) {
        this.width = n;
        this.height = n2;
        this.dimension = true;
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }

    public void setPosition(int n, int n2) {
        this.x = n;
        this.y = n2;
        this.position = true;
    }

    public boolean isValid() {
        return this.position && this.dimension;
    }

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.x = 0;
        this.y = 0;
        this.position = false;
        this.dimension = false;
    }
}

