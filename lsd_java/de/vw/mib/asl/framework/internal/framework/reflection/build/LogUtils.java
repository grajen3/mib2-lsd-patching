/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.reflection.build;

import java.io.PrintWriter;

public final class LogUtils {
    public static void logError(String string) {
        System.err.println(string);
    }

    public static void logError(Throwable throwable) {
        LogUtils.logError(throwable.getMessage());
        throwable.printStackTrace(System.err);
    }

    public static PrintWriter createPrintWriter() {
        return new PrintWriter(System.out);
    }

    private LogUtils() {
    }
}

