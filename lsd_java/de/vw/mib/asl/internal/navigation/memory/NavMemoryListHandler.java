/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryListHandler$ViewWindowRequestData;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbSetup;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public class NavMemoryListHandler
extends AbstractResettableNavGatewayTarget
implements ASLListElementFetcher,
DSIServiceStateListener,
ASLOnlineServiceListener {
    public static final int VIEWTYPE_ONLINE;
    public static final int VIEWTYPE_FAVORITES;
    public static final int VIEWTYPE_PHONE_CONTACTS;
    public static final int VIEWTYPE_DEST_MEM;
    private static final int MEMORY_LIST_FETCH_TIMEOUT;
    private static final int[] OBSERVERS;
    private static final int WINDOW_SIZE;
    private static final INavigationDP NAVIGATION_DP;
    private LinkedList getViewWindowQueue = new LinkedList();
    private boolean organizerReady;
    private DSIAdbList dsiAdbList = null;
    private DSINavigation dsiNavigation = null;
    private DSIAdbSetup dsiAdbSetup = null;
    private DSIListener adbListListener;
    private DSIListener adbUserProfileListener;
    private DSIListener dsiAdbSetupListener;
    private AdbViewSize viewSize;
    private boolean requestUnderway;
    private String flagDestName = "";
    private boolean isServiceStateListenerAdded = false;
    private boolean isDestinationImportActive;
    private boolean onlineServiceAvailable = false;
    private boolean onlineServiceFirstUpdate = true;
    private final ASLOnlineCoreServices onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetup;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;

    public NavMemoryListHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: NAVI_TARGET_PREPARE_ON");
                }
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryListHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup, this);
                }
                this.initModelLists();
                break;
            }
            case 101001: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: NAVI_TARGET_GO_ON");
                }
                this.addObservers(OBSERVERS);
                this.onlineServiceFirstUpdate = true;
                this.onlineCoreServices.registerForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(9), this);
                break;
            }
            case 101000: {
                this.onlineCoreServices.unRegisterForServiceUpdate(this.onlineCoreServices.getServiceIDWithNumericServiceID(9), this);
                break;
            }
            case 1073742435: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: ASL_NAVIGATION_MEMORY_DESTINATION_ITEM_SET_AS_CURRENT_DEST");
                }
                this.caseSetDestinationAsCurrentDest();
                break;
            }
            case 1073742448: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: ASL_NAVIGATION_MEMORY_RESET_FLAG_DEST_SAVING_STATE");
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(897, false);
                break;
            }
            case 1073742469: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: ASL_NAVIGATION_MEMORY_STORE_FLAG_DEST");
                }
                PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
                new CmdGetLocationDescriptionTransform(this, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition.getLatitude(), posPosition.getLongitude()).getLocation()).execute();
                break;
            }
            case 0x40000640: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: ASL_NAVIGATION_MEMORY_SET_FLAG_DEST_NAME");
                }
                this.flagDestName = eventGeneric.getString(0);
                break;
            }
            case 3500006: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: ASL_ORGANIZER_FACTORY_SETTINGS_RESTORED");
                }
                this.dsiAdbList.setListStyle(0, 1, 0);
                break;
            }
            case 3499061: {
                if (this.isTraceEnabled()) {
                    this.trace("NavMemoryListHandler: EV_DESTINATION_IMPORT_ACTIVE");
                }
                this.caseDestinationImportActive(eventGeneric);
                break;
            }
        }
    }

    private void caseDestinationImportActive(EventGeneric eventGeneric) {
        boolean bl;
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler.caseDestinationImportActive");
        }
        boolean bl2 = !(bl = eventGeneric.getBoolean(0)) && this.isDestinationImportActive;
        this.isDestinationImportActive = bl;
        if (bl2) {
            this.updateListsSize(this.viewSize.getPublicProfileEntries(), this.viewSize.getPublicTopDestinations(), this.viewSize.getNavi(), this.viewSize.getOnlineDestination());
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryListHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                if (this.isTraceEnabled()) {
                    this.trace().append("NavMemoryListHandler tries to register to ").append(string).append("...").log();
                }
                this.initDsiNavigation();
                if (this.isTraceEnabled()) {
                    this.trace().append("NavMemoryListHandler registered to ").append(string).log();
                }
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern() && !this.isFirstStartupDone) {
            if (this.isTraceEnabled()) {
                this.trace().append("NavMemoryListHandler tries to register to ").append(string).append("...").log();
            }
            this.initDsiAdbSetup();
            if (this.isTraceEnabled()) {
                this.trace().append("NavMemoryListHandler registered to ").append(string).log();
            }
        }
        if (this.dsiAdbSetup != null && this.dsiNavigation != null) {
            this.isFirstStartupDone = true;
        }
    }

    public void initDsiAdbSetup() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbSetup = (DSIAdbSetup)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup);
        this.dsiAdbSetupListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener);
        this.dsiAdbSetup.setNotification(1, this.dsiAdbSetupListener);
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryListHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName().intern()) {
                this.unregisterDsiAdbSetup(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiAdbSetup(String string, DSIProxy dSIProxy) {
        this.dsiAdbSetupListener = null;
        this.organizerReady = false;
        if (this.isTraceEnabled()) {
            this.trace().append("NavMemoryListHandler unregistered from ").append(string).log();
        }
    }

    private void caseSetDestinationAsCurrentDest() {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(NAVIGATION_DP.getMemoryLocation());
        NAVIGATION_DP.setDestInputLocation(navLocation);
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler: dsiAdbListGetViewWindowResult()");
        }
        this.requestUnderway = false;
        if (this.getViewWindowQueue.size() > 0) {
            NavMemoryListHandler$ViewWindowRequestData navMemoryListHandler$ViewWindowRequestData = (NavMemoryListHandler$ViewWindowRequestData)this.getViewWindowQueue.removeFirst();
            ASLCachedWindowList aSLCachedWindowList = navMemoryListHandler$ViewWindowRequestData.getList();
            if (this.isTraceEnabled()) {
                this.trace("NavMemoryListHandler: remove list from request queue: ", aSLCachedWindowList.getName());
                this.trace("NavMemoryListHandler: queue size remaining: ", this.getViewWindowQueue.size());
            }
            if (aSLCachedWindowList != null) {
                if (n == 0 && n2 > 0 && dataSetArray != null && dataSetArray.length > 0) {
                    aSLCachedWindowList.updateListItems(dataSetArray[0].getEntryPosition(), (DataSet[])dataSetArray.clone());
                } else if (n2 == 0) {
                    aSLCachedWindowList.setSize(0);
                }
                aSLCachedWindowList.setSize(n2);
            }
            this.sendNextViewWindowRequest();
        }
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        this.viewSize = adbViewSize;
        if (this.viewSize != null) {
            if (this.isTraceEnabled()) {
                this.trace("NavMemoryListHandler: dsiAdbListUpdateViewSize()");
                this.trace().append("NavMemoryListHandler: DestMem: ").append(this.viewSize.getPublicProfileEntries()).append(", Top: ").append(this.viewSize.getPublicTopDestinations()).append(", Phone: ").append(this.viewSize.getNavi()).append(", OnlineDestMem: ").append(this.viewSize.getOnlineDestination()).log();
            }
            this.updateListsSize(this.viewSize.getPublicProfileEntries(), this.viewSize.getPublicTopDestinations(), this.viewSize.getNavi(), this.viewSize.getOnlineDestination());
        } else if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler: updateViewSize == null!");
        }
    }

    public void dsiAdbListInvalidData(int n) {
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler: dsiAdbListInvalidData()");
        }
        this.updateListsSize(0, 0, 0, 0);
        if (this.viewSize != null) {
            this.updateListsSize(this.viewSize.getPublicProfileEntries(), this.viewSize.getPublicTopDestinations(), this.viewSize.getNavi(), this.viewSize.getOnlineDestination());
        }
    }

    public void dsiAdbListUpdateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        boolean bl;
        boolean bl2 = bl = n == 1 && indexInformationArray != null && indexInformationArray.length > 0;
        if (bl) {
            for (int i2 = 0; i2 < indexInformationArray.length; ++i2) {
                int n2 = indexInformationArray[i2].getViewtype();
                CharacterInfo[] characterInfoArray = indexInformationArray[i2].getCharacterInfo();
                GenericASLList genericASLList = this.getListForViewType(n2);
                this.updateListData(characterInfoArray, genericASLList);
            }
        } else {
            GenericASLList genericASLList = this.getListForViewType(6);
            this.updateListData(null, genericASLList);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(4112, true);
    }

    private void updateListData(CharacterInfo[] characterInfoArray, GenericASLList genericASLList) {
        if (characterInfoArray == null || genericASLList == null) {
            if (genericASLList != null) {
                genericASLList.updateStringIndex(new int[0], new String[0]);
            }
        } else {
            int[] nArray = new int[characterInfoArray.length];
            String[] stringArray = new String[characterInfoArray.length];
            for (int i2 = 0; i2 < characterInfoArray.length; ++i2) {
                CharacterInfo characterInfo = characterInfoArray[i2];
                nArray[i2] = characterInfo.index;
                stringArray[i2] = Character.toString((char)characterInfo.value);
            }
            genericASLList.updateStringIndex(nArray, stringArray);
        }
    }

    public void dsiAdbListAsyncException(int n, String string, int n2) {
        if (n2 == 1004) {
            this.error("NavMemoryListHandler: Error requesting memory DataSets. Error code: ", n);
            this.requestUnderway = false;
            this.getViewWindowQueue.removeFirst();
            this.sendNextViewWindowRequest();
        }
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        if (this.isTraceEnabled()) {
            this.trace("TargetListFetcher: handleCommandCmdGetLocationDescriptionTransform()");
        }
        if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation);
            if (this.flagDestName != null) {
                iLocationWrapper.setMmiInternalDataValue(2, this.flagDestName);
            }
            this.dsiNavigation.dmFlagDestinationSet(iLocationWrapper.getLocation());
            NAVIGATION_DP.setMemoryLocation(iLocationWrapper.getLocationCopy());
            ServiceManager.aslPropertyManager.valueChangedBoolean(897, true);
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
                this.warn("NavMemoryListHandler: Organizer instance not in state READY anymore, destination memory won't work.");
                DSIProxyFactory.getDSIProxyAPI().getDSIProxy().removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListListener);
            }
            this.organizerReady = false;
        }
    }

    public void dsiAdbUserProfileUpdateDownloadState(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler.dsiAdbUserProfileUpdateDownloadState(): downloadState=", n);
        }
        boolean bl = n == 0 || n == 1 || n == 2 || n == 3;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3448, bl);
    }

    private void updateListsSize(int n, int n2, int n3, int n4) {
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler.updateListsSize()");
        }
        if (!this.isDestinationImportActive) {
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("NavMemoryListHandler.updateListsSize(): destMem=").append(n).append(" topDest=").append(n2).append(" phone=").append(n3).append(" onlineDest=").append(n4).toString());
            }
            ListManager.getGenericASLList(904).setSizeClearCache(n);
            ListManager.getGenericASLList(909).setSizeClearCache(n2);
            ListManager.getGenericASLList(905).setSizeClearCache(n3);
            ListManager.getGenericASLList(-2098196480).setSizeClearCache(n4);
        }
    }

    private int getViewTypeForList(int n) {
        switch (n) {
            case 909: {
                return 15;
            }
            case 905: {
                return 2;
            }
            case 904: {
                return 6;
            }
            case 1110146: {
                return 18;
            }
        }
        this.warn(new StringBuffer().append("NavMemoryListHandler: Default viewType requested by list ").append(n).append(". Contacts will be displayed in Destmem list and probably won't work").toString());
        return 6;
    }

    private GenericASLList getListForViewType(int n) {
        switch (n) {
            case 15: {
                return ListManager.getGenericASLList(909);
            }
            case 6: {
                return ListManager.getGenericASLList(904);
            }
            case 2: {
                return ListManager.getGenericASLList(905);
            }
            case 18: {
                return ListManager.getGenericASLList(-2098196480);
            }
        }
        return null;
    }

    static int getViewTypeForEntryType(int n) {
        switch (n) {
            case 5: {
                return 18;
            }
        }
        return 6;
    }

    private void initModelLists() {
        GenericASLList genericASLList = ListManager.getGenericASLList(904);
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 20, 0);
        genericASLList.setColumn4ObjectId(1);
        genericASLList.setFetchTimeout(0);
        genericASLList = ListManager.getGenericASLList(905);
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 20, 0);
        genericASLList.setColumn4ObjectId(1);
        genericASLList.setFetchTimeout(0);
        genericASLList = ListManager.getGenericASLList(909);
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 20, 0);
        genericASLList.setColumn4ObjectId(1);
        genericASLList.setFetchTimeout(0);
        genericASLList = ListManager.getGenericASLList(-2098196480);
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 20, 0);
        genericASLList.setColumn4ObjectId(1);
        genericASLList.setFetchTimeout(0);
    }

    private void initOrganizerDSI() {
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler: InitOrganizerDSI()");
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2);
        this.adbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListListener);
        this.dsiAdbList.setNotification(new int[]{1, 2}, this.adbListListener);
        this.adbUserProfileListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener);
        dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).setNotification(8, this.adbUserProfileListener);
        this.dsiAdbList.setListStyle(0, 1, 0);
    }

    private void sendNextViewWindowRequest() {
        if (this.getViewWindowQueue.size() > 0 && !this.requestUnderway) {
            NavMemoryListHandler$ViewWindowRequestData navMemoryListHandler$ViewWindowRequestData = (NavMemoryListHandler$ViewWindowRequestData)this.getViewWindowQueue.getFirst();
            if (navMemoryListHandler$ViewWindowRequestData != null) {
                int n = this.getViewTypeForList(navMemoryListHandler$ViewWindowRequestData.getList().getListId());
                if (navMemoryListHandler$ViewWindowRequestData.getIndex() == 0) {
                    this.dsiAdbList.getViewWindow(navMemoryListHandler$ViewWindowRequestData.getIndex(), 4, n, navMemoryListHandler$ViewWindowRequestData.getCount());
                } else {
                    this.dsiAdbList.getViewWindow(navMemoryListHandler$ViewWindowRequestData.getIndex(), 6, n, navMemoryListHandler$ViewWindowRequestData.getCount());
                }
                this.requestUnderway = true;
            } else {
                this.warn("NavMemoryListHandler: next request data was null");
                this.getViewWindowQueue.removeFirst();
                this.sendNextViewWindowRequest();
            }
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbSetup == null ? (class$org$dsi$ifc$organizer$DSIAdbSetup = NavMemoryListHandler.class$("org.dsi.ifc.organizer.DSIAdbSetup")) : class$org$dsi$ifc$organizer$DSIAdbSetup).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryListHandler.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        if (bl || bl2) {
            if (this.isTraceEnabled()) {
                this.trace("NavMemoryListHandler: resetting values after DSI restart");
            }
            this.initLocalVariables();
            if (bl) {
                this.initDsiAdbSetup();
            }
            if (bl2) {
                this.initDsiNavigation();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.viewSize = null;
        this.getViewWindowQueue.clear();
        this.requestUnderway = false;
        this.flagDestName = "";
        this.isDestinationImportActive = false;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        this.getViewWindowQueue.add(new NavMemoryListHandler$ViewWindowRequestData(this, aSLCachedWindowList, n, n2));
        if (this.isTraceEnabled()) {
            this.trace("NavMemoryListHandler: Add getViewWindow() request to queue: ", aSLCachedWindowList.getName());
            this.trace("NavMemoryListHandler: New queue size: ", this.getViewWindowQueue.size());
        }
        this.sendNextViewWindowRequest();
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
    public void updateServiceStatusOnChange(int n) {
        switch (n) {
            case 0: 
            case 7: {
                if (this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = true;
                AbstractASLHsmTarget.writeBooleanToDatapool(-1091563520, true);
                break;
            }
            default: {
                if (!this.onlineServiceAvailable && !this.onlineServiceFirstUpdate) break;
                this.onlineServiceFirstUpdate = false;
                this.onlineServiceAvailable = false;
                AbstractASLHsmTarget.writeBooleanToDatapool(-1091563520, false);
            }
        }
        boolean bl = ASLOnlineFactory.getOnlineCoreServices().isOCUService(this.onlineCoreServices.getServiceIDWithNumericServiceID(9));
        AbstractASLHsmTarget.writeBooleanToDatapool(-1074786304, bl);
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
        OBSERVERS = new int[]{-429443840, 1661075520, -2063466432, 1879179328, 0x40060040};
        NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    }
}

