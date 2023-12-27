/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.internal.carplay.common.CarPlayGlobalProperies;
import de.vw.mib.asl.internal.carplay.common.CarPlayHMIRequestParameterConfiguration;
import de.vw.mib.asl.internal.carplay.target.HsmTarget;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;

public class NavigationHandler
extends AbstractASLNavigationServicesListener {
    private HsmTarget target;
    private CarPlayGlobalProperies properties;

    public NavigationHandler(HsmTarget hsmTarget, CarPlayGlobalProperies carPlayGlobalProperies) {
        this.target = hsmTarget;
        this.properties = carPlayGlobalProperies;
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
        if (bl && this.properties.isConnected()) {
            CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration = this.properties.getParamconfig();
            super.getClass();
            ResourceRequest[] resourceRequestArray = carPlayHMIRequestParameterConfiguration.getRessourceRequest(0);
            CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration2 = this.properties.getParamconfig();
            super.getClass();
            AppStateRequest[] appStateRequestArray = carPlayHMIRequestParameterConfiguration2.getAppStateRequest(2);
            this.target.getDSICarPlay().requestModeChange(resourceRequestArray, appStateRequestArray, "User initiated");
        } else if (!bl && this.properties.isConnected() && this.properties.getActiveNavigation() == 3) {
            CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration = this.properties.getParamconfig();
            super.getClass();
            ResourceRequest[] resourceRequestArray = carPlayHMIRequestParameterConfiguration.getRessourceRequest(0);
            CarPlayHMIRequestParameterConfiguration carPlayHMIRequestParameterConfiguration3 = this.properties.getParamconfig();
            super.getClass();
            AppStateRequest[] appStateRequestArray = carPlayHMIRequestParameterConfiguration3.getAppStateRequest(6);
            this.target.getDSICarPlay().requestModeChange(resourceRequestArray, appStateRequestArray, "User initiated");
        }
        this.properties.setHmiRouteGuidanceActive(bl);
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
    }
}

