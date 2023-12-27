/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.states;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapManager;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapParentState;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapStateActive;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapStateNotActive;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu;
import org.dsi.ifc.base.DSIListener;

public class TrafficMiniMapTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    private HsmState _stateParent;
    private HsmState _stateNotActive;
    private HsmState _stateActive;
    private DSIAsiaTrafficInfoMenu _dsiAsiaTrafficInfoMenu = null;
    private DSIListener _dsiAsiaTrafficInfoMenuListener = null;
    private final String _classname;
    final int[] OBSERVED_EVENTS = new int[]{155076864, -1047453440, -2034685376, -2101794240, -2135348672, -2001130944};
    final int[] DSI_ATTR = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener;

    public TrafficMiniMapTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._classname = "TrafficMiniMapTarget";
        this._stateParent = new TrafficMiniMapParentState(this, this.hsm, "TrafficMiniMapStateNotActive", this.getWorkStateParent());
        TrafficMiniMapManager.setTrafficMiniMapTarget(this);
    }

    public HsmState getParentState() {
        if (this._stateParent == null) {
            this._stateParent = new TrafficMiniMapParentState(this, this.hsm, "TrafficMiniMapParentState", this.getWorkStateParent());
        }
        return this._stateParent;
    }

    public HsmState getStateActive() {
        if (this._stateActive == null) {
            this._stateActive = new TrafficMiniMapStateActive(this, this.hsm, "TrafficMiniMapStateActive", this._stateParent);
        }
        return this._stateActive;
    }

    public HsmState getStateNotActive() {
        if (this._stateNotActive == null) {
            this._stateNotActive = new TrafficMiniMapStateNotActive(this, this.hsm, "TrafficMiniMapStateNotActive", this._stateParent);
        }
        return this._stateNotActive;
    }

    void initPersistence() {
        if (this.isTraceEnabled()) {
            this.trace().append("TrafficMiniMapTarget").append(".initPersistence()").log();
        }
        ServiceManager.persistence.registerSharedPersistable(TrafficMiniMapManager.getPersistence());
        ServiceManager.persistence.loadPersistable(5027, 0, TrafficMiniMapManager.getPersistence());
    }

    private void initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("TrafficMiniMapTarget").append(".initializeDSI()").log();
        }
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this._dsiAsiaTrafficInfoMenu = (DSIAsiaTrafficInfoMenu)dSIProxy.getService(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = TrafficMiniMapTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu);
        this._dsiAsiaTrafficInfoMenuListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = TrafficMiniMapTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener);
        if (this._dsiAsiaTrafficInfoMenuListener != null) {
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = TrafficMiniMapTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener, this._dsiAsiaTrafficInfoMenuListener);
        } else {
            this.warn().append("TrafficMiniMapTarget").append(".initializeDSI() Invalid DSIAsiaTrafficInfoMenuListener").log();
        }
        if (this._dsiAsiaTrafficInfoMenu != null) {
            this._dsiAsiaTrafficInfoMenu.setNotification(this.DSI_ATTR, this._dsiAsiaTrafficInfoMenuListener);
        } else {
            this.warn().append("TrafficMiniMapTarget").append(".initializeDSI() Invalid DSIAsiaTrafficInfoMenu").log();
        }
    }

    private void deInitializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append("TrafficMiniMapTarget").append(".deInitializeDSI()").log();
        }
        this._dsiAsiaTrafficInfoMenu = null;
        this._dsiAsiaTrafficInfoMenuListener = null;
    }

    private void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append("TrafficMiniMapTarget").append(".startup()").log();
        }
        this.initPersistence();
        this.addObservers(this.OBSERVED_EVENTS);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = TrafficMiniMapTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu, this);
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.addParticipant(TrafficMiniMapManager.getTrafficMiniMapController(), FactoryResetComponents.ONLINE);
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append("TrafficMiniMapTarget").append(".shutdown()").log();
        }
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu = TrafficMiniMapTarget.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenu")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenu, this);
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        factoryResetService.removeParticipant(TrafficMiniMapManager.getTrafficMiniMapController(), FactoryResetComponents.ONLINE);
    }

    public DSIAsiaTrafficInfoMenu getDSI() {
        if (this._dsiAsiaTrafficInfoMenu == null) {
            this.warn().append("TrafficMiniMapTarget").append(".getDSI() Invalid DSI instance").log();
        }
        return this._dsiAsiaTrafficInfoMenu;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TrafficMiniMapTarget").append(".gotEvent(POWER_ON)").log();
                }
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(196)) break;
                this.startup();
                break;
            }
            case 107: {
                if (this.isTraceEnabled()) {
                    this.trace().append("TrafficMiniMapTarget").append(".gotEvent(POWER_OFF)").log();
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
        return 128;
    }

    @Override
    protected HsmState getDefaultState() {
        return this._stateParent;
    }

    @Override
    public int getDefaultTargetId() {
        return -1026746624;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append("TrafficMiniMapTarget").append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[4]) {
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
            this.trace().append("TrafficMiniMapTarget").append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[4]) {
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

