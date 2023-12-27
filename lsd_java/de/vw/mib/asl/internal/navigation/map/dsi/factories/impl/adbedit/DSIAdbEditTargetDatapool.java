/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit;

import java.util.HashMap;
import java.util.Map;

public class DSIAdbEditTargetDatapool {
    private boolean serviceAvailable;
    private final Map serviceInstances = new HashMap();

    public Map getServiceInstances() {
        return this.serviceInstances;
    }

    public boolean isServiceAvailable() {
        return this.serviceAvailable;
    }

    public void setServiceAvailable(boolean bl) {
        this.serviceAvailable = bl;
    }
}

