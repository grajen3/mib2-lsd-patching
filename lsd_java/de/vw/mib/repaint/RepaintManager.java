/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint;

import de.vw.mib.repaint.Paintable;

public interface RepaintManager {
    default public void enableRepaints() {
    }

    default public void disableRepaints() {
    }

    default public void repaint() {
    }

    default public void registerRepaintHandler(Paintable paintable) {
    }

    default public void unregisterRepaintHandler(Paintable paintable) {
    }

    default public int getRefreshInterval() {
    }

    default public int getRefreshFrequency() {
    }

    default public void setRefreshFrequency(int n) {
    }

    default public boolean isRepaintAlwaysEnabled() {
    }
}

