/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioData;

public final class DabViewMode {
    public void notifyHMI() {
        GuiApiDab.updateViewMode(this.get());
    }

    public void set(int n) {
        RadioData.getDabDatabase().mPersistable.setViewMode(n);
        this.notifyHMI();
    }

    public void notifyFriends() {
        this.notifyHMI();
    }

    public int get() {
        return RadioData.getDabDatabase().mPersistable.getViewMode();
    }

    public void reset() {
        RadioData.getDabDatabase().mPersistable.setViewMode(0);
    }
}

