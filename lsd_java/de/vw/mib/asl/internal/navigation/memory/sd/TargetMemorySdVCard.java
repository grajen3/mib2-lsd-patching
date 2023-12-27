/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory.sd;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.memory.ASLNavMemoryDP;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import edu.emory.mathcs.backport.java.util.LinkedList;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDImportingSDEntryListDataCollector;
import generated.de.vw.mib.asl.internal.navigation.memory.sd.transformer.NavigationMemorySDVCardImportBrowserResultsCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DSIAdbVCardExchange;

public class TargetMemorySdVCard
extends AbstractASLTarget
implements ASLListElementFetcher,
DSIServiceStateListener {
    private static final int WINDOW_SIZE;
    private DSIAdbVCardExchange dsiAdbVCardExchange;
    private int vCardUseCase;
    private int fileBrowserSessionHandle;
    private boolean fileBrowserSessionActive;
    private boolean parseVCardResultReceived;
    private GenericASLList modelVCardList;
    private Path currentPath;
    private int countWindowsReceived;
    private int countImportsReceived;
    private boolean lastImportVCardSent;
    private int importFileCount;
    private int countImportFailure;
    private int countImportSuccess;
    private boolean organizerReady;
    private LinkedList eventQueue = new LinkedList();
    private boolean eventQueueBlocked = false;
    private DSIListener dsiAdbSetupListener;
    private boolean errorHandlingActive;
    private boolean expectImportVCardResult;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchange;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;

    public TargetMemorySdVCard(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerObservers();
                this.initASL();
                this.fileBrowserSessionActive = false;
                this.initVCardImport();
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup, this);
                ServiceManager.aslPropertyManager.valueChangedResourceLocator(913, null);
                break;
            }
            case 107: {
                this.unregisterObservers();
                break;
            }
            case 1073742491: {
                this.case_startVCardImport();
                break;
            }
            case 100110: {
                this.case_fileBrowserResolveResourceLocatorsImport(eventGeneric);
                break;
            }
            case 1073742479: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdVCard: ASL_NAVIGATION_MEMORY_SD_LOADV_CARDS");
                }
                this.sendHMIEvent(105);
                break;
            }
            case 1073742482: {
                this.case_selectVCardFromList(eventGeneric);
                break;
            }
            case 100109: {
                this.case_filebrowserResolveResourceLocatorNavigation(eventGeneric);
                break;
            }
            case 1073742489: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdVCard: ASL_NAVIGATION_MEMORY_SD_SET_VCARD_USE_CASE");
                }
                this.vCardUseCase = eventGeneric.getInt(0);
                break;
            }
            case 100106: {
                this.case_fileBrowserDirectoryChanged(eventGeneric);
                break;
            }
            case 100107: {
                this.case_startSessionWithParametersResult(eventGeneric);
                break;
            }
            case 100108: {
                this.case_filebrowserGetEntriesResult(eventGeneric);
                break;
            }
            case 1073743927: {
                this.sendSelectFinishedEvent();
                break;
            }
            case 1073744066: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetMemorySdVCard: ASL_NAVIGATION_MEMORY_SD_RESET_FILEBROWSER_PATH_RECEIVED");
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(3014, false);
                break;
            }
            case 2500021: {
                this.case_filebrowserUpdateSessionClosed(eventGeneric);
                break;
            }
        }
    }

    private void case_startVCardImport() {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: START_V_CARD_IMPORT");
            this.trace().append("TargetMemorySdVCard: Expected number of windows: ").append(this.getTotalWindowCount()).log();
        }
        if (this.importFileCount == 0) {
            NavigationMemorySDVCardImportBrowserResultsCollector navigationMemorySDVCardImportBrowserResultsCollector = (NavigationMemorySDVCardImportBrowserResultsCollector)ListManager.getGenericASLList(929).getRowItemCacheOnly(0);
            navigationMemorySDVCardImportBrowserResultsCollector.navigation_memory_sd_v_card_import_browser_results_number_available_items = 0;
            navigationMemorySDVCardImportBrowserResultsCollector.navigation_memory_sd_v_card_import_browser_results_number_imported_items = 0;
            navigationMemorySDVCardImportBrowserResultsCollector.navigation_memory_sd_v_card_import_browser_results_number_failed_items = 0;
            ListManager.getGenericASLList(929).updateList(new Object[]{navigationMemorySDVCardImportBrowserResultsCollector});
            return;
        }
        this.expectImportVCardResult = true;
        for (int i2 = 0; i2 < this.importFileCount; i2 += 20) {
            if (this.isTraceEnabled()) {
                this.trace().append("TargetMemorySdVCard: sending fetchItems ").append(i2 / 20 + 1).append("/").append(this.getTotalWindowCount()).log();
            }
            this.fetchItems(null, i2, 20);
        }
    }

    private void case_selectVCardFromList(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: ASL_NAVIGATION_MEMORY_SD_SELECT_DEST_LIST_V_CARD");
        }
        int n = eventGeneric.getInt(0);
        BrowsedFile browsedFile = (BrowsedFile)this.modelVCardList.getRowItemCacheOnly(n);
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1058336256, 226951424, -1608178176);
        eventGeneric2.setObject(1, new BrowsedFileSet(this.currentPath, new BrowsedFile[]{browsedFile}));
        this.send(eventGeneric2);
    }

    private void case_startSessionWithParametersResult(EventGeneric eventGeneric) {
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: EV_HANDLE_FILEBROWSER_START_SESSION_WITH_PARAMETERS_RESULT");
        }
        if (bl = eventGeneric.getBoolean(0)) {
            this.fileBrowserSessionActive = true;
            this.fileBrowserSessionHandle = eventGeneric.getInt(1);
            this.importFileCount = eventGeneric.getInt(2);
            if (this.isTraceEnabled()) {
                this.trace().append("TargetMemorySdVCard: Total vCard file count in directory:").append(this.importFileCount).log();
            }
            if (this.vCardUseCase == 0) {
                this.sendHMIEvent(106);
                ServiceManager.aslPropertyManager.valueChangedBoolean(3014, true);
            } else if (this.vCardUseCase == 1) {
                this.modelVCardList.setSize(0);
                this.modelVCardList.setSize(this.importFileCount);
            }
        } else {
            this.handleFileBrowserImportError();
        }
    }

    private void case_fileBrowserDirectoryChanged(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: EV_FILEBROWSER_DIRECTORY_CHANGED");
        }
        this.stopOldFileBrowserSession();
        this.currentPath = (Path)eventGeneric.getObject(0);
        this.startNewFileBrowserSession();
        if (this.vCardUseCase == 1) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(3014, true);
            this.sendHMIEvent(106);
        }
    }

    private void case_filebrowserGetEntriesResult(EventGeneric eventGeneric) {
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: EV_FILEBROWSER_GET_ENTRIES_RESULT");
        }
        if (bl = eventGeneric.getBoolean(1)) {
            if (this.vCardUseCase == 0) {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1058336256, 243728640, -1608178176);
                eventGeneric2.setObject(1, eventGeneric.getObject(3));
                this.send(eventGeneric2);
            } else if (this.vCardUseCase == 1) {
                int n = eventGeneric.getInt(2);
                BrowsedFileSet browsedFileSet = (BrowsedFileSet)eventGeneric.getObject(3);
                this.modelVCardList.updateListItems(n, browsedFileSet.getFiles());
                this.eventQueueBlocked = false;
                this.sendNextEvent();
            }
        } else {
            this.handleFileBrowserImportError();
        }
    }

    private void case_fileBrowserResolveResourceLocatorsImport(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: EV_HANDLE_FILEBROWSER_RESOLVE_RESOURCE_LOCATORS_IMPORT");
        }
        this.eventQueueBlocked = false;
        boolean bl = eventGeneric.getBoolean(0);
        if (bl && this.organizerReady) {
            this.sendNextEvent();
            ResourceLocator[] resourceLocatorArray = (ResourceLocator[])eventGeneric.getObject(1);
            this.dsiAdbVCardExchange.importVCard(resourceLocatorArray, 0);
            ++this.countWindowsReceived;
            if (this.countWindowsReceived >= this.getTotalWindowCount()) {
                this.sendEmptyVCard();
            }
        } else {
            this.handleFileBrowserImportError();
        }
    }

    private void case_filebrowserResolveResourceLocatorNavigation(EventGeneric eventGeneric) {
        ResourceLocator[] resourceLocatorArray;
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: EV_HANDLE_FILEBROWSER_RESOLVE_RESOURCE_LOCATOR_NAVIGATION");
        }
        if ((bl = eventGeneric.getBoolean(0)) && this.organizerReady && (resourceLocatorArray = (ResourceLocator[])eventGeneric.getObject(1)) != null && resourceLocatorArray.length == 1 && resourceLocatorArray[0] != null) {
            ResourceLocator resourceLocator = resourceLocatorArray[0];
            this.dsiAdbVCardExchange.parseVCard(resourceLocator.getUrl());
        }
    }

    private void case_filebrowserUpdateSessionClosed(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == this.fileBrowserSessionHandle) {
            if (this.isTraceEnabled()) {
                this.trace("TargetMemorySdVCard: UPDATE_SESSION_CLOSED received");
            }
            this.stopOldFileBrowserSession();
        }
    }

    private void handleFileBrowserImportError() {
        if (!this.errorHandlingActive) {
            if (this.isTraceEnabled()) {
                this.warn("TargetMemorySdVCard: handleFileBrowserImportError");
            }
            this.stopOldFileBrowserSession();
            this.countWindowsReceived = this.getTotalWindowCount();
            this.errorHandlingActive = true;
            this.eventQueue.clear();
            this.sendEmptyVCard();
        }
    }

    private void startNewFileBrowserSession() {
        if (!this.fileBrowserSessionActive) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1058336256, 193396992, 143327488);
            eventGeneric.setObject(0, this.currentPath);
            eventGeneric.setInt(1, 3);
            eventGeneric.setBoolean(2, true);
            this.sendSafe(eventGeneric);
            if (this.isTraceEnabled()) {
                this.trace().append("TargetMemorySdVCard: requested activation of source ").append(this.currentPath.toString()).log();
            }
        }
    }

    private void stopOldFileBrowserSession() {
        if (this.fileBrowserSessionActive) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1058336256, -1272633856);
            eventGeneric.setInt(0, this.fileBrowserSessionHandle);
            this.sendSafe(eventGeneric);
            if (this.isTraceEnabled()) {
                this.trace("TargetMemorySdVCard: Stopping FileBrowser session");
            }
            this.fileBrowserSessionActive = false;
        }
    }

    private void sendEmptyVCard() {
        if (!this.lastImportVCardSent) {
            if (this.isTraceEnabled()) {
                this.trace("TargetMemorySdVCard: Queueing empty importVCard() at end of sequence");
            }
            this.dsiAdbVCardExchange.importVCard(null, 0);
            this.lastImportVCardSent = true;
        }
    }

    private void importDone() {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetMemorySdVCard: Import done, total counts: ").append(this.countImportSuccess).append("/").append(this.countImportFailure).append(" received in ").append(this.countImportsReceived - 1).append("(+1 empty) import windows.").log();
        }
        this.updateImportResultPopupData();
        this.updateImportStatus(true, 100);
        this.initVCardImport();
        this.expectImportVCardResult = false;
    }

    private void updateImportStatus(boolean bl, int n) {
        NavigationMemorySDImportingSDEntryListDataCollector navigationMemorySDImportingSDEntryListDataCollector = new NavigationMemorySDImportingSDEntryListDataCollector();
        navigationMemorySDImportingSDEntryListDataCollector.navigation_memory_sd_importing_sd_entry_list_data_progress = n;
        navigationMemorySDImportingSDEntryListDataCollector.navigation_memory_sd_importing_sd_entry_list_data_state = bl ? 2 : 1;
        ListManager.getGenericASLList(924).updateList(new Object[]{navigationMemorySDImportingSDEntryListDataCollector});
    }

    private void updateImportResultPopupData() {
        NavigationMemorySDVCardImportBrowserResultsCollector navigationMemorySDVCardImportBrowserResultsCollector = (NavigationMemorySDVCardImportBrowserResultsCollector)ListManager.getGenericASLList(929).getRowItemCacheOnly(0);
        navigationMemorySDVCardImportBrowserResultsCollector.navigation_memory_sd_v_card_import_browser_results_number_imported_items = this.countImportSuccess;
        navigationMemorySDVCardImportBrowserResultsCollector.navigation_memory_sd_v_card_import_browser_results_number_failed_items = this.countImportFailure;
        navigationMemorySDVCardImportBrowserResultsCollector.navigation_memory_sd_v_card_import_browser_results_number_available_items = this.countImportSuccess + this.countImportFailure;
        ListManager.getGenericASLList(929).updateList(new Object[]{navigationMemorySDVCardImportBrowserResultsCollector});
    }

    private void sendSelectFinishedEvent() {
        if (ASLNavMemoryDP.getInstance().isMemoryStatusRequestReceived() && this.parseVCardResultReceived) {
            this.sendHMIEvent(100);
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
            ASLNavMemoryDP.getInstance().setMemoryStatusRequestReceived(false);
            this.parseVCardResultReceived = false;
        }
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (!this.organizerReady && n == 2 && n2 == 1) {
            this.initOrganizerDSI();
            this.organizerReady = true;
        }
        if (this.organizerReady && n != 2 && n2 == 1) {
            this.deregisterFromOrganizer();
            this.organizerReady = false;
        }
    }

    public void dsiAdbVCardExchangeImportVCardResult(int n, int n2, int n3, int n4) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetMemorySdVCard.dsiAdbVCardExchangeImportVCardResult: Imported vCards window (success/failed): ").append(n2).append("/").append(n3).log();
        }
        if (this.expectImportVCardResult) {
            this.countImportSuccess += n2;
            this.countImportFailure += n3;
            ++this.countImportsReceived;
            this.updateImportStatus(false, (int)((float)this.countImportsReceived / (float)this.getTotalWindowCount() * 51266));
            if (n4 != 0 && this.isTraceEnabled()) {
                this.trace().append("TargetMemorySdVCard: Not all vCards were imported. Reason: ").append(n4);
            }
        }
        if (this.emptyVCardReceived(n, n2, n3, n4)) {
            this.importDone();
        }
    }

    private boolean emptyVCardReceived(int n, int n2, int n3, int n4) {
        return this.lastImportVCardSent && n == 0 && n2 == 0 && n3 == 0 && n4 == 0;
    }

    public void dsiAdbVCardExchangeParseVCardResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0 && this.isTraceEnabled()) {
            this.trace().append("TargetMemorySdVCard: Parsed vCard and resolved address: ").append(adbEntryArray[0].getAddressData()[0].toString()).log();
        }
        this.parseVCardResultReceived = true;
        this.sendSelectFinishedEvent();
    }

    public void dsiAdbVCardExchangeAsyncException(int n, String string, int n2) {
        if (n2 == 1000) {
            this.warn().append("Importing vCards timed out! Error code: ").append(n).append(", Error message: ").append(string).log();
            this.sendNextEvent();
        }
    }

    private void initVCardImport() {
        this.trace("TargetMemorySdVCard: Initializing VCard Import");
        this.countWindowsReceived = 0;
        this.countImportsReceived = 0;
        this.lastImportVCardSent = false;
        this.importFileCount = 0;
        this.countImportFailure = 0;
        this.countImportSuccess = 0;
        this.eventQueueBlocked = false;
        this.eventQueue.clear();
        this.parseVCardResultReceived = false;
        this.errorHandlingActive = false;
        this.updateImportStatus(true, 0);
        this.stopOldFileBrowserSession();
    }

    private void initASL() {
        this.modelVCardList = ListManager.getGenericASLList(922);
        this.modelVCardList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 20, 0);
        this.modelVCardList.setColumn4ObjectId(0);
    }

    private void initOrganizerDSI() {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: Registering as DSIAdbVCardExchange listener!");
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbVCardExchange = (DSIAdbVCardExchange)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchange == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchange = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbVCardExchange")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchange);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener, dSIListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendNextEvent() {
        if (!this.eventQueueBlocked && this.eventQueue.size() > 0) {
            try {
                this.trace("TargetMemorySdVCard: Sending next getEntries event to filebrowser. Remaining events in queue after this: ", this.eventQueue.size() - 1);
                this.send((EventGeneric)this.eventQueue.getFirst());
                this.eventQueueBlocked = true;
            }
            catch (GenericEventException genericEventException) {
                this.error("NavigationMemorySd.FileBrowserHelper - Exception while requesting entries from FileBrowser. Continue with next import window.");
            }
            finally {
                this.eventQueue.removeFirst();
            }
        }
    }

    private int getTotalWindowCount() {
        return (this.importFileCount + 20 - 1) / 20;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetMemorySdVCard: fetch items called: ").append(n).append("  ").append(n2).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1058336256, 210174208, -1507514880);
        eventGeneric.setInt(0, this.fileBrowserSessionHandle);
        eventGeneric.setInt(1, n);
        eventGeneric.setInt(2, n2);
        this.eventQueue.addLast(eventGeneric);
        this.sendNextEvent();
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName())) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            DSIAdbSetup dSIAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
            this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
            dSIAdbSetup.setNotification(1, this.dsiAdbSetupListener);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName())) {
            if (this.isTraceEnabled()) {
                this.trace().append("TargetMemorySdVCard tries to unregister from ").append(string).log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDsiAdbSetup(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void registerObservers() {
        this.addObserver(-1946025920);
        this.addObserver(-2013134784);
        this.addObserver(-1895694272);
        this.addObserver(-1845362624);
        this.addObserver(-1694367680);
        this.addObserver(-1727922112);
        this.addObserver(-1039663040);
        this.addObserver(-1255856640);
    }

    private void unregisterObservers() {
        this.removeObserver(-1946025920);
        this.removeObserver(-2013134784);
        this.removeObserver(-1895694272);
        this.removeObserver(-1845362624);
        this.removeObserver(-1694367680);
        this.removeObserver(-1727922112);
        this.removeObserver(-1039663040);
        this.removeObserver(-1255856640);
    }

    private void unregisterDsiAdbSetup(String string, DSIProxy dSIProxy) {
        this.dsiAdbSetupListener = null;
        this.traceUnregisteredDone(string);
    }

    private void deregisterFromOrganizer() {
        if (this.isTraceEnabled()) {
            this.trace("TargetMemorySdVCard: Unregistering as DSIAdbVCardExchange listener!");
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener);
        dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener == null ? (class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener = TargetMemorySdVCard.class$("org.dsi.ifc.organizer.DSIAdbVCardExchangeListener")) : class$org$dsi$ifc$organizer$DSIAdbVCardExchangeListener, dSIListener);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetMemorySdVCard unregistered from ").append(string).log();
        }
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

