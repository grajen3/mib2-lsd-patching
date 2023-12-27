/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.display.DisplayManager;
import de.vw.mib.graphics.display.DisplayPerformanceMetrics;
import de.vw.mib.graphics.image.BufferImage;

public abstract class AbstractDisplayManager
implements DisplayManager {
    private final DisplayPerformanceMetrics performanceMetrics = new DisplayPerformanceMetrics();

    @Override
    public void dispose() {
    }

    @Override
    public final DisplayPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public abstract void updateDisplay(int n) {
    }

    @Override
    public abstract void enableDisplayable(int n, int n2) {
    }

    @Override
    public abstract void disableDisplayable(int n, int n2) {
    }

    @Override
    public abstract Dimension getDisplayableExtents(int n, int n2) {
    }

    @Override
    public abstract void setDisplayable(int n, int n2, Rectangle rectangle, Rectangle rectangle2) {
    }

    @Override
    public abstract void setDisplayableAlpha(int n, int n2, int n3) {
    }

    @Override
    public abstract Object getNativeDisplayableHandle(int n, int n2) {
    }

    @Override
    public abstract BufferImage getDisplayableContent(int n, int n2) {
    }

    @Override
    public abstract BufferImage getDisplayableContent(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    @Override
    public abstract BufferImage getDisplayContent(int n) {
    }

    @Override
    public abstract void releaseContent(BufferImage bufferImage) {
    }

    @Override
    public abstract boolean isGetDisplayableContentSupported(int n) {
    }
}

