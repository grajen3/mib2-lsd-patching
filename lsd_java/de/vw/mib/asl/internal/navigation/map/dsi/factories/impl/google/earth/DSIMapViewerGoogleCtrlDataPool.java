/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth;

import java.util.HashMap;
import java.util.Map;

public class DSIMapViewerGoogleCtrlDataPool {
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

