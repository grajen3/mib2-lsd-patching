/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser;

import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceInfo;
import de.vw.mib.asl.api.filebrowser.sourcehandling.FileBrowserSourceList;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.filebrowser.FileBrowserListCollector;
import de.vw.mib.asl.internal.filebrowser.ModelSessions;
import de.vw.mib.asl.internal.filebrowser.StateBrowsingPartitioned;
import de.vw.mib.asl.internal.filebrowser.StateGetDownloadResourceLocators;
import de.vw.mib.asl.internal.filebrowser.StateIdle;
import de.vw.mib.asl.internal.filebrowser.StatePartitionChoice;
import de.vw.mib.asl.internal.filebrowser.StateStartAslSession;
import de.vw.mib.asl.internal.filebrowser.StateStartModelContextSession;
import de.vw.mib.asl.internal.filebrowser.StateStartSession;
import de.vw.mib.asl.internal.filebrowser.StateStartSessionWithParameters;
import de.vw.mib.asl.internal.filebrowser.StateTop;
import de.vw.mib.asl.internal.filebrowser.sessions.Session;
import de.vw.mib.asl.internal.filebrowser.sessions.Sessions;
import de.vw.mib.asl.internal.filebrowser.sourcehandling.IndexedList;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;

public final class HsmTargetFileBrowser
extends AbstractASLHsmTarget
implements ASLListElementFetcher {
    static final int EV_MODEL_PARTITIONS;
    private final ModelSessions modelSessions = new ModelSessions();
    DSIFileBrowser dsiFileBrowser;
    boolean fileTypeActive = false;
    final StateTop topState = new StateTop(this, this.hsm, "stateTop", this.getWorkStateParent());
    final StateIdle idleState = new StateIdle(this, this.hsm, "stateIdle", this.topState);
    final StateGetDownloadResourceLocators stateGetDownloadResourceLocators = new StateGetDownloadResourceLocators(this, "stateGetDownloadResourceLocators", (HsmState)this.idleState);
    final StateBrowsingPartitioned browsingPartitionedState = new StateBrowsingPartitioned(this, this.hsm, "stateBrowsingPartitioned", this.idleState);
    final StateStartSession startSessionState = new StateStartSession(this, this.hsm, "stateStartSession", this.idleState);
    final StateStartAslSession startAslSessionState = new StateStartAslSession(this, this.hsm, "stateStartAslSession", this.idleState);
    final StatePartitionChoice partitionChoiceState = new StatePartitionChoice(this, this.hsm, "statePartitionChoice", this.startAslSessionState);
    final StateStartModelContextSession startModelContextSessionState = new StateStartModelContextSession(this, this.hsm, "stateStartModelContextSession", this.idleState);
    final StateStartSessionWithParameters startSessionWithParamtersState = new StateStartSessionWithParameters(this, this.hsm, "stateStartSessionWithParameters", this.idleState);
    FileBrowserSourceList sourceList = null;
    private static final int MAX_SESSIONS;
    final Sessions sessions = new Sessions(4);
    static final int WINDOW_SIZE;
    private static final int NUM_RL_REQUEST_SLOTS;
    private int pendingModelResourceLocatorRequestSlotIndex = -1;
    private int pendingModelResourceLocatorRequestStartIndex = -1;
    FileBrowserListCollector[] pendingModelResourceLocatorCollectorWindow = null;
    static final int INVALID_RL_SLOT;
    private final EventGeneric[] RL_REQUEST_SLOTS = new EventGeneric[10];
    public static final String[] ROOT_PATH;
    static final String SD1;
    static final String SD2;
    static final String USB;
    static final boolean SET_PATH_SUCCESSFUL;
    static final boolean SET_PATH_FAILED;
    private FileBrowserListCollector[] collectedPartitions;
    IndexedList filebrowserSourcesV2 = new IndexedList(-205913088, DeviceFilter.REMOVABLE);
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$DSIFileBrowser;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$DSIFileBrowserListener;

    public HsmTargetFileBrowser(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -1058336256;
    }

    ModelSessions getModelSessions() {
        return this.modelSessions;
    }

    public DSIFileBrowser getDsiFileBrowser() {
        return this.dsiFileBrowser;
    }

    public void register() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiFileBrowser = (DSIFileBrowser)dSIProxy.getService(this, class$org$dsi$ifc$filebrowser$DSIFileBrowser == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowser = HsmTargetFileBrowser.class$("org.dsi.ifc.filebrowser.DSIFileBrowser")) : class$org$dsi$ifc$filebrowser$DSIFileBrowser);
        DSIListener dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$filebrowser$DSIFileBrowserListener == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowserListener = HsmTargetFileBrowser.class$("org.dsi.ifc.filebrowser.DSIFileBrowserListener")) : class$org$dsi$ifc$filebrowser$DSIFileBrowserListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$filebrowser$DSIFileBrowserListener == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowserListener = HsmTargetFileBrowser.class$("org.dsi.ifc.filebrowser.DSIFileBrowserListener")) : class$org$dsi$ifc$filebrowser$DSIFileBrowserListener, dSIListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.topState;
    }

    void activateCurrentModelSessionFilter() {
        if (this.getModelSessions().isValid()) {
            Session session = this.getModelSessions().getCurrentModelFilebrowserSession();
            session.setExtensions(this.getModelSessions().getExtensionFilter());
            this.dsiFileBrowser.setFileExtensionFilter(session.getDsiHandle(), session.getExtensions());
            this.dsiFileBrowser.getFileCount(session.getDsiHandle());
            this.topState.updateNumberOfVCards(session);
        }
    }

    int getFreeRLRequestSlot() {
        for (int i2 = 9; i2 >= 0; --i2) {
            if (null != this.RL_REQUEST_SLOTS[i2]) continue;
            return i2;
        }
        return -1;
    }

    void setRLRequestEvent(int n, EventGeneric eventGeneric) {
        this.RL_REQUEST_SLOTS[n] = eventGeneric;
    }

    EventGeneric getRLRequestEvent(int n) {
        return this.RL_REQUEST_SLOTS[n];
    }

    void clearRLEventSlot(int n) {
        if (n != -1) {
            this.RL_REQUEST_SLOTS[n] = null;
        }
    }

    int getPendingModelResourceLocatorSlotIndex() {
        return this.pendingModelResourceLocatorRequestSlotIndex;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetFileBrowser.fetchItems(list=").append(aSLCachedWindowList.getName()).append(", index=").append(n).append(", count=").append(n2).append(") partition faking=").append(this.collectedPartitions != null).append(", valid modelsession=").append(this.getModelSessions().isValid()).log();
        }
        if (this.getModelSessions().isValid()) {
            if (this.collectedPartitions == null) {
                this.dsiFileBrowser.getViewWindow(this.getModelSessions().getCurrentModelFilebrowserSession().getDsiHandle(), n2, n);
            } else {
                aSLCachedWindowList.updateListItems(n, this.collectedPartitions);
            }
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.fetchItems(aSLCachedWindowList, n, n2);
    }

    void handleListResponse(int n, int n2, BrowsedFileSet browsedFileSet) {
        Session session = this.getModelSessions().getCurrentModelFilebrowserSession();
        if (this.getModelSessions().isValid() && session.getAslHandle() == n) {
            FileBrowserListCollector[] fileBrowserListCollectorArray = new FileBrowserListCollector[browsedFileSet.files.length];
            for (int i2 = 0; i2 < browsedFileSet.files.length; ++i2) {
                fileBrowserListCollectorArray[i2] = new FileBrowserListCollector();
                fileBrowserListCollectorArray[i2].listEntry = browsedFileSet.files[i2];
                fileBrowserListCollectorArray[i2].mediaInfo = null;
            }
            this.pendingModelResourceLocatorCollectorWindow = fileBrowserListCollectorArray;
            this.pendingModelResourceLocatorRequestStartIndex = n2;
            this.dsiFileBrowser.getResourceLocatorWindow(session.getDsiHandle(), browsedFileSet.files.length, n2);
        }
    }

    void handleResourceLocatorResponse(ResourceLocator[] resourceLocatorArray) {
        this.clearRLEventSlot(this.pendingModelResourceLocatorRequestSlotIndex);
        this.pendingModelResourceLocatorRequestSlotIndex = -1;
        if (this.pendingModelResourceLocatorCollectorWindow.length == resourceLocatorArray.length) {
            for (int i2 = this.pendingModelResourceLocatorCollectorWindow.length - 1; i2 >= 0; --i2) {
                this.pendingModelResourceLocatorCollectorWindow[i2].resourceLocator = resourceLocatorArray[i2];
            }
        }
        ListManager.getGenericASLList(424).updateListItems(this.pendingModelResourceLocatorRequestStartIndex, this.pendingModelResourceLocatorCollectorWindow);
        this.pendingModelResourceLocatorCollectorWindow = null;
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    void notifyModel(Session session) {
        Path path = session.getPath();
        if (path == null || path.folderNames.length == 0) {
            ServiceManager.aslPropertyManager.valueChangedString(412, session.getMediumName());
            ServiceManager.aslPropertyManager.valueChangedInteger(417, 0);
            ServiceManager.aslPropertyManager.valueChangedInteger(418, 0);
        } else {
            ServiceManager.aslPropertyManager.valueChangedString(412, path.folderNames[path.folderNames.length - 1]);
            ServiceManager.aslPropertyManager.valueChangedInteger(417, path.folderNames.length);
            ServiceManager.aslPropertyManager.valueChangedInteger(418, path.folderNames.length - 1);
        }
        if (path != null) {
            ServiceManager.aslPropertyManager.valueChangedInteger(415, this.getModelSourceIdByPath(path));
        }
    }

    private int getModelSourceIdByPath(Path path) {
        int n = -1;
        block9: for (int i2 = 0; i2 < this.sourceList.count() && n == -1; ++i2) {
            FileBrowserSourceInfo fileBrowserSourceInfo = this.sourceList.get(i2);
            if (null == fileBrowserSourceInfo) continue;
            for (int i3 = 0; i3 < fileBrowserSourceInfo.getMediaInfos().length; ++i3) {
                if (!fileBrowserSourceInfo.getMediaInfos()[i3].mountPoint.equals(path.mountPoint)) continue;
                n = fileBrowserSourceInfo.getSourceId();
                continue block9;
            }
        }
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 6;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 9;
            }
            case 5: {
                return 10;
            }
            case 6: {
                return 11;
            }
        }
        return 0;
    }

    void setCollectedPartitions(FileBrowserListCollector[] fileBrowserListCollectorArray) {
        this.collectedPartitions = fileBrowserListCollectorArray;
    }

    void closeCurrentModelSession() {
        if (this.getModelSessions().isValid()) {
            Session session = this.getModelSessions().getCurrentModelFilebrowserSession();
            if (session.getDsiHandle() != -1) {
                this.getDsiFileBrowser().stop(session.getDsiHandle());
            }
            this.getModelSessions().resetCurrentModelFilebrowserSession();
            this.sessions.removeSession(session.getAslHandle());
        }
    }

    public void sendBackIfBlocked(EventGeneric eventGeneric) {
        if (eventGeneric.isBlocked()) {
            eventGeneric.setBlocked(false);
            this.getEventDispatcher().sendBack(eventGeneric);
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

    static {
        ROOT_PATH = new String[0];
    }
}

