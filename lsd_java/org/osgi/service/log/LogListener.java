/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.service.log;

import java.util.EventListener;
import org.osgi.service.log.LogEntry;

public interface LogListener
extends EventListener {
    default public void logged(LogEntry logEntry) {
    }
}

