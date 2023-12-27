/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.tourimport.states;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.online.tourimport.TourImportFactory;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateActiveIdle;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateDownloadActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateExportActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateNotActive;
import de.vw.mib.asl.internal.online.tourimport.states.TourImportStateParent;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOnlineTourImport;

public class TourImportTarget
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    private final HsmState _stateParent;
    private HsmState _stateActiveIdle;
    private HsmState _stateActive;
    private HsmState _stateNotActive;
    private HsmState _stateDownloadActive;
    private HsmState _stateExportActive;
    private DSIOnlineTourImport _dsiTourImport = null;
    private DSIListener _dsiTourImportListener = null;
    private final String _classname = super.getClass().getName();
    final int[] OBSERVED_EVENTS = new int[]{-1534721792, -1551499008, -1568276224, -1585053440};
    final int[] DSI_ATTR = new int[0];
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTourImport;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTourImportListener;

    public TourImportTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this._stateParent = new TourImportStateParent(this, this.hsm, "TourImportStateParent", this.getWorkStateParent());
        TourImportFactory.setOnlineTourImportTarget(this);
    }

    private void initializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".initializeDSI()").log();
        }
        if (this.getDSITourImport() == null) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this._dsiTourImport = (DSIOnlineTourImport)dSIProxy.getService(this, class$org$dsi$ifc$online$DSIOnlineTourImport == null ? (class$org$dsi$ifc$online$DSIOnlineTourImport = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImport")) : class$org$dsi$ifc$online$DSIOnlineTourImport);
            this._dsiTourImportListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$online$DSIOnlineTourImportListener == null ? (class$org$dsi$ifc$online$DSIOnlineTourImportListener = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImportListener")) : class$org$dsi$ifc$online$DSIOnlineTourImportListener);
            if (this._dsiTourImportListener != null) {
                dSIProxy.addResponseListener(this, class$org$dsi$ifc$online$DSIOnlineTourImportListener == null ? (class$org$dsi$ifc$online$DSIOnlineTourImportListener = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImportListener")) : class$org$dsi$ifc$online$DSIOnlineTourImportListener, this._dsiTourImportListener);
            } else {
                this.warn().append(this._classname).append(".initializeDSI() Invalid DSITourImportListener").log();
            }
            if (this._dsiTourImport != null) {
                this._dsiTourImport.setNotification(this.DSI_ATTR, this._dsiTourImportListener);
            } else {
                this.warn().append(this._classname).append(".initializeDSI() Invalid DSITourImport").log();
            }
        } else if (this.isTraceEnabled()) {
            this.warn().append(this._classname).append(".initializeDSI() Already initialized").log();
        }
    }

    private void deInitializeDSI() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".deInitializeDSI()").log();
        }
        this._dsiTourImport = null;
        this._dsiTourImportListener = null;
    }

    private void startup() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startup()").log();
        }
        this.addObservers(this.OBSERVED_EVENTS);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$online$DSIOnlineTourImport == null ? (class$org$dsi$ifc$online$DSIOnlineTourImport = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImport")) : class$org$dsi$ifc$online$DSIOnlineTourImport, this);
        this.startTimer();
        try {
            if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".Navi service is available").log();
                }
                TourImportFactory.getNaviServices();
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            this.error(navigationServiceException);
        }
    }

    private void shutdown() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".shutdown()").log();
        }
        ServiceManager.dsiServiceLocator.removeServiceStateListener(class$org$dsi$ifc$online$DSIOnlineTourImport == null ? (class$org$dsi$ifc$online$DSIOnlineTourImport = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImport")) : class$org$dsi$ifc$online$DSIOnlineTourImport, this);
        this.removeObservers(this.OBSERVED_EVENTS);
        this.deInitializeDSI();
    }

    public void startTimer() {
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".startTimer()").log();
        }
        this.startTimer(-1249509120, (long)0, false);
    }

    public DSIOnlineTourImport getDSITourImport() {
        return this._dsiTourImport;
    }

    public HsmState getNonActiveState() {
        if (this._stateNotActive == null) {
            this._stateNotActive = new TourImportStateNotActive(this, this.hsm, "TourImportStatetNotActive", this._stateParent);
        }
        return this._stateNotActive;
    }

    public HsmState getActiveIdleState() {
        if (this._stateActiveIdle == null) {
            this._stateActiveIdle = new TourImportStateActiveIdle(this, this.hsm, "TourImportStatetActiveIdle", this._stateParent);
        }
        return this._stateActiveIdle;
    }

    public HsmState getActiveState() {
        if (this._stateActive == null) {
            this._stateActive = new TourImportStateActive(this, this.hsm, "TourImportStatetActive", this.getActiveIdleState());
        }
        return this._stateActive;
    }

    public HsmState getDownloadActiveState() {
        if (this._stateDownloadActive == null) {
            this._stateDownloadActive = new TourImportStateDownloadActive(this, this.hsm, "TourImportStatetDownloadActive", this.getActiveState());
        }
        return this._stateDownloadActive;
    }

    public HsmState getExportActiveState() {
        if (this._stateExportActive == null) {
            this._stateExportActive = new TourImportStateExportActive(this, this.hsm, "TourImportStatetExportActive", this.getActiveState());
        }
        return this._stateExportActive;
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
            case 100021: {
                if (this.isTraceEnabled()) {
                    this.trace().append(this._classname).append(".gotEvent(TIMER_EVT_ECHECK_DSISEARCH)").log();
                }
                if (this.getDSITourImport() != null) break;
                ServiceManager.dsiServiceAdmin.startService((class$org$dsi$ifc$online$DSIOnlineTourImport == null ? (class$org$dsi$ifc$online$DSIOnlineTourImport = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImport")) : class$org$dsi$ifc$online$DSIOnlineTourImport).getName(), 0);
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
        return 929961472;
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".registered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string.intern() == (class$org$dsi$ifc$online$DSIOnlineTourImport == null ? (class$org$dsi$ifc$online$DSIOnlineTourImport = TourImportTarget.class$("org.dsi.ifc.online.DSIOnlineTourImport")) : class$org$dsi$ifc$online$DSIOnlineTourImport).getName().intern()) {
            this.initializeDSI();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        String string2 = string.intern();
        if (this.isTraceEnabled()) {
            this.trace().append(this._classname).append(".unregistered(").append(string2).append(", ").append(n).append(")").log();
        }
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[93]) {
            this.deInitializeDSI();
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

