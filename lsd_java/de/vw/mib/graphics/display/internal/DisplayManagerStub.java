/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.display.internal.AbstractDisplayManager;
import de.vw.mib.graphics.image.BufferImage;

public class DisplayManagerStub
extends AbstractDisplayManager {
    @Override
    public IntSet getActiveDisplayables(int n) {
        return null;
    }

    @Override
    public void updateDisplay(int n) {
    }

    @Override
    public void enableDisplayable(int n, int n2) {
    }

    @Override
    public void disableDisplayable(int n, int n2) {
    }

    @Override
    public Dimension getDisplayableExtents(int n, int n2) {
        return null;
    }

    public void setDisplayablePosition(int n, int n2, int n3, int n4) {
    }

    public void setDisplayableDimension(int n, int n2, int n3, int n4) {
    }

    public void setDisplayableScalemode(int n, int n2, int n3) {
    }

    public void setDisplayableCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    @Override
    public void setDisplayable(int n, int n2, Rectangle rectangle, Rectangle rectangle2) {
    }

    @Override
    public void setDisplayableAlpha(int n, int n2, int n3) {
    }

    @Override
    public Object getNativeDisplayableHandle(int n, int n2) {
        return null;
    }

    @Override
    public BufferImage getDisplayableContent(int n, int n2) {
        return null;
    }

    @Override
    public BufferImage getDisplayableContent(int n, int n2, int n3, int n4, int n5, int n6) {
        return null;
    }

    @Override
    public BufferImage getDisplayContent(int n) {
        return null;
    }

    @Override
    public void releaseContent(BufferImage bufferImage) {
    }

    @Override
    public boolean isGetDisplayableContentSupported(int n) {
        return false;
    }
}

