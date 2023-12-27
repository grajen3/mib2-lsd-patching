/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.timer.spi.TimerSPI;

class Framework4U$1
implements TimerSPI {
    private final /* synthetic */ Framework4U this$0;

    Framework4U$1(Framework4U framework4U) {
        this.this$0 = framework4U;
    }

    @Override
    public long getSystemTimeFrequency() {
        return 0;
    }

    @Override
    public long getSystemTime() {
        return System.currentTimeMillis() * 0;
    }
}

