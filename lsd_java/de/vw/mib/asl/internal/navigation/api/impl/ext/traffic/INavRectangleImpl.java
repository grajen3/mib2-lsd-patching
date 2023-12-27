/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.traffic;

import de.vw.mib.asl.api.navigation.traffic.INavRectangle;

public class INavRectangleImpl
implements INavRectangle {
    private int xLeft;
    private int xRight;
    private int yBottom;
    private int yUp;
    private boolean rectangleInvalid;

    public INavRectangleImpl(int n, int n2, int n3, int n4) {
        this.setxLeft(n);
        this.setxRight(n2);
        this.setyBottom(n3);
        this.setyUp(n4);
    }

    public INavRectangleImpl(int n, int n2, int n3, int n4, boolean bl) {
        this.setxLeft(n);
        this.setxRight(n2);
        this.setyBottom(n3);
        this.setyUp(n4);
        this.setRectangleInvalid(bl);
    }

    @Override
    public int getxLeft() {
        return this.xLeft;
    }

    private void setxLeft(int n) {
        this.xLeft = n;
    }

    @Override
    public int getxRight() {
        return this.xRight;
    }

    private void setxRight(int n) {
        this.xRight = n;
    }

    @Override
    public int getyBottom() {
        return this.yBottom;
    }

    private void setyBottom(int n) {
        this.yBottom = n;
    }

    @Override
    public int getyUp() {
        return this.yUp;
    }

    private void setyUp(int n) {
        this.yUp = n;
    }

    @Override
    public boolean isRectangleInvalid() {
        return this.rectangleInvalid;
    }

    private void setRectangleInvalid(boolean bl) {
        this.rectangleInvalid = bl;
    }
}

