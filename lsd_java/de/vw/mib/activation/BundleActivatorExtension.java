/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.activation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public interface BundleActivatorExtension
extends BundleActivator {
    default public void preload(BundleContext bundleContext) {
    }
}

