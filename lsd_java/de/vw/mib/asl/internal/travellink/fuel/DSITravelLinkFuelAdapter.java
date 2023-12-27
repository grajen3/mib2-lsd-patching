/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.fuel;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.TravelLinkConstants;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericProperty;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class DSITravelLinkFuelAdapter {
    public void requestFuelStations(String string, int n, int n2) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("DSITravelLinkFuelAdapter - requestFuelStations( ").append(string).append(", ").append(n).append(", ").append(n2).append(" )").log();
            }
            int n3 = 29;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[8];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{2};
            genericPropertyArray[0].key = -1608178176;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[0];
            genericPropertyArray[1].key = -1;
            genericPropertyArray[2] = new GenericProperty();
            genericPropertyArray[2].valuesInt = new int[0];
            genericPropertyArray[2].key = -1;
            genericPropertyArray[3] = new GenericProperty();
            genericPropertyArray[3].valuesInt = new int[]{n};
            genericPropertyArray[3].key = -1557846528;
            genericPropertyArray[4] = new GenericProperty();
            genericPropertyArray[4].valuesString = new String[]{string};
            genericPropertyArray[4].key = -1541069312;
            genericPropertyArray[5] = new GenericProperty();
            int n4 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeId();
            genericPropertyArray[5].valuesInt = new int[]{n4};
            genericPropertyArray[5].key = -1524292096;
            genericPropertyArray[6] = new GenericProperty();
            String string2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getPreferredFuelTypeName();
            genericPropertyArray[6].valuesString = new String[]{string2};
            genericPropertyArray[6].key = -1507514880;
            genericPropertyArray[7] = new GenericProperty();
            genericPropertyArray[7].valuesBoolean = TravelLinkConstants.GP_BOOLEAN_ARRAY_FALSE;
            genericPropertyArray[7].key = -1490737664;
            int n5 = 200;
            int n6 = -1;
            int n7 = 1;
            if (49 == n2) {
                n5 = 20;
                genericPropertyArray[7].valuesBoolean = TravelLinkConstants.GP_BOOLEAN_ARRAY_TRUE;
                n6 = 5;
                n7 = -1;
                TLinkServiceManager.getServiceManager().getFuel().setFuelGasStationsRequestType(1);
            } else {
                TLinkServiceManager.getServiceManager().getFuel().setFuelGasStationsRequestType(2);
            }
            boolean bl2 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(29, 1, genericPropertyArray, n5, n6, n7);
            if (!bl2) {
                int n8 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(n2);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(29, 1, genericPropertyArray, n5, n6, n7, n8);
                ListManager.getGenericASLList(-1757469952).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFuelStationDetails(long l) {
        int n = 30;
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("DSITravelLinkFuelAdapter - requestFuelStationDetails( ").append(l).append(" )").log();
            }
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesLong = new long[]{l};
            genericPropertyArray[0].key = 69608960;
            boolean bl2 = true;
            int n2 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(30, 1, genericPropertyArray, 1, -1, 1);
            boolean bl5 = TLinkServiceManager.getServiceManager().getRequestQueue().isRequestBlocked(30);
            if (!bl4) {
                if (bl5) {
                    if (ServiceManager.logger2.isTraceEnabled(4)) {
                        ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("DSITravelLinkFuelAdapter - requestFuelStationDetails() isRequestBlocked = true").log();
                    }
                    TLinkServiceManager.getServiceManager().getRequestQueue().setRequestToAppParameter(30, 1, genericPropertyArray, 1, -1, 1);
                } else {
                    TLinkServiceManager.getServiceManager().getRequestQueue().blockRequest(30);
                    int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(30);
                    TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(30, 1, genericPropertyArray, 1, -1, 1, n3);
                    TLinkServiceManager.getServiceManager().getDatapool().put(30, new GenericPropertyContainer[0]);
                }
            }
        }
        catch (Exception exception) {
            TLinkServiceManager.getServiceManager().getRequestQueue().setRequestIsBlocked(30, false);
            TLinkServiceManager.getServiceManager().getRequestQueue().deleteRequestToAppParameter(30);
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFuelTypes() {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("DSITravelLinkFuelAdapter - requestFuelTypes()").log();
            }
            int n = 51;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = 50;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(51, 1, genericPropertyArray, 50, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(51);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(51, 1, genericPropertyArray, 50, -1, 1, n4);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToSetPreferredFuelType(String string, int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(4)) {
                ServiceManager.logger2.trace(4).append("TL <FUEL> ").append("DSITravelLinkFuelAdapter - requestToSetPreferredFuelType( ").append(string).append(", ").append(n).append(" )").log();
            }
            int n2 = 56;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesString = new String[]{string};
            genericPropertyArray[0].key = -869915136;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{n};
            genericPropertyArray[1].key = -853137920;
            boolean bl2 = true;
            int n3 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(56, 1, genericPropertyArray, 1, -1, 1);
            if (!bl4) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(56);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(56, 1, genericPropertyArray, 1, -1, 1, n4);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

