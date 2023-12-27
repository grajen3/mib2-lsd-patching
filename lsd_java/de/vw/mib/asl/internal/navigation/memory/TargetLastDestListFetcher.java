/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.memory.ASLNavMemoryDP;
import de.vw.mib.asl.internal.navigation.memory.MemoryFormatter;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.LDListElement;

public class TargetLastDestListFetcher
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    private static final INavigationDP NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private static final ASLNavMemoryDP MEMORY_DP = ASLNavMemoryDP.getInstance();
    private DSINavigation dsiNavigation;
    private DSIListener navigationListener;
    private boolean lastDestGetReceived;
    private String selectedName;
    private boolean isServiceStateListenerAdded = false;
    private boolean topOfLastDestUpdate = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetLastDestListFetcher(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerObservers();
                ListManager.getGenericASLList(908).setColumn4ObjectId(3);
                break;
            }
            case 1073742466: {
                if (this.isTraceEnabled()) {
                    this.trace("TargetLastDestListFetcher: ASL_NAVIGATION_MEMORY_SELECT_LAST_DEST_MEM_LIST_ITEM");
                }
                long l = eventGeneric.getLong(0);
                LDListElement lDListElement = (LDListElement)ListManager.getGenericASLList(908).getListItemByIdCacheOnly(l);
                if (lDListElement != null) {
                    this.selectedName = lDListElement.getTitle() == null ? "" : lDListElement.getTitle();
                } else {
                    this.warn("TargetLastDestListFetcher: Unable to retrieve selected LDListElement from cached list. Setting empty name.");
                    this.selectedName = "";
                }
                NAVIGATION_DP.setSaveCorrectedAddressToEntry(false);
                this.trace("TargetLastDestListFetcher: Request last destination id: ", (int)l);
                this.lastDestGetReceived = false;
                MEMORY_DP.setMemoryStatusRequestReceived(false);
                this.dsiNavigation.dmLastDestinationsGet(l);
                break;
            }
            case 1073743927: {
                this.sendSelectFinishedEvent();
                break;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.initDsiNavigation();
            this.isFirstStartupDone = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            try {
                DSIProxy dSIProxy;
                if (this.isTraceEnabled()) {
                    this.trace().append("TargetLastDestListFetcher tries to unregister from ").append(string).log();
                }
                if ((dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy()) == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                this.unregisterDsiNavigation(string, dSIProxy);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetLastDestListFetcher unregistered from ").append(string).log();
        }
    }

    public void dsiNavigationUpdateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        if (n == 1) {
            if (!Util.isNullOrEmpty(lDListElementArray)) {
                LDListElement lDListElement = lDListElementArray[0];
                this.topOfLastDestUpdate = true;
                this.dsiNavigation.dmLastDestinationsGet(lDListElement.getId());
                ListManager.getGenericASLList(908).updateList(lDListElementArray);
            } else {
                if (this.isTraceEnabled()) {
                    this.trace("dsiNavMemoryUpdateDmLastDestinationsList: dmLastDestinationsList was null or empty");
                }
                ListManager.getGenericASLList(908).clear();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("dsiNavigationUpdateDmLastDestinationsList received an invalid flag");
        }
    }

    public void dsiNavigationDmLastDestinationsGetResult(long l, NavLocation navLocation) {
        if (l == 0L) {
            if (this.topOfLastDestUpdate) {
                this.topOfLastDestUpdate = false;
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTopOfLastDestLocation(navLocation);
                return;
            }
            this.setMapToLocation(navLocation);
            NAVIGATION_DP.setMemoryLocation(navLocation);
            NAVIGATION_DP.setMemoryLocationIsTopDest(false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(891, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(896, false);
            ListManager.getGenericASLList(910).updateListItem(0, MemoryFormatter.createMemoryDestinationDetails(navLocation, this.selectedName));
            ServiceManager.aslPropertyManager.valueChangedString(887, this.selectedName);
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, !navLocation.isPositionValid());
            this.lastDestGetReceived = true;
            this.sendSelectFinishedEvent();
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("An error on the Southside leads to the following exception: Result code for dmLastDestinationsGetResult() in TargetLastDestListFetcher was not NAVRESULTCODE_OK");
        }
    }

    private void sendSelectFinishedEvent() {
        if (MEMORY_DP.isMemoryStatusRequestReceived() && this.lastDestGetReceived) {
            if (this.isTraceEnabled()) {
                this.trace("TargetLastDestListFetcher.sendSelectFinished()");
            }
            this.sendHMIEvent(100);
            ServiceManager.aslPropertyManager.valueChangedInteger(2762, 0);
            MEMORY_DP.setMemoryStatusRequestReceived(false);
            this.lastDestGetReceived = false;
        }
    }

    private void setMapToLocation(NavLocation navLocation) {
        MapConfiguration mapConfiguration = new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(5, mapConfiguration);
    }

    private void registerObservers() {
        if (!this.isServiceStateListenerAdded) {
            this.isServiceStateListenerAdded = true;
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        }
        this.addObserver(-2113798080);
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        if (bl) {
            if (this.isTraceEnabled()) {
                this.trace("TargetLastDestListFetcher: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetLastDestListFetcher: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initDsiNavigation() {
        String string = (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern();
        if (this.isTraceEnabled()) {
            this.trace().append("TargetLastDestListFetcher tries to register to ").append(string).append("...").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetLastDestListFetcher.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(new int[]{8}, this.navigationListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetLastDestListFetcher registered to ").append(string).log();
        }
    }

    private void initLocalVariables() {
        this.dsiNavigation = null;
        this.navigationListener = null;
        this.lastDestGetReceived = false;
        this.selectedName = "";
        this.isServiceStateListenerAdded = false;
        this.topOfLastDestUpdate = false;
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

