/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.global.NavLocation;

public class MobilityHorizonSetupDatapool {
    private final IPersistedDestInputSetup persistableDestInputSetup;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private ASLSystemAPI systemAPI;

    public MobilityHorizonSetupDatapool() {
        this.persistableDestInputSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
        this.systemAPI = ASLSystemFactory.getSystemApi();
    }

    public NavLocation getHomeLocation() {
        return this.persistableDestInputSetup.getHomeLocation();
    }

    public int[] getMobilityHorizonConsideredLocationTypes() {
        return this.persistedMapSetup.getMobilityHorizonConsideredLocationTypes();
    }

    public int getPrimaryEngineType() {
        return this.systemAPI.getPrimaryEngineType();
    }

    public int getSecondaryEngineType() {
        return this.systemAPI.getSecondaryEngineType();
    }

    public boolean isBEV() {
        return this.systemAPI.getFeatureFlagValueBEV();
    }

    public boolean isPHEV() {
        return this.systemAPI.getFeatureFlagValuePHEV();
    }

    public void setMobilityHorizonConsideredLocationTypes(int[] nArray) {
        this.persistedMapSetup.setMobilityHorizonConsideredLocationTypes(nArray);
    }
}

