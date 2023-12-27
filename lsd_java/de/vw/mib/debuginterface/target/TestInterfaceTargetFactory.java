/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target;

import org.osgi.framework.BundleContext;

public interface TestInterfaceTargetFactory {
    default public boolean createAndRegisterDebugTarget(int n, BundleContext bundleContext) {
    }
}

