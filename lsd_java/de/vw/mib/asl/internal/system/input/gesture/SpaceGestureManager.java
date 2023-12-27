/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input.gesture;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.input.gesture.PropagatingSpaceGestureService;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager$1;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager$2;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager$3;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class SpaceGestureManager
extends AbstractSystemTarget {
    private final ConfigurationManagerAsyncValueSetterService configurationManagerAsyncValueSetterService;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final PropagatingSpaceGestureService gestureService;
    private final SystemCommonPersistenceService persistenceService;
    private final ASLPropertyManager propertyManager;
    private final SystemServices services;
    private SystemCommon systemCommon;

    public SpaceGestureManager(SystemServices systemServices) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -123071232);
        this.services = systemServices;
        this.propertyManager = systemServices.getPropertyManager();
        this.persistenceService = systemServices.getSystemCommonPersistenceService();
        this.gestureService = systemServices.getSpaceGestureService();
        this.configurationManagerAsyncValueSetterService = systemServices.getConfigurationManagerAsyncValueSetterService();
        this.configurationManagerDiag = systemServices.getConfigManagerDiag();
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075841851: {
                this.systemCommon.setGestureActive(!this.systemCommon.isGestureActive());
                this.updateSpaceGestureActivation();
                break;
            }
            case 1075841852: {
                this.systemCommon.setGestureInformationActive(!this.systemCommon.isGestureInformationActive());
                this.updateSpaceGestureInformationActivation();
                break;
            }
            case 1075841853: {
                this.systemCommon.setGestureSoundeffectActive(!this.systemCommon.isGestureSoundeffectActive());
                this.updateSpaceGestureSoundeffectActivation();
                break;
            }
        }
    }

    public void run() {
        this.loadPersistenceData();
        this.setupProfileChangeListener();
        this.registerRTMethodListener();
        this.setupFactoryResetParticipant();
        this.addObservers();
    }

    void loadPersistenceData() {
        this.systemCommon = this.persistenceService.loadSystemCommon();
        this.initializationGestureSpace();
    }

    void performFactoryReset() {
        this.systemCommon.setGestureActive(true);
        this.systemCommon.setGestureInformationActive(true);
        this.systemCommon.setGestureSoundeffectActive(true);
        this.initializationGestureSpace();
    }

    private void addObservers() {
        ServiceRegister serviceRegister = this.services.getServiceRegister();
        serviceRegister.addObserver(990584896, this.getTargetId());
        serviceRegister.addObserver(1007362112, this.getTargetId());
        serviceRegister.addObserver(1024139328, this.getTargetId());
    }

    private void initializationGestureSpace() {
        this.updateSpaceGestureActivation();
        this.updateSpaceGestureInformationActivation();
        this.updateSpaceGestureSoundeffectActivation();
    }

    private void registerRTMethodListener() {
        this.configurationManagerDiag.addFeatureFlagValueChangeReceiver(new SpaceGestureManager$1(this), 465);
    }

    private void setupFactoryResetParticipant() {
        this.services.getFactoryResetService().addParticipant(new SpaceGestureManager$2(this), FactoryResetComponents.SYSTEM);
    }

    private void setupProfileChangeListener() {
        this.persistenceService.addProfileChangeListener(new SpaceGestureManager$3(this));
    }

    private void updateSpaceGestureActivation() {
        boolean bl = this.configurationManagerDiag.isFeatureFlagSet(465);
        boolean bl2 = this.systemCommon.isGestureActive() && bl;
        this.propertyManager.valueChangedBoolean(1664229376, bl2);
        this.gestureService.applyCurrentSpaceGestureValue(bl2);
        this.configurationManagerAsyncValueSetterService.setSpaceGestureAvailability(bl2);
    }

    private void updateSpaceGestureInformationActivation() {
        boolean bl = this.systemCommon.isGestureInformationActive();
        this.propertyManager.valueChangedBoolean(1681006592, bl);
        this.gestureService.applyCurrentSpaceGestureInformationValue(bl);
    }

    private void updateSpaceGestureSoundeffectActivation() {
        boolean bl = this.systemCommon.isGestureSoundeffectActive();
        this.propertyManager.valueChangedBoolean(1697783808, bl);
        this.gestureService.applyCurrentSpaceGestureSoundEffectValue(bl);
    }

    static /* synthetic */ void access$000(SpaceGestureManager spaceGestureManager) {
        spaceGestureManager.updateSpaceGestureActivation();
    }
}

