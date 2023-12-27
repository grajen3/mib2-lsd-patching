/*
 * Decompiled with CFR 0.152.
 */
package org.osgi.framework;

import org.osgi.framework.BundleContext;

public interface BundleActivator {
    default public void start(BundleContext bundleContext) {
    }

    default public void stop(BundleContext bundleContext) {
    }
}

