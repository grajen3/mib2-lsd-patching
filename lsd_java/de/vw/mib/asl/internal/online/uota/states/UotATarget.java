/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.states;

import de.vw.mib.asl.api.download.ASLDownloadFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.online.uota.UotAFactory;
import de.vw.mib.asl.internal.online.uota.common.UotAPropertyManager;
import de.vw.mib.asl.internal.online.uota.states.UotAStateActive;
import de.vw.mib.asl.internal.online.uota.states.UotAStateActiveDownload;
import de.vw.mib.asl.internal.online.uota.states.UotAStateActiveSWDL;
import de.vw.mib.asl.internal.online.uota.states.UotAStateNotActive;
import de.vw.mib.asl.internal.online.uota.states.UotAStateParent;
import de.vw.mib.asl.internal.online.uota.states.UotAStatePending;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.Util;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.uota.DSIUotA;

public class UotATarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    private final String _classname = super.getClass().getName();
    private final HsmState _stateParent;
    private HsmState _stateNotActive;
    private HsmState _stateActive;
    private HsmState _stateActiveDownload;
    private HsmState _stateActiveSWDL;
    private HsmState _statePending;
    private String _currentState;
    private DSIUotA _dsiUotA = null;
    private DSIListener _dsiUotAListener = null;
    private UotAPropertyManager _propertyManager;
    final int[] OBSERVED_EVENTS = new int[]{155076864, 1612194560, 1628971776, 1696080640, 701895488, 718672704, 651563840, 668341056, 567677760, 634786624, 735449920, 769004352, 1171657536, 1188434752, 1020662592, 1037439808, 1205211968, 1070994240, 1154880320, 1104548672, 1121325888, 1138103104};
    final int[] DSI_ATTR = new int[]{1, 2, 3};
    static /* synthetic */ Class class$org$dsi$ifc$uota$DSIUotA;
    static /* synthetic */ Class class$org$dsi$ifc$uota$DSIUotAListener;

    public UotATarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._stateParent = new UotAStateParent(this, this.hsm, "UotAStateParent", this.getWorkStateParent());
        this._currentState = this._stateParent.getName();
    }

    public HsmState getStateActive() {
        if (this._stateActive == null) {
            this._stateActive = new UotAStateActive(this, this.hsm, "UotAStateActive", this._stateParent);
        }
        this._currentState = this._stateActive.getName();
        return this._stateActive;
    }

    public HsmState getStateActiveDownload() {
        if (this._stateActiveDownload == null) {
            this._stateActiveDownload = new UotAStateActiveDownload(this, this.hsm, "UotAStateActiveDownload", this.getStateActive());
        }
        this._currentState = this._stateActiveDownload.getName();
        return this._stateActiveDownload;
    }

    public HsmState getStateNotActive() {
        if (this._stateNotActive == null) {
            this._stateNotActive = new UotAStateNotActive(this, this.hsm, "UotAStateNotActive", this._stateParent);
        }
        this._currentState = this._stateNotActive.getName();
        return this._stateNotActive;
    }

    public HsmState getStateActiveSWDL() {
        if (this._stateActiveSWDL == null) {
            this._stateActiveSWDL = new UotAStateActiveSWDL(this, this.hsm, "UotAStateActiveSWDL", this._stateParent);
        }
        this._currentState = this._stateActiveSWDL.getName();
        return this._stateActiveSWDL;
    }

    public HsmState getStatePending() {
        if (this._statePending == null) {
            this._statePending = new UotAStatePending(this, this.hsm, "UotAStatePending", this._stateParent);
        }
        this._currentState = this._statePending.getName();
        return this._statePending;
    }

    public String getCurrentStateName() {
        return this._currentState;
    }

    private void initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this._dsiUotA = (DSIUotA)dSIProxy.getService(this, class$org$dsi$ifc$uota$DSIUotA == null ? (class$org$dsi$ifc$uota$DSIUotA = UotATarget.class$("org.dsi.ifc.uota.DSIUotA")) : class$org$dsi$ifc$uota$DSIUotA);
        this._dsiUotAListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$uota$DSIUotAListener == null ? (class$org$dsi$ifc$uota$DSIUotAListener = UotATarget.class$("org.dsi.ifc.uota.DSIUotAListener")) : class$org$dsi$ifc$uota$DSIUotAListener);
        if (this._dsiUotAListener != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$uota$DSIUotAListener == null ? (class$org$dsi$ifc$uota$DSIUotAListener = UotATarget.class$("org.dsi.ifc.uota.DSIUotAListener")) : class$org$dsi$ifc$uota$DSIUotAListener, this._dsiUotAListener);
        } else {
            this.warn().append(this._classname).append(".initializeDSI() Invalid DSIUotAListener").log();
        }
        if (this._dsiUotA != null) {
            this._dsiUotA.setNotification(4, this._dsiUotAListener);
            String string = this.getPropertyManager().getCurrentLanguage();
            if (!Util.isNullOrEmpty(string)) {
                this._dsiUotA.setLanguage(this.getPropertyManager().getCurrentLanguage());
            }
        } else {
            this.warn().append(this._classname).append(".initializeDSI() Invalid DSIUotA").log();
        }
    }

    private void deInitializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".deInitializeDSI()").log();
        }
        this._dsiUotA = null;
        this._dsiUotAListener = null;
    }

    private void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startup()").log();
        }
        this.addObservers(this.OBSERVED_EVENTS);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$uota$DSIUotA == null ? (class$org$dsi$ifc$uota$DSIUotA = UotATarget.class$("org.dsi.ifc.uota.DSIUotA")) : class$org$dsi$ifc$uota$DSIUotA, this);
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.addParticipant(UotAFactory.getPacketController(this), FactoryResetComponents.ONLINE);
        UotAFactory.getNavigationGuidanceService(this);
        if (ASLDownloadFactory.getDownloadApi().getDownloadStateService() != null) {
            ASLDownloadFactory.getDownloadApi().getDownloadStateService().addListener(UotAFactory.getInstallationService(this));
        }
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startdown()").log();
        }
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$uota$DSIUotA == null ? (class$org$dsi$ifc$uota$DSIUotA = UotATarget.class$("org.dsi.ifc.uota.DSIUotA")) : class$org$dsi$ifc$uota$DSIUotA, this);
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.removeParticipant(UotAFactory.getPacketController(this), FactoryResetComponents.ONLINE);
    }

    public void setRemainingNotifications() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".setRemainingNotifications()").log();
        }
        if (this._dsiUotA != null && this._dsiUotAListener != null) {
            this._dsiUotA.setNotification(this.DSI_ATTR, this._dsiUotAListener);
        }
    }

    public DSIUotA getDSIUotA() {
        if (this._dsiUotA == null) {
            this.warn().append(this._classname).append(".getDSIUotA() Invalid DSI instance").log();
        }
        return this._dsiUotA;
    }

    public UotAPropertyManager getPropertyManager() {
        if (this._propertyManager == null) {
            this._propertyManager = UotAFactory.getPropertyManager();
        }
        return this._propertyManager;
    }

    public void updateUOTAServiceStatus(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(new StringBuffer().append(".updateUOTAServiceStatus(").append(bl).append(")").toString()).log();
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(205408512);
        eventGeneric.setBoolean(0, bl);
        this.sendSafe(eventGeneric);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_ON)").log();
                }
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(POWER_OFF)").log();
                }
                this.shutdown();
                break;
            }
        }
        super.gotEvent(eventGeneric);
    }

    @Override
    public int getClassifier() {
        return 32768;
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    @Override
    protected HsmState getDefaultState() {
        return this._stateParent;
    }

    @Override
    public int getDefaultTargetId() {
        return 946738688;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[150]) {
            this.initializeDSI();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1083965440);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 9);
            eventGeneric.setString(2, "NO_LANGUAGE");
            this.sendSafe(eventGeneric);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[150]) {
            this.deInitializeDSI();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1117519872);
            eventGeneric.setInt(0, this.getTargetId());
            eventGeneric.setInt(1, 9);
            this.sendSafe(eventGeneric);
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

