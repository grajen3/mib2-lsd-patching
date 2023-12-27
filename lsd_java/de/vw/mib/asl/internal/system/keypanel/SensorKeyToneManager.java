/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.AbtFeatureService;
import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureServiceImpl;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager$1;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager$2;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager$3;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager$4;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager$5;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.timer.Timer;

public class SensorKeyToneManager
extends AbstractSystemTarget {
    private static final int TIMER_VOLUME_KEY_DELAY;
    private final ASLPropertyManager propertyManager;
    private final SystemCommonPersistenceService persistenceService;
    private final EventDispatcherHSM eventDispatcher;
    private final EventFactory eventFactory;
    private SystemCommon systemCommon;

    public SensorKeyToneManager(SystemServices systemServices) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -139848448);
        this.propertyManager = systemServices.getPropertyManager();
        this.persistenceService = systemServices.getSystemCommonPersistenceService();
        this.eventDispatcher = systemServices.getEventDispatcher();
        this.eventFactory = systemServices.getEventFactory();
        this.updateSensorFeedbackAvailability(systemServices.getAbtFeatureServiceImpl());
        this.loadPersistenceData();
        this.setupProfileChangeListener();
        this.setupFactoryResetParticipant(systemServices);
        this.setupHardKeyListener(systemServices);
        this.setupVolumeKeyListener(systemServices);
        this.addObservers(systemServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075841847: {
                this.systemCommon.setAcousticSensorButtonFeedback(!this.systemCommon.isAcousticSensorButtonFeedback());
                this.updateSensorFeedbackActivation();
                break;
            }
        }
    }

    void loadPersistenceData() {
        this.systemCommon = this.persistenceService.loadSystemCommon();
        this.updateSensorFeedbackActivation();
    }

    void performFactoryReset() {
        this.systemCommon.setAcousticSensorButtonFeedback(false);
        this.updateSensorFeedbackActivation();
    }

    void sendBeep() {
        if (this.systemCommon.isAcousticSensorButtonFeedback()) {
            EventGeneric eventGeneric = this.eventFactory.newEvent(638139648);
            eventGeneric.setInt(0, 4);
            this.eventDispatcher.sendSafe(eventGeneric);
        }
    }

    private void setupHardKeyListener(SystemServices systemServices) {
        SensorKeyToneManager$1 sensorKeyToneManager$1 = new SensorKeyToneManager$1(this);
        systemServices.getSystemKeyUtil().addKeyListener(1, 35, sensorKeyToneManager$1);
    }

    private void setupVolumeKeyListener(SystemServices systemServices) {
        AbtFeatureServiceImpl abtFeatureServiceImpl = systemServices.getAbtFeatureServiceImpl();
        if (abtFeatureServiceImpl.getRotaryEncoderType() == 0) {
            Timer timer = this.createVokumeKeyTimer(systemServices);
            KeyAdapter keyAdapter = this.createVolumeKeyAdapter(timer);
            systemServices.getSystemKeyUtil().addKeyListener(1, 13, keyAdapter);
        }
    }

    private KeyAdapter createVolumeKeyAdapter(Timer timer) {
        return new SensorKeyToneManager$2(this, timer);
    }

    private Timer createVokumeKeyTimer(SystemServices systemServices) {
        SensorKeyToneManager$3 sensorKeyToneManager$3 = new SensorKeyToneManager$3(this);
        Timer timer = systemServices.getTimerManager().createTimer("Volume Timer", 0, false, sensorKeyToneManager$3, systemServices.getThreadSwitcher());
        return timer;
    }

    private void addObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(923476032, this.getTargetId());
    }

    private void updateSensorFeedbackActivation() {
        this.propertyManager.valueChangedBoolean(1613897728, this.systemCommon.isAcousticSensorButtonFeedback());
    }

    private void setupProfileChangeListener() {
        this.persistenceService.addProfileChangeListener(new SensorKeyToneManager$4(this));
    }

    private void setupFactoryResetParticipant(SystemServices systemServices) {
        systemServices.getFactoryResetService().addParticipant(new SensorKeyToneManager$5(this), FactoryResetComponents.SYSTEM);
    }

    private void updateSensorFeedbackAvailability(AbtFeatureService abtFeatureService) {
        boolean bl = abtFeatureService.getButtonTechnology() == 2;
        this.propertyManager.valueChangedBoolean(1597120512, bl);
    }
}

