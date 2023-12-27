/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanCallback;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanManager$1;
import de.vw.mib.asl.internal.system.persistence.PersistedBooleanManager$2;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public class PersistedBooleanManager
extends AbstractSystemTarget {
    private final String LOG_PREFIX;
    private final Logger logger;
    private final int eventId;
    private final int propertyId;
    private final PersistedBooleanCallback callback;
    private ASLPropertyManager propertyManager;
    private SystemCommon maintainer;
    private SystemCommonPersistenceService persistenceService;

    public PersistedBooleanManager(SystemServices systemServices, int n, int n2, int n3, PersistedBooleanCallback persistedBooleanCallback) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), n);
        this.LOG_PREFIX = new StringBuffer().append("[PersistedBooleanManager] event=").append(n2).append(", propertyId=").append(n3).toString();
        this.eventId = n2;
        this.propertyId = n3;
        this.callback = persistedBooleanCallback;
        this.logger = systemServices.getAsl1Logger();
        this.propertyManager = systemServices.getPropertyManager();
        this.persistenceService = systemServices.getSystemCommonPersistenceService();
        this.maintainer = this.persistenceService.loadSystemCommon();
        this.persistenceService.addProfileChangeListener(this.createProfileChangeListener());
        systemServices.getFactoryResetService().addParticipant(this.createFactoryResetParticipant(), FactoryResetComponents.SYSTEM);
        this.updateModelDataPool();
        this.registerObservers(systemServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (eventGeneric.getReceiverEventId() == this.eventId) {
            this.processToggleState();
        }
    }

    public boolean get() {
        boolean bl = this.callback.get(this.maintainer);
        if (this.isTraceEnabled()) {
            this.logger.trace(2048).append(this.LOG_PREFIX).append(" get: ").append(bl).log();
        }
        return bl;
    }

    void loadPersistedData() {
        if (this.isTraceEnabled()) {
            this.logger.trace(2048).append(this.LOG_PREFIX).append(" loadPersistedData: ").append(this.get()).log();
        }
        this.maintainer = this.persistenceService.loadSystemCommon();
        this.updateModelDataPool();
    }

    void resetState() {
        boolean bl = this.callback.getDefault();
        this.callback.set(this.maintainer, bl);
        if (this.isTraceEnabled()) {
            this.logger.trace(2048).append(this.LOG_PREFIX).append(" resetState: ").append(this.get()).log();
        }
        this.updateModelDataPool();
    }

    private AbstractFactoryResetParticipant createFactoryResetParticipant() {
        return new PersistedBooleanManager$1(this);
    }

    private void processToggleState() {
        boolean bl = !this.callback.get(this.maintainer);
        this.callback.set(this.maintainer, bl);
        if (this.isTraceEnabled()) {
            this.logger.trace(2048).append(this.LOG_PREFIX).append(" processToggleState: ").append(bl).log();
        }
        this.updateModelDataPool();
    }

    private void updateModelDataPool() {
        this.propertyManager.valueChangedBoolean(this.propertyId, this.callback.get(this.maintainer));
    }

    private AbstractProfileChangeHandler createProfileChangeListener() {
        return new PersistedBooleanManager$2(this);
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(this.eventId, this.getTargetId());
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }
}

