/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.organizer.ASLOrganizerFactory;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.memory.ASLNavMemoryDP;
import de.vw.mib.asl.internal.navigation.memory.MemoryFormatter;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryListHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.transformer.NavigationMemoryDestinationDetailsCollector;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.PhoneData;

public class TargetAdbEdit
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    private static final int INVALID_NAME_SPELLER_HANDLE;
    private static final int SEARCH_WINDOW_SIZE;
    private static final INavigationDP NAVIGATION_DP;
    private static final ASLNavMemoryDP MEMORY_DP;
    private static final int MAX_ALLOWED_SPELLER_CHARACTERS;
    private static final int[] OBSERVERS;
    private static final int USE_CASE_SAVE;
    private static final int USE_CASE_REPLACE;
    private final SpellerData nameSpeller = new SpellerData();
    private DSIAdbEdit dsiAdbEdit;
    private DSIAdbList dsiAdbList;
    private DSINavigation dsiNavigation;
    private AdbEntry entryToSave;
    private int dsiAdbListSpellerHandle = -2;
    private long entryIdToReplace;
    private int useCase;
    private boolean entryToSaveIsTopDest;
    private NavLocation locationToSave;
    private boolean organizerReady;
    private DSIListener adbEditListener;
    private DSIListener adbListListener;
    private boolean newTopDestEntryAvailable = true;
    private boolean isServiceStateListenerAdded = false;
    private DSIListener dsiNavigationListener;
    private DSIListener dsiAdbSetupListener;
    private boolean hwrModeEnabled = false;
    private DSIAdbSetup dsiAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;

    public TargetAdbEdit(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup, this);
                }
                this.addObservers(OBSERVERS);
                ServiceManager.aslPropertyManager.valueChangedInteger(3370, 40);
                break;
            }
            case 107: {
                this.removeObservers(OBSERVERS);
                break;
            }
            case 1073742470: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: TOGGLE_DESTINATION_BELONGING_TO_TOP_DEST_LIST");
                }
                this.case_toggleTopDest();
                break;
            }
            case 1073742445: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: NEW_CONTACT_SPELLER_INIT");
                }
                this.case_navMemContactSpellerInit(eventGeneric);
                break;
            }
            case 1073742431: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: CONTACT_SPELLER_SET_CHAR");
                }
                this.case_navMemContactSpellerAddChar(eventGeneric);
                break;
            }
            case 1074841869: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: CONTACT_SPELLER_SET_CHAR_HWR");
                }
                this.case_navMemContactSpellerAddCharHwr(eventGeneric);
                break;
            }
            case 1074841868: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: CONTACT_SPELLER_CLEAR_ALL_CHARS");
                }
                ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().clear(this.nameSpeller);
                this.updateNameSpellerData();
                break;
            }
            case 1074841870: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: SET_HWR_SPELLER_MODE_ENABLED");
                }
                this.hwrModeEnabled = eventGeneric.getBoolean(0);
                ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, this.hwrModeEnabled);
                break;
            }
            case 1073742429: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: CONTACT_SPELLER_DELETE_CHAR");
                }
                this.case_navMemContactSpellerDelChar(eventGeneric);
                break;
            }
            case 1073742432: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: CONTACT_SPELLER_SET_CURSOR_POSITION");
                }
                this.case_navMemContactSpellerSetCursorPosition(eventGeneric);
                break;
            }
            case 1073743744: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: NEW_CONTACT_SPELLER_SAVE");
                }
                this.case_saveDestMemEntry();
                break;
            }
            case 1073742434: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: DELETE_ENTRY");
                }
                long l = MEMORY_DP.getMemorySelectedAdbEntry().getEntryId();
                int n = MEMORY_DP.getMemorySelectedAdbEntry().getEntryType();
                this.dsiAdbEdit.deleteEntries(new long[]{l}, NavMemoryListHandler.getViewTypeForEntryType(n), 0);
                break;
            }
            case 1073742447: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: REPLACE_EXISTING_DESTINATION_MEMORY_ENTRY");
                }
                this.case_replaceEntry();
                break;
            }
            case 1073742446: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: PREPARE_DEST_MEM_SAVE");
                }
                this.case_prepareDestMemSave(eventGeneric);
                break;
            }
            case 1073742471: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: UPDATE_DETAIL_NOT_VALID");
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
                break;
            }
            case 1073742453: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetAdbEdit: SAVE_DEST_DETAIL_NOT_VALID");
                }
                MapConfiguration mapConfiguration = new MapConfiguration(NAVIGATION_DP.getMemoryLocation(), 25, 0);
                ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(5, mapConfiguration);
                ListManager.getGenericASLList(910).updateList(new Object[]{MemoryFormatter.createMemoryDestinationDetails(NAVIGATION_DP.getMemoryLocation(), MEMORY_DP.getMemorySelectedAdbEntryName())});
                if (NAVIGATION_DP.isSaveCorrectedAddressToEntry()) {
                    this.useCase = 1;
                    this.entryToSave = MEMORY_DP.getMemorySelectedAdbEntry();
                    if (this.entryToSave != null) {
                        this.entryIdToReplace = this.entryToSave.getEntryId();
                        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(NAVIGATION_DP.getMemoryLocation());
                        this.dsiNavigation.locationToStream(iLocationWrapper.getLocation());
                    }
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
                break;
            }
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.trace("TargetAdbEdit: resetting values after DSI restart");
            }
            this.initLocalVariables();
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiAdbSetup();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("TargetAdbEdit: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiNavigation();
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern() && !this.isFirstStartupDone) {
            this.initDsiAdbSetup();
        }
        if (this.dsiNavigation != null && this.dsiAdbSetup != null && this.dsiAdbEdit != null && this.dsiAdbList != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initDsiAdbSetup() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit tries to register to ").append("DSIAdbSetup").log();
        }
        this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
        this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit registered to ").append("DSIAdbSetup").log();
        }
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit tries to register to ").append("DSINavigation...").log();
        }
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit registered to ").append("DSINavigation").log();
        }
    }

    private void initLocalVariables() {
        this.organizerReady = false;
        this.isServiceStateListenerAdded = false;
        this.dsiAdbEdit = null;
        this.dsiAdbList = null;
        this.dsiAdbListSpellerHandle = -2;
        this.dsiAdbSetup = null;
        this.dsiNavigation = null;
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (this.isTraceEnabled()) {
                this.trace().append("TargetAdbEdit tries to unregister from ").append(string).append("...").log();
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern()) {
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
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetAdbEdit.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit unregistered from ").append(string).log();
        }
    }

    public void dsiAdbEditUpdateNewPublicProfileEntryAvailable(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAdbEdit: dsiAdbEditUpdateNewPublicProfileEntryAvailable()");
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(899, !bl);
    }

    public void dsiAdbEditUpdateNewPublicProfileTopDestEntryAvailable(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAdbEdit: dsiAdbEditUpdateNewPublicProfileTopDestEntryAvailable()");
        }
        this.newTopDestEntryAvailable = bl;
    }

    public void dsiNavigationLocationToStreamResult(boolean bl, byte[] byArray) {
        if (bl) {
            AddressData[] addressDataArray = ASLPhoneFactory.getPhoneApi().ripADBAddressData(this.entryToSave.getAddressData());
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(NAVIGATION_DP.getMemoryLocation());
            if (addressDataArray.length == 0) {
                addressDataArray = new AddressData[]{new AddressData()};
                addressDataArray[0].country = iLocationWrapper.getCountry();
                addressDataArray[0].locality = iLocationWrapper.getCity();
                addressDataArray[0].postalCode = iLocationWrapper.getPostalCode();
                addressDataArray[0].street = new StringBuilder(iLocationWrapper.getStreet()).append(" ").append(iLocationWrapper.getHousenumber()).toString();
                addressDataArray[0].addressType = 2;
                addressDataArray[0].topDestination = false;
            }
            addressDataArray[0].navLocation = byArray;
            this.entryToSave.addressData = new AddressData[]{addressDataArray[0], new AddressData()};
        } else {
            this.warn("Location could not be converted to byte[], saving only raw address data");
        }
        switch (this.useCase) {
            case 1: {
                this.dsiAdbEdit.changeEntry(this.entryToSave, 0);
                break;
            }
            default: {
                this.dsiAdbEdit.insertEntry(this.entryToSave, 0);
            }
        }
    }

    public void dsiAdbEditInsertEntryResult(int n, AdbEntry adbEntry) {
        if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(901, 0);
        } else if (n == 1) {
            ServiceManager.aslPropertyManager.valueChangedInteger(901, 1);
        } else if (n == 5 || n == 6) {
            if (this.isTraceEnabled()) {
                this.trace("TargetAdbEdit: Adressbook full, cant insert new entry!");
            }
            ServiceManager.aslPropertyManager.valueChangedInteger(901, 1);
        }
        this.sendDestinationSavedFinished();
    }

    public void dsiAdbEditDeleteEntriesResult(int n) {
        if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
            if (NAVIGATION_DP.isMemoryLocationTopDest()) {
                ASLNavigationMapFactory.getNavigationMapApi().sendEvAddressBookEntryChanged(this, null);
            }
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 1);
        }
        this.sendHMIEvent(83);
    }

    public void dsiAdbEditChangeEntryResult(int n, AdbEntry adbEntry) {
        if (this.isTraceEnabled()) {
            this.trace("TargetAdbEdit: Received DSI response dsiAdbEditChangeEntryResult");
        }
        if (n == 0) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvAddressBookEntryChanged(this, adbEntry);
            MEMORY_DP.setCurrentlySelectedAddressName(NAVIGATION_DP.getMemoryLocation());
            ServiceManager.aslPropertyManager.valueChangedInteger(901, 0);
            NAVIGATION_DP.setMemoryLocationIsTopDest(ASLPhoneFactory.getPhoneApi().ripADBAddressData(adbEntry.getAddressData())[0].isTopDestination());
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(901, 1);
        }
        this.sendDestinationSavedFinished();
    }

    public void dsiAdbListStopSpellerResult(int n, int n2) {
        if (this.dsiAdbListSpellerHandle == n2) {
            this.dsiAdbListSpellerHandle = -2;
        }
    }

    public void dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 0) {
            String string3 = this.nameSpeller.getEnteredText();
            if (this.dsiAdbListSpellerHandle == -2) {
                int n4;
                this.dsiAdbListSpellerHandle = n2;
                if (string2.equalsIgnoreCase(string3)) {
                    for (n4 = 0; n4 < dataSetArray.length; ++n4) {
                        if (!dataSetArray[n4].getGeneralDescription1().equalsIgnoreCase(string3)) continue;
                        this.entryIdToReplace = dataSetArray[n4].getEntryId();
                        ((NavigationMemoryDestinationDetailsCollector)ListManager.getGenericASLList((int)910).getRowItemCacheOnly((int)0)).navigation_memory_destinations_name = string3;
                        ServiceManager.aslPropertyManager.valueChangedInteger(901, 2);
                        this.sendDestinationSavedFinished();
                        this.dsiAdbList.stopSpeller(this.dsiAdbListSpellerHandle);
                        return;
                    }
                }
                int n5 = n4 = string3.length() > 0 ? (int)string3.charAt(0) : 32;
                if (string != null && string.toLowerCase().indexOf(String.valueOf((char)n4).toLowerCase()) == -1) {
                    this.saveNewEntry();
                } else {
                    this.dsiAdbList.addSpellerChars(this.dsiAdbListSpellerHandle, String.valueOf((char)n4));
                }
            } else if (this.dsiAdbListSpellerHandle == n2) {
                if (dataSetArray.length < 20 || string2.equalsIgnoreCase(string3)) {
                    for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
                        if (!dataSetArray[i2].getGeneralDescription1().equalsIgnoreCase(string3)) continue;
                        this.entryIdToReplace = dataSetArray[i2].getEntryId();
                        ((NavigationMemoryDestinationDetailsCollector)ListManager.getGenericASLList((int)910).getRowItemCacheOnly((int)0)).navigation_memory_destinations_name = string3;
                        ServiceManager.aslPropertyManager.valueChangedInteger(901, 2);
                        this.sendDestinationSavedFinished();
                        this.dsiAdbList.stopSpeller(this.dsiAdbListSpellerHandle);
                        return;
                    }
                    this.saveNewEntry();
                } else if (string3.toLowerCase().startsWith(string2.toLowerCase())) {
                    if (string3.length() <= string2.length() || string.toLowerCase().indexOf(String.valueOf(string3.charAt(string2.length())).toLowerCase()) == -1) {
                        this.saveNewEntry();
                    } else {
                        try {
                            this.dsiAdbList.addSpellerChars(this.dsiAdbListSpellerHandle, String.valueOf(string3.charAt(string2.length())));
                        }
                        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                            this.saveNewEntry();
                        }
                    }
                } else {
                    this.saveNewEntry();
                }
            }
        } else {
            this.error("DSIAdbList speller result not successful during destination memory save sequence.");
            this.saveNewEntry();
        }
    }

    private void sendDestinationSavedFinished() {
        this.sendHMIEvent(425);
        ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
    }

    private AdbEntry prepareEntryForSerialization(ILocationWrapper iLocationWrapper) {
        AdbEntry adbEntry = this.createNewAdbEntry();
        adbEntry.phoneData[0].number = iLocationWrapper.getPhonenumber();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit.case_saveNewContact(): About to save location as new contact: ").append(iLocationWrapper.getLocation().toString()).log();
        }
        adbEntry.getPersonalData().lastName = this.nameSpeller.getEnteredText();
        ServiceManager.aslPropertyManager.valueChangedString(890, this.nameSpeller.getEnteredText());
        adbEntry.addressData[0].country = iLocationWrapper.getCountry();
        adbEntry.addressData[0].locality = iLocationWrapper.getCity();
        adbEntry.addressData[0].postalCode = iLocationWrapper.getPostalCode();
        StringBuffer stringBuffer = new StringBuffer(iLocationWrapper.getStreet());
        if (iLocationWrapper.isHousenumberAvailable()) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(iLocationWrapper.getHousenumber());
        }
        adbEntry.addressData[0].street = stringBuffer.toString();
        adbEntry.addressData[0].addressType = 2;
        double d2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(iLocationWrapper.getLatitude());
        double d3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(iLocationWrapper.getLongitude());
        adbEntry.addressData[0].geoPosition = new StringBuffer().append(d2).append(";").append(d3).toString();
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#0.000000");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            decimalFormat.setGroupingUsed(false);
            adbEntry.addressData[0].geoPosition = new StringBuilder().append(decimalFormat.format(d2)).append(";").append(decimalFormat.format(d3)).toString();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        adbEntry.addressData[0].topDestination = this.newTopDestEntryAvailable ? this.entryToSaveIsTopDest : false;
        return adbEntry;
    }

    private void saveNewEntry() {
        this.dsiAdbList.stopSpeller(this.dsiAdbListSpellerHandle);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.locationToSave);
        this.entryToSave = this.prepareEntryForSerialization(iLocationWrapper);
        this.useCase = 0;
        iLocationWrapper.setMmiInternalDataValue(1, this.nameSpeller.getEnteredText());
        this.dsiNavigation.locationToStream(iLocationWrapper.getLocation());
    }

    private void case_replaceEntry() {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.locationToSave);
        this.entryToSave = this.prepareEntryForSerialization(iLocationWrapper);
        this.entryToSave.entryId = this.entryIdToReplace;
        this.entryIdToReplace = 0L;
        this.useCase = 1;
        iLocationWrapper.setMmiInternalDataValue(1, this.nameSpeller.getEnteredText());
        this.dsiNavigation.locationToStream(iLocationWrapper.getLocation());
    }

    private void case_saveDestMemEntry() {
        if (this.dsiAdbListSpellerHandle != -2) {
            this.dsiAdbList.stopSpeller(this.dsiAdbListSpellerHandle);
            this.dsiAdbListSpellerHandle = -2;
        }
        this.dsiAdbList.startSpeller(6, 20, 2);
    }

    private void case_toggleTopDest() {
        boolean bl = false;
        AdbEntry adbEntry = MEMORY_DP.getMemorySelectedAdbEntry();
        AddressData addressData = ASLPhoneFactory.getPhoneApi().ripADBAddressData(adbEntry.getAddressData())[0];
        boolean bl2 = !addressData.isTopDestination();
        addressData.topDestination = bl = bl2;
        if (addressData.getAddressType() == 0) {
            addressData.addressType = 2;
        }
        if (bl && !this.containsGeoCoordinate(addressData)) {
            addressData.geoPosition = this.encodeGeoPositionToVCard3_0(NAVIGATION_DP.getMemoryLocation());
        }
        adbEntry.addressData = new AddressData[]{addressData, new AddressData()};
        this.dsiAdbEdit.changeEntry(adbEntry, 0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(895, bl);
        MapConfiguration mapConfiguration = null;
        mapConfiguration = !bl ? new MapConfiguration(NAVIGATION_DP.getMemoryLocation(), 25, 0) : new MapConfiguration(NAVIGATION_DP.getMemoryLocation(), 28, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(5, mapConfiguration);
    }

    private String encodeGeoPositionToVCard3_0(NavLocation navLocation) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#0.000000", decimalFormatSymbols);
        String string = decimalFormat.format(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(iLocationWrapper.getLatitude()));
        String string2 = decimalFormat.format(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(iLocationWrapper.getLongitude()));
        return string.concat(";").concat(string2);
    }

    private boolean containsGeoCoordinate(AddressData addressData) {
        return !StringUtil.isEmpty(addressData.getGeoPosition());
    }

    private void case_navMemContactSpellerInit(EventGeneric eventGeneric) {
        if (this.locationToSave != null) {
            if (this.isTraceEnabled()) {
                this.trace().append("TargetAdbEdit: Location to save: ").append(this.locationToSave.toString()).log();
            }
            FixFormatterFieldData fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.locationToSave));
            int n = 10 + ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
            String string = ServiceManager.fixFormat4Asl.fmtRulesetBasedString(n, fixFormatterFieldData);
            if (string.length() > 40) {
                string = string.substring(0, 40);
            }
            this.nameSpeller.setEnteredText(string);
        } else {
            this.nameSpeller.setEnteredText("");
        }
        this.nameSpeller.setCursorPosition(this.nameSpeller.getEnteredText().length());
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().selectAll(this.nameSpeller);
        this.updateNameSpellerData();
    }

    private void case_navMemContactSpellerAddCharHwr(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        if (this.hwrModeEnabled) {
            int n = eventGeneric.getInt(1);
            int n2 = eventGeneric.getInt(2);
            int n3 = eventGeneric.getInt(3);
            this.addChar(string, n, n2, n3);
        } else {
            this.addChar(string, this.nameSpeller.getCursorPosition(), 0, 0);
        }
    }

    private void case_navMemContactSpellerAddChar(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        this.addChar(string, this.nameSpeller.getCursorPosition(), 0, 0);
    }

    private void addChar(String string, int n, int n2, int n3) {
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().addChar(this.nameSpeller, string);
        this.nameSpeller.setSelectionStart(n2);
        this.nameSpeller.setSelectionEnd(n3);
        if (this.isTraceEnabled()) {
            this.trace().append("spellerString: ").append(this.nameSpeller.getEnteredText()).log();
        }
        this.updateNameSpellerData();
    }

    private void case_navMemContactSpellerDelChar(EventGeneric eventGeneric) {
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deleteChar(this.nameSpeller);
        if (this.isTraceEnabled()) {
            this.trace().append("spellerString: ").append(this.nameSpeller.getEnteredText()).log();
        }
        this.updateNameSpellerData();
    }

    private void case_navMemContactSpellerSetCursorPosition(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deselectAll(this.nameSpeller);
        this.nameSpeller.setCursorPosition(n);
        this.updateNameSpellerData();
    }

    private void case_prepareDestMemSave(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.entryToSaveIsTopDest = false;
        switch (n) {
            case 1: {
                this.locationToSave = NAVIGATION_DP.getRouteInfoLocation();
                break;
            }
            case 2: {
                this.locationToSave = NAVIGATION_DP.getDestInputLocation();
                break;
            }
            case 3: {
                this.locationToSave = NAVIGATION_DP.getPOILocation();
                break;
            }
            case 5: 
            case 8: 
            case 9: {
                this.locationToSave = NAVIGATION_DP.getMapInputLocation();
                break;
            }
            case 4: {
                this.locationToSave = NAVIGATION_DP.getMemoryLocation();
                break;
            }
            case 10: {
                this.locationToSave = NAVIGATION_DP.getDetailViewLocation();
                break;
            }
            default: {
                this.entryToSaveIsTopDest = NAVIGATION_DP.isMemoryLocationTopDest();
                this.locationToSave = NAVIGATION_DP.getMemoryLocation();
            }
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(896, false);
        NAVIGATION_DP.setMemoryLocation(this.locationToSave);
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (n == 2) {
            if (!this.organizerReady) {
                this.initOrganizerDSI();
            }
            this.organizerReady = true;
        } else {
            if (this.organizerReady) {
                if (this.isTraceEnabled()) {
                    this.trace().append("TargetAdbEdit unregisters from organizer...").log();
                }
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListListener);
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbEditListener);
            }
            this.organizerReady = false;
        }
        if (this.dsiNavigation != null && this.dsiAdbSetup != null && this.dsiAdbEdit != null && this.dsiAdbList != null) {
            this.isFirstStartupDone = true;
        }
    }

    private void initOrganizerDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit tries to register to organizer...").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2);
        this.adbEditListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.adbEditListener);
        this.dsiAdbEdit.setNotification(2, this.adbEditListener);
        this.dsiAdbEdit.setNotification(4, this.adbEditListener);
        this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2);
        this.adbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetAdbEdit.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListListener);
        this.dsiAdbList.setNotification(2, this.adbListListener);
    }

    private void updateNameSpellerData() {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetAdbEdit: Updated speller entered Text: ").append(this.nameSpeller.getEnteredText()).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(2921, this.nameSpeller.getEnteredText().trim().length() > 0);
        TargetAdbEdit.writeSpellerDataToDatapool(888, this.nameSpeller);
    }

    private AdbEntry createNewAdbEntry() {
        AdbEntry adbEntry = ASLOrganizerFactory.getOrganizerApi().createNewEntry();
        adbEntry.addressData = new AddressData[]{new AddressData()};
        adbEntry.addressData[0].addressType = 2;
        adbEntry.entryType = 4;
        adbEntry.phoneData = new PhoneData[]{new PhoneData()};
        adbEntry.phoneData[0].number = "";
        adbEntry.phoneData[0].numberType = 4;
        return adbEntry;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
        MEMORY_DP = ASLNavMemoryDP.getInstance();
        OBSERVERS = new int[]{-2046689216, 1828847680, -2147024832, 1593966656, 1627521088, 214503488, 231280704, 1560412224, 248057920, 1963065408, 1644298304, 1845624896, 1862402112, 1610743872, -2029912000};
    }
}

