/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

public interface IJobLogger {
    public static final int LOG_CRITICAL;
    public static final int LOG_ERROR;
    public static final int LOG_WARNING;
    public static final int LOG_INFO;
    public static final int LOG_DEBUG;
    public static final int LOG_DEBUG2;

    default public void log(int n, String string, Object object) {
    }

    default public void log(int n, String string, Object object, int n2) {
    }

    default public void log(int n, String string, Object object, int n2, int n3) {
    }

    default public void log(int n, String string, Object object, Object object2) {
    }

    default public void log(int n, String string, Object object, Object object2, int n2) {
    }

    default public void logException(Exception exception) {
    }
}

