/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.GenericCollector;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.bap.BapNavBookAdbListFetcher;
import de.vw.mib.asl.internal.navigation.bap.HsmBapListTarget$1;
import de.vw.mib.asl.internal.navigation.bap.HsmBapListTarget$2;
import de.vw.mib.asl.internal.navigation.bap.LoggerDelegate;
import de.vw.mib.asl.internal.navigation.bap.api.impl.ILocationAccessorNavBapImpl;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;

public class HsmBapListTarget
extends AbstractResettableAslHsmTarget
implements DSIServiceStateListener,
LoggerDelegate {
    protected int numberOfLastDestRequests = 0;
    protected Object[] lastDestColls;
    protected DSIAdbEdit dsiAdbEdit = null;
    protected DSIAdbList dsiAdbList = null;
    private DSIListener internalAdbListListener;
    protected DSINavigation dsiNavigation = null;
    protected BapNavBookAdbListFetcher navBookFetcher = null;
    private static final int VIEW_WINDOW_INITIAL_SIZE;
    private static final int INVALID_HANDLE;
    int bapSpellerHandle = -1;
    String currentSpellerChars = "";
    int numberOfCharactersToRemove = 0;
    int numberOfCharactersToAdd = 0;
    private boolean wasServiceStateListenerRegistered = false;
    private DSIListener adbEditListener;
    private DSIListener adbListListener;
    private DSIListener navigationListener;
    protected final HsmState stateWork = new HsmBapListTarget$1(this, this.hsm, "stateWork", this.getWorkStateParent());
    protected final HsmState stateConfigureAdb = new HsmBapListTarget$2(this, this.hsm, "stateConfigureAdb", this.stateWork);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;

    public HsmBapListTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
    }

    protected void registerObservers() {
        this.addObserver(-989790144);
        this.addObserver(-1023344576);
        this.addObserver(-973012928);
        this.addObserver(-956235712);
        this.addObserver(-939458496);
        this.addObserver(-429443840);
        if (!this.wasServiceStateListenerRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 3, this);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 3, this);
            dSIProxy.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            this.wasServiceStateListenerRegistered = true;
        }
    }

    protected void unregisterObservers() {
    }

    protected void addSpellerChars(String string) {
        this.numberOfCharactersToRemove = 0;
        this.numberOfCharactersToAdd = string.length();
        for (int i2 = 0; i2 < this.numberOfCharactersToAdd; ++i2) {
            this.dsiAdbList.addSpellerChars(this.bapSpellerHandle, new String(new char[]{string.charAt(i2)}));
        }
    }

    private boolean updateAddedSpellerCharacters(int n) {
        if (this.numberOfCharactersToAdd > 0) {
            this.numberOfCharactersToAdd = this.currentSpellerChars.length() - n;
        }
        return this.numberOfCharactersToAdd > 0;
    }

    private boolean isAddingSpellerCharacters() {
        return this.numberOfCharactersToAdd > 0;
    }

    protected void removeSpellerChars(int n) {
        this.numberOfCharactersToAdd = 0;
        this.numberOfCharactersToRemove = n;
        if (this.numberOfCharactersToRemove == 0) {
            this.addSpellerChars(this.currentSpellerChars);
        } else {
            this.dsiAdbList.removeSpellerChar(this.bapSpellerHandle);
        }
    }

    private boolean shouldRemoveSpellerChars() {
        return this.numberOfCharactersToRemove > 0;
    }

    public void dsiAdbListSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 0) {
            this.bapSpellerHandle = n2;
            if (this.shouldRemoveSpellerChars()) {
                this.removeSpellerChars(string2.length());
            } else if (!this.updateAddedSpellerCharacters(string2.length())) {
                ASLNavBAPFactory.getNavBAPApi().navBookSpellerResult(n, n2, dataSetArray, n3, string, string2);
                this.sendHMIEvent(71);
            }
        } else if (n == 2) {
            if (!this.isAddingSpellerCharacters()) {
                ASLNavBAPFactory.getNavBAPApi().navBookSpellerResult(n, n2, dataSetArray, n3, string, string2);
                this.sendHMIEvent(71);
            }
        } else {
            this.sendHMIEvent(70);
        }
    }

    public void dsiAdbListStopSpellerResult(int n, int n2) {
        if (n == 0) {
            this.sendHMIEvent(72);
        }
    }

    public void dsiAdbListInvalidData(int n) {
        this.navBookFetcher.dsiAdbListInvalidData(n);
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        this.navBookFetcher.dsiAdbListUpdateViewSize(adbViewSize, n);
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.navBookFetcher.dsiAdbListGetViewWindowResult(n, dataSetArray, n2);
    }

    public void dsiNavigationDmLastDestinationsGetResult(long l, NavLocation navLocation) {
        if (this.numberOfLastDestRequests != 0 && l == 0L) {
            Object object;
            if (this.lastDestColls == null) {
                this.lastDestColls = new GenericCollector[this.numberOfLastDestRequests];
            }
            ILocationAccessor iLocationAccessor = ServiceManager.dsiServiceLocator.getLocationAccessorFactory().fromLocation(navLocation);
            StringBuffer stringBuffer = new StringBuffer();
            if (iLocationAccessor.getStreet() != null) {
                stringBuffer.append(iLocationAccessor.getStreet());
                object = iLocationAccessor.getHousenumber();
                if (object != null) {
                    stringBuffer.append(" ");
                    stringBuffer.append((String)object);
                }
            }
            object = this.createDetailListCollector(iLocationAccessor, stringBuffer);
            --this.numberOfLastDestRequests;
            this.lastDestColls[this.numberOfLastDestRequests] = object;
            if (this.numberOfLastDestRequests == 0) {
                ListManager.getGenericASLList(739).updateList(this.lastDestColls);
                this.sendHMIEvent(67);
            }
        }
    }

    private Object createDetailListCollector(ILocationAccessor iLocationAccessor, StringBuffer stringBuffer) {
        ILocationAccessorNavBapImpl iLocationAccessorNavBapImpl = null;
        if (iLocationAccessor != null) {
            iLocationAccessorNavBapImpl = new ILocationAccessorNavBapImpl(iLocationAccessor);
        }
        return ASLNavBAPFactory.getNavBAPApi().createDetailListCollector(iLocationAccessorNavBapImpl, stringBuffer.toString());
    }

    public void dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0) {
            ASLNavBAPFactory.getNavBAPApi().addrListUpdate(adbEntryArray);
            this.sendHMIEvent(67);
        }
    }

    public void dsiAdbListSetListStyleResult(int n) {
        this.navBookFetcher.dsiAdbListSetListStyleResult(n);
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbEdit();
            }
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbList();
            }
        } else if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.initDsiNavigation();
        }
        if (this.dsiAdbEdit != null && this.dsiAdbList != null && this.dsiNavigation != null) {
            this.isFirstStartupDone = true;
        }
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
    }

    public void initDsiAdbList() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 3);
        this.adbListListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 3, this.adbListListener);
        this.navBookFetcher = new BapNavBookAdbListFetcher(this.dsiAdbList, 2);
        this.navBookFetcher.setLogger(this);
        this.internalAdbListListener = this.adbListListener;
        this.dsiAdbList.setNotification(1, this.internalAdbListListener);
        this.navBookFetcher.configureAdbList();
    }

    public void initDsiAdbEdit() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 3);
        this.adbEditListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 3, this.adbEditListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmBapListTarget tries to unregistered from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName().intern()) {
                this.unregisterDSIAdbEdit(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName().intern()) {
                this.unregisterDSIAdbList(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDSINavigation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDSINavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
        }
        this.traceUnregisterDone(string);
    }

    private void unregisterDSIAdbList(String string, DSIProxy dSIProxy) {
        if (this.dsiAdbList == null) {
            this.trace().append("dsiAdbList was null!");
        } else {
            this.internalAdbListListener = null;
            if (this.adbListListener != null) {
                dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 3, this.adbListListener);
            }
            this.navBookFetcher = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmBapListTarget unregistered from ").append(string).log();
        }
    }

    private void unregisterDSIAdbEdit(String string, DSIProxy dSIProxy) {
        if (this.adbEditListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 3, this.adbEditListener);
            this.adbEditListener = null;
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.wasDsiNavigationResettet(hashMap);
        boolean bl2 = this.wasDsiAdbEditResettet(hashMap);
        boolean bl3 = this.wasDsiAdbListResettet(hashMap);
        if (bl || bl2 || bl3) {
            if (this.isTraceEnabled()) {
                this.trace("HsmBapListTarget: resetting values after DSI restart");
            }
            if (bl) {
                this.initLocalVariablesDsiNavigation();
            }
            if (bl2 || bl3) {
                this.initLocalVariablesDsiAdb();
            }
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl2) {
                this.initDsiAdbEdit();
            }
            if (bl3) {
                this.initDsiAdbList();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmBapListTarget: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    public boolean wasDsiAdbListResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 3);
    }

    public boolean wasDsiAdbEditResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmBapListTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 3);
    }

    public boolean wasDsiNavigationResettet(HashMap hashMap) {
        return this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmBapListTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
    }

    private void initLocalVariablesDsiNavigation() {
        this.numberOfLastDestRequests = 0;
        this.lastDestColls = null;
    }

    private void initLocalVariablesDsiAdb() {
        this.bapSpellerHandle = -1;
        this.currentSpellerChars = "";
        this.numberOfCharactersToRemove = 0;
        this.numberOfCharactersToAdd = 0;
    }

    @Override
    public int getSubClassifier() {
        return 0x800000;
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

