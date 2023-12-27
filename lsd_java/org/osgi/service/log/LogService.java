/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.service.log;

import org.osgi.framework.ServiceReference;

public interface LogService {
    public static final int LOG_ERROR;
    public static final int LOG_WARNING;
    public static final int LOG_INFO;
    public static final int LOG_DEBUG;

    default public void log(int n, String string) {
    }

    default public void log(int n, String string, Throwable throwable) {
    }

    default public void log(ServiceReference serviceReference, int n, String string) {
    }

    default public void log(ServiceReference serviceReference, int n, String string, Throwable throwable) {
    }
}

