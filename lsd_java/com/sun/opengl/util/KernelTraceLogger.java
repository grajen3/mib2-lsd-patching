/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.util;

public class KernelTraceLogger {
    private static native void setKernelTraceUserEvent0(String string) {
    }

    public static void setKernelTraceUserEvent(String string) {
        KernelTraceLogger.setKernelTraceUserEvent0(string);
    }
}

