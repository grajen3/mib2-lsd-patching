/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exlap;

import de.vw.mib.asl.api.exlap.ASLExLAPFactory;
import de.vw.mib.asl.api.exlap.ExlapInterface;
import de.vw.mib.asl.api.exlap.ExlapService;
import de.vw.mib.asl.api.exlap.callback.ExlapExternalAppsUpdate;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.exlap.ExlapPersistence;
import de.vw.mib.asl.internal.exlap.ExlapTarget$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.has.HAS;
import de.vw.mib.has.HASClient;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASEngineAPI;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.has.HASInvocationHandler;
import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;
import generated.de.vw.mib.has.contexts.exlap.ExlapProperties;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.exlap.DSIExlap;
import org.dsi.ifc.exlap.Service;

public class ExlapTarget
extends AbstractASLTarget
implements HASInvocationHandler,
ExlapInterface,
ExlapService,
FactoryResetParticipant {
    boolean EXLAP_OVERRIDE_SWAP = System.getProperty("de.vw.mib.asl.internal.exlap.overrideSWaP") != null;
    private static final int EXLAP_SERVICE_ID_NAVIGATION;
    private static final int EXLAP_SERVICE_ID_SAI_VEHICLE_DATA;
    private static final int EXLAP_SERVICE_ID_RSE;
    private DSIExlap dsiExlap;
    private DSIListener dsiExlapListener;
    private boolean exlapToBeStarted;
    private boolean rseAvailable;
    private ExlapPersistence exlapPersistence;
    private HASContext context;
    private ExlapProperties hasProperties;
    private ArrayList externalAppUpdateList = new ArrayList();
    ValetParkingCallback valetParkingServiceCallback = null;
    boolean valetParkingActivated;
    private ValetParkingListener valetParkingListener = new ExlapTarget$1(this);
    static /* synthetic */ Class class$org$dsi$ifc$exlap$DSIExlap;
    static /* synthetic */ Class class$org$dsi$ifc$exlap$DSIExlapListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$exlap$ExlapService;

    public ExlapTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -223143424;
    }

    @Override
    public int getSubClassifier() {
        return 0x800000;
    }

    public void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiExlap = (DSIExlap)dSIProxy.getService(this, class$org$dsi$ifc$exlap$DSIExlap == null ? (class$org$dsi$ifc$exlap$DSIExlap = ExlapTarget.class$("org.dsi.ifc.exlap.DSIExlap")) : class$org$dsi$ifc$exlap$DSIExlap);
        this.dsiExlapListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$exlap$DSIExlapListener == null ? (class$org$dsi$ifc$exlap$DSIExlapListener = ExlapTarget.class$("org.dsi.ifc.exlap.DSIExlapListener")) : class$org$dsi$ifc$exlap$DSIExlapListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$exlap$DSIExlapListener == null ? (class$org$dsi$ifc$exlap$DSIExlapListener = ExlapTarget.class$("org.dsi.ifc.exlap.DSIExlapListener")) : class$org$dsi$ifc$exlap$DSIExlapListener, this.dsiExlapListener);
        this.dsiExlap.setNotification(1, this.dsiExlapListener);
    }

    public void dsiExlapAsyncException(int n, String string, int n2) {
        switch (n2) {
            case 2000: {
                this.dsiExlapStartResult(1);
                break;
            }
            case 2002: {
                this.dsiExlapStopResult(1);
                break;
            }
        }
    }

    public void dsiExlapStopResult(int n) {
        if (this.valetParkingServiceCallback != null) {
            this.valetParkingServiceCallback.notifyValetParkingTransitionFinished(n == 0);
            this.valetParkingServiceCallback = null;
        }
        if (n == 0) {
            this.trace("ExlapTarget.dsiExlapStopResult() ", n);
        } else {
            this.exlapPersistence.setExternalAppsUserSettingEnabled(true);
            ExlapTarget.writeBooleanToDatapool(1009917952, true);
            this.updateExternalAppsListeners();
            this.warn("ExlapTarget.dsiExlapStopResult() ", n);
        }
    }

    public void dsiExlapStartResult(int n) {
        if (this.valetParkingServiceCallback != null) {
            this.valetParkingServiceCallback.notifyValetParkingTransitionFinished(n == 0);
            this.valetParkingServiceCallback = null;
        }
        if (n == 0) {
            this.trace("ExlapTarget.dsiExlapStartResult() ", n);
        } else {
            this.exlapPersistence.setExternalAppsUserSettingEnabled(false);
            ExlapTarget.writeBooleanToDatapool(1009917952, false);
            this.updateExternalAppsListeners();
            this.warn("ExlapTarget.dsiExlapStartResult() ", n);
        }
    }

    public void dsiExlapUpdateAvailableServices(Service[] serviceArray, int n) {
        this.exlapToBeStarted = this.EXLAP_OVERRIDE_SWAP;
        this.rseAvailable = this.EXLAP_OVERRIDE_SWAP;
        if (n == 1 && serviceArray != null) {
            for (int i2 = 0; i2 < serviceArray.length; ++i2) {
                Service service = serviceArray[i2];
                if (service.getStatus() != 0) continue;
                this.exlapToBeStarted = true;
                if (service.getId() != 132608 && service.getId() != 66560) continue;
                this.rseAvailable = true;
            }
        }
        ExlapTarget.writeBooleanToDatapool(412162048, this.exlapToBeStarted);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isExternalAppSupported", this.exlapToBeStarted);
        ExlapTarget.writeBooleanToDatapool(428939264, this.rseAvailable);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isRSELightSupported", this.rseAvailable);
        if (!this.rseAvailable) {
            this.hasProperties.updateExlapRestrictionMode(2);
        } else {
            this.hasProperties.updateExlapRestrictionMode(this.convertRestrictionModeASL2HAS(this.exlapPersistence.getRseUserSetting()));
        }
        if (this.EXLAP_OVERRIDE_SWAP || n == 1) {
            this.checkStartStop();
        }
    }

    private void checkStartStop() {
        if (this.exlapToBeStarted && this.exlapPersistence.isExternalAppsUserSettingEnabled() && !this.valetParkingActivated) {
            this.dsiExlap.start();
        } else if (!this.exlapPersistence.isExternalAppsUserSettingEnabled() || !this.exlapToBeStarted) {
            this.dsiExlap.stop();
        }
    }

    private void initPersistence() {
        this.exlapPersistence = new ExlapPersistence();
        ServiceManager.persistence.registerSharedPersistable(this.exlapPersistence);
        ServiceManager.persistence.loadPersistable(5025, 0, this.exlapPersistence);
        ExlapTarget.writeIntegerToDatapool(909254656, this.exlapPersistence.getRseUserSetting());
        ExlapTarget.writeBooleanToDatapool(1009917952, this.exlapPersistence.isExternalAppsUserSettingEnabled());
        this.hasProperties.updateExlapRestrictionMode(this.convertRestrictionModeASL2HAS(this.exlapPersistence.getRseUserSetting()));
        this.updateExternalAppsListeners();
    }

    private void initHAS() {
        HASClient[] hASClientArray = HAS.getInstance().getFactory().getClients();
        for (int i2 = 0; i2 < hASClientArray.length; ++i2) {
            HASClient hASClient = hASClientArray[i2];
            if (hASClient.getDSIInstance() != 0) continue;
            hASClient.setInvocationAdapter(this);
        }
        HASEngineAPI hASEngineAPI = HAS.getInstance().getEngine();
        this.context = hASEngineAPI.getRegistry().getContextByName("Exlap");
        this.hasProperties = (ExlapProperties)this.context.getPropertiesImpl();
        this.context.setContextState(2);
    }

    @Override
    public void handleInvocation(HASInvocation hASInvocation) {
        if (hASInvocation.getState() == 0) {
            boolean bl = this.exlapToBeStarted;
            if (bl) {
                if (this.rseAvailable) {
                    if (!this.exlapPersistence.isExternalAppsUserSettingEnabled() || this.exlapPersistence.getRseUserSetting() == 0) {
                        switch (hASInvocation.getActionId()) {
                            case 5: 
                            case 19: 
                            case 20: 
                            case 29: 
                            case 32: 
                            case 33: 
                            case 35: {
                                bl = true;
                                break;
                            }
                            default: {
                                bl = false;
                                break;
                            }
                        }
                    } else {
                        bl = this.exlapPersistence.getRseUserSetting() != 2 ? hASInvocation.getActionId() != 30 && hASInvocation.getActionId() != 31 && hASInvocation.getActionId() != 9 : true;
                    }
                } else {
                    bl = true;
                }
            }
            if (!bl) {
                hASInvocation.setResultCode(2);
                if (hASInvocation.getActionId() == 2) {
                    StartGuidanceResultContainer startGuidanceResultContainer = (StartGuidanceResultContainer)HAS.getInstance().getFactory().createContainer(67);
                    startGuidanceResultContainer.setResult(2);
                    hASInvocation.setResult(startGuidanceResultContainer);
                } else {
                    hASInvocation.setResult(null);
                }
                hASInvocation.setState(1);
            }
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.initHAS();
                this.initPersistence();
                this.registerDSI();
                this.dsiExlapUpdateAvailableServices(null, 2);
                ASLExLAPFactory.getExLAPApi().setExlapTarget(this);
                FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                factoryResetService.addParticipant(this, FactoryResetComponents.FULL);
                this.valetParkingListener.notifyValetParkingStateChanged(ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState(), null);
                ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this.valetParkingListener);
                ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry().registerAPI(class$de$vw$mib$asl$api$exlap$ExlapService == null ? (class$de$vw$mib$asl$api$exlap$ExlapService = ExlapTarget.class$("de.vw.mib.asl.api.exlap.ExlapService")) : class$de$vw$mib$asl$api$exlap$ExlapService, this);
                break;
            }
            case 1075841830: {
                this.exlapPersistence.setExternalAppsUserSettingEnabled(!this.exlapPersistence.isExternalAppsUserSettingEnabled());
                ExlapTarget.writeBooleanToDatapool(1009917952, this.exlapPersistence.isExternalAppsUserSettingEnabled());
                this.updateExternalAppsListeners();
                this.checkStartStop();
                break;
            }
            case 1075841826: {
                int n = eventGeneric.getInt(0);
                this.exlapPersistence.setRseUserSetting(n);
                ExlapTarget.writeIntegerToDatapool(909254656, this.exlapPersistence.getRseUserSetting());
                this.hasProperties.updateExlapRestrictionMode(this.convertRestrictionModeASL2HAS(n));
                break;
            }
        }
    }

    private void addExternalAppsUpdates(ExlapExternalAppsUpdate exlapExternalAppsUpdate) {
        exlapExternalAppsUpdate.onChange(this.exlapPersistence.isExternalAppsUserSettingEnabled());
        this.externalAppUpdateList.add(exlapExternalAppsUpdate);
    }

    private void updateExternalAppsListeners() {
        Iterator iterator = this.externalAppUpdateList.iterator();
        while (iterator.hasNext()) {
            ExlapExternalAppsUpdate exlapExternalAppsUpdate = (ExlapExternalAppsUpdate)iterator.next();
            exlapExternalAppsUpdate.onChange(this.exlapPersistence.isExternalAppsUserSettingEnabled());
        }
    }

    private int convertRestrictionModeASL2HAS(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
        }
        return 0;
    }

    @Override
    public boolean isChauffeurModeActive() {
        return this.exlapPersistence.getRseUserSetting() == 2 || this.exlapToBeStarted && !this.rseAvailable;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.exlapPersistence.clear();
        ExlapTarget.writeBooleanToDatapool(1009917952, this.exlapPersistence.isExternalAppsUserSettingEnabled());
        ExlapTarget.writeIntegerToDatapool(909254656, this.exlapPersistence.getRseUserSetting());
        this.updateExternalAppsListeners();
        this.checkStartStop();
        factoryResetCallback.notifyResetDone();
    }

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void registerExlapExternalAppsUpdates(ExlapExternalAppsUpdate exlapExternalAppsUpdate) {
        this.addExternalAppsUpdates(exlapExternalAppsUpdate);
    }

    static /* synthetic */ ExlapPersistence access$000(ExlapTarget exlapTarget) {
        return exlapTarget.exlapPersistence;
    }

    static /* synthetic */ boolean access$100(ExlapTarget exlapTarget) {
        return exlapTarget.exlapToBeStarted;
    }

    static /* synthetic */ DSIExlap access$200(ExlapTarget exlapTarget) {
        return exlapTarget.dsiExlap;
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

