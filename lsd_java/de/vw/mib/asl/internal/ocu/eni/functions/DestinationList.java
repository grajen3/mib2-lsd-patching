/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.functions;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.internal.ocu.common.timer.TimerObj;
import de.vw.mib.asl.internal.ocu.eni.functions.ENIFunction;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationsList_Data;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationsList_GetArray;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.DestinationsList_SetGetArray;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayDataList;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunction;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class DestinationList
extends ENIFunction
implements ArrayListener,
ASGArrayListFactory,
ASGArrayListChangeNotifier,
ASGArrayListDelegate,
Logger,
ASLNavigationServicesListener,
TimerNotifier {
    private static final int DESTION_LIST_MAX_REQUESTABLE_ELEMENTS;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    private static final int LAT_LON_FRACTION;
    private static final int IMPORT_STATE_STOP_TIME;
    private ASGArrayList _destionationList;
    private boolean _destListLoadedSinceUninitialize;
    private ASLNavigationServices _navigationOnlineServices;
    private boolean _navigationServiceAvailable;
    private int _contactCapacity = -1;
    private static final int UNKNOWN_CONTACT_CAPACITY;
    private Timer _importStateTimer;
    private boolean _importStateRunning;
    private int _importStateImportedEntries;
    private int _importStateImportedFailed;
    private boolean _lastImportFailed;

    private ASGArrayList getDestionationList() {
        if (this._destionationList == null) {
            this._destionationList = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, this.getFunctionId(), true, 4, 0);
        }
        return this._destionationList;
    }

    private boolean isDestListLoadedSinceUninitialize() {
        return this._destListLoadedSinceUninitialize;
    }

    private void setDestListLoadedSinceUninitialize(boolean bl) {
        this._destListLoadedSinceUninitialize = bl;
    }

    private ASLNavigationServices getNavigationOnlineServices() {
        if (this._navigationOnlineServices == null) {
            this._navigationOnlineServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(this);
            this.setNavigationServiceAvailable(this._navigationOnlineServices.isServiceAvailable());
        }
        return this._navigationOnlineServices;
    }

    private boolean isNavigationServiceAvailable() {
        return this._navigationServiceAvailable;
    }

    private void setNavigationServiceAvailable(boolean bl) {
        this._navigationServiceAvailable = bl;
    }

    private Timer getImportStateTimer() {
        if (this._importStateTimer == null) {
            this._importStateTimer = new TimerObj(this, 0);
        }
        return this._importStateTimer;
    }

    private int getContactCapacity() {
        return this._contactCapacity;
    }

    private void setContactCapacity(int n) {
        this._contactCapacity = n;
    }

    private boolean isImportStateRunning() {
        return this._importStateRunning;
    }

    private void setImportStateRunning(boolean bl) {
        this._importStateRunning = bl;
    }

    private int getImportStateImportedEntries() {
        return this._importStateImportedEntries;
    }

    private void setImportStateImportedEntries(int n) {
        this._importStateImportedEntries = n;
    }

    private void incrementImportedEntriesCounter() {
        if (this.isImportStateRunning()) {
            ++this._importStateImportedEntries;
        }
    }

    private int getImportStateImportedFailed() {
        return this._importStateImportedFailed;
    }

    private void incrementImportedFailedCounter() {
        if (this.isImportStateRunning()) {
            ++this._importStateImportedFailed;
        }
    }

    private void setImportStateImportedFailed(int n) {
        this._importStateImportedFailed = n;
    }

    private void resetImportStateCounters() {
        this.setImportStateImportedEntries(0);
        this.setImportStateImportedFailed(0);
    }

    @Override
    public void initialize(boolean bl) {
        if (bl && !this.isDestListLoadedSinceUninitialize() && this.getNavigationOnlineServices().isServiceAvailable()) {
            this.getDestionationList().reloadData();
        }
    }

    @Override
    public void uninitialize() {
        if (this.isDestListLoadedSinceUninitialize()) {
            this.getDestionationList().clearList();
        }
        this.setDestListLoadedSinceUninitialize(false);
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        switch (n) {
            case 34: {
                this.getDestionationList().error(-1);
                break;
            }
            case 33: {
                this.getDestionationList().error(-2);
                break;
            }
            case 67: {
                this.getDestionationList().error(-3);
                break;
            }
            case 66: {
                this.getDestionationList().error(-4);
                break;
            }
            default: {
                this.getLogger().warn(256).append("DestionationList: ignore got error code = ").append(n).log();
            }
        }
    }

    @Override
    public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
        this.getDestionationList().statusArray(bAPStatusArray);
    }

    @Override
    public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
        if (!this.isImportStateRunning() && !this.getDestionationList().isLoading()) {
            this.getDestionationList().changedArray(bAPChangedArray);
        }
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return new DestinationsList_GetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return new DestinationsList_SetGetArray();
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new DestinationsList_Data(new ArrayHeader());
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        DestinationsList_Data destinationsList_Data = (DestinationsList_Data)bAPArrayElement;
        DestinationsList_Data destinationsList_Data2 = (DestinationsList_Data)bAPArrayElement2;
        switch (n) {
            case 0: {
                destinationsList_Data2 = destinationsList_Data;
                break;
            }
            case 1: {
                destinationsList_Data2.name.setContent(destinationsList_Data.name);
                break;
            }
            case 2: {
                destinationsList_Data2.position_Latitude = destinationsList_Data.position_Latitude;
                destinationsList_Data2.position_Longitude = destinationsList_Data.position_Longitude;
                destinationsList_Data2.typeOfDestination = destinationsList_Data.typeOfDestination;
                destinationsList_Data2.poi_Type = destinationsList_Data.poi_Type;
                destinationsList_Data2.stopover_Sn = destinationsList_Data.stopover_Sn;
                break;
            }
            default: {
                this.getLogger().error(256, "DestinationList: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return destinationsList_Data2;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return new TimerObj(timerNotifier, l);
    }

    @Override
    public void elementsInserted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
    }

    @Override
    public void elementsDeleted(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
        if (aSGArrayList.size() == 0) {
            aSGArrayList.reloadData();
        }
    }

    @Override
    public void elementsUpdated(ASGArrayList aSGArrayList, int n, BAPArrayDataList bAPArrayDataList) {
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        if (!aSGArrayList.isLoading()) {
            this.setDestListLoadedSinceUninitialize(true);
            this._importDestinationsIfPossible();
        }
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.getDelegate().getArray(this).getArray(bAPGetArray, this);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        this.getDelegate().getArray(this).setGetArray(bAPSetGetArray, this);
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getLogger().warn(256).append("DestinationList: request time out counter=").append(n).append(", finished=").append(bl).log();
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 1;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return aSGArrayList.size() != 1;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = "DestinationList: ";
        switch (n) {
            case 1: {
                this.getLogger().fatal(256).append("DestinationList: ").append(string).log();
                break;
            }
            case 2: {
                this.getLogger().error(256).append("DestinationList: ").append(string).log();
                break;
            }
            case 4: {
                this.getLogger().warn(256).append("DestinationList: ").append(string).log();
                break;
            }
            case 8: {
                this.getLogger().info(256).append("DestinationList: ").append(string).log();
                break;
            }
            case 12: {
                this.getLogger().normal(256).append("DestinationList: ").append(string).log();
                break;
            }
            case 16: {
                if (!this.getLogger().isTraceEnabled(256)) break;
                this.getLogger().trace(256).append("DestinationList: ").append(string).log();
                break;
            }
            default: {
                this.getLogger().error(256).append("DestinationList: ").append("Wrong log message called from ASG array list").log();
            }
        }
    }

    @Override
    public void importContactResult(int n) {
        if (n == 1 || this._lastImportFailed) {
            if (this._lastImportFailed) {
                this._lastImportFailed = false;
            } else {
                this.incrementImportedEntriesCounter();
            }
            if (this.getDestionationList().size() > 0) {
                this.getDestionationList().deleteArrayElements(this.getDestionationList().getElements(0, 1), 1);
            }
        } else {
            this.incrementImportedFailedCounter();
            this.getLogger().error(256, "DestinationList: ASLNavigationServices could not import entry");
            this._lastImportFailed = true;
        }
    }

    @Override
    public void updateContactCapacity(int n) {
        int n2 = this.getContactCapacity();
        this.setContactCapacity(n);
        if (n2 == 0 && n > 0 && this.isNavigationServiceAvailable()) {
            this.getDestionationList().reloadData();
        }
    }

    @Override
    public void updateGuidanceActive(boolean bl) {
    }

    @Override
    public void updateServiceAvailable(boolean bl) {
        if (!this.isNavigationServiceAvailable() && bl) {
            this.getDestionationList().reloadData();
        }
        this.setNavigationServiceAvailable(bl);
    }

    private void _startRouteGuidanceToDestionationListEntry(DestinationsList_Data destinationsList_Data) {
        NavAddress navAddress = new NavAddress();
        navAddress.setName(destinationsList_Data.name.toString());
        navAddress.setState(destinationsList_Data.addr_State.toString());
        navAddress.setZip(destinationsList_Data.addr_PostalCode.toString());
        navAddress.setPhoneNumber(destinationsList_Data.addr_Telephone.toString());
        navAddress.setHousenumber(destinationsList_Data.addr_Number.toString());
        navAddress.setCountry(destinationsList_Data.addr_Country.toString());
        navAddress.setCity(destinationsList_Data.addr_Town.toString());
        navAddress.setStreet(destinationsList_Data.addr_Street.toString());
        navAddress.setLatitude(DestinationList.convertBapGeoCoordinateToDecimalNavCoordinate(destinationsList_Data.position_Latitude));
        navAddress.setLongitude(DestinationList.convertBapGeoCoordinateToDecimalNavCoordinate(destinationsList_Data.position_Longitude));
        if (this.getNavigationOnlineServices().isGuidanceActive()) {
            this.getLogger().warn(256).append("DestinationList: Attempt to start route guidance, although the route guidance is already active to = ").append(navAddress.toString()).log();
        } else if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("DestinationList: Attempt to start immediatly route guidance to =").append(navAddress.toString()).log();
        }
        int n = this.getNavigationOnlineServices().startGuidance(new NavAddress[]{navAddress}, false, 3);
        if (n == 2) {
            this.getLogger().warn(256).append("DestinationList: Failed to request to start route guidance from navigation").log();
        } else if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().warn(256).append("DestinationList: Successfully requested route guidance start from navigation").log();
        }
    }

    private static AdbEntry _convertDestinationEntryToAdbEntry(DestinationsList_Data destinationsList_Data) {
        PersonalData personalData = new PersonalData();
        personalData.lastName = destinationsList_Data.name.toString();
        PhoneData phoneData = new PhoneData();
        phoneData.number = destinationsList_Data.addr_Telephone.toString();
        AddressData addressData = new AddressData();
        addressData.addressType = 2;
        addressData.street = destinationsList_Data.addr_Number.isEmptyString() ? destinationsList_Data.addr_Street.toString() : new StringBuffer().append(destinationsList_Data.addr_Number.toString()).append(" ").append(destinationsList_Data.addr_Street.toString()).toString();
        addressData.locality = destinationsList_Data.addr_Town.toString();
        addressData.country = destinationsList_Data.addr_Country.toString();
        addressData.region = destinationsList_Data.addr_State.toString();
        addressData.postalCode = destinationsList_Data.addr_PostalCode.toString();
        addressData.geoPosition = DestinationList.convertBapGeoCoordinatesToVCard30CoordinateString(destinationsList_Data.position_Latitude, destinationsList_Data.position_Longitude);
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.personalData = personalData;
        adbEntry.phoneData = new PhoneData[]{phoneData};
        adbEntry.addressData = new AddressData[]{addressData};
        return adbEntry;
    }

    private void _importDestinationListEntry(DestinationsList_Data destinationsList_Data, boolean bl) {
        AdbEntry adbEntry = DestinationList._convertDestinationEntryToAdbEntry(destinationsList_Data);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("DestinationList: Attempt to import adbEntry =").append(adbEntry.toString()).log();
        }
        this.getNavigationOnlineServices().importContact(adbEntry, 3, !bl);
    }

    private void _importDestinationsIfPossible() {
        if (this.getDestionationList().size() > 0 && this.getNavigationOnlineServices().isServiceAvailable()) {
            DestinationsList_Data destinationsList_Data = (DestinationsList_Data)this.getDestionationList().get(0);
            if (destinationsList_Data.typeOfDestination == 4) {
                this._importDestinationListEntry(destinationsList_Data, true);
                this._startRouteGuidanceToDestionationListEntry(destinationsList_Data);
            } else {
                this._importDestinationListEntry(destinationsList_Data, false);
                this.setImportStateRunning(true);
                this.getImportStateTimer().retrigger(null);
            }
        } else {
            this.setImportStateRunning(false);
        }
    }

    private static double convertBapGeoCoordinateToDecimalNavCoordinate(int n) {
        return (double)n / 1000000.0;
    }

    private static String convertBapGeoCoordinatesToVCard30CoordinateString(int n, int n2) {
        return new StringBuffer().append(Float.toString((float)n / 2389065)).append(";").append(Float.toString((float)n2 / 2389065)).toString();
    }

    @Override
    public void timerFired(Timer timer) {
        int n = this.getImportStateImportedEntries();
        int n2 = this.getImportStateImportedFailed();
        int n3 = Math.max(0, this.getDestionationList().getBapArrayListSize() - n2);
        this.setImportStateRunning(false);
        if (this.getLogger().isTraceEnabled(256)) {
            this.getLogger().trace(256).append("DestinationList: Attempt to show import summary: importedSuceeded =").append(n).append(", importedFailed = ").append(n2).append(", importedPending = ").append(n3).log();
        }
        this.getNavigationOnlineServices().importContactSummary(n, n2, n3, 1);
        this.resetImportStateCounters();
        if (this.getContactCapacity() > 0) {
            this.getDestionationList().reloadData();
        }
    }
}

