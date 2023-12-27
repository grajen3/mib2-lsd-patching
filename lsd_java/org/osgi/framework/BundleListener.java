/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import java.util.EventListener;
import org.osgi.framework.BundleEvent;

public interface BundleListener
extends EventListener {
    default public void bundleChanged(BundleEvent bundleEvent) {
    }
}

