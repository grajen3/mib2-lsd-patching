/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon.DSIMobilityHorizonDatapool;
import java.util.HashMap;
import java.util.Map;

public class DSIMobilityHorizonTargetDatapool {
    private final Map serviceInstances = new HashMap();
    private final DSIMobilityHorizonDatapool dsiMobilityHorizonDatapool;
    private boolean serviceAvailable;

    public DSIMobilityHorizonTargetDatapool(DSIMobilityHorizonDatapool dSIMobilityHorizonDatapool) {
        this.dsiMobilityHorizonDatapool = dSIMobilityHorizonDatapool;
    }

    public DSIMobilityHorizonDatapool getDsiMobilityHorizonDatapool() {
        return this.dsiMobilityHorizonDatapool;
    }

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

