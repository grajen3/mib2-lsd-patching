/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiAbstractHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateCategory;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateCategoryGroup;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateMain;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util.PPoiNotifierModel;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public class PPoiHsmTarget
extends PPoiAbstractHsmTarget
implements DSIServiceStateListener {
    private DSINavigation dsiNavigation;
    private DSIListener dsiNavigationListener;
    protected final PPoiNotifierModel notifierModel;
    private static final int[] DSI_NAV_UPDATES = new int[]{62, 91};
    private int lastLiValueWindowSize = -1;
    final HsmState statePpoi = new PPoiStateMain(this, this.hsm, "pPoiStateMain", this.getWorkStateParent());
    final HsmState statePPoiGroupCategory = new PPoiStateCategoryGroup(this, this.hsm, "pPoiStateGroupCategory", this.statePpoi);
    final PPoiStateCategory statePPoiCategoy = new PPoiStateCategory(this, this.hsm, "pPoiSatateGroupElement", this.statePpoi);
    final HsmState statePPoiDetail = new PPoiStateDetail(this, this.hsm, "pPoiStateDetail", this.statePpoi);
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public PPoiHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.notifierModel = new PPoiNotifierModel();
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PPoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()) && !this.isFirstStartupDone) {
            this.initDSINavigation();
            this.isFirstStartupDone = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PPoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            this.dsiNavigationListener = null;
            if (this.isTraceEnabled()) {
                this.trace().append("PPoiHsmTarget unregistered from ").append(string).log();
            }
        }
    }

    private void initDSINavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.myTrace(null, "DSI_NAVIGATION service registered");
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PPoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = PPoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.dsiNavigation.setNotification(DSI_NAV_UPDATES, this.dsiNavigationListener);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.statePpoi;
    }

    public DSINavigation getDsiNavigation() {
        return this.dsiNavigation;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PPoiHsmTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("PPoiHsmTarget: resetting values after DSI restart");
            }
            this.resetHsmToState(this.getDefaultState());
            this.lastLiValueWindowSize = -1;
            this.initDSINavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("PPoiHsmTarget: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    public void clearAllModelData() {
        ((PPoiStateCategoryGroup)this.statePPoiGroupCategory).clearModelData();
        this.statePPoiCategoy.clearModelData();
        ((PPoiStateDetail)this.statePPoiDetail).clearModelData();
        this.statePPoiCategoy.setSelectedEntryFromGroupList(0);
    }

    void transAfterCallback(HsmState hsmState) {
        try {
            if (this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
                this.trace().append("transitioning to state '").append(hsmState.getName()).append("'").log();
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-125304576);
            eventGeneric.setObject(0, hsmState);
            this.triggerMe(eventGeneric, -125304576);
        }
        catch (Exception exception) {
            this.error("cannot transition to new state");
            this.error(exception.toString());
        }
    }

    public void setLiValueListWindowSize(PPoiAbstractHsmState pPoiAbstractHsmState, int n, boolean bl) {
        if (this.getTextLogger().isTraceEnabled(this.getSubClassifier())) {
            this.makeTrace(pPoiAbstractHsmState).append("setLiValueListWindowSize:").append(n).append(" init:").append(bl ? "true" : "false").log();
        }
        if (bl || this.lastLiValueWindowSize != n) {
            this.lastLiValueWindowSize = n;
            new CmdSetLiValueListWindowSize(pPoiAbstractHsmState, n).execute();
        }
    }

    public int getLastLiValueWindowSize() {
        return this.lastLiValueWindowSize;
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

