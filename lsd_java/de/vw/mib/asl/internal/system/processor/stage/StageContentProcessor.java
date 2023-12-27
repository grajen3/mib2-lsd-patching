/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor.stage;

import de.vw.mib.asl.api.system.contentprocessor.AbstractContentProcessor;
import de.vw.mib.asl.api.system.powerstate.PowerStateListener;
import de.vw.mib.asl.api.system.powerstate.PowerStateService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListener;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.persistence.PersistenceValidator;
import de.vw.mib.asl.internal.system.processor.manager.ClockManager;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor$1;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor$2;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor$3;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor$4;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import java.util.ArrayList;
import java.util.List;

public class StageContentProcessor
extends AbstractContentProcessor {
    private final List allowedHmiOffContents = this.getAllowedHmiOffContents();
    private final PowerStateService powerStateService;
    private final ClockManager clockManager;
    private final SystemCommonPersistenceService commonPersistenceService;
    private final AslPersistenceSyncApi persistenceSyncApi;
    private SystemCommon systemCommon;
    private String lastUserMode;
    private String hmiOffContentOverride;
    private boolean valetParkingEnabled;
    private boolean wasPowerOff;
    private final SystemLogger systemLogger;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$system$processor$stage$StageContentProcessor;

    public StageContentProcessor(SystemServices systemServices) {
        super(systemServices.getAsl1Logger(), "ScreenAreaStage");
        this.verifyConstructorArguments(systemServices);
        ValetParkingService valetParkingService = systemServices.getValetParkingService();
        this.valetParkingEnabled = valetParkingService.getCurrentValetParkingState();
        valetParkingService.addListener(this.createValetparkingServiceListener());
        this.clockManager = systemServices.getClockManager();
        this.commonPersistenceService = systemServices.getSystemCommonPersistenceService();
        this.persistenceSyncApi = systemServices.getPersistence();
        this.loadPersistence();
        this.lastUserMode = this.systemCommon.getLastContentId();
        this.powerStateService = systemServices.getPowerStateService();
        this.powerStateService.addListener(this.createPowerStateListener());
        this.processNewPowerState(this.powerStateService.getPowerState());
        this.commonPersistenceService.addProfileChangeListener(this.createProfileChangeListener());
        this.persistenceSyncApi.addGlobalProfileChangeListener(this.createGlobalProfileChangeListener());
        this.systemLogger = new SystemLogger(systemServices.getAsl1Logger(), class$de$vw$mib$asl$internal$system$processor$stage$StageContentProcessor == null ? (class$de$vw$mib$asl$internal$system$processor$stage$StageContentProcessor = StageContentProcessor.class$("de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor")) : class$de$vw$mib$asl$internal$system$processor$stage$StageContentProcessor);
    }

    public String getLastUserMode() {
        return this.lastUserMode;
    }

    @Override
    public void requestContent(String string) {
        this.systemLogger.trace(new Object[]{"requestContent called! Content id is ", string, "."});
        if ("HMI_OFF".equals(string)) {
            this.updateOffContent();
        } else {
            this.doRequestContent(string);
        }
    }

    void onProfileChangeCompleted() {
        this.persistLastContent(this.lastUserMode);
    }

    void loadPersistence() {
        this.systemCommon = this.commonPersistenceService.loadSystemCommon();
    }

    void processNewPowerState(int n) {
        this.overrideLastUserMode();
        if (!this.checkIsPowerStateOff()) {
            this.hmiOffContentOverride = null;
        }
        switch (n) {
            case 2: {
                if (this.isValetParkingEnabled()) {
                    this.updateContentForValetParking();
                    break;
                }
                this.updateContent(this.lastUserMode);
                break;
            }
            case 1: {
                if (this.clockManager.isClockOn()) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1781669888, true);
                    this.updateHmiOffContent("HMI_USER_PERCEIVED_CLOCK");
                    break;
                }
                this.updateHmiOffContent("HMI_USER_PERCEIVED_OFF");
                break;
            }
            case 4: {
                this.updateContent("HMI_SWDL");
                break;
            }
            default: {
                this.updateHmiOffContent("HMI_USER_PERCEIVED_OFF");
            }
        }
        this.wasPowerOff = this.checkIsPowerStateOff();
    }

    private void updateContentForValetParking() {
        if ("HMI_CLIMATE".equals(this.lastUserMode)) {
            this.updateContent("HMI_CLIMATE");
        } else {
            this.updateContent("HMI_CAR");
        }
    }

    void processNewValetparkingState(boolean bl) {
        if (bl != this.valetParkingEnabled) {
            this.valetParkingEnabled = bl;
            if (this.powerStateService.getPowerState() == 2) {
                this.processNewPowerState(this.powerStateService.getPowerState());
            }
        }
    }

    private GlobalProfileChangeListener createGlobalProfileChangeListener() {
        return new StageContentProcessor$1(this);
    }

    private AbstractProfileChangeHandler createProfileChangeListener() {
        return new StageContentProcessor$2(this);
    }

    private boolean updateOffContent() {
        if (this.checkIsPowerStateOff()) {
            this.hmiOffContentOverride = null;
            this.processNewPowerState(this.powerStateService.getPowerState());
            return true;
        }
        this.logger.warn(2048, "Ignoring content request for HMI_Off since power state is no OFF state.");
        return false;
    }

    private void doRequestContent(String string) {
        this.saveRequestedContent(string);
        this.persistLastContent(string);
        if (this.checkContentRequestAllowed(string)) {
            this.processNewPowerState(this.powerStateService.getPowerState());
        }
    }

    private void overrideLastUserMode() {
        if (this.wasPowerOff && !this.checkIsPowerStateOff()) {
            this.lastUserMode = this.systemCommon.getLastContentId();
        }
    }

    private void saveRequestedContent(String string) {
        if (this.checkIsPowerStateOff() && this.allowedHmiOffContents.contains(string)) {
            this.hmiOffContentOverride = string;
        } else {
            this.lastUserMode = string;
        }
    }

    private void updateHmiOffContent(String string) {
        if (this.allowedHmiOffContents.contains(this.hmiOffContentOverride)) {
            this.updateContent(this.hmiOffContentOverride);
        } else {
            this.updateContent(string);
        }
    }

    private List getAllowedHmiOffContents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("HMI_CLIMATE");
        return arrayList;
    }

    private boolean isValetParkingEnabled() {
        return this.valetParkingEnabled && this.lastUserMode != "HMI_SERVICEMODE" && this.lastUserMode != "HMI_TESTMODE";
    }

    private boolean checkContentRequestAllowed(String string) {
        boolean bl = this.checkIsPowerState(2);
        boolean bl2 = this.checkIsPowerStateOff() && this.allowedHmiOffContents.contains(string);
        boolean bl3 = bl || bl2;
        return bl3;
    }

    private boolean checkIsPowerState(int n) {
        return this.powerStateService.getPowerState() == n;
    }

    private boolean checkIsPowerStateOff() {
        return this.checkIsPowerState(1) || this.checkIsPowerState(0);
    }

    private PowerStateListener createPowerStateListener() {
        return new StageContentProcessor$3(this);
    }

    private ValetParkingListener createValetparkingServiceListener() {
        return new StageContentProcessor$4(this);
    }

    private void persistLastContent(String string) {
        boolean bl;
        String string2 = "HMI_KOREA_TPEG";
        if ("HMI_KOREA_TPEG".equals(string)) {
            string = "HMI_KOREA_NAV";
            this.logger.info(2048).append("Incoming content id ").append("HMI_KOREA_TPEG").append(" will be persisted as ").append(string).append(".").log();
        }
        boolean bl2 = bl = PersistenceValidator.validateLastContentId(string) && !this.persistenceSyncApi.isProfileChangeRunning();
        if (bl) {
            this.systemCommon.setLastContentId(string);
        }
    }

    private void verifyConstructorArguments(SystemServices systemServices) {
        if (systemServices == null) {
            throw new IllegalArgumentException("The system services must not be null.");
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

