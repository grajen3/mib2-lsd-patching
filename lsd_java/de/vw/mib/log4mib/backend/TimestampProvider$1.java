/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.backend;

import de.vw.mib.log4mib.backend.TimestampProvider;

final class TimestampProvider$1
implements TimestampProvider {
    final long offset = System.currentTimeMillis();

    TimestampProvider$1() {
    }

    @Override
    public long getTimestamp() {
        return System.currentTimeMillis() - this.offset;
    }
}

