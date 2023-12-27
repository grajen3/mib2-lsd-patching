/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.EventListener;
import org.osgi.framework.FrameworkEvent;

public interface FrameworkListener
extends EventListener {
    default public void frameworkEvent(FrameworkEvent frameworkEvent) {
    }
}

