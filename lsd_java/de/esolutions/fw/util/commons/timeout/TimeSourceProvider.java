/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.SystemTimeSource;

public class TimeSourceProvider {
    private static ITimeSource monotonicTimeSource;

    public static synchronized void setMonotonicTimeSource(ITimeSource iTimeSource) {
        monotonicTimeSource = iTimeSource;
    }

    public static synchronized ITimeSource getMonotonicTimeSource() {
        if (monotonicTimeSource == null) {
            monotonicTimeSource = new SystemTimeSource();
        }
        return monotonicTimeSource;
    }
}

