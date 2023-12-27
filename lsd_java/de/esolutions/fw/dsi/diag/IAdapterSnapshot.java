/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public interface IAdapterSnapshot {
    default public ProviderInfo[] getAllProviders() {
    }

    default public DispatcherInfo[] getAllDispatchers() {
    }

    default public long getTimeStamp() {
    }
}

