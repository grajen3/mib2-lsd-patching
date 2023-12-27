/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.ski;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public class Ski
implements DataProcessor {
    public static final int SKI_RESORT_INVALID_ID;
    public static final boolean SKI_RESORT_NEARBY;
    public static final boolean SKI_RESORT_NOT_NEARBY;
    private long skiStationId = -1L;
    private long selectedSkiResortIdToDelete = -1L;
    public static final boolean SHOW_NEARESTSKIRESORTPOPUP_TRUE;
    public static final boolean SHOW_NEARESTSKIRESORTPOPUP_FALSE;
    private boolean showNearestSkiResortPopup = false;
    public static final int SKI_RESORT_REQUESTED_UNKNOWN;
    public static final int SKI_RESORT_REQUESTED_NEARBY;
    public static final int SKI_RESORT_REQUESTED_RESORTID;
    private int skiResortRequested = 0;
    public static final int NEARBYAVAILABLE_UNKNOWN;
    public static final int NEARBYAVAILABLE_TRUE;
    public static final int NEARBYAVAILABLE_FALSE;
    private int nearByAvailable = 0;
    private int responseStatusNearBy = 3;

    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        switch (n) {
            case 48: {
                this.setResponseStatusNearBy(n2);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStatusForSkiResortClosed(n2);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStatusForSkiConditions(n2);
                TLinkServiceManager.getServiceManager().getDatapool().put(48, genericPropertyContainerArray);
                if (1 != this.getSkiResortRequested()) break;
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateSkiConditions(genericPropertyContainerArray);
                this.setNearBySkiResortIdForLSM(genericPropertyContainerArray, n2);
                break;
            }
            case 47: {
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStatusForSkiResortClosed(n2);
                TLinkServiceManager.getServiceManager().getDatapool().put(47, genericPropertyContainerArray);
                if (2 != this.getSkiResortRequested()) break;
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateSkiConditions(genericPropertyContainerArray);
                break;
            }
            case 27: {
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateFavoriteSkiResorts(genericPropertyContainerArray);
                break;
            }
            case 24: {
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStateListForSki(genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStateListForSetupSki(genericPropertyContainerArray);
                break;
            }
            case 25: {
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateAddFavoriteSkiResortStatus(genericPropertyContainerArray, n2);
                break;
            }
            case 26: {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestFavoriteSkiResorts();
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateDeleteFavoriteSkiResortStatus(genericPropertyContainerArray, n2);
                break;
            }
            case 28: {
                TLinkServiceManager.getServiceManager().getGuiControllerSki().updateResortListForSki(genericPropertyContainerArray);
                break;
            }
            default: {
                if (!ServiceManager.logger2.isTraceEnabled(16)) break;
                ServiceManager.logger2.error(16).append("Ski : processAndUpdate : RequestType is not handled. RequestTypeID --> ").append(n).log();
            }
        }
    }

    public void requestSkiResortInfo(int n) {
        boolean bl = false;
        Object[] objectArray = ListManager.getGenericASLList(4110).getDSIObjects();
        if (null == objectArray || objectArray.length < 1) {
            return;
        }
        GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
        if (null != genericPropertyContainerArray && n >= 0 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
            long l = GenericPropertyUtility.getLong(1812857600, 0, genericPropertyContainerArray[n]);
            TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestSkiCondition(l, false);
            TLinkServiceManager.getServiceManager().getSki().setSkiStationId(l);
        }
    }

    public void requestToAddFavoriteSkiResort(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1874910464).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                long l = GenericPropertyUtility.getLong(135136000, 0, genericPropertyContainerArray[n]);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestToAddFavoriteSkiResort(l);
            } else if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.error(16, "listIndex is not valid for the the list ski resort list ");
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public long getSkiStationId() {
        return this.skiStationId;
    }

    public void setSkiStationId(long l) {
        this.skiStationId = l;
    }

    public void requestToDeleteFavoriteSkiResort(EventGeneric eventGeneric) {
        try {
            GenericPropertyContainer[] genericPropertyContainerArray;
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(4110).getDSIObjects();
            this.selectedSkiResortIdToDelete = -1L;
            if (null != objectArray && objectArray.length > 0 && null != (genericPropertyContainerArray = (GenericPropertyContainer[])objectArray) && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                this.selectedSkiResortIdToDelete = GenericPropertyUtility.getLong(1812857600, 0, genericPropertyContainerArray[n]);
                String string = GenericPropertyUtility.getString(1829634816, 0, genericPropertyContainerArray[n]);
                String string2 = GenericPropertyUtility.getString(1846412032, 0, genericPropertyContainerArray[n]);
                String string3 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedNamingRuleF(string, string2);
                TLinkServiceManager.getServiceManager().getGuiControllerSki().setSelectedFavoriteSkiResortNameToDelete(string3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestToDeleteFavoriteSkiResort() {
        TLinkServiceManager.getServiceManager().getDsiTravelLinkSkiAdapter().requestToDeleteFavoriteSkiResort(this.selectedSkiResortIdToDelete);
    }

    public boolean getNearestSkiResortPopupShown() {
        return this.showNearestSkiResortPopup;
    }

    public void setNearestSkiResortPopupShown(boolean bl) {
        this.showNearestSkiResortPopup = bl;
    }

    public int getSkiResortRequested() {
        return this.skiResortRequested;
    }

    public void setSkiResortRequested(int n) {
        this.skiResortRequested = n;
    }

    public int getNearByAvailable() {
        return this.nearByAvailable;
    }

    public void setNearByAvailable(int n) {
        this.nearByAvailable = n;
    }

    public void checkAndUpdateNearAvailableResortToGui() {
        if (1 == this.getNearByAvailable()) {
            TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStatusForSkiConditions(this.getResponseStatusNearBy());
            GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(48);
            if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
                if (1 == this.getSkiResortRequested()) {
                    TLinkServiceManager.getServiceManager().getGuiControllerSki().updateSkiConditions(genericPropertyContainerArray);
                }
            } else if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.error(16).append("Ski : checkAndUpdateNearAvailable : NearByAvailable flag is true. But not data is available ! ").log();
            }
        } else if (2 == this.getNearByAvailable()) {
            TLinkServiceManager.getServiceManager().getGuiControllerSki().updateStatusForSkiConditions(this.getResponseStatusNearBy());
        } else if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("Ski : checkAndUpdateNearAvailable : HMI waiting to receive the nearby ski resort data  !").log();
        }
    }

    public int getResponseStatusNearBy() {
        return this.responseStatusNearBy;
    }

    public void setNearBySkiResortIdForLSM(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        if ((n == 6 || n == 1 || n == 2 || n == 5 || n == 0) && genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            long l = GenericPropertyUtility.getLong(1326252800, 0, genericPropertyContainerArray[0]);
            TLinkServiceManager.getServiceManager().getSki().setSkiStationId(l);
        }
    }

    public void setResponseStatusNearBy(int n) {
        this.responseStatusNearBy = n;
    }

    public void upateSkiConditions() {
        if (1 == this.getSkiResortRequested()) {
            GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(48);
            TLinkServiceManager.getServiceManager().getGuiControllerSki().updateSkiConditions(genericPropertyContainerArray);
        } else {
            GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(47);
            TLinkServiceManager.getServiceManager().getGuiControllerSki().updateSkiConditions(genericPropertyContainerArray);
        }
    }
}

