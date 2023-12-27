/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.util;

public class JoglCommon {
    private static final String JAVA_VERSION;

    private static native String getNativeJoglVersion() {
    }

    public static String getNativeVersion() {
        return JoglCommon.getNativeJoglVersion();
    }

    public static String getJavaVersion() {
        return "20110322";
    }
}

