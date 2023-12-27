/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.asl.internal.navigation.memory.ASLNavMemoryDP;
import de.vw.mib.asl.internal.navigation.memory.MemoryFormatter;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import generated.de.vw.mib.asl.internal.navigation.speech.transformer.NavigationSpeechRecognizedContactCollector;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DataSet;

public class TargetNavMemLoadEntry
extends AbstractResettableNavGatewayTarget
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSIListener dsiNavigationListener;
    private DSIAdbSetup dsiAdbSetup;
    private DSIListener dsiAdbSetupListener;
    private DSIAdbList dsiAdbList;
    private DSIListener adbListListener;
    private DSIAdbEdit dsiAdbEdit;
    private DSIListener adbEditListener;
    private boolean organizerReady;
    private long selectedEntryId = 0L;
    private AdbEntry selectedAdbEntry;
    private AddressData[] selectedAddresses;
    private int selectedSlot;
    private AddressData selectedAddress;
    private boolean getEntryReceived;
    private boolean listIndexReceived;
    private boolean wasSpeechSelect;
    private int searchMode;
    private boolean modelSelectsAddressSlot;
    private NavLocation myFlagDest;
    private boolean isServiceStateListenerAdded = false;
    private static final INavigationDP NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private static final ASLNavMemoryDP MEMORY_DP = ASLNavMemoryDP.getInstance();
    private static final int[] OBSERVERS = new int[]{923271232, 2114060352, -2080243648, 1526857792, 2080505920, 1996619840, -2097020864, 1795293248, -335413184, -2130575296, 1070141504, 1541485312};
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetNavMemLoadEntry(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup, this);
                }
                this.addObservers(OBSERVERS);
                break;
            }
            case 1073742462: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: SELECT_DESTINATION_MEMORY_LIST_ITEM");
                }
                this.selectedEntryId = eventGeneric.getLong(0);
                this.getEntries(new long[]{this.selectedEntryId}, 6, 0);
                this.modelSelectsAddressSlot = false;
                this.setGetEntryReceived(false);
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                break;
            }
            case 1073742468: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: SELECT_TOP_DEST_MEM_LIST_ITEM");
                }
                this.selectedEntryId = eventGeneric.getLong(0);
                this.getEntries(new long[]{this.selectedEntryId}, 15, 0);
                this.modelSelectsAddressSlot = false;
                this.setGetEntryReceived(false);
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                break;
            }
            case 3400027: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: ASL_NAVI_SERVICE_SELECT_FAVOURITE");
                }
                this.selectedEntryId = eventGeneric.getLong(0);
                this.getEntries(new long[]{this.selectedEntryId}, 15, 0);
                this.modelSelectsAddressSlot = false;
                this.setGetEntryReceived(false);
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                break;
            }
            case 1073742427: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: CONTACT_LIST_ITEM_SELECT_LOAD_DATA_REQUEST");
                }
                this.selectedEntryId = eventGeneric.getLong(0);
                DataSet dataSet = (DataSet)ListManager.getGenericASLList(905).getListItemByIdCacheOnly(this.selectedEntryId);
                if (dataSet != null) {
                    this.listIndexReceived = true;
                } else {
                    this.dsiAdbList.getViewWindow(this.selectedEntryId, 0, 2, 1);
                }
                this.modelSelectsAddressSlot = true;
                this.setGetEntryReceived(false);
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                this.getEntries(new long[]{this.selectedEntryId}, 2, 0);
                break;
            }
            case 1073742460: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: SELECT_CONTACT_LIST_ITEM");
                }
                this.selectedSlot = eventGeneric.getInt(0);
                this.selectedAddress = this.selectedAddresses[this.selectedSlot];
                if (this.selectedAddress == null) break;
                byte[] byArray = this.selectedAddress.getNavLocation();
                if (byArray != null && byArray.length > 0) {
                    this.dsiNavigation.streamToLocation(byArray);
                    break;
                }
                this.sendTryBestMatch(this.selectedAddress);
                break;
            }
            case 1073742455: {
                this.case_searchListItemLoadDataRequest(eventGeneric);
                break;
            }
            case 1073742467: {
                this.case_selectSearchListItem(eventGeneric);
                break;
            }
            case 1073742572: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: SELECT_CONTACT");
                }
                this.selectedEntryId = eventGeneric.getLong(0);
                this.getEntries(new long[]{this.selectedEntryId}, 14, 0);
                this.wasSpeechSelect = true;
                this.modelSelectsAddressSlot = true;
                this.setGetEntryReceived(false);
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                break;
            }
            case 1073742465: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: SELECT_FLAG_DEST_MEM_LIST_ITEM");
                }
                if (this.myFlagDest == null) break;
                ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.myFlagDest);
                String string = iLocationWrapper.getMmiInternalDataValue(2);
                this.setGetEntryReceived(true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(902, !iLocationWrapper.isNavigable());
                this.setLocationForDetailsScreen(null, this.myFlagDest, string, false, false, true, false);
                this.sendSelectFinishedEvent();
                break;
            }
            case 1073743927: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: LIST_ITEM_SELECTION_STATUS_REQUEST__1");
                }
                MEMORY_DP.setMemoryStatusRequestReceived(true);
                this.sendSelectFinishedEvent();
                this.send(2051740672, 923271232, 0);
                this.send(-2142563328, 923271232, 0);
                break;
            }
            case 1073742443: {
                this.searchMode = eventGeneric.getInt(0);
                break;
            }
            case 1074841919: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: SELECT_ONLINE_DEST_MEM_LIST_ITEM");
                }
                this.selectedEntryId = eventGeneric.getLong(0);
                this.getEntries(new long[]{this.selectedEntryId}, 18, 0);
                this.modelSelectsAddressSlot = false;
                this.setGetEntryReceived(false);
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                break;
            }
        }
    }

    private void case_searchListItemLoadDataRequest(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: ASL_NAVIGATION_MEMORY_SEARCH_LIST_ITEM_SELECT_LOAD_DATA_REQUEST");
        }
        this.selectedEntryId = eventGeneric.getLong(0);
        this.modelSelectsAddressSlot = true;
        this.setGetEntryReceived(false);
        MEMORY_DP.setMemoryStatusRequestReceived(false);
        switch (this.searchMode) {
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: DESTMEM_ALL");
                }
                this.getEntries(new long[]{this.selectedEntryId}, 14, 0);
                break;
            }
            case 1: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: LASTDEST");
                }
                this.dsiNavigation.dmLastDestinationsGet(this.selectedEntryId);
                break;
            }
            case 2: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: TOPDEST");
                }
                this.getEntries(new long[]{this.selectedEntryId}, 15, 0);
                break;
            }
            case 3: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: DESTMEM");
                }
                this.getEntries(new long[]{this.selectedEntryId}, 6, 0);
                break;
            }
            case 4: {
                if (!this.isTraceEnabled()) break;
                this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: VCARDS");
                break;
            }
            case 5: {
                if (!this.isTraceEnabled()) break;
                this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: GPSPICS");
                break;
            }
            case 6: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: CONTACTS");
                }
                this.getEntries(new long[]{this.selectedEntryId}, 14, 0);
                break;
            }
            case 7: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySearch: ListItemLoadDataRequest with search type: ONLINE DESTINATIONS");
                }
                this.getEntries(new long[]{this.selectedEntryId}, 18, 0);
                break;
            }
            default: {
                this.warn("TargetMemorySearch: ListItemLoadDataRequest with unknown search type! Trying to load entry from phone or destination memory.");
                this.getEntries(new long[]{this.selectedEntryId}, 2, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(2762, 1);
                this.sendHMIEvent(78);
            }
        }
    }

    private void case_selectSearchListItem(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: ASL_NAVIGATION_MEMORY_SELECT_SEARCH_LIST_ITEM");
        }
        if (this.searchMode != 1) {
            int n = eventGeneric.getInt(0);
            this.selectedAddress = this.selectedAddresses[n];
            this.resolveAddressThrougDSI();
        }
    }

    private void resolveAddressThrougDSI() {
        byte[] byArray = this.selectedAddress.getNavLocation();
        if (byArray != null && byArray.length > 0) {
            this.dsiNavigation.streamToLocation(byArray);
        } else if (this.selectedAdbEntry.getEntryType() == 5 && this.selectedAddressContainsGeoCoordinate()) {
            ASLNavigationServices aSLNavigationServices;
            int[] nArray;
            if (this.isTraceEnabled()) {
                this.trace("TargetNavMemLoadEntry.resolveAddressThroughDSI(): Found online contact with geo coordinate string. Trying to parse.");
            }
            if ((nArray = (aSLNavigationServices = ASLNavigationFactory.getNavigationApi().getASLNavigationServices(null)).parseGeoPositionVCard3_0(this.selectedAddress.getGeoPosition())).length == 2 && (nArray[0] != 0 || nArray[1] != 0)) {
                this.sendLiGetLocationDescriptionTransform(nArray);
            } else {
                this.warn("TargetNavMemLoadEntry.resolveAddressThroughDSI(): coordinates could not be parsed from online contact. Fall back to tryBestMatch(). ");
                this.sendTryBestMatch(this.selectedAddress);
            }
        } else {
            this.sendTryBestMatch(this.selectedAddress);
        }
    }

    private boolean selectedAddressContainsGeoCoordinate() {
        return this.selectedAddress != null && !StringUtil.isEmpty(this.selectedAddress.getGeoPosition());
    }

    private void getEntries(long[] lArray, int n, int n2) {
        if (this.organizerReady) {
            this.dsiAdbEdit.getEntries(lArray, n, n2);
        } else {
            this.handleOrganizerError("Organizer DSI is not ready for getEntries()!");
        }
    }

    public void dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: dsiAdbEditGetEntriesResult()");
        }
        if (n == 0 && adbEntryArray != null && adbEntryArray.length > 0) {
            this.trace("TargetNavMemLoadEntry: processing entries");
            this.selectedAdbEntry = this.findAdbEntryWithId(adbEntryArray, this.selectedEntryId);
            MEMORY_DP.setMemorySelectedAdbEntry(this.selectedAdbEntry);
            if (this.selectedAdbEntry != null) {
                boolean bl;
                this.selectedAddresses = ASLPhoneFactory.getPhoneApi().ripADBAddressData(this.selectedAdbEntry.getAddressData());
                if (this.isTraceEnabled()) {
                    this.trace("TargetNavMemLoadEntry: Number of addresses in the loaded entry: ", this.selectedAddresses.length);
                }
                if (this.selectedAddresses.length > 1 && this.selectedAdbEntry.getEntryType() == 4) {
                    this.selectedAddresses = new AddressData[]{this.selectedAddresses[0]};
                }
                if (this.selectedAdbEntry.addressData.length > 1 && this.selectedAdbEntry.getEntryType() == 1) {
                    for (bl = false; bl < this.selectedAdbEntry.addressData.length; bl += 1) {
                        if (!StringUtil.isEmpty(this.selectedAdbEntry.addressData[bl].region)) continue;
                        this.selectedAdbEntry.addressData[bl].region = " ";
                    }
                }
                this.provideSpeechSelectContactAddressData(this.selectedAddresses.length, this.selectedEntryId);
                ListManager.getGenericASLList(903).updateList(this.selectedAddresses);
                ListManager.getGenericASLList(881).updateList(this.selectedAddresses);
                if (this.selectedAddresses.length > 0) {
                    String string = this.createAddressPartsStringFromNavAddress(this.selectedAddresses[0]);
                    ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setInvalidDestMemLocationAddressParts(string);
                    if (!this.modelSelectsAddressSlot) {
                        this.selectedSlot = 0;
                        this.selectedAddress = this.selectedAddresses[this.selectedSlot];
                        this.resolveAddressThrougDSI();
                    }
                } else {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
                    bl = this.selectedAdbEntry.getEntryType() == 4;
                    boolean bl2 = this.selectedAdbEntry.getEntryType() == 5;
                    this.setLocationForDetailsScreen(this.selectedAdbEntry, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation(), this.selectedAdbEntry.getCombinedName(), bl, false, false, bl2);
                    this.setGetEntryReceived(true);
                    this.sendSelectFinishedEvent();
                }
            } else {
                this.handleOrganizerError("Organizer error: getEntriesResult() did not return the requested entry!");
            }
        } else if (this.wasSpeechSelect && n == 2 && adbEntryArray == null) {
            this.provideSpeechSelectContactAddressData(0, 0L);
        } else {
            this.handleOrganizerError("Organizer error: getEntriesResult() returned with invalid parameters!");
        }
        if (this.modelSelectsAddressSlot) {
            this.sendHMIEvent(78);
        }
    }

    private String createAddressPartsStringFromNavAddress(AddressData addressData) {
        String string = "";
        if (addressData != null) {
            string = new StringBuffer().append(StringUtil.isEmpty(addressData.getRegion()) ? "" : new StringBuffer().append(addressData.getRegion()).append(" ").toString()).append(StringUtil.isEmpty(addressData.getLocality()) ? "" : new StringBuffer().append(addressData.getLocality()).append(" ").toString()).append(StringUtil.isEmpty(addressData.getPostalCode()) ? "" : new StringBuffer().append(addressData.getPostalCode()).append(" ").toString()).append(StringUtil.isEmpty(addressData.getStreet()) ? "" : new StringBuffer().append(addressData.getStreet()).append(" ").toString()).toString();
            string = string.replace('\n', ' ').replace('\r', ' ');
        }
        return string;
    }

    public void dsiNavigationDmLastDestinationsGetResult(long l, NavLocation navLocation) {
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: dmLastDestinationGetResult()");
        }
        if (l == 0L && navLocation != null && navLocation.isPositionValid()) {
            NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation);
            ListManager.getGenericASLList(903).updateList(new String[]{""});
            this.sendHMIEvent(78);
            String string = null;
            try {
                string = ((LDListElement)ListManager.getGenericASLList(908).getListItemByIdCacheOnly(this.selectedEntryId)).getTitle();
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (string == null) {
                string = "";
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, false);
            this.setLocationForDetailsScreen(null, navLocation2, string, false, false, false, false);
            this.setGetEntryReceived(true);
            this.sendSelectFinishedEvent();
        }
    }

    public void dsiNavigationStreamToLocationResult(boolean bl, NavLocation navLocation) {
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: dsiNavigationStreamToLocationResult()");
        }
        if (bl) {
            if (navLocation != null) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(902, !navLocation.isPositionValid());
                boolean bl2 = this.selectedAdbEntry.getEntryType() == 4;
                boolean bl3 = this.selectedAdbEntry.getEntryType() == 5;
                this.setGetEntryReceived(true);
                this.setLocationForDetailsScreen(this.selectedAdbEntry, navLocation, this.selectedAdbEntry.getCombinedName(), bl2, this.selectedAddress.isTopDestination(), false, bl3);
                MEMORY_DP.setCurrentlySelectedAddressName(navLocation);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
                this.sendSelectFinishedEvent();
            }
        } else {
            this.sendTryBestMatch(this.selectedAddress);
        }
    }

    public void dsiNavigationUpdateDmFlagDestination(NavLocation navLocation, int n) {
        if (navLocation != null) {
            this.myFlagDest = navLocation;
            ServiceManager.aslPropertyManager.valueChangedBoolean(898, true);
            ServiceManager.aslPropertyManager.valueChangedString(884, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation).getMmiInternalDataValue(2));
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(898, false);
        }
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: handleCommandCmdTryBestMatch()");
        }
        boolean bl2 = this.selectedAdbEntry.getEntryType() == 4;
        boolean bl3 = bl = this.selectedAdbEntry.getEntryType() == 5;
        if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation != null) {
            NavLocation navLocation;
            if (bl) {
                ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation);
                iLocationWrapper.setMmiInternalDataValue(1, this.selectedAdbEntry.getCombinedName());
                navLocation = iLocationWrapper.getLocation();
            } else {
                navLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, !navLocation.isPositionValid());
            this.setGetEntryReceived(true);
            this.setLocationForDetailsScreen(this.selectedAdbEntry, navLocation, this.selectedAdbEntry.getCombinedName(), bl2, this.selectedAddress.isTopDestination(), false, bl);
        } else {
            this.sendTryBestMatch(this.selectedAddress);
        }
    }

    @Override
    public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: handleCommandCmdTryBestMatch()");
        }
        boolean bl2 = this.selectedAdbEntry.getEntryType() == 4;
        boolean bl3 = bl = this.selectedAdbEntry.getEntryType() == 5;
        if (cmdTryBestMatch.liTryBestMatchResult_result != null && cmdTryBestMatch.liTryBestMatchResult_result.length > 0) {
            TryBestMatchResultData tryBestMatchResultData = cmdTryBestMatch.liTryBestMatchResult_result[0];
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(tryBestMatchResultData.getLocation());
            iLocationWrapper.setMmiInternalDataValue(1, this.selectedAdbEntry.getCombinedName());
            NavLocation navLocation = iLocationWrapper.getLocation();
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, !navLocation.isPositionValid());
            this.setGetEntryReceived(true);
            this.setLocationForDetailsScreen(this.selectedAdbEntry, navLocation, this.selectedAdbEntry.getCombinedName(), bl2, this.selectedAddress.isTopDestination(), false, bl);
            MEMORY_DP.setCurrentlySelectedAddressName(navLocation);
        } else {
            NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper().getLocation();
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
            this.setLocationForDetailsScreen(this.selectedAdbEntry, navLocation, "", bl2, this.selectedAddress.isTopDestination(), false, bl);
            MEMORY_DP.setCurrentlySelectedAddressName(navLocation);
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 1);
            this.sendHMIEvent(78);
        }
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry entered dsiAdbListGetViewWindowResult()");
        }
        if (n == 0 && n2 > 0 && dataSetArray != null && dataSetArray.length > 0 && !this.listIndexReceived && dataSetArray.length == 1 && dataSetArray[0].getEntryId() == this.selectedEntryId) {
            this.listIndexReceived = true;
            this.sendSelectFinishedEvent();
        }
    }

    private AdbEntry findAdbEntryWithId(AdbEntry[] adbEntryArray, long l) {
        for (int i2 = 0; i2 < adbEntryArray.length; ++i2) {
            AdbEntry adbEntry = adbEntryArray[i2];
            if (adbEntry.getEntryId() != l) continue;
            return adbEntry;
        }
        return null;
    }

    private void sendTryBestMatch(AddressData addressData) {
        TryBestMatchData tryBestMatchData = new TryBestMatchData();
        tryBestMatchData.country = addressData.getCountry() != null ? addressData.getCountry() : "";
        tryBestMatchData.postalCode = addressData.getPostalCode() != null ? addressData.getPostalCode() : "";
        tryBestMatchData.locality = addressData.getLocality() != null ? addressData.getLocality() : "";
        tryBestMatchData.region = addressData.getRegion() != null ? addressData.getRegion() : "";
        tryBestMatchData.streedAndOrHouseNumber = addressData.getStreet() != null ? addressData.getStreet() : "";
        tryBestMatchData.unstructured = addressData.getGeoPosition() != null ? addressData.getGeoPosition() : "";
        new CmdTryBestMatch(this, tryBestMatchData).execute();
    }

    private void sendLiGetLocationDescriptionTransform(int[] nArray) {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(nArray[0], nArray[1]).getLocation();
        new CmdGetLocationDescriptionTransform(this, navLocation).execute();
    }

    private void setLocationForDetailsScreen(AdbEntry adbEntry, NavLocation navLocation, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        if (adbEntry != null) {
            iLocationWrapper = this.setPhoneNumberFromAdbEntryToLocation(adbEntry, iLocationWrapper);
        }
        NAVIGATION_DP.setMemoryLocation(iLocationWrapper.getLocation());
        NAVIGATION_DP.setMemoryLocationIsTopDest(bl2);
        NAVIGATION_DP.setSaveCorrectedAddressToEntry(bl || bl4);
        int n = bl2 ? 28 : 25;
        this.setMapToLocation(navLocation, n);
        NavigationMemoryDestinationDetailsCollector navigationMemoryDestinationDetailsCollector = bl4 ? MemoryFormatter.createMemoryOnlineDestinationDetails(iLocationWrapper, this.selectedAddress, string) : MemoryFormatter.createMemoryDestinationDetails(iLocationWrapper, string);
        ListManager.getGenericASLList(910).updateList(new Object[]{navigationMemoryDestinationDetailsCollector});
        ServiceManager.aslPropertyManager.valueChangedBoolean(891, bl || bl4);
        ServiceManager.aslPropertyManager.valueChangedBoolean(895, NAVIGATION_DP.isMemoryLocationTopDest());
        ServiceManager.aslPropertyManager.valueChangedBoolean(896, bl3);
        ServiceManager.aslPropertyManager.valueChangedString(887, string);
        this.sendSelectFinishedEvent();
    }

    private ILocationWrapper setPhoneNumberFromAdbEntryToLocation(AdbEntry adbEntry, ILocationWrapper iLocationWrapper) {
        if (StringUtil.isEmpty(iLocationWrapper.getMmiInternalDataValue(4))) {
            String string = adbEntry.phoneData.length > 0 ? adbEntry.phoneData[0].getNumber() : "";
            iLocationWrapper.setMmiInternalDataValue(4, string);
        }
        return iLocationWrapper;
    }

    private void sendSelectFinishedEvent() {
        if (MEMORY_DP.isMemoryStatusRequestReceived() && this.isGetEntryReceived()) {
            if (this.isTraceEnabled()) {
                this.trace("TargetNavMemLoadEntry.sendSelectFinished()");
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
            this.sendHMIEvent(100);
            MEMORY_DP.setMemoryStatusRequestReceived(false);
            this.setGetEntryReceived(false);
        }
    }

    private void setMapToLocation(NavLocation navLocation, int n) {
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, n, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(5, mapConfiguration);
    }

    private void handleOrganizerError(String string) {
        this.provideSpeechSelectContactAddressData(0, 0L);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext(string);
    }

    private void provideSpeechSelectContactAddressData(int n, long l) {
        if (this.wasSpeechSelect) {
            NavigationSpeechRecognizedContactCollector navigationSpeechRecognizedContactCollector = new NavigationSpeechRecognizedContactCollector();
            navigationSpeechRecognizedContactCollector.navigation_speech_selected_contact_address_count = n;
            navigationSpeechRecognizedContactCollector.navigation_speech_selected_contact_entry_id = l;
            navigationSpeechRecognizedContactCollector.navigation_speech_selected_contact_name = this.selectedAdbEntry.getCombinedName();
            ListManager.getGenericASLList(992).updateList(new NavigationSpeechRecognizedContactCollector[]{navigationSpeechRecognizedContactCollector});
            this.sendHMIEvent(108);
            this.wasSpeechSelect = false;
            if (this.isTraceEnabled()) {
                this.trace().append("TargetNavMemLoadEntry.provideSpeechSelectContactAddressData: #Addresses available: ").append(n).log();
            }
        }
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (n == 2) {
            if (!this.organizerReady) {
                this.initOrganizerDSI();
            }
            this.organizerReady = true;
        } else {
            if (this.organizerReady) {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.adbEditListener);
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListListener);
            }
            this.organizerReady = false;
        }
    }

    private void initOrganizerDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry tries to register to organizer...").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2);
        this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2);
        this.adbEditListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
        this.adbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.adbEditListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry registered to organizer").log();
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiNavigation();
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern() && !this.isFirstStartupDone) {
            this.initDsiAdbSetup();
        }
        if (this.dsiNavigation != null && this.dsiAdbSetup != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiAdbSetup() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry tries to register to ").append("DsiAdbSetup...").log();
        }
        this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
        this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry registered to ").append("DsiAdbSetup").log();
        }
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry tries to register to ").append("DsiNavigation...").log();
        }
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiNavigation.setNotification(65, this.dsiNavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry registered to ").append("DsiNavigation").log();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            DSIProxy dSIProxy;
            if (this.isTraceEnabled()) {
                this.trace().append("TargetNavMemLoadEntry tries to unregistered from ").append(string).append("...").log();
            }
            if ((dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy()) == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern()) {
                this.unregisterDsiAdbSetup(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiAdbSetup(String string, DSIProxy dSIProxy) {
        this.dsiAdbSetupListener = null;
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry unregistered from ").append(string).log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    private boolean isGetEntryReceived() {
        return this.getEntryReceived;
    }

    private void setGetEntryReceived(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetNavMemLoadEntry.setGetEntryReceived: ").append(bl).log();
        }
        this.getEntryReceived = bl;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetNavMemLoadEntry.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetNavMemLoadEntry.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.trace("TargetNavMemLoadEntry: resetting values after DSI restart");
            }
            this.initLocalVariables();
            if (bl) {
                this.dsiNavigation = null;
                this.dsiNavigationListener = null;
                this.initDsiNavigation();
            }
            if (bl2) {
                this.organizerReady = false;
                this.dsiAdbEdit = null;
                this.adbEditListener = null;
                this.dsiAdbList = null;
                this.adbListListener = null;
                this.dsiAdbSetup = null;
                this.dsiAdbSetupListener = null;
                this.initDsiAdbSetup();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("TargetNavMemLoadEntry: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.selectedEntryId = 0L;
        this.selectedAdbEntry = null;
        this.selectedAddresses = new AddressData[0];
        this.selectedSlot = 0;
        this.selectedAddress = null;
        this.getEntryReceived = false;
        this.listIndexReceived = false;
        this.wasSpeechSelect = false;
        this.modelSelectsAddressSlot = false;
        this.myFlagDest = null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

