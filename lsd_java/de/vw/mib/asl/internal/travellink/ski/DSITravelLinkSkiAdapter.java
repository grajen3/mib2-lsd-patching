/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.ski;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericProperty;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class DSITravelLinkSkiAdapter {
    public void requestSkiCondition(long l, boolean bl) {
        try {
            int n = 23;
            boolean bl2 = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesLong = new long[]{l};
            genericPropertyArray[0].key = -1064230656;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesBoolean = new boolean[]{bl};
            genericPropertyArray[1].key = -1047453440;
            boolean bl3 = true;
            int n2 = 20;
            int n3 = -1;
            int n4 = -1;
            if (bl) {
                TLinkServiceManager.getServiceManager().getSki().setSkiResortRequested(1);
            } else {
                TLinkServiceManager.getServiceManager().getSki().setSkiResortRequested(2);
            }
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(23, 1, genericPropertyArray, 1, n2, n3);
            if (!bl4) {
                n4 = bl ? TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(48) : TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(47);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(23, 1, genericPropertyArray, 1, n2, n3, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateSkiConditions(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void checkAndRequestSkiCondition() {
        long l = TLinkServiceManager.getServiceManager().getSki().getSkiStationId();
        if (l > -1L) {
            this.requestSkiCondition(l, false);
        } else {
            this.requestSkiCondition(-1L, true);
        }
    }

    public void requestSkiCondition(EventGeneric eventGeneric) {
        block6: {
            try {
                int n = eventGeneric.getInt(0);
                Object[] objectArray = ListManager.getGenericASLList(-1002495232).getDSIObjects();
                if (null == objectArray || objectArray.length < 1) {
                    return;
                }
                GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
                if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                    long l = GenericPropertyUtility.getLong(135136000, 0, genericPropertyContainerArray[n]);
                    this.requestSkiCondition(l, false);
                    TLinkServiceManager.getServiceManager().getSki().setSkiStationId(l);
                } else if (ServiceManager.logger2.isTraceEnabled(16)) {
                    ServiceManager.logger2.error(16, "listIndex is not valid for the the list ski resort list ");
                }
            }
            catch (Exception exception) {
                if (!ServiceManager.logger2.isTraceEnabled(16)) break block6;
                ServiceManager.logger2.error(16, "requestToAddFavoriteSkiResort", exception);
            }
        }
    }

    public void requestStateList() {
        try {
            int n = 24;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = -1;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(24, 1, genericPropertyArray, -1, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(24);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(24, 1, genericPropertyArray, -1, -1, 1, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStateListForSki(null);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStateListForSetupSki(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestResortList(int n) {
        try {
            int n2 = 28;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -2003689216;
            int n3 = 200;
            int n4 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(28, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(28);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(28, 1, genericPropertyArray, 200, -1, 1, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateResortListForSki(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestResortList(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1891687680).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(-1542651136, 0, genericPropertyContainerArray[n]);
                this.requestResortList(n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSkiResortListForOneState(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-985718016).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(-1542651136, 0, genericPropertyContainerArray[n]);
                this.requestResortList(n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToAddFavoriteSkiResort(long l) {
        try {
            int n = 25;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesLong = new long[]{l};
            genericPropertyArray[0].key = 1351819520;
            boolean bl2 = true;
            int n2 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(25, 1, genericPropertyArray, 1, -1, 1);
            if (!bl4) {
                int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(25);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(25, 1, genericPropertyArray, 1, -1, 1, n3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToDeleteFavoriteSkiResort(long l) {
        try {
            if (l > -1L) {
                int n = 26;
                boolean bl = true;
                GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
                genericPropertyArray[0].valuesLong = new long[]{l};
                genericPropertyArray[0].key = -1265426176;
                boolean bl2 = true;
                int n2 = -1;
                boolean bl3 = true;
                boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(26, 1, genericPropertyArray, 1, -1, 1);
                if (!bl4) {
                    int n3 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(26);
                    TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(26, 1, genericPropertyArray, 1, -1, 1, n3);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFavoriteSkiResorts() {
        try {
            int n = 27;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = -1;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(27, 1, genericPropertyArray, -1, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(27);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(27, 1, genericPropertyArray, -1, -1, 1, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateFavoriteSkiResorts(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

