/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint.internal;

import de.vw.mib.repaint.Paintable;
import de.vw.mib.repaint.RepaintManager;

public class RepaintManagerStub
implements RepaintManager {
    @Override
    public void enableRepaints() {
    }

    @Override
    public void disableRepaints() {
    }

    @Override
    public void repaint() {
    }

    @Override
    public void registerRepaintHandler(Paintable paintable) {
    }

    @Override
    public void unregisterRepaintHandler(Paintable paintable) {
    }

    @Override
    public int getRefreshInterval() {
        return 1;
    }

    @Override
    public int getRefreshFrequency() {
        return 1;
    }

    @Override
    public void setRefreshFrequency(int n) {
    }

    @Override
    public boolean isRepaintAlwaysEnabled() {
        return false;
    }
}

