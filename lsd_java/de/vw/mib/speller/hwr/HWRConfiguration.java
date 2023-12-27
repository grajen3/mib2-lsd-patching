/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.hwr;

public class HWRConfiguration
implements Cloneable {
    private int mode;
    private int touchAreaX;
    private int touchAreaY;
    private int touchAreaW;
    private int touchAreaH;

    public Object clone() {
        return super.clone();
    }

    public int getMode() {
        return this.mode;
    }

    public int getTouchAreaX() {
        return this.touchAreaX;
    }

    public int getTouchAreaY() {
        return this.touchAreaY;
    }

    public int getTouchAreaW() {
        return this.touchAreaW;
    }

    public int getTouchAreaH() {
        return this.touchAreaH;
    }

    public void setMode(int n) {
        this.mode = n;
    }

    public void setTouchAreaX(int n) {
        this.touchAreaX = n;
    }

    public void setTouchAreaY(int n) {
        this.touchAreaY = n;
    }

    public void setTouchAreaW(int n) {
        this.touchAreaW = n;
    }

    public void setTouchAreaH(int n) {
        this.touchAreaH = n;
    }
}

