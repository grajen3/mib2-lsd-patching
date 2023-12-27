/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class SystemTimeSource
implements ITimeSource {
    @Override
    public final long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public final String toString() {
        return "SystemTimeSource";
    }
}

