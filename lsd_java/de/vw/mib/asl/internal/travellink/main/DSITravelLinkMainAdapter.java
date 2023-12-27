/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import org.dsi.ifc.travellink.GenericProperty;

public final class DSITravelLinkMainAdapter {
    public void requestAllSubscriptionStates() {
        try {
            boolean bl;
            boolean bl2 = true;
            boolean bl3 = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            boolean bl4 = true;
            int n = 5;
            int n2 = -1;
            if (ServiceManager.logger2.isTraceEnabled(2)) {
                ServiceManager.logger2.trace(2).append("DSITravelLinkMainAdapter: Request all subscription states").log();
            }
            if (!(bl = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(1, 1, genericPropertyArray, 1, 5, -1))) {
                int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(1);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(1, 1, genericPropertyArray, 1, 5, -1, n3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestResetFactorySettings() {
        try {
            int n = 59;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            boolean bl2 = true;
            int n2 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(59, 1, genericPropertyArray, 1, -1, 1);
            if (!bl4) {
                int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(59);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(59, 1, genericPropertyArray, 1, -1, 1, n3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestStopUpdatesForMainView() {
        int[] nArray = new int[]{29, 35, 2, 17};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopAllUpdates() {
        int[] nArray = new int[]{29, 35, 17, 2};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForSkiView() {
        int[] nArray = new int[]{23};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdates(int[] nArray) {
        try {
            if (null != nArray && nArray.length > 0) {
                int n;
                boolean bl = false;
                for (n = 0; n < nArray.length; ++n) {
                    if (!TLinkServiceManager.getServiceManager().getDsiProxy().isUpdateActive(nArray[n])) continue;
                    bl = true;
                    break;
                }
                if (bl) {
                    int n2;
                    n = 0;
                    boolean bl2 = true;
                    GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
                    genericPropertyArray[0].valuesInt = nArray;
                    genericPropertyArray[0].key = -2138825216;
                    for (n2 = 0; n2 < nArray.length; ++n2) {
                        TLinkServiceManager.getServiceManager().getDsiProxy().resetRequestParamValues(nArray[n2]);
                    }
                    n2 = 1;
                    int n3 = -1;
                    boolean bl3 = true;
                    int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(0);
                    if (ServiceManager.logger2.isTraceEnabled(2)) {
                        for (int i2 = 0; i2 < genericPropertyArray[0].valuesInt.length; ++i2) {
                            ServiceManager.logger2.info(2).append(new StringBuffer().append("DSITravelLinkMainAdapter: Stop updates for request type ").append(TLinkServiceManager.getServiceManager().getTravelLinkTrace().getRequestTypeAsString(genericPropertyArray[0].valuesInt[i2])).toString()).log();
                        }
                    }
                    TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(0, 1, genericPropertyArray, 1, -1, 1, n4);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

