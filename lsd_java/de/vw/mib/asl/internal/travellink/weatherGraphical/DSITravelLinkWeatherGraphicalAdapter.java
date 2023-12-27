/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.weatherGraphical;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import org.dsi.ifc.travellink.GenericProperty;

public final class DSITravelLinkWeatherGraphicalAdapter {
    public void requestStormInformation(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(64)) {
                ServiceManager.logger2.trace(64).append("DSITravelLinkWeatherGraphicalAdapter - requestStormInformation( ").append(n).append(" )").log();
            }
            int n2 = 39;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = 1486955520;
            boolean bl2 = true;
            int n3 = 20;
            int n4 = -1;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(39, 1, genericPropertyArray, 1, 20, -1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(39);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(39, 1, genericPropertyArray, 1, 20, -1, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerWeatherGraphical().prepareAndUpdateDataForStorm(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

