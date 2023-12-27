/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.memory.IEntriesResultListener;
import de.vw.mib.asl.api.navigation.memory.IListResultListener;
import de.vw.mib.asl.api.navigation.memory.ITbmResultListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$1;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$2;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$3;
import de.vw.mib.asl.internal.navigation.memory.NavMemoryDataRetriver$Handler;
import de.vw.mib.asl.internal.navigation.memory.api.impl.ASLNavigationMemoryAPIImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.LinkedList;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbEditListener;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DSIAdbUserProfile;
import org.dsi.ifc.organizer.DSIAdbUserProfileListener;
import org.dsi.ifc.organizer.DataSet;

public class NavMemoryDataRetriver
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    private static final int DSI_TIMEOUT;
    private static final int EV_ENQUEUE_HANDLER;
    private static final int EV_CHECK_HANDLER;
    private static final int EV_TIMEOUT_HANDLER;
    public static NavMemoryDataRetriver INSTANCE;
    private DSIAdbList dsiAdbList = null;
    private DSIAdbEdit dsiAdbEdit = null;
    private DSINavigation dsiNavigation = null;
    private DSIAdbUserProfile dsiAdbUserProfile = null;
    private DSIAdbListListener dsiAdbListListener;
    private DSIAdbEditListener dsiAdbEditListener;
    private DSINavigationListener dsiNavigationListener;
    private DSIAdbUserProfileListener dsiAdbUserProfileListener;
    private LinkedList handlerQueue = new LinkedList();
    private NavMemoryDataRetriver$Handler currentHandler;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfile;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbUserProfileListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;

    public NavMemoryDataRetriver(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2, this);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2, this);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        DSIProxyFactory.getDSIProxyAPI().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile, this);
        INSTANCE = this;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100100: {
                this.handlerQueue.add(eventGeneric.getObject(0));
                break;
            }
            case 100101: {
                break;
            }
            case 100103: {
                this.currentHandler = null;
                break;
            }
        }
        this.checkHandler();
    }

    private void checkHandler() {
        if (this.currentHandler == null && this.handlerQueue != null && !this.handlerQueue.isEmpty()) {
            this.currentHandler = (NavMemoryDataRetriver$Handler)this.handlerQueue.removeFirst();
            this.startTimer(126288128, (long)0, false);
            this.currentHandler.doRequest();
        }
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        try {
            if (this.currentHandler != null) {
                ((IListResultListener)this.currentHandler.getHandler()).handleResultList(n, dataSetArray, n2, this.currentHandler.getArg());
            } else if (this.isTraceEnabled()) {
                this.trace("currentHandler is null");
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        this.finishHandler();
    }

    public void dsiAdbListInvalidData(int n) {
        ASLNavigationMemoryAPIImpl.notifyInvalidateContactData();
    }

    public void dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        try {
            if (this.currentHandler != null) {
                ((IEntriesResultListener)this.currentHandler.getHandler()).handleResultEntries(n, adbEntryArray, this.currentHandler.getArg());
            } else if (this.isTraceEnabled()) {
                this.trace("currentHandler is null");
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        this.finishHandler();
    }

    public void dsiNavigationLiTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        try {
            if (this.currentHandler != null) {
                ((ITbmResultListener)this.currentHandler.getHandler()).handleResultTbm(tryBestMatchResultDataArray, this.currentHandler.getArg());
            } else if (this.isTraceEnabled()) {
                this.trace("currentHandler is null");
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        this.finishHandler();
    }

    public void dsiAdbUserProfileUpdateDownloadState(int n, int n2, int n3) {
        ASLNavigationMemoryAPIImpl.notifyProfileDownloadState(n, n2, n3);
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        ASLNavigationMemoryAPIImpl.notifyUpdateViewSizes(adbViewSize, n);
    }

    private void finishHandler() {
        this.currentHandler = null;
        this.stopTimer(126288128);
        try {
            this.triggerMe(92733696);
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
    }

    @Override
    public void registered(String string, int n) {
        if ((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName().equals(string) && n == 2) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbList();
            }
        } else if ((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName().equals(string) && n == 2) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbEdit();
            }
        } else if ((class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName().equals(string)) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbUserProfile();
            }
        } else if ((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().equals(string) && !this.isFirstStartupDone) {
            this.initDsiNavigation();
        }
        if (this.dsiAdbList != null && this.dsiAdbEdit != null && this.dsiAdbUserProfile != null && this.dsiNavigation != null) {
            this.isFirstStartupDone = true;
        }
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
    }

    public void initDsiAdbUserProfile() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbUserProfile = (DSIAdbUserProfile)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile);
        this.dsiAdbUserProfileListener = (DSIAdbUserProfileListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbUserProfileListener == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfileListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbUserProfileListener")) : class$org$dsi$ifc$organizer$DSIAdbUserProfileListener, this.dsiAdbUserProfileListener);
        this.dsiAdbUserProfile.setNotification(8, (DSIListener)this.dsiAdbUserProfileListener);
    }

    public void initDsiAdbEdit() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2);
        this.dsiAdbEditListener = (DSIAdbEditListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.dsiAdbEditListener);
    }

    public void initDsiAdbList() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2);
        this.dsiAdbListListener = (DSIAdbListListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.dsiAdbListListener);
        this.dsiAdbList.setNotification(1, (DSIListener)this.dsiAdbListListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if ((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName().equals(string) && n == 2) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.dsiAdbListListener);
        } else if ((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName().equals(string) && n == 2) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.dsiAdbListListener);
        } else if ((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().equals(string)) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        }
        this.currentHandler = null;
        this.stopTimer(126288128);
    }

    public void getListBlock(IListResultListener iListResultListener, int n, int n2, int n3, Object object) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, new NavMemoryDataRetriver$1(this, iListResultListener, n2, n, n3, object));
        eventGeneric.setReceiverEventId(75956480);
        eventGeneric.setReceiverTargetId(-867494912);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public void getEntries(IEntriesResultListener iEntriesResultListener, long[] lArray, int n, Object object) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, new NavMemoryDataRetriver$2(this, iEntriesResultListener, lArray, n, object));
        eventGeneric.setReceiverEventId(75956480);
        eventGeneric.setReceiverTargetId(-867494912);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    public void tryBestMatch(ITbmResultListener iTbmResultListener, TryBestMatchData tryBestMatchData, Object object) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, new NavMemoryDataRetriver$3(this, iTbmResultListener, tryBestMatchData, object));
        eventGeneric.setReceiverEventId(75956480);
        eventGeneric.setReceiverTargetId(-867494912);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 2);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 2);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbUserProfile == null ? (class$org$dsi$ifc$organizer$DSIAdbUserProfile = NavMemoryDataRetriver.class$("org.dsi.ifc.organizer.DSIAdbUserProfile")) : class$org$dsi$ifc$organizer$DSIAdbUserProfile).getName(), 0);
        boolean bl4 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = NavMemoryDataRetriver.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        if (bl || bl2 || bl3 || bl4) {
            if (this.isTraceEnabled()) {
                this.trace("NavMemoryDataRetriver: resetting values after DSI restart");
            }
            this.initLocalVariables();
            if (bl) {
                this.initDsiAdbEdit();
            }
            if (bl2) {
                this.initDsiAdbList();
            }
            if (bl3) {
                this.initDsiAdbUserProfile();
            }
            if (bl4) {
                this.initDsiNavigation();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("NavMemoryDataRetriver: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        try {
            this.triggerMe(92733696);
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
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

    static /* synthetic */ DSIAdbList access$000(NavMemoryDataRetriver navMemoryDataRetriver) {
        return navMemoryDataRetriver.dsiAdbList;
    }

    static /* synthetic */ DSIAdbEdit access$100(NavMemoryDataRetriver navMemoryDataRetriver) {
        return navMemoryDataRetriver.dsiAdbEdit;
    }

    static /* synthetic */ DSINavigation access$200(NavMemoryDataRetriver navMemoryDataRetriver) {
        return navMemoryDataRetriver.dsiNavigation;
    }
}

