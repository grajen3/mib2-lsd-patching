/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.service.log;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;

public interface LogEntry {
    default public Bundle getBundle() {
    }

    default public ServiceReference getServiceReference() {
    }

    default public int getLevel() {
    }

    default public String getMessage() {
    }

    default public Throwable getException() {
    }

    default public long getTime() {
    }
}

