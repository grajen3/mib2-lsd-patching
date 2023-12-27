/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.asl.ASLDisplayManagerTarget;
import de.vw.mib.graphics.Dimension;

public class ASLDisplayManagerTargetDelegate
implements ASLDisplayManagerTarget {
    private ASLDisplayManagerTarget delegate;

    @Override
    public void setOpacity(int n, int n2, int n3) {
        this.deleagate().setOpacity(n, n2, n3);
    }

    @Override
    public Dimension getExtents(int n) {
        return this.deleagate().getExtents(n);
    }

    @Override
    public void setPosition(int n, int n2, int n3, int n4) {
        this.deleagate().setPosition(n, n2, n3, n4);
    }

    @Override
    public void beginDisplayContextSwitch(int n) {
        this.deleagate().beginDisplayContextSwitch(n);
    }

    @Override
    public void endDisplayContextSwitch(int n) {
        this.deleagate().endDisplayContextSwitch(n);
    }

    @Override
    public void enableDisplayable(int n, int n2) {
        this.deleagate().enableDisplayable(n, n2);
    }

    @Override
    public void disableDisplayable(int n, int n2) {
        this.deleagate().disableDisplayable(n, n2);
    }

    @Override
    public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.deleagate().setCropping(n, n2, n3, n4, n5, n6, n7, n8, n9, n10);
    }

    @Override
    public void setDimension(int n, int n2, int n3, int n4) {
        this.deleagate().setDimension(n, n2, n3, n4);
    }

    @Override
    public void setScaleMode(int n, int n2, int n3) {
        this.deleagate().setScaleMode(n, n2, n3);
    }

    public void set(ASLDisplayManagerTarget aSLDisplayManagerTarget) {
        this.delegate = aSLDisplayManagerTarget;
    }

    private ASLDisplayManagerTarget deleagate() {
        if (this.delegate == null) {
            throw new IllegalStateException("ASLDisplayManagerTarget is not available!");
        }
        return this.delegate;
    }
}

