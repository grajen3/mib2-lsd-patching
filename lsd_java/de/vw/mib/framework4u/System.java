/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.framework4u;

import de.vw.mib.timer.spi.TimerSPI;
import java.lang.reflect.Array;

public final class System {
    private static final double MICRO;
    private static final double MILLI;
    private final double cycleFactor_micros;
    private final double cycleFactor_millis;
    private final TimerSPI timerSpi;

    System(TimerSPI timerSPI) {
        this.timerSpi = timerSPI;
        long l = timerSPI.getSystemTimeFrequency();
        this.cycleFactor_micros = 1000000.0 / (double)l;
        this.cycleFactor_millis = 1000.0 / (double)l;
    }

    public long currentTimeMicros() {
        return (long)((double)this.timerSpi.getSystemTime() * this.cycleFactor_micros);
    }

    public long currentTimeMillis() {
        return (long)((double)this.timerSpi.getSystemTime() * this.cycleFactor_millis);
    }

    public void arraycopy(Object object, int n, Object object2, int n2, int n3) {
        java.lang.System.arraycopy(object, n, object2, n2, n3);
    }

    public void arraycopy(Object object, Object object2) {
        java.lang.System.arraycopy(object, 0, object2, 0, Array.getLength(object2));
    }
}

