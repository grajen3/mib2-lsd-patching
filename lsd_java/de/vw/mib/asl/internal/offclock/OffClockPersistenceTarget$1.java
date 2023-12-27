/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.offclock;

import de.vw.mib.asl.internal.offclock.OffClockPersistenceTarget;
import de.vw.mib.configuration.NvListener;

class OffClockPersistenceTarget$1
implements NvListener {
    private final /* synthetic */ OffClockPersistenceTarget this$0;

    OffClockPersistenceTarget$1(OffClockPersistenceTarget offClockPersistenceTarget) {
        this.this$0 = offClockPersistenceTarget;
    }

    @Override
    public void notifyNvListener(int n) {
        if (n == 5) {
            this.this$0.writePersistedClockLayoutToAslApi();
        }
    }
}

