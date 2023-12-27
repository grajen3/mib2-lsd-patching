/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.logger;

import de.vw.mib.bap.array.asg.ASGArrayList;

public interface Logger {
    public static final int LOG_LEVEL_FATAL;
    public static final int LOG_LEVEL_ERROR;
    public static final int LOG_LEVEL_WARN;
    public static final int LOG_LEVEL_INFO;
    public static final int LOG_LEVEL_NORMAL;
    public static final int LOG_LEVEL_TRACE;

    default public void log(ASGArrayList aSGArrayList, int n, String string) {
    }
}

