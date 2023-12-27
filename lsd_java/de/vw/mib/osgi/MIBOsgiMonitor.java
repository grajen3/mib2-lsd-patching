/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.osgi;

import org.osgi.framework.Bundle;

public interface MIBOsgiMonitor {
    default public void bundleStateChanged(int n, Bundle bundle) {
    }
}

