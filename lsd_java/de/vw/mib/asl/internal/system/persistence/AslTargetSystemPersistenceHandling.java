/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.persistence.AslTargetSystemPersistenceHandling$1;
import de.vw.mib.asl.internal.system.persistence.PersistenceGeneralVehicleStatesListener;
import de.vw.mib.asl.internal.system.persistence.PopupActivatingGlobalProfileChangeListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

public class AslTargetSystemPersistenceHandling
extends AbstractASLTarget {
    private static final String LOGGING_DELIM;
    private final DSIProxy dsiProxy;
    private final int defaultDebugProbes = this.retrieveDefaultDebugProbes();
    private PersistenceGeneralVehicleStatesListener dsiListener;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public AslTargetSystemPersistenceHandling(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -290843392;
    }

    void connectToDsi() {
        try {
            if (this.dsiListener == null) {
                this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)this.dsiProxy.getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AslTargetSystemPersistenceHandling.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                this.dsiListener = new PersistenceGeneralVehicleStatesListener(ServiceManager.persistence, ServiceManager.logger);
                this.dsiProxy.addResponseListener(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = AslTargetSystemPersistenceHandling.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener, this.dsiListener);
            }
            this.dsiGeneralVehicleStates.setNotification(new int[]{25}, (DSIListener)this.dsiListener);
        }
        catch (Exception exception) {
            this.info("Could not connect to DSIGeneralVehicleStates");
        }
    }

    private int retrieveDefaultDebugProbes() {
        String string = System.getProperty("debugProbes.default");
        int n = -1;
        if (string != null) {
            try {
                n = Integer.valueOf(string);
            }
            catch (NumberFormatException numberFormatException) {
                this.warn().append("[AslTargetSystemPersistenceHandling] ").append("Invalid default debug probes configuration.").append(numberFormatException).log();
            }
        }
        return n;
    }

    private void processPowerOn() {
        this.setupPersistableEarlyData();
        this.setupPopupActivatingListener();
        this.connectToDsi();
        this.dsiProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AslTargetSystemPersistenceHandling.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this.createDsiServiceStateAdapter());
    }

    private void setupPopupActivatingListener() {
        AslPersistenceSyncApi aslPersistenceSyncApi = ServiceManager.persistence;
        PopupActivatingGlobalProfileChangeListener popupActivatingGlobalProfileChangeListener = new PopupActivatingGlobalProfileChangeListener(ServiceManager.aslPropertyManager, aslPersistenceSyncApi);
        aslPersistenceSyncApi.addGlobalProfileChangeListener(popupActivatingGlobalProfileChangeListener);
    }

    private void setupPersistableEarlyData() {
        IPersistableEarlyData iPersistableEarlyData = this.loadPersistenceData();
        this.setupDebugProbeConfig(iPersistableEarlyData);
        this.setupViewSetup(iPersistableEarlyData);
    }

    private void setupViewSetup(IPersistableEarlyData iPersistableEarlyData) {
        AslTargetSystemPersistenceHandling.writeBooleanToDatapool(1618, iPersistableEarlyData.getTestmodeAlternativeViewSetup1());
        AslTargetSystemPersistenceHandling.writeBooleanToDatapool(1619, iPersistableEarlyData.getTestmodeAlternativeViewSetup2());
    }

    private void setupDebugProbeConfig(IPersistableEarlyData iPersistableEarlyData) {
        int n = this.retrieveActivatedDebugProbes(iPersistableEarlyData);
        this.triggerDebugProbeChange(n);
    }

    private void triggerDebugProbeChange(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.triggerObserver(1115101952, eventGeneric);
        ServiceManager.configManagerDiag.setDynamicTmDebugProbesCfg(n);
    }

    private int retrieveActivatedDebugProbes(IPersistableEarlyData iPersistableEarlyData) {
        int n = iPersistableEarlyData.getDebugProbeConfiguration();
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemPersistenceHandling] ").append("Found DebugProbesConfig, sending it now... >> ").append(n);
        }
        if (n == 0 && this.defaultDebugProbes != -1) {
            this.info().append("[AslTargetSystemPersistenceHandling] ").append("No debug probes were found, but defaults are set, using these instead").log();
            n = this.defaultDebugProbes;
        }
        return n;
    }

    private IPersistableEarlyData loadPersistenceData() {
        IPersistableEarlyData iPersistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
        SharedPersistable sharedPersistable = (SharedPersistable)((Object)iPersistableEarlyData);
        ServiceManager.persistence.registerSharedPersistable(sharedPersistable);
        boolean bl = ServiceManager.persistence.loadPersistable(5000, 0, sharedPersistable);
        if (!bl) {
            this.info().append("[AslTargetSystemPersistenceHandling] ").append("No Early Persistable Data loaded, use default values").log();
        }
        return iPersistableEarlyData;
    }

    private DSIServiceStateListenerAdapter createDsiServiceStateAdapter() {
        return new AslTargetSystemPersistenceHandling$1(this);
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

