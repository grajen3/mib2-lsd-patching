/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.backend;

import de.vw.mib.log4mib.backend.TimestampProvider$1;

public interface TimestampProvider {
    public static final TimestampProvider DEFAULT = new TimestampProvider$1();

    default public long getTimestamp() {
    }
}

