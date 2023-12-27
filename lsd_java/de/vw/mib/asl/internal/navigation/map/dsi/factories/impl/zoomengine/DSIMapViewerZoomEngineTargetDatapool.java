/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine;

import java.util.HashMap;
import java.util.Map;

public class DSIMapViewerZoomEngineTargetDatapool {
    private final Map serviceInstances = new HashMap();
    private boolean serviceAvailable;

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

