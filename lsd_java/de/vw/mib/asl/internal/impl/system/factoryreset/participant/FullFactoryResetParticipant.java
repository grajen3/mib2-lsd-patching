/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.AbstractLegacyFactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.FullFactoryResetParticipant$1;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.timer.Timer;

public class FullFactoryResetParticipant
extends AbstractLegacyFactoryResetParticipant {
    static final String DEFAULT_CONTENT_ID;
    private final ASLPropertyManager aslPropertyManager;
    private final SystemCommonPersistenceService commonPersistenceService;
    private SystemCommon systemCommon;

    public FullFactoryResetParticipant(SystemServices systemServices) {
        super(systemServices, -358858496);
        this.aslPropertyManager = systemServices.getPropertyManager();
        this.commonPersistenceService = systemServices.getSystemCommonPersistenceService();
        this.loadPersistence();
        this.commonPersistenceService.addProfileChangeListener(this.createProfileChangeListener());
    }

    @Override
    public long getCallbackTimeout() {
        return 0;
    }

    @Override
    public String getComponentName() {
        return "Full";
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.resetLastMainContext();
        this.triggerObserver();
        Timer timer = this.createTimer(this.getComponentName(), this.getCallbackTimeout(), this.createDefaultCallbackRunnable(factoryResetCallback));
        timer.start();
    }

    void loadPersistence() {
        this.systemCommon = this.commonPersistenceService.loadSystemCommon();
    }

    private ProfileChangeListener createProfileChangeListener() {
        return new FullFactoryResetParticipant$1(this);
    }

    private void resetLastMainContext() {
        this.aslPropertyManager.valueChangedInteger(1612, 0);
        this.systemCommon.setLastContentId("HMI_RADIO");
    }
}

