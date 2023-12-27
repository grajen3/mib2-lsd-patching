/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenDatapool;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenNotifierModel;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenStateInit;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenStateWork;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DSINavigationListener;

public class SplitScreenTargetHSM
extends AbstractResettableAslHsmTarget
implements ReloadPersistedDataListener,
DSIServiceStateListener {
    private final SplitscreenStateWork stateWork;
    private final SplitscreenStateInit stateInit;
    protected final SplitscreenDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[SplitScreenTargetHSM]");
    protected final SplitscreenNotifierModel notifierModel;
    private SplitscreenInternalAPINotifier internalAPINotifier;
    private DSINavigation dsiNavigation;
    private static final int[] ATTRIBUTES_NAVIGATION = new int[]{28, 57, 54, 85, 29};
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public SplitScreenTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new SplitscreenDatapool();
        this.notifierModel = new SplitscreenNotifierModel();
        this.stateInit = new SplitscreenStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateWork = new SplitscreenStateWork(this, "stateWork", this.getWorkStateParent());
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    protected void transStateWork() {
        this.logger.trace("transStateWork()");
        this.getHsm().trans(this.stateWork);
    }

    public void notifyModel() {
        this.notifierModel.notifySplitScreenGuidanceChanged(this.datapool.isSplitScreenGuidance());
        this.notifierModel.notifySplitScreenContentChanged(this.datapool.getSplitScreenContentGuidance());
        this.notifierModel.notifySplitscreenNoGuidanceChanged(this.datapool.isSplitScreenNoGuidance());
        this.notifierModel.notifySplitscreenNoGuidanceContentChanged(this.datapool.getSplitScreenContentNoGuidance());
    }

    @Override
    public void reloadPersistedData() {
        this.notifyModel();
    }

    public SplitscreenInternalAPINotifier getInternalAPINotifier() {
        return this.internalAPINotifier;
    }

    public void setInternalAPINotifier(SplitscreenInternalAPINotifier splitscreenInternalAPINotifier) {
        this.internalAPINotifier = splitscreenInternalAPINotifier;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = SplitScreenTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.trace("SplitScreenTargetHSM: resetting values after DSI restart");
            }
            this.initDsiNavigation();
            this.stateInit.initModel();
            this.resetHsmToState(this.stateWork);
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("SplitScreenTargetHSM: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[79]) {
            this.initDsiNavigation();
            this.isFirstStartupDone = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("SplitScreenTargetHSM tries to unregister from ").append(string).append("...").log();
        }
    }

    void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSINavigationListener dSINavigationListener = (DSINavigationListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = SplitScreenTargetHSM.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = SplitScreenTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigation.setNotification(ATTRIBUTES_NAVIGATION, (DSIListener)dSINavigationListener);
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

